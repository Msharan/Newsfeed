package learn.example.com.newsfeed.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import learn.example.com.newsfeed.model.NewsFeed;
import learn.example.com.newsfeed.repository.NewsFeedRepository;
import learn.example.com.newsfeed.utility.Constants;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public class NewsFeedViewModel extends AndroidViewModel {
    private LiveData<NewsFeed> newsFeedLiveData;
    private NewsFeedRepository mNewsFeedRepository;

    public NewsFeedViewModel(@NonNull Application application) {
        super(application);
        mNewsFeedRepository = NewsFeedRepository.getInstance();
    }

    public LiveData<NewsFeed> getAllNewsFeed() {
        newsFeedLiveData = mNewsFeedRepository.getAllNewsFeed(getParams());
        return newsFeedLiveData;
    }

    private Map<String,String> getParams() {
        Map<String,String> params = new HashMap<>();
        params.put(Constants.APIKEY,Constants.NEWS_API_KEY);
        params.put(Constants.COUNTRY,"in");
        return params;
    }
}
