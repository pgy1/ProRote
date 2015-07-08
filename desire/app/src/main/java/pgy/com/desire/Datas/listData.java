package pgy.com.desire.Datas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengguangyu on 2015/7/2.
 */
public class listData {

    public ArrayList<Map<String,Object>> getData(){
        ArrayList<Map<String,Object>> data = new ArrayList<Map<String, Object>>();

        for(int i =0 ; i <10 ; i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("item_title",i);
            data.add(map);
        }

        return data;
    }
}
