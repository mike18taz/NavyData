package com.example.downs.navydata;
import android.app.Activity;
import android.content.Context;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* we don't need fragment_names-xml anymore */
public class AcronymsListFragment extends ListFragment {

    final String[] names = {"AA", "AC", "AD", "ADT", "ADSW", "APR", "ASOSH", "AT", "AUIC", "AWA",
            "BMK", "BMR", "BOL", "CAC", "CCC", "CDB", "CFL", "CMS-ID", "C-WAY", "DEPS", "DOD",
            "DTS", "EAOS","EP", "EOS", "FEP", "HRA", "IDT", "IDTT", "MP", "NDAWS", "NKO", "NOSC",
            "NROWS", "NSIPS", "NSU", "NWU", "P", "PCS", "PFA", "PII", "PMA", "PO", "PRD", "PRIMS",
            "PRT", "RUAD", "RUIC", "SOP", "TRUIC", "UA", "UIC"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1, names);
        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        // ListView can only be accessed here, not in onCreate()
        super.onViewCreated(view, savedInstanceState);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new
                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent,
                                                                            final View view, int position, long id) {
                                                        if (callback != null) {
                                                            callback.onItemSelected(names[position]);
                                                        }
                                                    }
                                                });

    }

    public interface Callback {
        public void onItemSelected(String id);
    }

    private Callback callback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof Callback) {
            callback = (Callback) activity;
        }
    }

   // @Override
    //public void onAttach(Context context) {
       // super.onAttach(context);
       // if (context.getApplicationContext() instanceof Callback) {
          //  callback = (Callback) context.getApplicationContext();
        //}
    //}

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}
