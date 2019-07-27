package by.egorgutko.myproject.Presenter;

import by.egorgutko.myproject.Interface.MainActivityView;

public abstract class BasePresenter<T> {

    T mActivity;

    public void attachView(T view) {
        if (view != null)
            mActivity = view;
    }

    public void detachView() {
        mActivity = null;
    }
}
