package by.egorgutko.myproject;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component()
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
