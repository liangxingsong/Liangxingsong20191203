package com.bawei.liangxingsong20191203.view.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.liangxingsong20191203.R;
import com.bawei.liangxingsong20191203.base.BaseFragment;
import com.bawei.liangxingsong20191203.util.NetUtil;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:37
 * 类名：com.bawei.liangxingsong20191203.view.fragment
 */

public class HomeFragment extends BaseFragment {
    private RelativeLayout relativeLayout;
    private TextView textView;
    @Override
    protected void initView(View view) {
        relativeLayout = view.findViewById(R.id.rl);
        textView = view.findViewById(R.id.qwe);
    }

    @Override
    protected int LayoutId() {
        return R.layout.home;
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().hasnet(getActivity())){
            textView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.INVISIBLE);
        }else{
            textView.setVisibility(View.INVISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }
}
