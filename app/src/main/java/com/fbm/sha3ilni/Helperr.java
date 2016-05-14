package com.fbm.sha3ilni;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.util.BitSet;

/**
 * Created by Mojahed Dameri on 5/14/16.
 */
public class Helperr {

    public static Bitmap fromBase64(String str) {

        byte[] decodedString = Base64.decode(str, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;
    }
}
