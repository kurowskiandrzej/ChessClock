package com.kurowskiandrzej.chessclock.validation

import com.kurowskiandrzej.chessclock.error_handling.exception.EmptyInputFieldException
import org.junit.Assert.assertThrows
import org.junit.Test

class InputTextValidationTest {

    @Test
    fun emptyInputFieldThrowsException() {
        assertThrows(EmptyInputFieldException::class.java) {
            InputTextValidation.Builder()
                .setText("  ")
                .setFieldName("name")
                .setAllowEmpty(false)
                .validate()
        }
    }
}