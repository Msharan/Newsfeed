package learn.example.com.newsfeed.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import learn.example.com.newsfeed.repository.NetworkRepository;
import learn.example.com.newsfeed.utility.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by manisha.sharan on 06/03/19.
 */
@Module
public class NetworkModule {
    private HttpLoggingInterceptor interceptor;
    private OkHttpClient client;
    private Retrofit mRetrofit;
    private NetworkRepository mNetworkRepository;

    @Singleton
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        interceptor = new HttpLoggingInterceptor();
        return interceptor;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return client;
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.NEWS_BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return mRetrofit;
    }

    @Singleton
    @Provides
    public NetworkRepository provideNetworkRepository(Retrofit mRetrofit){
        mNetworkRepository = mRetrofit.create(NetworkRepository.class);
        return mNetworkRepository;
    }
}
