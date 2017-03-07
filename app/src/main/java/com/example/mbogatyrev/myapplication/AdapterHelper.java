package com.example.mbogatyrev.myapplication;

import android.content.Context;
import android.widget.Adapter;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mbogatyrev on 07.03.2017.
 */
public class AdapterHelper {

    private Context context;

    private String[] relatives = new String[]{"Parents", "Brothers", "Sisters"};
    private String[] parents = new String[]{"Father", "Mother"};
    private String[] brothers = new String[]{"Ah'mad"};
    private String[] sisters = new String[]{"Ayshat", "Fatima", "Asya", "Rabiya", "Salima"};

    AdapterHelper(Context context){
        this.context = context;
    }

    public SimpleExpandableListAdapter getAdapter(){
        ArrayList<Map<String, String>> group = new ArrayList<Map<String, String>>();
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<ArrayList<Map<String, String>>>();

        group = fillArray("groupName", relatives, group, null);
        fillArray("relative", parents, new ArrayList<Map<String, String>>(), childData);
        fillArray("relative", brothers, new ArrayList<Map<String, String>>(), childData);
        fillArray("relative", sisters, new ArrayList<Map<String, String>>(), childData);

        String[] groupFrom = new String[]{"groupName"};
        int[] groupTo = new int[]{android.R.id.text1};

        String[] childFrom = new String[]{"relative"};
        int[] childTo = new int[]{android.R.id.text1};


        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(context, group, android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo, childData, android.R.layout.simple_list_item_1,
                childFrom, childTo);
        return adapter;
    }

    private ArrayList fillArray(String keyName, String[] dataMass, ArrayList<Map<String, String>> arrayToFill, ArrayList<ArrayList<Map<String, String>>> childData){
        for (String dataItem : dataMass){
            Map<String, String> m = new HashMap<>();
            m.put(keyName, dataItem);
            arrayToFill.add(m);
        }
        if(childData != null) {
            childData.add(arrayToFill);
            return childData;
        }
        else {
            return arrayToFill;
        }
    }
}
