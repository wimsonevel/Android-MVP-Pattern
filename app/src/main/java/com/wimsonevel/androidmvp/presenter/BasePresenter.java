package com.wimsonevel.androidmvp.presenter;

/**
 * Created by Wim on 12/31/16.
 */

public interface BasePresenter<V> {

    void attachView(V view);
    void detachView();
    boolean isViewAttached();

}