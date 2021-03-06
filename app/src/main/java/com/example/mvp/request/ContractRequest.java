package com.example.mvp.request;

import com.example.mvp.model.Entity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface ContractRequest {

    @GET("/api/data/Android/{page}/{limit}")
    Observable<Entity> getData(@Path("page") int page, @Path("limit") int limit);
}
