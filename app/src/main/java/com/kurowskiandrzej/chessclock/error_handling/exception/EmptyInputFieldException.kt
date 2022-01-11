package com.kurowskiandrzej.chessclock.error_handling.exception

class EmptyInputFieldException(
    message: String
) : Exception("Field $message cannot be empty.")