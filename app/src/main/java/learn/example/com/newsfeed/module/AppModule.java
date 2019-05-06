package learn.example.com.newsfeed.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import learn.example.com.newsfeed.MainActivity;
import learn.example.com.newsfeed.adapter.NewsListAdapter;
import learn.example.com.newsfeed.viewmodel.NewsFeedViewModel;

/**
 * Created by manisha.sharan on 06/03/19.
 */
@Module
public class AppModule {
    private FragmentActivity activity;
    private Class modelClass;

    public AppModule(FragmentActivity activity,Class modelClass) {
        this.activity = activity;
        this.modelClass = modelClass;
    }

    @Singleton
    @Provides
    public NewsFeedViewModel provideNewsFeedViewModel() {
        return (NewsFeedViewModel)ViewModelProviders.of(activity).get(modelClass);
    }

    @Singleton
    @Provides
    public NewsListAdapter provideNewsListAdapter() {
        return new NewsListAdapter(activity);
    }
}
