package com.hadi.bit_task.model

import com.google.gson.annotations.SerializedName

/**
 * this is the model for the api service response
 */
data class UserInfoResponse(
    val data: Data,
    val status: Boolean
)

data class MediaDataResponse(
    val data: List<Data>,
    val status: Boolean
)

data class Data(
    val id: Long,
    val title: String,
    val image: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("profile_picture") val profilePicture: String,
    val bio: String,
    val location: String,
    val counts: Counts
)

data class Counts(
    val posts: Int,
    val followers: Int,
    val following: Int
)