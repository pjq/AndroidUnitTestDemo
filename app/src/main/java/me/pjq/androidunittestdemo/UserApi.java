package me.pjq.androidunittestdemo;

import java.util.concurrent.Executors;

/**
 * Created by i329817(Jianqing.Peng@sap.com) on 1/6/17.
 */

public class UserApi {
    public void register(String name, final Callback callback) {
        Executors.newFixedThreadPool(1).submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    callback.onSuccess("Success");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    callback.onFailed("failed", e);
                }

            }
        });
    }

    public static interface Callback<T> {
        void onSuccess(T result);

        void onFailed(String error, T result);

    }
}
