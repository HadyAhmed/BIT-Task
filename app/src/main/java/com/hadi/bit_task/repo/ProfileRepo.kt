package com.hadi.bit_task.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hadi.bit_task.data.ApiResult
import com.hadi.bit_task.data.NetworkClient
import com.hadi.bit_task.model.MediaDataResponse
import com.hadi.bit_task.model.UserInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ProfileRepo {
    companion object {
        val mInstance = ProfileRepo()
    }

    private val apiService = NetworkClient.mInstance.apiService()

    fun fetchProfile(): LiveData<ApiResult> {
        val profileResponse = MutableLiveData<ApiResult>()

        Timber.i("fetchProfile ${apiService.getProfileMedia().request().url}")

        apiService.getProfile().enqueue(object : Callback<UserInfoResponse> {
            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                profileResponse.value = ApiResult(throwable = t)
            }

            override fun onResponse(
                call: Call<UserInfoResponse>,
                response: Response<UserInfoResponse>
            ) {
                if (response.body() != null && response.isSuccessful) {
                    profileResponse.value = ApiResult(resultData = response.body())
                } else {
                    profileResponse.value = ApiResult(responseCode = response.code())
                }
            }
        })
        return profileResponse
    }

    fun fetchProfileMedia(): LiveData<ApiResult> {
        val profileMediaResponse = MutableLiveData<ApiResult>()

        Timber.i("fetchProfileMedia ${apiService.getProfileMedia().request().url}")

        apiService.getProfileMedia().enqueue(object : Callback<MediaDataResponse> {
            override fun onFailure(call: Call<MediaDataResponse>, t: Throwable) {
                profileMediaResponse.value = ApiResult(throwable = t)
            }

            override fun onResponse(
                call: Call<MediaDataResponse>,
                response: Response<MediaDataResponse>
            ) {
                if (response.body() != null && response.isSuccessful) {
                    profileMediaResponse.value = ApiResult(resultData = response.body())
                } else {
                    profileMediaResponse.value = ApiResult(responseCode = response.code())
                }
            }
        })
        return profileMediaResponse
    }

}