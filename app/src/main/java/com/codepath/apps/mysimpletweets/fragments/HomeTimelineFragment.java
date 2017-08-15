package com.codepath.apps.mysimpletweets.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.TwitterClient;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class HomeTimelineFragment extends TweetsListFragment {
  private TwitterClient client;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    client = TwitterApplication.getRestClient(); // Singleton client
    populateTimeline();
  }

  private void populateTimeline() {
    client.getHomeTimeline(new JsonHttpResponseHandler() {

      //succes
      @Override
      public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
        // Log.d("DEBUG",json.toString()); a retirer
        addAll(Tweet.fromJSONArray(json));
        // aTweets.notifyDataSetChanged(); a retirer
        //  Log.d("DEBUG", tweets.toString()); a retirer
      }

      //failure
      @Override
      public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        if(throwable != null) {
          throwable.printStackTrace();
        }

        if(errorResponse != null)
          Log.d("DEBUG",errorResponse.toString());
      }
    });
  }

}
