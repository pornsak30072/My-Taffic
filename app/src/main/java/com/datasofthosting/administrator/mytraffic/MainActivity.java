package com.datasofthosting.administrator.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private String urlYoutubeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   //Main method

    public void clickAboutMe(View view) {

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.effect_btn_long);
        mediaPlayer.start();

        //Intent to WebView การเคลื่อนย้ายการทำงาน
        urlYoutubeString = "https://youtu.be/wMgDHi4Eq_c";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlYoutubeString));
        startActivity(intent);
    }
}   //Main class
