package learn.example.com.newsfeed.repository;

import java.util.Map;

import learn.example.com.newsfeed.model.NewsFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public interface NetworkRepository {

    @GET("top-headlines")
    Call<NewsFeed> getAllNewsFeed(@QueryMap Map<String,String> queryMap);
}
