package com.example.home.api;

import com.example.commonlibrary.base.BaseBean;
import com.example.home.bean.CpsIndexTBBean;
import com.example.home.bean.CpsIndexTBListBean;
import com.example.home.bean.PublicAccountBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    /**
     * 获取公众号列表
     *
     * @return Observable<PublicAccountBean>
     */
    @POST("wxarticle/chapters/json")
    @FormUrlEncoded
    Observable<PublicAccountBean> getPublicAccountList(@FieldMap Map<String, String> map);

    /**
     * 获取公众号列表
     *
     * @return Observable<PublicAccountBean>
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
    Observable<BaseBean<CpsIndexTBBean>> getCpsPDDIndex(@Query("uid") String uid);

    /***
     * 淘宝分类id
     * @param id 拼多多分类id
     * @return
     */
    @POST("/outside/tbHomeSearchGoodsList")
    Observable<BaseBean<List<CpsIndexTBListBean>>> getPDDCategoryList(@Query("mid") String uid, @Query("id") String id, @Query("page") int page, @Query("pageSize") int pageSize);

}
