package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by David on 2016-10-23.
 */

public abstract class Card {

    protected View m_View;

    public View getView() {
        return this.m_View;
    }

    public abstract View createView(ViewGroup parent);
}
