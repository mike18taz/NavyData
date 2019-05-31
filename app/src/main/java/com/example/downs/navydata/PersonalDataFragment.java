package com.example.downs.navydata;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class PersonalDataFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this.getContext(), "Data must be entered in all fields or app will crash.",
            Toast.LENGTH_LONG).show();
        Toast.makeText(this.getContext(), "Some fields require numbers.",
                Toast.LENGTH_LONG).show();
    }


    public void cancel(View view) {
       // finish(getExitTransition());
    }
    public void saveSailorData(View view) {
        DatabaseManager dbMgr = new DatabaseManager(this.getContext());
        String name = ((EditText) getView().findViewById(
                R.id.name)).getText().toString();
        String unit = ((EditText) getView().findViewById(
                R.id.unit)).getText().toString();
        String nosc = ((EditText) getView().findViewById(
                R.id.nosc)).getText().toString();
        String mob_activity = ((EditText) getView().findViewById(
                R.id.mob_activity)).getText().toString();
        String mob_billet = ((EditText) getView().findViewById(
                R.id.mob_billet)).getText().toString();
        String truic = ((EditText) getView().findViewById(
                R.id.truic)).getText().toString();
        String umuic = ((EditText) getView().findViewById(
                R.id.umuic)).getText().toString();
        String nosc_uic = ((EditText) getView().findViewById(
                R.id.nosc_uic)).getText().toString();
        String prd = ((EditText) getView().findViewById(
                R.id.prd)).getText().toString();
        String eaos = ((EditText) getView().findViewById(
                R.id.eaos)).getText().toString();
        String ced = ((EditText) getView().findViewById(
                R.id.ced)).getText().toString();
        String report_date = ((EditText) getView().findViewById(
                R.id.report_date)).getText().toString();
        String rank_date = ((EditText) getView().findViewById(
                R.id.rank_date)).getText().toString();
        String clearance_date = ((EditText) getView().findViewById(
                R.id.clearance_date)).getText().toString();
        SailorData sailorData = new SailorData(name, unit, nosc, mob_activity, mob_billet, truic,
                umuic, nosc_uic, prd, eaos, ced, report_date, rank_date, clearance_date);
        dbMgr.editSailorData(sailorData);
        Toast.makeText(this.getContext(), "Data saved", Toast.LENGTH_LONG).show();
       // finish(getExitTransition());
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(
                R.layout.activity_add_data, container, false);

        return rootView;
    }



}
