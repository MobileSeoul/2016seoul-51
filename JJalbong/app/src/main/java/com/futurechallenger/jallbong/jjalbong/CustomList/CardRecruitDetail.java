package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.futurechallenger.jallbong.jjalbong.AssetJsonReader;
import com.futurechallenger.jallbong.jjalbong.R;
import com.futurechallenger.jallbong.jjalbong.VolunteerRecruitFragment;

/**
 * Created by David on 2016-10-31.
 */

public class CardRecruitDetail extends Card {
//    public String m_title;
//    public String m_address1;
//    public String m_address2;
//    public String m_time;
//    public Drawable m_pic1;
//    public Drawable m_pic2;
//
//    public String m_organizer;
//    public String m_recruitnum;
//    public String m_recruitcategory;
//    public String m_description;
//    public String m_schedule;
//    public String m_vcscore;

    VolunteerRecruitFragment.VCRecruit m_recruit;
    AssetManager m_Assetmanager;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_View = inflater.inflate(R.layout.cardview_recruit_detail, parent, false);

        ImageView image1 = (ImageView) m_View.findViewById(R.id.image1);
        ImageView image2 = (ImageView) m_View.findViewById(R.id.image2);



        TextView text1 = (TextView) m_View.findViewById(R.id.text1);
        TextView text2 = (TextView) m_View.findViewById(R.id.text2);
        TextView text3 = (TextView) m_View.findViewById(R.id.text3);
        TextView text4 = (TextView) m_View.findViewById(R.id.text4);
        TextView text5 = (TextView) m_View.findViewById(R.id.text5);
        TextView text6 = (TextView) m_View.findViewById(R.id.text6);
        TextView text7 = (TextView) m_View.findViewById(R.id.text7);

        if(m_recruit != null) {
            image1.setImageDrawable(AssetJsonReader.getBitmap(m_Assetmanager, m_recruit.pic1));
            image2.setImageDrawable(AssetJsonReader.getBitmap(m_Assetmanager, m_recruit.pic2));

            text1.setText(m_recruit.title);
            text2.setText(m_recruit.address2);
            text3.setText(m_recruit.time);
            text4.setText(m_recruit.recruitcategory + ", " + m_recruit.recruitnum + "명 모집");
            text5.setText(m_recruit.organizer);
            text6.setText(m_recruit.description);
            text7.setText(m_recruit.schedule);
        }

        return m_View;
    }

    public void setRecruit(VolunteerRecruitFragment.VCRecruit recruit) {
        m_recruit = recruit;
    }

    public void setAssetManager(AssetManager assetManager) {
        m_Assetmanager = assetManager;
    }
}
