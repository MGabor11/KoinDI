package com.apppoweron.koindi.api.exception

import com.apppoweron.koindi.R

class BadRequestException : BaseErrorException() {
    override fun getErrorMessage(): Int {
        return R.string.bad_request_error
    }
}