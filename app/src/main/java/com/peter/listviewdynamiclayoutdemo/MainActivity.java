package com.peter.listviewdynamiclayoutdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;

    private ArrayList<String> mArrayList;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mListView = (ListView) findViewById(R.id.listView);

        addData();
        CustomAdapter mCustomAdapter = new CustomAdapter();

        mListView.setAdapter(mCustomAdapter);
    }

    private void addData() {
        mArrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mArrayList.add(i, "填充数据" + i);
        }
    }

    class CustomAdapter extends BaseAdapter {

        static final int TYPE_DATA = 0;
        static final int TYPE_IMAGE = 1;

        static final int TYPE_COUNT = 2;

        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public int getViewTypeCount() {
            return TYPE_COUNT;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_IMAGE;
            } else {
                return TYPE_DATA;
            }
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1.初始化不同类型布局的控件
            ViewHolder mHolder = null;
            int type = getItemViewType(position);
            if (convertView == null || convertView.getTag() == null) {
                mHolder = new ViewHolder();
                switch (type) {
                    case TYPE_DATA:
                        convertView = View.inflate(mContext, R.layout.item_text, null);
                        mHolder.tv_text = (TextView) convertView.findViewById(R.id.tv_text);
                        break;
                    case TYPE_IMAGE:
                        convertView = View.inflate(mContext, R.layout.item_image, null);
                        break;
                }
                convertView.setTag(mHolder);
            } else {
                mHolder = (ViewHolder) convertView.getTag();
            }

            // 2.渲染不同布局类型的数据
            if (type == TYPE_DATA) {

            }

            if (type == TYPE_IMAGE) {

            }

            return convertView;
        }
    }



    /**
     * 非广告的数据
     */
    class NormalItem {
        private String title;

        public NormalItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    // 所有类型的布局的控件都包含在内
    static class ViewHolder {
        public TextView tv_text;
        public ImageView poster;
    }
}
