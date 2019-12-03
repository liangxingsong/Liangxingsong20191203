package com.bawei.liangxingsong20191203.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:03
 * 类名：com.bawei.liangxingsong20191203.base
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(LayoutId(),container,false);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    protected abstract int LayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
}
