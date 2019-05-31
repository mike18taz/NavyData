package com.example.downs.navydata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        Toast.makeText(this, "Data must be entered in all fields or app will crash.",
            Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Some fields require numbers.",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void cancel(View view) {
        finish();
    }
    public void saveSailorData(View view) {
        DatabaseManager dbMgr = new DatabaseManager(this);
        String name = ((EditText) findViewById(
                R.id.name)).getText().toString();
        String unit = ((EditText) findViewById(
                R.id.unit)).getText().toString();
        String nosc = ((EditText) findViewById(
                R.id.nosc)).getText().toString();
        String mob_activity = ((EditText) findViewById(
                R.id.mob_activity)).getText().toString();
        String mob_billet = ((EditText) findViewById(
                R.id.mob_billet)).getText().toString();
        String truic = ((EditText) findViewById(
                R.id.truic)).getText().toString();
        String umuic = ((EditText) findViewById(
                R.id.umuic)).getText().toString();
        String nosc_uic = ((EditText) findViewById(
                R.id.nosc_uic)).getText().toString();
        String prd = ((EditText) findViewById(
                R.id.prd)).getText().toString();
        String eaos = ((EditText) findViewById(
                R.id.eaos)).getText().toString();
        String ced = ((EditText) findViewById(
                R.id.ced)).getText().toString();
        String report_date = ((EditText) findViewById(
                R.id.report_date)).getText().toString();
        String rank_date = ((EditText) findViewById(
                R.id.rank_date)).getText().toString();
        String clearance_date = ((EditText) findViewById(
                R.id.clearance_date)).getText().toString();
        SailorData sailorData = new SailorData(name, unit, nosc, mob_activity, mob_billet, truic,
                umuic, nosc_uic, prd, eaos, ced, report_date, rank_date, clearance_date);
        dbMgr.editSailorData(sailorData);
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
        finish();
    }


    public void addSailorData(MenuItem source) {
        Intent intent = new Intent(this, AddDataActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }
}
