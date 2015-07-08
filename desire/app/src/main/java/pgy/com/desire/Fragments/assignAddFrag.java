package pgy.com.desire.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pgy.com.desire.R;

/**
 * Created by pengguangyu on 2015/7/2.
 */
public class assignAddFrag extends Fragment {

    public Context mContext;

    public assignAddFrag(Context c ){
        this.mContext = c ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_frag_add, container, false);
        getActivity().setTitle("add");

        return rootView;
    }
}
