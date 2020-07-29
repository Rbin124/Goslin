package com.example.live.api;


import com.example.commonlibrary.base.BaseBean;
import com.example.live.bean.CpsIndexTBBean;
import com.example.live.bean.PublicAccountBean;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    /**
     * 获取公众号列表
     * @return  Observable<PublicAccountBean>
     */
    @POST("wxarticle/chapters/json")
    @FormUrlEncoded
    Observable<PublicAccountBean> getPublicAccountList(@FieldMap Map<String, String> map);

    /**
     * 获取公众号列表
     * @return  Observable<PublicAccountBean>
     */
    @POST("wxarticle/chapters/json")
    @FormUrlEncoded
    Observable<PublicAccountBean> getPublicAccountList2(@FieldMap Map<String, String> map);

    /***
     * 拼多多首页
     * @param uid 登陆人id
     * @return
     */
    @POST("/outside/pddHomeIndex")
    Observable<CpsIndexTBBean>getCpsPDDIndex(@Query("uid") String uid);

}
