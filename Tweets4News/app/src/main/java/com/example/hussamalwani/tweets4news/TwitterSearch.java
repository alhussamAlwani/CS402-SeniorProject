package com.example.hussamalwani.tweets4news;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.tweetui.TweetViewAdapter;

import java.util.List;

public class TwitterSearch extends AppCompatActivity {

    //User search setup
    private boolean flagLoading;
    private boolean endOfSearchResults;
    private static String SEARCH_QUERY = "";
    private TweetViewAdapter adapter;
    private static final String SEARCH_RESULT_TYPE = "recent";
    private static final int SEARCH_COUNT = 100;
    private long maxId;
    ListView SearchList;

    String MODIFY1 = "";
    String MODIFY2 = "";
    String MODIFY3 = "";

    private String getFirstWord(String text) {
        if (text.indexOf(' ') > -1) { // Check if there is more than one word.
            return text.substring(0, text.indexOf(' ')); // Extract first word.
        } else {
            return text; // Text is the first word itself.
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_search);setProgressBarIndeterminateVisibility(true);

        MODIFY1 = QueryVariables.queries.get(QueryVariables.queries.size() - 1);
        //MODIFY2 = MODIFY1.replaceAll("\\s+"," OR ");

        TextAnalyzer ta = new TextAnalyzer();
        MODIFY2 = ta.analyze(MODIFY1, "morphanalyzer");
        MODIFY2 = ta.analyze(MODIFY2, "disambiguator");
        MODIFY2 = ta.analyze(MODIFY2, "ner");

        String[] parts = MODIFY1.split(" ");
        MODIFY3 = parts[0] + " " + parts[1] + " exclude:retweets exclude:replies OR " + parts[0] + " " + parts[1] + " " + parts[2] + " exclude:retweets exclude:replies";

        SEARCH_QUERY = MODIFY3;
        //SEARCH_QUERY = ;
        QueryVariables.queries.clear();

        handleIntent(getIntent());
        adapter = new TweetViewAdapter(TwitterSearch.this);
        SearchList = (ListView) findViewById(R.id.search_list);
        SearchList.setAdapter(adapter);
        SearchList.setEmptyView(findViewById(R.id.loading));
        final SearchService service = Twitter.getApiClient().getSearchService();
        service.tweets(SEARCH_QUERY, null, null, null, SEARCH_RESULT_TYPE, SEARCH_COUNT, null, null,
                maxId, true, new Callback<Search>() {
                    @Override
                    public void success(Result<Search> searchResult) {

                        setProgressBarIndeterminateVisibility(false);
                        final List<Tweet> tweets = searchResult.data.tweets;
                        adapter.getTweets().addAll(tweets);
                        adapter.notifyDataSetChanged();
                        if (tweets.size() > 0) {
                            maxId = tweets.get(tweets.size() - 1).id - 1;
                        } else {
                            endOfSearchResults = true;
                        }
                        flagLoading = false;
                    }

                    @Override
                    public void failure(TwitterException error) {

                        setProgressBarIndeterminateVisibility(false);
                        Toast.makeText(TwitterSearch.this,
                                "Failed",
                                Toast.LENGTH_SHORT).show();

                        flagLoading = false;
                    }
                }
        );


//        SearchTimeline searchTimeline = new SearchTimeline.Builder().query(SEARCH_QUERY).build();
//        final TweetTimelineListAdapter timelineAdapter = new TweetTimelineListAdapter(this, searchTimeline);
//        setListAdapter(timelineAdapter);
//        getListView().setEmptyView(findViewById(R.id.loading));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.menu_search){
            return true;
        }

        // search action
//        return true;

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_twitter_search, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Enter search");

        return super.onCreateOptionsMenu(menu);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            SEARCH_QUERY = intent.getStringExtra(SearchManager.QUERY);

            /**
             * Use this query to display search results like 1. Getting the data
             * from SQLite and showing in listview 2. Making webrequest and
             * displaying the data For now we just display the query only
             */
            Log.d("Searched", SEARCH_QUERY);
        }
    }
}