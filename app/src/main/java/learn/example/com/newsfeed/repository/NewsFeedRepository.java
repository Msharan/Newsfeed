package learn.example.com.newsfeed.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

import learn.example.com.newsfeed.component.DaggerNetworkComponent;
import learn.example.com.newsfeed.model.NewsFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public class NewsFeedRepository {
    private static NewsFeedRepository mInstance;
    @Inject
     NetworkRepository mNetworkRepository;

    public NewsFeedRepository() {
        DaggerNetworkComponent.builder().build().inject(this);
    }

    public static NewsFeedRepository getInstance() {
        if(mInstance == null) {
            synchronized (NewsFeedRepository.class) {
                if(mInstance == null) {
                    mInstance = new NewsFeedRepository();
                }
            }
        }
        return mInstance;
    }

    public LiveData<NewsFeed> getAllNewsFeed(Map<String,String> params) {
        final MutableLiveData<NewsFeed> mutableLiveData = new MutableLiveData<>();
        mNetworkRepository.getAllNewsFeed(params).enqueue(new Callback<NewsFeed>() {
            @Override
            public void onResponse(Call<NewsFeed> call, Response<NewsFeed> response) {
                if(!response.isSuccessful()) {
                    Log.d("manisha","Error in response");
                } else
                    mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsFeed> call, Throwable t) {
                Log.d("manisha","Failure in response");
            }
        });
        return mutableLiveData;
    }

}
