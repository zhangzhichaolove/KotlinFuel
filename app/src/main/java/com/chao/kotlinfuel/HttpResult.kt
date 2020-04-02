package com.chao.kotlinfuel

data class HttpResult<T>(var success: Boolean = false, var msg: String = "", var result: T)