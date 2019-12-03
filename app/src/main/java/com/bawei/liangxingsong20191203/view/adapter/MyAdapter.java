package com.bawei.liangxingsong20191203.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liangxingsong20191203.R;
import com.bawei.liangxingsong20191203.model.bean.Bean;
import com.bawei.liangxingsong20191203.util.NetUtil;

import java.util.List;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:04
 * 类名：com.bawei.liangxingsong20191203.view.adapter
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ShopGridDataBean> shopGridData;

    public MyAdapter(Context context, List<Bean.ShopGridDataBean> shopGridData) {
        this.context = context;
        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return shopGridData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.layout,null);
            holder.imageView = view.findViewById(R.id.iv);
            holder.textView = view.findViewById(R.id.tv);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(shopGridData.get(i).getTitle());
        String imageurl = shopGridData.get(i).getImageurl();
        NetUtil.getInstance().dogetphoto(imageurl,holder.imageView);
        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
