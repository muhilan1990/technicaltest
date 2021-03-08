package com.du.technicaltest.others;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
public class LoginResult {
//    @Nullable
//    public LoggedInUserView success;
    @Nullable
    public Integer error;

    public LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    @Nullable
    public Integer getError() {
        return error;
    }
}