package com.bawei.liangxingsong20191203.presenter;

import com.bawei.liangxingsong20191203.contract.MyContract;
import com.bawei.liangxingsong20191203.model.MyModel;
import com.bawei.liangxingsong20191203.model.bean.Bean;
import com.bawei.liangxingsong20191203.view.fragment.Gouwuche;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:14
 * 类名：com.bawei.liangxingsong20191203.presenter
 */

public class MyPresenter {

    private MyModel myModel;

    public void getMyData(final MyContract.IView iView){
        myModel = new MyModel();
        myModel.getMyData(new MyContract.IModelCallBack() {
            @Override
            public void onMySuccess(Bean bean) {
                iView.onMySuccess(bean);
            }

            @Override
            public void onMyFailing(String throwable) {
               iView.onMyFailing(throwable);
            }
        });
    }
}
