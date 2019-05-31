package com.example.downs.navydata;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class AcronymsActivity extends AppCompatActivity
        implements AcronymsListFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acronyms);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public void onItemSelected(String value) {
        Bundle arguments = new Bundle();
        arguments.putString("name", value);
        if (value.equals("AA")) {
            arguments.putString("description", "An Acronym");
        } else if (value.equals("AC")) {
            arguments.putString("description", "Active Component");
        } else if (value.equals("AD")) {
            arguments.putString("description", "Active Duty");
        } else if (value.equals("ADT")) {
            arguments.putString("description", "Active Duty Training");
        } else if (value.equals("ADSW")) {
            arguments.putString("description", "Active Duty for Special Work");
        } else if (value.equals("APR")) {
            arguments.putString("description", "Annual Points for Retirement");
        } else if (value.equals("ASOSH")) {
            arguments.putString("description", "Annual");
        } else if (value.equals("AT")) {
            arguments.putString("description", "Annual Training");
        } else if (value.equals("AUIC")) {
            arguments.putString("description", "Assigned Unit Identification Code");
        } else if (value.equals("AWA")) {
            arguments.putString("description", "An Acronym Within An Acronym");
        } else if (value.equals("BMK")) {
            arguments.putString("description", "Basic Military Knowledge");
        } else if (value.equals("BMR")) {
            arguments.putString("description", "Basic Military Requirements");
        } else if (value.equals("BOL")) {
            arguments.putString("description", "BUPERS OnLine");
        } else if (value.equals("CAC")) {
            arguments.putString("description", "Common Access Card");
        } else if (value.equals("CCC")) {
            arguments.putString("description", "Command Career Counselor");
        } else if (value.equals("CDB")) {
            arguments.putString("description", "Career Development Board");
        } else if (value.equals("CFL")) {
            arguments.putString("description", "Command Fitness Leader");
        } else if (value.equals("CMS-ID")) {
            arguments.putString("description", "Community Manager System - Interactive Detailing");
        } else if (value.equals("C-WAY")) {
            arguments.putString("description", "Career Waypoints");
        } else if (value.equals("DEPS")) {
            arguments.putString("description", "Active Duty");
        } else if (value.equals("DOD")) {
            arguments.putString("description", "Department of Defense");
        } else if (value.equals("DTS")) {
            arguments.putString("description", "Defense Travel System");
        } else if (value.equals("EAOS")) {
            arguments.putString("description", "End of Anticipated Obligated Service");
        } else if (value.equals("EP")) {
            arguments.putString("description", "Early Promote");
        } else if (value.equals("EOS")) {
            arguments.putString("description", "End of Obligated Service");
        } else if (value.equals("FEP")) {
            arguments.putString("description", "Fitness Enhancement Program");
        } else if (value.equals("HRA")) {
            arguments.putString("description", "Health Readiness Assessment");
        } else if (value.equals("IDT")) {
            arguments.putString("description", "Inactive Duty Training");
        } else if (value.equals("IDTT")) {
            arguments.putString("description", "Inactive Duty Training with Travel");
        } else if (value.equals("MP")) {
            arguments.putString("description", "Must Promote");
        } else if (value.equals("NDAWS")) {
            arguments.putString("description", "Navy Awards");
        } else if (value.equals("NKO")) {
            arguments.putString("description", "Navy Knowledge Online");
        } else if (value.equals("NOSC")) {
            arguments.putString("description", "Navy Operational Support Center");
        } else if (value.equals("NROWS")) {
            arguments.putString("description", "Navy Reserve Order Writing System");
        } else if (value.equals("NSIPS")) {
            arguments.putString("description", "Navy Standard Integrated Personnel System");
        } else if (value.equals("NSU")) {
            arguments.putString("description", "Navy Service Uniform");
        } else if (value.equals("NWU")) {
            arguments.putString("description", "Navy Working Uniform");
        } else if (value.equals("P")) {
            arguments.putString("description", "Promotable");
        } else if (value.equals("PCS")) {
            arguments.putString("description", "Permanent Change of Station");
        } else if (value.equals("PII")) {
            arguments.putString("description", "Personal Identifiable Information");
        } else if (value.equals("PFA")) {
            arguments.putString("description", "Physical Fitness Assesment");
        } else if (value.equals("PMA")) {
            arguments.putString("description", "Performance Mark Average");
        } else if (value.equals("PO")) {
            arguments.putString("description", "Petty Officer");
        } else if (value.equals("PRD")) {
            arguments.putString("description", "Projected Rotation Date");
        } else if (value.equals("PRIMS")) {
            arguments.putString("description", "Physical Readiness Information Management System");
        } else if (value.equals("PRT")) {
            arguments.putString("description", "Physical Readiness Test");
        } else if (value.equals("RUAD")) {
            arguments.putString("description", "Reserve");
        } else if (value.equals("RUIC")) {
            arguments.putString("description", "R");
        } else if (value.equals("SOP")) {
            arguments.putString("description", "Standard Operating Procedures");
        } else if (value.equals("TRUIC")) {
            arguments.putString("description", "Training Reserve");
        } else if (value.equals("UA")) {
            arguments.putString("description", "Unexcused Absence");
        } else if (value.equals("UIC")) {
            arguments.putString("description", "Unit Identification Code");
        }
        AcronymsDataFragment fragment = new AcronymsDataFragment();
        fragment.setArguments(arguments);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(
                R.id.acronyms_details_container, fragment);
        fragmentTransaction.commit();
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
