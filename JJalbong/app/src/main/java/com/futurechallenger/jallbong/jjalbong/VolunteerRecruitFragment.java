package com.futurechallenger.jallbong.jjalbong;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.futurechallenger.jallbong.jjalbong.CustomList.Card;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardSeparator;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardVolunteerCenter;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardVolunteerRecruit;
import com.futurechallenger.jallbong.jjalbong.CustomList.CardVolunteerReview;
import com.futurechallenger.jallbong.jjalbong.CustomList.ListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by David on 2016-10-29.
 */

public class VolunteerRecruitFragment extends Fragment {
    protected String m_SelectedPhoneNumber;
    protected String m_SelectedSite;
    private ArrayList<VCRecruit> m_VCRecruitList = new ArrayList<VCRecruit>(); // VCRecruit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_custom_list, container, false);

        ListView listview = (ListView)rootView.findViewById(R.id.customlistview1);
        ListViewAdapter adapter = new ListViewAdapter();

        // load data into adapter
        DataLoaderForReview(adapter);
        DataLoaderForRecruit(adapter);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >= 5) {
                    //m_VCRecruitList.add(vcRecruit);
                    Intent intent = new Intent(getContext(), RecruitDetailActivity.class);
                    VCRecruit object = m_VCRecruitList.get(position-5);
                    intent.putExtra("VCRecruit", object);
                    startActivity(intent);
                }

            }
        });
        return rootView;
    }

    static class VCReview {
        String like;
        String comment;
        String username;
    }

    public void DataLoaderForReview(ListViewAdapter adapter) {
        String contents = AssetJsonReader.reader(getResources().getAssets(), "vc_review.json");
        JsonObject root = new JsonParser().parse(contents).getAsJsonObject();
        JsonArray subnode = root.get("vcreviews").getAsJsonArray();

        Gson gson = new Gson();
        int size = subnode.size();

        // separator
        CardSeparator card = new CardSeparator();
        card.setTitle("봉사 후기 (주간 베스트 3)");
        adapter.addCard(card);

        for(int i=0; i<size; i++) {
            VolunteerRecruitFragment.VCReview vcReview = gson.fromJson(subnode.get(i), VolunteerRecruitFragment.VCReview.class);
            CardVolunteerReview vcCard = new CardVolunteerReview();

            vcCard.setId(i+1);
            vcCard.setLike(vcReview.like);
            vcCard.setComment(vcReview.comment);
            vcCard.setUserName(vcReview.username);

            adapter.addCard(vcCard);
        }
    }

    public static class VCRecruit implements Serializable {
        public String id;
        public String title;
        public String address1;
        public String address2;
        public String time;
        public String pic1;
        public String pic2;
        public String organizer;
        public String recruitnum;
        public String recruitcategory;
        public String description;
        public String schedule;
        public String vcscore;
//        Drawable drawable1;
//        Drawable drawable2;
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
            m_VCRecruitList.add(vcRecruit);

            CardVolunteerRecruit vcCard = new CardVolunteerRecruit();

            vcCard.setTitle(vcRecruit.title);
            vcCard.setDescription1(vcRecruit.address1 + ", " + vcRecruit.time);
            vcCard.setDescription2(vcRecruit.recruitnum + "명 모집");
            vcCard.setDescription3(vcRecruit.vcscore + "점");

            if(vcRecruit.pic1.isEmpty() == false) {
                AssetManager assetmanager = getResources().getAssets();
                vcCard.setPic1(AssetJsonReader.getBitmap(assetmanager, vcRecruit.pic1));
//                Bitmap bitmap = null;
//                try{
//                    InputStream is = assetmanager.open(vcRecruit.pic1,AssetManager.ACCESS_BUFFER);
//                    bitmap = BitmapFactory.decodeStream(is);
//                    Drawable drawable = (Drawable)(new BitmapDrawable(bitmap));
////                    vcRecruit.drawable1 = drawable;
//                    vcCard.setPic1(drawable);
//                }catch(Exception e){
//                }
            }

            if(vcRecruit.pic2.isEmpty() == false) {
                AssetManager assetmanager = getResources().getAssets();
                vcCard.setPic2(AssetJsonReader.getBitmap(assetmanager, vcRecruit.pic2));
            }

            adapter.addCard(vcCard);
        }
    }


    public void loadSeparator(ListViewAdapter adapter) {
        CardSeparator card = new CardSeparator();

        card.setTitle("지역구별");

        adapter.addCard(card);
    }

    protected void showDialog() {
        final CharSequence[] items = {"전화 걸기", "사이트 열기"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(items, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int index){
//                    Toast.makeText(getContext(), items[index], Toast.LENGTH_SHORT).show();
                if(index == 0) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + m_SelectedPhoneNumber));
                    startActivity(intent);
                } else {
                    Uri uri = Uri.parse(m_SelectedSite);
                    Intent it  = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
