package com.fzq.mybutterknifedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fzq on 2018/1/4.
 */

public class MyAdapter extends BaseAdapter {

    public final String[] names = new String[50];
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        initDatas();
    }

    private void initDatas() {
        for (int i = 0; i < 50; i++) {
            names[i] = "name -- " + i;
        }
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public String getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.layout_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(names[position]);
        if (position % 2 == 0) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        return convertView;
    }

    /**
     * 在ViewHolder中使用ButterKnife
     */
    class ViewHolder {

        @BindView(R.id.Item_text)
        TextView textView;
        @BindView(R.id.Item_checkBox)
        CheckBox checkBox;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
