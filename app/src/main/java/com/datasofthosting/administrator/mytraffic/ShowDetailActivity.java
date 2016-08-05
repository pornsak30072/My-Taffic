package com.datasofthosting.administrator.mytraffic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class ShowDetailActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private TextView showTitleTextView, getShowTitleTextView;
    private TextView showDetailTextView, getShowDetailTextView;
    private ImageView showTrafficImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    
        //Bind Widget
        bindWidget();

        //Show Widget
        showWidget();

    }   //onCreate

    private void showWidget() {

        //Receive from Intent
        int intClick = getIntent().getIntExtra("click", 0);

        //Show Title
        MyData objMyData = new MyData();
        //String[] strTitle = objMyData.title();
        //showTitleTextView.setText(strTitle[intClick]);
        String[] titleStrings = getResources().getStringArray(R.array.my_title);
        showTitleTextView.setText(titleStrings[intClick]);

        //Show Traffic image
        int[] intDrawable = objMyData.icon();
        showTrafficImageView.setImageResource(intDrawable[intClick]);

        //Show Detail
        //String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        //showDetailTextView.setText(strDetail[intClick]);
        String[] strDetail = getResources().getStringArray(R.array.my_detail);
        showDetailTextView.setText(strDetail[intClick]);

    }   //showWidget

    private void bindWidget() {

        showTitleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        showDetailTextView = (TextView) findViewById(R.id.txtDetail);
        showTrafficImageView = (ImageView) findViewById(R.id.imvTrafficDetail);

    }   //bindWidget

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ShowDetail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.datasofthosting.administrator.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ShowDetail Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.datasofthosting.administrator.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
