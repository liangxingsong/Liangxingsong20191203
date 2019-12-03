package com.bawei.liangxingsong20191203.model;

import com.bawei.liangxingsong20191203.contract.MyContract;
import com.bawei.liangxingsong20191203.model.bean.Bean;
import com.bawei.liangxingsong20191203.util.NetUtil;
import com.google.gson.Gson;

/**
 * 作者：梁兴松
 * 时间：2019/12/3  9:05
 * 类名：com.bawei.liangxingsong20191203.model
 */

public class MyModel {
    public void getMyData(final MyContract.IModelCallBack iModelCallBack){
        NetUtil.getInstance().doget("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallBack() {
            @Override
            public void doget(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallBack.onMySuccess(bean);
            }

            @Override
            public void Error(String throwable) {
                iModelCallBack.onMyFailing(throwable);
            }
        });
    }
}
