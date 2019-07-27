package by.egorgutko.myproject.Presenter;

import javax.inject.Inject;

import by.egorgutko.myproject.Interface.MainActivityView;
import by.egorgutko.myproject.MainActivity;

public class PresenterForList extends BasePresenter<MainActivity> {
    @Inject
    PresenterForList() {
    }

   /* public void attachView(MainActivityView view) {
        if (view != null)
            mainActivityView = view;
    }

    public void detachView() {
        mainActivityView = null;
    }
*/
    public void exitOfApp() {
        mActivity.exitOfApp();
    }
}
