package com.kurowskiandrzej.chessclock.error_handling.exception

import com.kurowskiandrzej.chessclock.common.Constants

class InvalidStartingTimeException(status: InvalidStartingTimeStatus): Exception(
    "Value for starting time should be " +
            "higher than ${Constants.MINIMAL_STARTING_TIME} " +
            "and lower than ${Constants.MAXIMAL_STARTING_TIME}. " +
            "Current value is ${
                when (status) {
                    InvalidStartingTimeStatus.TOO_LOW -> "too low"
                    InvalidStartingTimeStatus.TOO_HIGH -> "too high"
                }
            }."
)

enum class InvalidStartingTimeStatus {
    TOO_LOW,
    TOO_HIGH
}