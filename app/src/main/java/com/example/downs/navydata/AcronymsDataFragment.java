package com.example.downs.navydata;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AcronymsDataFragment extends Fragment {

    String name;
    String description;

    public AcronymsDataFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey("name")) {
            name = getArguments().getString("name");
        }
        if (getArguments().containsKey("description")) {
            description = getArguments().getString("description");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_acronyms_details, container, false);
        TextView textView = (TextView)
                rootView.findViewById(R.id.text1);
        textView.setText(name);
        TextView textView2 = (TextView)
                rootView.findViewById(R.id.textView2);
        textView2.setText(description);


        return rootView;
    }
}
