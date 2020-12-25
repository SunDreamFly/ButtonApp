package com.example.buttonapp.utils.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NetApi {
    @GET()
    Observable<ResponseBody> get(@Url String url);


}
