package learn.example.com.newsfeed.component;

import javax.inject.Singleton;

import dagger.Component;
import learn.example.com.newsfeed.module.NetworkModule;
import learn.example.com.newsfeed.repository.NewsFeedRepository;

/**
 * Created by manisha.sharan on 06/03/19.
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    void inject(NewsFeedRepository newsFeedRepository);
}
