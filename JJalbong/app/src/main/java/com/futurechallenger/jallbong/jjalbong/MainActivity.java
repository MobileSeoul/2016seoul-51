package com.futurechallenger.jallbong.jjalbong;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static junit.framework.Assert.assertEquals;

public class MainActivity extends AppCompatActivity {

    static class Person {
        String name;
        String phone_number;

        Person(String name, String phoneNumber) {
            this.name = name;
            this.phone_number = phoneNumber;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();

                        Toast.makeText(getApplicationContext(), AssetJsonReader.reader(getResources().getAssets(), "c_center.json"), Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), SimpleListActivity.class));

                        Gson gson = new Gson();
                        String json = "{'name':'김태희', 'phone_number':'010-1234-5678'}";
                        Person person = gson.fromJson(json, Person.class);
                        assertEquals("김태희", person.name);
                        assertEquals("010-1234-5678", person.phone_number);
                    }
                }
        );
    }


}
