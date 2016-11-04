package com.androidlee.api;

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
    @FormUrlEncoded
    @POST("imageManage/findPicInfoByIdForAPP.action")
    Call<String> addReviews(@Field("ph_id") String bookId
    );
}
