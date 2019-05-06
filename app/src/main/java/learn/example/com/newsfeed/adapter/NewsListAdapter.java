package learn.example.com.newsfeed.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import learn.example.com.newsfeed.R;
import learn.example.com.newsfeed.model.NewsFeed;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.Viewmodel>  {
    private Context context;
    private NewsFeed mNewsFeed;

    public NewsListAdapter(Context context) {
        this.context = context;
    }

    public void setNewsFeed(NewsFeed mNewsFeed) {
        this.mNewsFeed = mNewsFeed;
    }

    @NonNull
    @Override
    public Viewmodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Viewmodel(LayoutInflater.from(context).inflate(R.layout.news_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewmodel viewmodel, int position) {
        if(position < mNewsFeed.getTotalResults()) {
            viewmodel.description.setText(mNewsFeed.getArticles()[position].getDescription());
            viewmodel.title.setText(mNewsFeed.getArticles()[position].getTitle());
            Glide.with(context).load(mNewsFeed.getArticles()[position].getUrlToImage()).centerCrop().into(viewmodel.imageView);
        }
    }

    @Override
    public int getItemCount() {
        if(mNewsFeed!=null)
            return mNewsFeed.getTotalResults();
        return 0;
    }

    class Viewmodel extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView description,title;

        public Viewmodel(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            title = itemView.findViewById(R.id.title);
        }
    }
}
