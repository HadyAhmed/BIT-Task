package com.hadi.bit_task.data

import com.hadi.bit_task.model.MediaDataResponse
import com.hadi.bit_task.model.UserInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //http://i0sa.com/bit/task/profile
    @GET("bit/task/profile")
    fun getProfile(): Call<UserInfoResponse>

    //http://i0sa.com/bit/task/home
    @GET("bit/task/home")
    fun getProfileMedia(): Call<MediaDataResponse>
}