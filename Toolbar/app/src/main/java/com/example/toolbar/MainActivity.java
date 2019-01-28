package com.example.toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Properties
    // import android.support.v7.widget.Toolbar;
    Toolbar toolbar;
    private String TAG = "Toolbar===>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the toolbar from the layout
        toolbar = findViewById(R.id.toolbar);

        //Set the properties of toolbar
        // import android.graphics.Color;
        toolbar.setBackgroundColor(Color.DKGRAY);
        toolbar.setTitleTextColor(Color.YELLOW);
        toolbar.setTitle(R.string.app_name);
        toolbar.setSubtitleTextColor(Color.RED);
        toolbar.setSubtitle(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mm_call) {
            //do something else
            doCall();
        } else if (id == R.id.mm_map) {
            //do something else
            doMap();
        } else if (id == R.id.mm_search) {
            //do something else
            doSearch();
        }
        return super.onOptionsItemSelected(item);
    }

    private void doCall(){
        Log.d(TAG,"doCall()");
        // require android.permission.CALL_PHONE
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:+12345678"));
        startActivity(intent);
    }
    private void doMap(){
        Log.d(TAG,"doMap");
        // require android.permission.INTERNET
        Uri uri = Uri.parse("geo:22.293564,114.16952?z=19");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        // get package
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this,"No google map!",Toast.LENGTH_LONG).show();
        }
    }
    private void doSearch(){
        Log.d(TAG,"doSearch");
        // require android.permission.INTERNET required
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.google.com.hk"));
        startActivity(intent);
    }
}
