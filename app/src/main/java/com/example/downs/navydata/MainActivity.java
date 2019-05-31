package com.example.downs.navydata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

/** MainActivity - This is the main activity that introduces all other activities for NavyData
 *  Created by Downs on 3/13/2017.
 */
public class MainActivity extends AppCompatActivity {

    boolean welcomeDelivered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (!welcomeDelivered) {
            Toast.makeText(this, "Select 'Add Data' from toolbar\nto begin entering data.",
                    Toast.LENGTH_LONG).show();
            welcomeDelivered = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addSailorData(MenuItem source) {
        Intent intent = new Intent(this, AddDataActivity.class);
        intent.putExtra("message", "Message from Developer");
        startActivity(intent);
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






