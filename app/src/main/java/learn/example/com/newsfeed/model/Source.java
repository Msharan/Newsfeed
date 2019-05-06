package learn.example.com.newsfeed.model;

/**
 * Created by manisha.sharan on 05/03/19.
 */
public class Source {
    private String id;
    private String name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
