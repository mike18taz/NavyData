package com.example.downs.navydata;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class UnitListActivity extends AppCompatActivity {
    DatabaseManager dbMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_unit_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = (ListView) findViewById(
                R.id.listViewUnit);

        dbMgr = new DatabaseManager(this);

        Cursor cursor = dbMgr.getSailorsCursor();
        startManagingCursor(cursor);
        String nameField = DatabaseManager.NAME_FIELD;
        String reportDateField = DatabaseManager.REPORT_DATE_FIELD;

        ListAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.two_line_list_item,
                cursor,
                new String[] {nameField, reportDateField},
                new int[] {android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view, int position, long id) {
                        Intent intent = new Intent(
                                getApplicationContext(),
                                DataMainActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                });
    }
    public void seeAwaf(View source) {
        Intent intent = new Intent(this, AcronymsActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }

    public void seeData(View source) {
        Intent intent = new Intent(this, UnitListActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }

    public void seeLinks(View source) {
        Intent intent = new Intent(this, ServiceMainActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }

    public void seeMrrr(View source) {
        Intent intent = new Intent(this, MilitaryActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
    }
}
