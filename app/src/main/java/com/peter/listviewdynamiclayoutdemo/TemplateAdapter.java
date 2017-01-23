package com.peter.listviewdynamiclayoutdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by peter on 17/1/23.
 */

public class TemplateAdapter extends BaseAdapter {

    private Context mContext;
    private List mData;

    public TemplateAdapter(Context context, List data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public int getCount() {
        return null == mData ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        // 一.初始化view
        // 1.判断是否有缓存
        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            // 2.实例化布局
            convertView = View.inflate(mContext, R.layout.item_template, null);
            viewHolder.tv_text = (TextView) convertView.findViewById(R.id.tv_text);
            convertView.setTag(viewHolder);
        } else {
            // 3.通过tag找到缓存的布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 二.渲染数据
        //Data data = (Data)mData.get(position);
        // viewHolder.tv_text.setText(data.getTitle());
        return convertView;
    }

    private static class ViewHolder {
        private TextView tv_text;
    }
}
