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
 * Created by David on 2016-10-30.
 */

public class CardVolunteerRecruit extends Card {
    protected String m_Title;
    protected String m_Description1;
    protected String m_Description2;
    protected String m_Description3;
    protected Drawable m_Pic1;
    protected Drawable m_Pic2;
    protected static int m_Sequence;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int sel = m_Sequence++%3;
        if(sel == 0)
            m_View = inflater.inflate(R.layout.cardview_recruit_a, parent, false);
        else if(sel == 1)
            m_View = inflater.inflate(R.layout.cardview_recruit_b, parent, false);
        else if(sel == 2)
            m_View = inflater.inflate(R.layout.cardview_recruit_c, parent, false);

        TextView text1 = (TextView) m_View.findViewById(R.id.text1);
        TextView text2 = (TextView) m_View.findViewById(R.id.text2);
        TextView text3 = (TextView) m_View.findViewById(R.id.text3);
        TextView text4 = (TextView) m_View.findViewById(R.id.text4);

        if(m_Pic1 != null) {
            ImageView image1 = (ImageView) m_View.findViewById(R.id.image1);
            image1.setImageDrawable(m_Pic1);
        }

        if(m_Pic2 != null) {
            ImageView image2 = (ImageView) m_View.findViewById(R.id.image2);
            if(image2 != null) {
                image2.setImageDrawable(m_Pic2);
            }
        }

        text1.setText(m_Title);
        text2.setText(m_Description1);
        text3.setText(m_Description2);
        if(text4 != null) {
            text4.setText(m_Description3);
        }

        return m_View;
    }

    public void setTitle(String title) {
        m_Title = title;
    }

    public void setDescription1(String desc1) {
        m_Description1 = desc1;
    }

    public void setDescription2(String desc2) {
        m_Description2 = desc2;
    }

    public void setDescription3(String desc3) {
        m_Description3 = desc3;
    }

    public void setPic1(Drawable pic1) {
        m_Pic1 = pic1;
    }

    public void setPic2(Drawable pic2) {
        m_Pic2 = pic2;
    }
}
