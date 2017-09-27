package com.futurechallenger.jallbong.jjalbong.CustomList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.futurechallenger.jallbong.jjalbong.AssetJsonReader;
import com.futurechallenger.jallbong.jjalbong.MainActivity;
import com.futurechallenger.jallbong.jjalbong.ProfileActivity;
import com.futurechallenger.jallbong.jjalbong.R;
import com.google.gson.Gson;

import static junit.framework.Assert.assertEquals;

/**
 * Created by David on 2016-10-31.
 */

public class CardProfile extends Card {
    protected String m_Title;
    protected Activity m_Activity;

    private EditText m_Text1;
    private Spinner m_Spin1;
    private Spinner m_Spin2;
    private Spinner m_Spin3;
    private Spinner m_Spin4;
    private CheckBox [] m_ChArr;

    @Override
    public View createView(ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_View = inflater.inflate(R.layout.cardview_profile, parent, false);



//        if(profileIsSet.compareTo("yes2") != 0) {
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putString("ProfileIsSet", "yes2");
//            editor.commit();
//
//        }

        SharedPreferences prefs = m_Activity.getSharedPreferences("PrefName", m_Activity.MODE_PRIVATE);
        String name = prefs.getString("Profile_Name", "홍길동");
        int age = prefs.getInt("Profile_Age", 2);
        int sex = prefs.getInt("Profile_Sex", 0);
        int local = prefs.getInt("Profile_Local", 3);
        int time = prefs.getInt("Profile_Time", 1);
        String category = prefs.getString("Profile_Category", "1001010000");

        m_Text1 = (EditText) m_View.findViewById(R.id.edit1);
        m_Text1.setText(name);

        m_Spin1 = (Spinner) m_View.findViewById(R.id.spinner1); // age
        m_Spin1.setSelection(age);

        m_Spin2 = (Spinner) m_View.findViewById(R.id.spinner2); // sex
        m_Spin2.setSelection(sex);

        m_Spin3 = (Spinner) m_View.findViewById(R.id.spinner3); // local
        m_Spin3.setSelection(local);

        m_Spin4 = (Spinner) m_View.findViewById(R.id.spinner4); // time
        m_Spin4.setSelection(time);

        m_ChArr = new CheckBox[11];

        m_ChArr[0] = (CheckBox) m_View.findViewById(R.id.checkbox0);
        m_ChArr[1] = (CheckBox) m_View.findViewById(R.id.checkbox1);
        m_ChArr[2] = (CheckBox) m_View.findViewById(R.id.checkbox2);
        m_ChArr[3] = (CheckBox) m_View.findViewById(R.id.checkbox3);
        m_ChArr[4] = (CheckBox) m_View.findViewById(R.id.checkbox4);
        m_ChArr[5] = (CheckBox) m_View.findViewById(R.id.checkbox5);
        m_ChArr[6] = (CheckBox) m_View.findViewById(R.id.checkbox6);
        m_ChArr[7] = (CheckBox) m_View.findViewById(R.id.checkbox7);
        m_ChArr[8] = (CheckBox) m_View.findViewById(R.id.checkbox8);
        m_ChArr[9] = (CheckBox) m_View.findViewById(R.id.checkbox9);
        m_ChArr[10] = (CheckBox) m_View.findViewById(R.id.checkbox10);

        String checkArr = category;
        int len = category.length();
        char []arr = new char[checkArr.length()];
        checkArr.getChars(0, len, arr, 0);

        for(int i=0; i<len; i++) {
            if(arr[i] == '1')
                m_ChArr[i].setChecked(true);
            else
                m_ChArr[i].setChecked(false);
        }

        return m_View;
    }

    public void saveProfile() {

//        if(profileIsSet.compareTo("yes2") != 0) {
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putString("ProfileIsSet", "yes2");
//            editor.commit();
//
//        }

        SharedPreferences prefs = m_Activity.getSharedPreferences("PrefName", m_Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Profile_Name", m_Text1.getText().toString());
        editor.putInt("Profile_Age", m_Spin1.getSelectedItemPosition());
        editor.putInt("Profile_Sex", m_Spin2.getSelectedItemPosition());
        editor.putInt("Profile_Local", m_Spin3.getSelectedItemPosition());
        editor.putInt("Profile_Time", m_Spin4.getSelectedItemPosition());

        String category = "";

        for(int i=0; i<m_ChArr.length; i++) {
            if(m_ChArr[i].isChecked())
                category += "1";
            else
                category += "0";
        }

        editor.putString("Profile_Category", category);
        editor.commit();
    }

    public void setTitle(String title) {
        m_Title = title;
    }

    public void setActivity(Activity activity) {
        m_Activity = activity;
    }
}
