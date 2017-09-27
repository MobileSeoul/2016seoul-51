package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.futurechallenger.jallbong.jjalbong.R;

/**
 * Created by David on 2016-10-29.
 */

public class CardVolunteerCenter extends Card {
    protected Drawable m_Icon;
    protected String m_Title;
    protected String m_Address;
    protected String m_Site;
    protected String m_VCNumber;
    protected String m_PhoneNumber;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_View = inflater.inflate(R.layout.cardview_volunteer_center, parent, false);

        ImageView icon = (ImageView) m_View.findViewById(R.id.image1);
        TextView text1 = (TextView) m_View.findViewById(R.id.text1);
        TextView text2 = (TextView) m_View.findViewById(R.id.text2);
        TextView text3 = (TextView) m_View.findViewById(R.id.text3);
        TextView text4 = (TextView) m_View.findViewById(R.id.text4);
        TextView text5 = (TextView) m_View.findViewById(R.id.text5);

        icon.setImageDrawable(m_Icon);
        text1.setText(m_Title);
        text2.setText(m_Address);
        text3.setText(m_Site);
        text4.setText(m_VCNumber);
        text5.setText(m_PhoneNumber);

        return m_View;
    }

    public void setIcon(Drawable icon) {
        m_Icon = icon;
    }

    public void setTitle(String title) {
        m_Title = title;
    }

    public void setVCNumber(String vcNumber) {
        m_VCNumber = "자원봉사자 " + vcNumber + " 명";
    }

    public void setAddress(String address) {
        m_Address = address;
    }

    public void setSite(String site) {
        m_Site = site;
    }

    public String getSite() {return m_Site;}

    public void setPhoneNumber(String phoneNumber) {
        m_PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {return m_PhoneNumber;}
}
