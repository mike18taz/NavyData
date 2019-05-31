package com.example.downs.navydata;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_military, menu);
        return true;
    }

    public void viewWebPages(View source) {
        Intent intent = new Intent(this, ServiceViewActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }

    public void fetchWebPages(View view) {
        EditText editText = (EditText) findViewById(R.id.urlsEditText);
        Intent intent = new Intent(this, URLService.class);
        intent.putExtra("urls", editText.getText().toString());
        Toast.makeText(this, "Links fetched",
                Toast.LENGTH_LONG).show();
        startService(intent);
    }
}