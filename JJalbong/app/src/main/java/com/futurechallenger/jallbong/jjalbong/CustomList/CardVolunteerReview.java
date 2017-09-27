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

public class CardVolunteerReview extends Card {
    protected String m_Like;
    protected String m_Comment;
    protected String m_UserName;
    protected int m_Id;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_View = inflater.inflate(R.layout.cardview_review, parent, false);

        TextView text1 = (TextView) m_View.findViewById(R.id.text1);
        TextView text2 = (TextView) m_View.findViewById(R.id.text2);
        TextView text3 = (TextView) m_View.findViewById(R.id.text3);

        text1.setText(m_Like);
        text2.setText(m_UserName);
        text3.setText(m_Comment);

        return m_View;
    }

    public void setLike(String like) {
        m_Like = like;
    }

    public void setComment(String comment) {
        m_Comment = comment;
    }

    public void setId(int id) {
        m_Id = id;
    }

    public int getId() {
        return m_Id;
    }

    public void setUserName(String userName) {
        m_UserName = userName;
    }
}
