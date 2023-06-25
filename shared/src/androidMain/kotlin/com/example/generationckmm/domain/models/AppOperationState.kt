package com.example.generationckmm.domain.models


import com.example.generationckmm.R


data class AppOperationState(
    val error: UniversalError? = null,
    val status: DataStatus = DataStatus.CREATED
) {
    enum class DataStatus {
        CREATED, SUCCESS, ERROR, LOADING, COMPLETE
    }
}

fun unknownError() =
    AppOperationState(
        UniversalError(
            "un know error"
        )
    )

fun universalError(error: UniversalError) =
    AppOperationState(error, AppOperationState.DataStatus.ERROR)