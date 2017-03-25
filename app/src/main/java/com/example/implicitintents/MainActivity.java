package com.example.implicitintents;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    public String number;
    public String weburl;
    EditText telno;
    EditText url;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        telno = (EditText) findViewById(R.id.id_nick_name);
        url = (EditText) findViewById(R.id.id_nick_name2);
        b1 = (Button) findViewById(R.id.button_ring);
        b2 = (Button) findViewById(R.id.button_launch);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ring();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                browse();
            }
        });
    }

    public void ring() {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        number = telno.getText().toString().trim();
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }

    public void browse() {

        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        weburl = url.getText().toString().trim();
        callIntent.setData(Uri.parse(weburl));
        startActivity(callIntent);
    }

    public void onClickButtonCloseApp(View v) {
        this.finish();
    }
}