package com.bawei.liangxingsong20191203.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:02
 * 类名：com.bawei.liangxingsong20191203.base
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int LayoutId();
}
