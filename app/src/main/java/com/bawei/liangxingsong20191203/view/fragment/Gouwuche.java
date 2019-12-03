package com.bawei.liangxingsong20191203.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.liangxingsong20191203.R;
import com.bawei.liangxingsong20191203.base.BaseFragment;
import com.bawei.liangxingsong20191203.contract.MyContract;
import com.bawei.liangxingsong20191203.model.bean.Bean;
import com.bawei.liangxingsong20191203.presenter.MyPresenter;
import com.bawei.liangxingsong20191203.view.activity.MainActivity;
import com.bawei.liangxingsong20191203.view.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  10:03
 * 类名：com.bawei.liangxingsong20191203.view.fragment
 */

public class Gouwuche extends BaseFragment implements MyContract.IView {
    private GridView gridView;
    private Button button;
    private MyPresenter myPresenter;
    private List<Bean.ShopGridDataBean> shopGridData = new ArrayList<>();
    @Override
    protected void initView(View view) {
        gridView = view.findViewById(R.id.gv);
        button = view.findViewById(R.id.button_but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.data();
            }
        });

    }

    @Override
    protected int LayoutId() {
        return R.layout.gouwuche;
    }

    @Override
    protected void initData() {
        myPresenter = new MyPresenter();
        myPresenter.getMyData(this);

    }

    @Override
    public void onMySuccess(Bean bean) {
        Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
        MyAdapter myAdapter = new MyAdapter(getActivity(),bean.getShopGridData());
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onMyFailing(String throwable) {
        Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
    }
}
