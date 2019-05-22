package com.apppoweron.koindi.api.exception

import com.apppoweron.koindi.R
import com.apppoweron.koindi.api.exception.BaseErrorException


class NoInternetException : BaseErrorException() {

    override fun getErrorMessage(): Int {
        return R.string.internet_connection_error
    }

}