package com.hadi.bit_task.data

data class ApiResult(
    var resultData: Any? = null,
    var responseCode: Int? = 0,
    var throwable: Throwable? = null
)