package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by shedeline on 8/6/2017.
 */

public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
  public TweetsArrayAdapter(@NonNull Context context, List<Tweet> tweets) {
    super(context,android.R.layout.simple_list_item_1, tweets);
  }
  //override nd setup custom template

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Tweet tweet =getItem(position);
    if(convertView == null){
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet,parent,false);
    }
    ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
    TextView  tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
    TextView  tvBody = (TextView)convertView.findViewById(R.id.tvBody);

    tvUserName.setText(tweet.getUser().getScreenName());
    tvBody.setText(tweet.getBody());
    ivProfileImage.setImageResource(android.R.color.transparent);
    Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);
    return convertView;

  }
}
