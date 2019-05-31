package com.example.downs.navydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class DataMainActivity extends AppCompatActivity {
    long sailorDataId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sailorDataId = extras.getLong("id");
            DatabaseManager dbMgr = new DatabaseManager(this);
            SailorData sailorData = dbMgr.getSailorData(sailorDataId);
            if (sailorData != null) {
                ((EditText) findViewById(R.id.name))
                        .setText(sailorData.getName());
                ((EditText) findViewById(R.id.unit))
                        .setText(sailorData.getUnit());
                ((EditText) findViewById(R.id.nosc))
                        .setText(sailorData.getNosc());
                ((EditText) findViewById(R.id.mob_activity))
                        .setText(sailorData.getMob_activity());
                ((EditText) findViewById(R.id.mob_billet))
                        .setText(sailorData.getMob_billet());
                ((EditText) findViewById(R.id.truic))
                        .setText(sailorData.getTruic());
                ((EditText) findViewById(R.id.umuic))
                        .setText(sailorData.getUmuic());
                ((EditText) findViewById(R.id.nosc_uic))
                        .setText(sailorData.getNosc_uic());
                ((EditText) findViewById(R.id.prd))
                        .setText(String.valueOf(sailorData.getPrd()));
                ((EditText) findViewById(R.id.eaos))
                        .setText(String.valueOf(sailorData.getEaos()));
                ((EditText) findViewById(R.id.ced))
                        .setText(String.valueOf(sailorData.getCed()));
                ((EditText) findViewById(R.id.report_date))
                        .setText(String.valueOf(sailorData.getReport_date()));
                ((EditText) findViewById(R.id.rank_date))
                        .setText(String.valueOf(sailorData.getRank_date()));
                ((EditText) findViewById(R.id.clearance_date))
                        .setText(String.valueOf(sailorData.getClearance_date()));
            } else {
                Log.d("db", "contact null");
            }
        }

    }
    public void editSailorData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        intent.putExtra("message", "Edit Data");
        startActivity(intent);
    }

    public void deleteSailorData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        intent.putExtra("message", "Edit Data");
        startActivity(intent);
    }

}
