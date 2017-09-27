package com.futurechallenger.jallbong.jjalbong;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by David on 2016-10-30.
 */

public class AssetJsonReader {
    public static String reader(AssetManager assetManager, String jsonFileName) {
        InputStream is = null;

        try{
            is = assetManager.open(jsonFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bis = new BufferedReader(isr);

        String content = "";
        while(true) {
            try {
                String str = bis.readLine();
                if(str == null)
                    break;
                content += str;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    public static Drawable getBitmap(AssetManager assetManager, String fileName) {
        Bitmap bitmap = null;
        Drawable drawable = null;
        try{
            InputStream is = assetManager.open(fileName,AssetManager.ACCESS_BUFFER);
            bitmap = BitmapFactory.decodeStream(is);
            drawable = (Drawable)(new BitmapDrawable(bitmap));

        }catch(Exception e){
        }
        return drawable;
    }
}
