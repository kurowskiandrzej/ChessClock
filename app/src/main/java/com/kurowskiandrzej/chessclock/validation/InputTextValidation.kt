package com.kurowskiandrzej.chessclock.validation

import com.kurowskiandrzej.chessclock.error_handling.exception.EmptyInputFieldException
import com.kurowskiandrzej.chessclock.error_handling.exception.InvalidInputLengthException

class InputTextValidation private constructor(builder: Builder) {

    class Builder {
        lateinit var text: String
        lateinit var fieldName: String
        var allowEmpty = false
        var minimumLength: Int? = null
        var maximumLength: Int? = null

        fun setText(text: String) = apply { this.text = text.trim() }
        fun setFieldName(name: String) = apply { this.fieldName = name }
        fun setAllowEmpty(allowEmpty: Boolean) = apply { this.allowEmpty = allowEmpty }
        fun setMinimumLength(length: Int) = apply { this.minimumLength = length }
        fun setMaximumLength(length: Int) = apply { this.maximumLength = length }
        fun validate() = InputTextValidation(this)
    }

    init {
        val text = builder.text

        if (!builder.allowEmpty && text.isEmpty()) {
            throw EmptyInputFieldException(builder.fieldName)
        }

        builder.minimumLength?.let { minimumLength ->
            if (text.length < minimumLength) {
                throw InvalidInputLengthException()
            }
        }
    }
}