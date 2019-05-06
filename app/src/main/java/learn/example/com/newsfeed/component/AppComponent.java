package learn.example.com.newsfeed.component;

import javax.inject.Singleton;

import dagger.Component;
import learn.example.com.newsfeed.MainActivity;
import learn.example.com.newsfeed.module.AppModule;

/**
 * Created by manisha.sharan on 06/03/19.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
