package com.idartech.anu;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class Idar extends AppCompatActivity {
    Context c;
    Activity a;
    public static final int hakAksesNelpon = 1;

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

    public static void panggilTelepon(Context c, Activity a, String nomor) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + nomor));
        if (ActivityCompat.checkSelfPermission(c, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(a, Manifest.permission.CALL_PHONE)) {
            } else {
                ActivityCompat.requestPermissions(a, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE},
                        hakAksesNelpon);
            }
            return;
        }
        a.startActivity(callIntent);

    }
}
