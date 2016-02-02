package com.sunflower.mydemo.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sunflower.mydemo.R;

public class DrawerFragment extends Fragment {


    public DrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_drawer,container,false);
        ListView  lv_listview = (ListView) myView.findViewById(R.id.lv_listview);

        ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.model_name));
        lv_listview.setAdapter(arrayAdapter);
        return myView;
    }
}
