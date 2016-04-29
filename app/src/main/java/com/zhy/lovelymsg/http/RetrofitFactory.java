package com.zhy.lovelymsg.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 * 创建时间: 16/4/11 下午4:49 <br/>
 *
 * @author zhaohaiyang
 * @since v0.0.1
 */
public class RetrofitFactory<T> {

    public static final String API_URL = "https://api.github.com";

    private static RetrofitFactory instance;

    private RetrofitFactory() {

    }


    public T createRetrofit(Class<T> clazz) {

        if (null == instance) {
            synchronized (RetrofitFactory.class) {
                if (null == instance) {
                    instance = new RetrofitFactory();
                }
            }
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);

    }
}
