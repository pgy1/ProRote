package pgy.com.desire.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

import pgy.com.desire.Adapters.assignAdapter;
import pgy.com.desire.R;

/**
 * Created by pengguangyu on 2015/7/2.
 */
public class assignListFrag extends Fragment {

    public Context mContext;
    public ArrayList<Map<String,Object>> mList;

    public assignListFrag(Context c , ArrayList<Map<String,Object>> l){
        this.mContext = c ;
        this.mList = l ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_frag_main, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.assign_list);
        assignAdapter adapter = new assignAdapter(getActivity(),mList);
        listView.setAdapter(adapter);

        return rootView;
    }

}
