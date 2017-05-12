package me.azab.oa.mytourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        // Setup Toolbar
        setSupportActionBar(mToolbar);

        // Setup ViewPager
        setupViewPager(mViewPager);

        // Setup Tab Layout
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragments Here
        adapter.addFrag(new AboutFragment(),"About");
        adapter.addFrag(new PlacesFragment().newInstance(PlacesFragment.MALLS_INDEX),"Malls");
        adapter.addFrag(new PlacesFragment().newInstance(PlacesFragment.RESTAURANTS_INDEX),"Restaurants");
        adapter.addFrag(new PlacesFragment().newInstance(PlacesFragment.CINEMA_INDEX),"Cinemas");

        viewPager.setAdapter(adapter);
    }
}
