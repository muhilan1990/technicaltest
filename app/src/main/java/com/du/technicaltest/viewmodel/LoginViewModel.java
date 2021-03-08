package com.du.technicaltest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.text.TextUtils;
import android.util.Patterns;
import com.du.technicaltest.data.LoginRepository;
import com.du.technicaltest.data.Result;
import com.du.technicaltest.data.model.LoggedInUser;
import com.du.technicaltest.R;
import com.du.technicaltest.others.LoginFormState;
import com.du.technicaltest.others.LoginResult;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    public MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    public LoginRepository loginRepository;

    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    public LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            //loginResult.setValue(new LoginResult(new LoggedInUserView("Hello")));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder email validation check
    public static boolean isUserNameValid(String username) {
        return (!TextUtils.isEmpty(username) && Patterns.EMAIL_ADDRESS.matcher(username).matches());
    }

    // A placeholder password validation check
    public boolean isPasswordValid(String password) {
        return password != null && password.trim().length() >= 6;
    }
}