package by.egorgutko.myproject;

import javax.inject.Singleton;

import by.egorgutko.myproject.Data.ListFragment;
import dagger.Component;

@Singleton
@Component()
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(ListFragment listFragment);
    void inject(ListActivity listActivity);

}
