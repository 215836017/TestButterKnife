package com.fzq.mybutterknifedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;
import butterknife.Unbinder;

/**
 * Created by fzq on 2017/12/14.
 */
public class MyFragment extends Fragment {

    @BindView(R.id.Frag_list)
    ListView listView;

    private Unbinder unbinder;
    private Context context;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getActivity();

        View rootView = inflater.inflate(R.layout.layout_fragment, container, false);

        //第一步： 绑定XML文件
        unbinder = ButterKnife.bind(this, rootView);

        adapter = new MyAdapter(context);
        listView.setAdapter(adapter);

        // 第二步： 使用ButterKnife

        return rootView;


    }

    // 1. 这里要注意的一点是不能对RecycrView使用，因为RecyclerView就没有RecyclerView.setOnItemClickListener,
    // 而ListView是有listView.setOnItemClickListener();
    // 对于OnItemLongClick和OnItemSelected事件监听也是相同
    //2. 注意这里有坑，如果item里面有Button等这些有点击的控件事件的，需要设置这些控件属性focusable为false
   // 3. 对于 @OnItemLongClick也是如此
    @OnItemClick(R.id.Frag_list)
    public void testOnItemClick(int pos) {

        Toast.makeText(context, "click: " + adapter.names[pos], Toast.LENGTH_SHORT).show();
    }

    @OnItemLongClick(R.id.Frag_list)
    public boolean testOnItemLongClick(int pos) {
        Toast.makeText(context, "long click: " + adapter.names[pos], Toast.LENGTH_SHORT).show();
        return true;
    }

// 这里用了ListView，也可以在Spinner中使用
    @OnItemSelected(R.id.Frag_list)
    public void testOnItemSelected(int pos) {
        Toast.makeText(context, "long click: " + adapter.names[pos], Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        //第三步： 在销毁时进行解绑，不写的话，在Fragment使用ButterKnife会报错
        unbinder.unbind();
    }


}
