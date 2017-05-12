package me.azab.oa.mytourguide;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout mFrameLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI
        mFrameLayout = (FrameLayout) findViewById(R.id.main_container);

        // Add Fragment to framelayout
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        BlankFragment mFragment = new BlankFragment();
        mFragmentTransaction.add(R.id.main_container,new PlacesFragment());
        mFragmentTransaction.commit();
    }
}
