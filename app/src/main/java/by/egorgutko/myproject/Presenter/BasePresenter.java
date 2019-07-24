package by.egorgutko.myproject.Presenter;

import by.egorgutko.myproject.Interface.MainActivityView;

public abstract class BasePresenter {

    MainActivityView mainActivityView;

    public void attachView(MainActivityView view) {
        if (view != null)
            mainActivityView = view;
    }

    public void detachView() {
        mainActivityView = null;
    }
}
