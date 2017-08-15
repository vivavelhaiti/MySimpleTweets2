package com.codepath.apps.mysimpletweets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.fragments.HomeTimelineFragment;
import com.codepath.apps.mysimpletweets.fragments.MentionsTimelineFragment;

public class TimelineActivity extends ActionBarActivity {
//  private TweetsListFragment fragmentTweetsList; a retirer

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timeline);

    ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
    vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
    PagerSlidingTabStrip tabStrip =(PagerSlidingTabStrip) findViewById(R.id.tabs);
    tabStrip.setViewPager(vpPager);
  }

  @Override
  public boolean onCreateOptionsMenu (Menu menu){
    getMenuInflater().inflate(R.menu.menu_timeline,menu);
  return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
    int id = item.getItemId();

    if (id == R.id.action_settings){
      return  true;
    }

    return super.onOptionsItemSelected(item);
  }

  public class TweetsPagerAdapter extends FragmentPagerAdapter {
    final  int PAGE_COUNT =2;
    private  String tabTitles[]= {"Home","Mentions"};

    public TweetsPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      if (position == 0){
        return new HomeTimelineFragment();
      } else if (position == 1){
        return new MentionsTimelineFragment();
      }else {
        return null;
      }
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return tabTitles [position];
    }

    @Override
    public int getCount() {
      return tabTitles.length;
    }
  }

}
