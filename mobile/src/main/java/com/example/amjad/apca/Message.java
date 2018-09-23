package com.example.amjad.apca;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class Message {
    public static void  message(Context context,String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    public static void AlertMessage(Context context,String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(context,AlertDialog.THEME_HOLO_DARK);
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setIcon(R.drawable.common_google_signin_btn_icon_dark);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
