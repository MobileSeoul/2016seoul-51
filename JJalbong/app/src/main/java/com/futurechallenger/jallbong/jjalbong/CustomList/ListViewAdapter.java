package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.futurechallenger.jallbong.jjalbong.R;

import java.util.ArrayList;

/**
 * Created by David on 2016-10-23.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Card> m_CardList = new ArrayList<Card>(); // VCRecruit

    public ListViewAdapter() {
    }

    @Override
    public int getCount() {
        return m_CardList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return m_CardList.get(position);
    }

    public void addCard(Card card) {
        m_CardList.add(card);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
//        final Context context = parent.getContext();

        Card card = m_CardList.get(position);

        convertView = card.getView();
        if(convertView == null) {
            convertView = card.createView(parent);
//            int type = listViewItem.getType();
//
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            switch(type) {
//                case 1: {
//                    convertView = inflater.inflate(R.layout.cardview_pic2text, parent, false);
//
//                    ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageview1);
//                    TextView titleTextView = (TextView) convertView.findViewById(R.id.textview1);
//                    TextView descTextView = (TextView) convertView.findViewById(R.id.textview2);
//
//                    iconImageView.setImageDrawable(listViewItem.getIcon());
//                    titleTextView.setText(listViewItem.getTitle());
//                    descTextView.setText(listViewItem.getDesc());
//                }
//                break;
//                case 2: {
//                    convertView = inflater.inflate(R.layout.listitem_index, parent, false);
//
//                    TextView titleTextView = (TextView) convertView.findViewById(R.id.textview1);
//                    titleTextView.setText(listViewItem.getTitle());
//                }
//                break;
//                case 3: {
//                    convertView = inflater.inflate(R.layout.listitem_magazine, parent, false);
//
//                    ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageview1);
//                    TextView titleTextView = (TextView) convertView.findViewById(R.id.textview1);
//                    TextView descTextView = (TextView) convertView.findViewById(R.id.textview2);
//
//                    iconImageView.setImageDrawable(listViewItem.getIcon());
//                    titleTextView.setText(listViewItem.getTitle());
//                    descTextView.setText(listViewItem.getDesc());
//                }
//                break;
//            }
//
//            listViewItem.setView(convertView);
        }

        return convertView;
    }



//    public void addIndexItem(String title) {
//        Card item = new Card();
//
//        item.setType(2);
//        item.setTitle(title);
//
//        listViewItemList.add(item);
//    }
//
//    public void addBasicItem(Drawable icon, String title, String desc) {
//        Card item = new Card();
//
//        item.setType(1);
//        item.setIcon(icon);
//        item.setTitle(title);
//        item.setDesc(desc);
//
//        listViewItemList.add(item);
//    }
//
//    public void addMagazineItem(Drawable icon, String title, String desc) {
//        Card item = new Card();
//
//        item.setType(3);
//        item.setIcon(icon);
//        item.setTitle(title);
//        item.setDesc(desc);
//
//        listViewItemList.add(item);
//    }
}
