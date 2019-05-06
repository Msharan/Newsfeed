package learn.example.com.newsfeed;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import learn.example.com.newsfeed.adapter.NewsListAdapter;
import learn.example.com.newsfeed.component.AppComponent;
import learn.example.com.newsfeed.component.DaggerAppComponent;
import learn.example.com.newsfeed.model.NewsFeed;
import learn.example.com.newsfeed.module.AppModule;
import learn.example.com.newsfeed.viewmodel.NewsFeedViewModel;

public class MainActivity extends AppCompatActivity {
    @Inject
    NewsFeedViewModel mNewsFeedViewModel;
    @Inject
    NewsListAdapter mNewsAdapter;
    private NewsFeed mNewsFeed;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DaggerAppComponent.builder().appModule(new AppModule(this,NewsFeedViewModel.class)).build().inject(this);

        mRecyclerView.setAdapter(mNewsAdapter);
        ((NewsFeedViewModel) mNewsFeedViewModel).getAllNewsFeed().observe(MainActivity.this, new Observer<NewsFeed>() {
            @Override
            public void onChanged(@Nullable NewsFeed newsFeed) {
                mNewsFeed = newsFeed;
                mNewsAdapter.setNewsFeed(mNewsFeed);
                mRecyclerView.setAdapter(mNewsAdapter);
                Log.d("manisha",String.valueOf(newsFeed.getTotalResults()));
            }
        });
    }
}
