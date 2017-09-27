package com.futurechallenger.jallbong.jjalbong;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.futurechallenger.jallbong.jjalbong.CustomList.CardRecruitDetail;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardSeparator;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardVolunteerRecruit;
import com.futurechallenger.jallbong.jjalbong.CustomList.ListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RecruitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit_detail);

        setTitle("봉사 모집안내");

        Intent intent = getIntent();
        VolunteerRecruitFragment.VCRecruit object = (VolunteerRecruitFragment.VCRecruit)intent.getSerializableExtra("VCRecruit");

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        // load data into adapter
        DataLoaderForRecruitDetail(adapter, object);

        listview = (ListView)findViewById(R.id.customlistview1);
        listview.setAdapter(adapter);

        findViewById(R.id.button1).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "참석 신청이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
        );
    }

    public void DataLoaderForRecruitDetail(ListViewAdapter adapter, VolunteerRecruitFragment.VCRecruit object) {

        // separator
        CardRecruitDetail card = new CardRecruitDetail();

        card.setAssetManager(getResources().getAssets());
        card.setRecruit(object);
//        card.setTitle("봉사모집 소식");

        adapter.addCard(card);
    }
}
