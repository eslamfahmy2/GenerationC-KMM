package com.example.generationckmm.data.wrappers

import com.example.generationckmm.R


object NoMatchingExceptionException : Exception() {
    override fun getLocalizedMessage(): String {
        return "no_matching_search"
    }
}

object NotNumberException : Exception() {
    override fun getLocalizedMessage(): String {
        return "input_not_valid"
    }
}

class JsException(
    override val message: String?,
    val statusCode: Int? = null,
) : Exception()
