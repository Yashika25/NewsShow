package com.example.yashika.newsshow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link YashAdapter} knows how to create a list item layout for each news in the
 * data source (a list of {@link YashNews} objects).
 * <p>
 * These list item layouts will be provided to adapter view like ListView to be displayed to user.
 */
public class YashAdapter extends ArrayAdapter<YashNews> {

    private static final String DATE_SEPERATOR = "T";
    private Context mContext;

    /**
     * Constructs a new {@link YashAdapter}
     *
     * @param context  is the context of the app.
     * @param yashNews is the list of the news, which is the source of the adapter.
     */
    public YashAdapter(Context context, List<YashNews> yashNews) {
        super(context, 0, yashNews);
        mContext = context;
    }

    /**
     * Returns a list item view that displays information about the news by a given author
     * in the list of news.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*Check if there is an existing list item view (called convertView) that we can reuse,
        otherwise, if convertView is null, then inflate a new list item layout. */
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.news_list_item, parent, false);
        }

        //Find the news by a given author in the list of news.
        YashNews currentNews = getItem(position);

        //Find the text view with view id title_news.
        TextView titleView = listItemView.findViewById(R.id.title_news);
        String titleOfNews = currentNews.getTitle();
        // Display the title of the current news in that TextView
        titleView.setText(titleOfNews);

        TextView authorView = listItemView.findViewById(R.id.author_news);
        String authorOfNews = currentNews.getDetails();
        authorView.setText(authorOfNews);

        String date;
        String dateTime = currentNews.getDate();
        if (dateTime.contains(DATE_SEPERATOR)) {
            String[] parts = dateTime.split(DATE_SEPERATOR);
            date = parts[0];
        } else {
            date = getContext().getString(R.string.no_date);
        }
        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(date);
        //Return the list item view  that is now showing the appropriate data.
        return listItemView;
    }

}