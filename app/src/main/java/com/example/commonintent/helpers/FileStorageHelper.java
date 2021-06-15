package com.example.commonintent.helpers;

import android.app.Activity;
import android.content.Intent;
import static com.example.commonintent.constant.IntentTypes.REQUEST_IMAGE_OPEN;

public class FileStorageHelper {

    public static void selectImage(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

}
