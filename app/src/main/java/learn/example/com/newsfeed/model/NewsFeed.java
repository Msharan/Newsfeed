package learn.example.com.newsfeed.model;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public class NewsFeed {
    private int totalResults;
    private Article[] articles;

    public NewsFeed(int totalResults, Article[] articles) {
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Article[] getArticles() {
        return articles;
    }


}
