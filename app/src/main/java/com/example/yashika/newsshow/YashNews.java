package com.example.yashika.newsshow;

/**
 * An {@link YashNews} object contains information related to a single news.
 */
public class YashNews {

    //Title of the news
    private String newsTitle;

    //Details of the news
    private String newsDetails;

    //Time of the news
    private String newsDate;

    /**
     * Website URL of the news
     */
    private String newsUrl;

    /**
     * Constructs a new {@link YashNews} object.
     *
     * @param title   is the title or heading of the news.
     * @param details is the author and section name of the news.
     * @param date    is the date when news got published.
     * @param url     is the website URL to find more details about the news.
     */
    public YashNews(String title, String details, String date, String url) {
        newsTitle = title;
        newsDetails = details;
        newsDate = date;
        newsUrl = url;
    }

    //Returns the heading of the news
    public String getTitle() {
        return newsTitle;
    }

    //Returns the writer of the news
    public String getDetails() {
        return newsDetails;
    }

    //Returns the Time of the news
    public String getDate() {
        return newsDate;
    }

    //Returns the website URL to find more information about the news
    public String getUrl() {
        return newsUrl;
    }

}
