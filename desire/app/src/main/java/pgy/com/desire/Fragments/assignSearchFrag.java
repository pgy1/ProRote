package pgy.com.desire.Fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import pgy.com.desire.R;
import pgy.com.desire.Utils.configHelper;
import pgy.com.desire.Utils.fileHelper;
import pgy.com.desire.Utils.urlHelper;

/**
 * Created by pengguangyu on 2015/7/2.
 */
public class assignSearchFrag extends Fragment {

    public Context mContext;

    public assignSearchFrag(Context c){
        this.mContext = c ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_frag_search, container, false);
        getActivity().setTitle("search");

        fileHelper fileHelper = new fileHelper();
        try {
            fileHelper.createSDDir(configHelper.appPath);
            fileHelper.createSDDir(configHelper.dataPath);
            fileHelper.createSDDir(configHelper.dbPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView url = (TextView) rootView.findViewById(R.id.get_url_str);
        url.setText("pgy");
        return rootView;
    }

    private class urlTask extends AsyncTask<Void,String,String>{

        @Override
        protected String doInBackground(Void... params) {
            try{
                String result = new urlHelper().getUrl("http://qinpin.aliapp.com/manager/?path=request&r=data&t=company&f=name&v=");
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
