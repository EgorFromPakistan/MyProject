package by.egorgutko.myproject.Presenter;

import by.egorgutko.myproject.Interface.MainActivityView;

public abstract class BasePresenter<TypeOfActicity> {

    TypeOfActicity mActivity;

    public void attachView(TypeOfActicity view) {
        if (view != null)
            mActivity = view;
    }

    public void detachView() {
        mActivity = null;
    }
}
