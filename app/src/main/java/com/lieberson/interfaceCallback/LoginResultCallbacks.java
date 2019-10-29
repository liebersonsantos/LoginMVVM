package com.lieberson.interfaceCallback;

public interface LoginResultCallbacks {

    void onSuccess(String message);
    void onError(String messageError);

}
