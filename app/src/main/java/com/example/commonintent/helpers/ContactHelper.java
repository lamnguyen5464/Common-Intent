package com.example.commonintent.helpers;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commonintent.constant.IntentTypes;

public class ContactHelper {
    public static final int REQUEST_SELECT_CONTACT = IntentTypes.REQUEST_SELECT_CONTACT;

    public static void selectContact(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    public static void handleOnReturn(Activity activity, Intent data, TextView resultTxt) {
        Uri contactUri = data.getData();
        String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cursor = activity.getContentResolver().query(contactUri, projection,
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = cursor.getString(numberIndex);
            resultTxt.setText("You choose: " + number);
            viewContact(activity, contactUri);
        }
    }

    public static void viewContact(Activity activity, Uri contactUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            Log.d("@@", contactUri.getPath());
            activity.startActivity(intent);
        }
    }

}
