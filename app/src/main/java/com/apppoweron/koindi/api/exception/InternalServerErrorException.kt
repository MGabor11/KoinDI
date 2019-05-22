package com.apppoweron.koindi.api.exception

import com.apppoweron.koindi.R


class InternalServerErrorException : BaseErrorException() {

    override fun getErrorMessage(): Int {
        return R.string.internal_server_error
    }

}