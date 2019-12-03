package com.bawei.liangxingsong20191203.contract;

import com.bawei.liangxingsong20191203.model.bean.Bean;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:09
 * 类名：com.bawei.liangxingsong20191203.contract
 */

public interface MyContract {
    interface IView{
        void onMySuccess(Bean bean);
        void onMyFailing(String throwable);
    }
    interface IModelCallBack{
        void onMySuccess(Bean bean);
        void onMyFailing(String throwable);
    }
}
