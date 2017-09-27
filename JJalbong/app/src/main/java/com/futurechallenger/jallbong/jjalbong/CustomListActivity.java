package com.futurechallenger.jallbong.jjalbong;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.futurechallenger.jallbong.jjalbong.CustomList.Card;
import com.futurechallenger.jallbong.jjalbong.CustomList.ListViewAdapter;

public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.customlistview1);
        listview.setAdapter(adapter);

//        adapter.addIndexItem("My favorite");
//        adapter.addBasicItem(ContextCompat.getDrawable(this, R.drawable.sample1), "Box", "Accout Box Black 36dp");
//        adapter.addBasicItem(ContextCompat.getDrawable(this, R.drawable.sample2), "Circle", "Accout Box White 36dp");
//        adapter.addIndexItem("Top 10");
//        adapter.addMagazineItem(ContextCompat.getDrawable(this, R.drawable.pic), "Oh my hosipital", "Many people wants voluneer. Because he think that when you help someone, they could feel happy.");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card item = (Card) parent.getItemAtPosition(position);

//                String titleStr = item.getTitle();
//                String descStr = item.getDesc();
//                Drawable iconDrawable = item.getIcon();

//                Toast.makeText(getApplicationContext(), "show " + titleStr + ", " +descStr, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
