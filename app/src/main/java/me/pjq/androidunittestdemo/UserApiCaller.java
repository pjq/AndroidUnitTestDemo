package me.pjq.androidunittestdemo;

import android.util.Log;

/**
 * Created by i329817(Jianqing.Peng@sap.com) on 1/6/17.
 */

public class UserApiCaller {
    private static final String TAG = "UserApiCaller";

    UserApi userApi;

    Object value;

    public Object getValue() {
        return value;
    }

    public void setUserApi(UserApi userApi) {
        this.userApi = userApi;
    }

    public void call() {
        userApi.register("jack", new UserApi.Callback() {
            @Override
            public void onSuccess(Object result) {
                Log.i(TAG, "onSuccess, result = " + result);

                value = result;
            }

            @Override
            public void onFailed(String error, Object result) {
                Log.i(TAG, "onFailed, result = " + error);
                value = result;
            }

        });
    }
}
