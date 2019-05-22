package com.apppoweron.koindi.api.exception

abstract class BaseErrorException : Exception() {

    abstract fun getErrorMessage(): Int

}