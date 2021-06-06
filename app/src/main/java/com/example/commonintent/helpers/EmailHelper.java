package com.example.commonintent.helpers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class EmailHelper {
    public static void composeEmail(Activity activity, String addresses[], String subject, String content) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, content);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }
    }

}
