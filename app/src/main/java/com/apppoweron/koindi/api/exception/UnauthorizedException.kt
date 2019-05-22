package com.apppoweron.koindi.api.exception

import com.apppoweron.koindi.R
import com.apppoweron.koindi.api.exception.BaseErrorException


class UnauthorizedException : BaseErrorException() {
    override fun getErrorMessage(): Int {
        return R.string.unauthorized_error
    }
}