package co.com.alejo.exercise1;


public class PageWeb {

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    private int Id;
    private String name;
    private long websites;

    public PageWeb(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

}

