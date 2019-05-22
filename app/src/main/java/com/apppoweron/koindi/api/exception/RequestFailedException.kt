package com.apppoweron.koindi.api.exception

import com.apppoweron.koindi.R

class RequestFailedException : BaseErrorException() {
    override fun getErrorMessage(): Int {
        return R.string.request_failed
    }
}