package com.futurechallenger.jallbong.jjalbong;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.futurechallenger.jallbong.jjalbong.CustomList.Card;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardProfile;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardSeparator;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardVolunteerRecruit;
import com.futurechallenger.jallbong.jjalbong.CustomList.ListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static junit.framework.Assert.assertEquals;

public class ProfileActivity extends AppCompatActivity {
    protected CardProfile m_CardProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("봉사 프로필");

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        // load data into adapter
//        DataLoaderForRecruit(adapter);
        DataLoaderForProfile(adapter);

        listview = (ListView)findViewById(R.id.customlistview1);
        listview.setAdapter(adapter);

        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();
                        m_CardProfile.saveProfile();

                        finish();
                    }
                }
        );
    }

    static class VCRecruit {
        String id;
        String title;
        String address1;
        String address2;
        String time;
        String pic1;
        String pic2;
        String organizer;
        String recruitnum;
        String recruitcategory;
        String description;
        String schedule;
        String vcscore;
    }

    public void DataLoaderForRecruit(ListViewAdapter adapter) {
        String contents = AssetJsonReader.reader(getResources().getAssets(), "vc_recruit.json");
        JsonObject root = new JsonParser().parse(contents).getAsJsonObject();
        JsonArray subnode = root.get("vcrecruits").getAsJsonArray();

        Gson gson = new Gson();
        int size = subnode.size();

        // separator
        CardSeparator card = new CardSeparator();
        card.setTitle("봉사모집 소식");
        adapter.addCard(card);

        for(int i=0; i<size; i++) {
            VolunteerRecruitFragment.VCRecruit vcRecruit = gson.fromJson(subnode.get(i), VolunteerRecruitFragment.VCRecruit.class);
            CardVolunteerRecruit vcCard = new CardVolunteerRecruit();

            vcCard.setTitle(vcRecruit.title);
            vcCard.setDescription1(vcRecruit.address1 + ", " + vcRecruit.time);
            vcCard.setDescription2(vcRecruit.recruitnum + "명 모집");
            vcCard.setDescription3(vcRecruit.vcscore + "점");

            adapter.addCard(vcCard);
        }
    }

    static class Profile {
        String name;
        String age;
        String sex;
        String time;
        String region;
        String category;
    }

    public void DataLoaderForProfile(ListViewAdapter adapter) {
        CardProfile card = new CardProfile();
        card.setActivity(this);
        adapter.addCard(card);

        m_CardProfile = card;
    }
}
