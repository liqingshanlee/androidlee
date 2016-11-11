package com.androidlee.api;

import com.androidlee.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者： 李青山
 * 创建时间： 2016/11/4.
 */

public interface TestService {
    //get请求用（Query）拼接参数
    //post用（Field）拼接参数id=1463129652953459
    @FormUrlEncoded//@FormUrlEncoded将会自动将请求参数的类型调整为application/x-www-form-urlencoded
    @POST("/appImg/sunningPhoneApp.action")
    Call<User> getImageView(@Field("page") String weidu, @Field("pageRows") String type
    );
}
