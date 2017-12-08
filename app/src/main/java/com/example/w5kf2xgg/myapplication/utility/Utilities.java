package com.example.w5kf2xgg.myapplication.utility;

import android.content.Context;
import android.util.Log;

import com.example.w5kf2xgg.myapplication.R;

import java.io.InputStream;

/**
 * Created by w5KF2XGG on 08-12-2017.
 */

public class Utilities {

    public String simpleText(Context context) {

        try {
            InputStream is = context.getResources().openRawResource(R.raw.response);
            byte[] buffer = new byte[is.available()];
            while (is.read(buffer) != -1) ;
            return new String(buffer);
        } catch (Exception e) {
            Log.e("Simpletext", "" + e.toString());
            return e.toString();
        }
    }
}

