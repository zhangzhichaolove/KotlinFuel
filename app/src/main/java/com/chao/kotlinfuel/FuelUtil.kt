package com.chao.kotlinfuel

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.gson.responseObject


fun String.httpGetSource(): Request {
    return Fuel.get(this)
}


inline fun <reified T : Any> String.httpGet(
    crossinline success: (result: T) -> Unit,
    crossinline error: (message: String) -> Unit
) {
    Fuel.get(this).responseObject<T> { _, _, result ->
        if (result.component2() != null) {
            error(result.component2()!!.message ?: "")
        } else {
            success(result.get())
        }
    }
}

fun String.httpPostSource(): Request {
    val listOf = listOf("a" to "c", "b" to "d")
    return Fuel.post(this, listOf)
}