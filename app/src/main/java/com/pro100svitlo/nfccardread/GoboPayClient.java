package com.pro100svitlo.nfccardread;

import com.pro100svitlo.nfccardread.dto.OrderDetails;
import com.pro100svitlo.nfccardread.dto.OrderId;
import com.pro100svitlo.nfccardread.dto.Payment;
import com.pro100svitlo.nfccardread.dto.Registration;
import com.pro100svitlo.nfccardread.dto.TableId;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GoboPayClient {

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/register")
    Call<Registration> register(@Body TableId tableId);

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/checkout")
    Call<OrderDetails> checkout(@Body OrderId orderId);

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/pay")
    Call<Void> pay(@Body Payment payment);
}