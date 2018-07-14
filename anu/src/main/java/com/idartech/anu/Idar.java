package com.idartech.anu;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class Idar extends AppCompatActivity {
    Context c;
    Activity a;

    public Idar() {
    }

    public Idar(Context c, Activity a) {
        this.c = c;
        this.a = a;
    }

    public static String uangIndo(int uang) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat df = NumberFormat.getCurrencyInstance(localeID);
        CharSequence cs = df.format(uang);
        String hasil = cs.toString();
        return hasil.substring(2);
    }
}
