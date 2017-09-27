package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.futurechallenger.jallbong.jjalbong.R;

/**
 * Created by David on 2016-10-30.
 */

public class CardSeparator extends Card {
    protected String m_Title;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_View = inflater.inflate(R.layout.cardview_separator, parent, false);

        TextView text1 = (TextView) m_View.findViewById(R.id.text1);
        text1.setText(m_Title);

        return m_View;
    }

    public void setTitle(String title) {
        m_Title = title;
    }
}
