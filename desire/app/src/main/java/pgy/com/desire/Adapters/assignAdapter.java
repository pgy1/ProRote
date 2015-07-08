package pgy.com.desire.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import pgy.com.desire.R;

/**
 * Created by pengguangyu on 2015/7/1.
 */
public class assignAdapter extends BaseAdapter{
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局
    private ArrayList<Map<String, Object>> listData;//得到一个LayoutInfalter对象用来导入布局

    public assignAdapter(Context context, ArrayList<Map<String, Object>> data) {
        this.mInflater = LayoutInflater.from(context);
        this.listData = data;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
                convertView = mInflater.inflate(R.layout.view_assign,null);
                holder = new ViewHolder();
                /*得到各个控件的对象*/
                holder.title = (TextView) convertView.findViewById(R.id.title_assign);
                convertView.setTag(holder);//绑定ViewHolder对象
            }else{
                holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象
            }
            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
            holder.title.setText(listData.get(position).get("item_title").toString());

            return convertView;
    }

    /*listview的item*/
    public final class ViewHolder{
        public ImageView image;
        public TextView title;
    }
}
