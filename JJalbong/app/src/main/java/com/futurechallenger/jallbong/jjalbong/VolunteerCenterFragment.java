package com.futurechallenger.jallbong.jjalbong;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.futurechallenger.jallbong.jjalbong.CustomList.ListViewAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by David on 2016-10-29.
 */

public class VolunteerCenterFragment extends Fragment {
    protected String m_SelectedPhoneNumber;
    protected String m_SelectedSite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_custom_list, container, false);

        ListView listview = (ListView)rootView.findViewById(R.id.customlistview1);
        ListViewAdapter adapter = new ListViewAdapter();

        // load data into adapter
        DataLoader(adapter);
//        loadSeparator(adapter);
//        loadItemData(adapter);
//        loadItemData(adapter);

//        adapter.addIndexItem("My favorite");
//        adapter.addBasicItem(ContextCompat.getDrawable(getActivity(), R.drawable.sample1), "Box", "Accout Box Black 36dp");
//        adapter.addBasicItem(ContextCompat.getDrawable(getActivity(), R.drawable.sample2), "Circle", "Accout Box White 36dp");
//        adapter.addIndexItem("Top 10");
//        adapter.addMagazineItem(ContextCompat.getDrawable(getActivity(), R.drawable.pic), "Oh my hosipital", "Many people wants voluneer. Because he think that when you help someone, they could feel happy.");

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CardVolunteerCenter card = (CardVolunteerCenter) parent.getItemAtPosition(position);

                m_SelectedPhoneNumber = card.getPhoneNumber();
                m_SelectedSite = card.getSite();

                showDialog();

//                String titleStr = item.getTitle();
//                String descStr = item.getDesc();
//                Drawable iconDrawable = item.getIcon();

//                    Toast.makeText(getActivity().getApplicationContext(), "show " + titleStr + ", " +descStr, Toast.LENGTH_SHORT).show();



//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
//                startActivity(intent);
            }
        });
        return rootView;
    }

    static class VCCenter {
        String title;
        String address;
        String phone;
        String site;
        String number;
    }

    public void DataLoader(ListViewAdapter adapter) {
        String contents = AssetJsonReader.reader(getResources().getAssets(), "vc_center.json");
        JsonObject root = new JsonParser().parse(contents).getAsJsonObject();
        JsonArray subnode = root.get("vccenters").getAsJsonArray();

        Gson gson = new Gson();
        int size = subnode.size();

        for(int i=0; i<size; i++) {
            VCCenter vcCenter = gson.fromJson(subnode.get(i), VCCenter.class);

            CardVolunteerCenter vcCard = new CardVolunteerCenter();

            vcCard.setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.app_icon));
            vcCard.setTitle(vcCenter.title);
            vcCard.setVCNumber(vcCenter.number);
            vcCard.setAddress(vcCenter.address);
            vcCard.setPhoneNumber(vcCenter.phone);
            vcCard.setSite(vcCenter.site);

            adapter.addCard(vcCard);

            if(i == 0) {
                CardSeparator card = new CardSeparator();
                card.setTitle("지역구 자원봉사센터");
                adapter.addCard(card);
            }
        }

//        CardVolunteerCenter vcCard = new CardVolunteerCenter();
//
//        vcCard.setIcon(ContextCompat.getDrawable(getActivity(), R.drawable.app_icon));
//        vcCard.setTitle("서울시 자원봉사센터");
//        vcCard.setVCNumber("2,259,997");
//        vcCard.setAddress("서울특별시 중구 소파로 131, 302호 (남산동3가)");
//        vcCard.setPhoneNumber("02-920-2922");
//        vcCard.setSite("http://volunteer.seoul.go.kr/");
//
//        adapter.addCard(vcCard);
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
