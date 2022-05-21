package de.arkton.android.smarthomemobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import de.arkton.android.smarthomemobile.R;
import de.arkton.android.smarthomemobile.fragments.GuestFragment;
import de.arkton.android.smarthomemobile.fragments.KitchenFragment;
import de.arkton.android.smarthomemobile.fragments.OutsideFragment;
import de.arkton.android.smarthomemobile.fragments.ViewPagerAdapter;
import de.arkton.android.smarthomemobile.support.MqttSender;

public class MainActivity extends AppCompatActivity {

    // region 0 Class members

    private static final String LOG_CLASS = MainActivity.class.getSimpleName();
    private MqttSender sender;

    // region 1 Live cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabLayout tabLayout;
        ViewPager viewPager;

        Log.d(LOG_CLASS,"onCreate");

        setContentView(R.layout.activity_main);

        sender = new MqttSender(this);
        sender.connect();

//        TextView logOutput = (TextView) findViewById(R.id.textViewLogData);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new KitchenFragment(), getResources().getString(R.string.labelTabKitchen));
        vpAdapter.addFragment(new GuestFragment(), getResources().getString(R.string.labelTabGuest));
        vpAdapter.addFragment(new OutsideFragment(), getResources().getString(R.string.labelTabOutside));
        viewPager.setAdapter(vpAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_CLASS,"onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_CLASS,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_CLASS,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_CLASS, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_CLASS, "onDestroy");

        sender.closeConnection();
    }

    //endregion

    // region 2 Private methods

    //endregion

    //region 3 Public methods
    public void setStatus(String msg) {
        TextView statusOutput = (TextView) findViewById(R.id.textViewConnectionStatus);
        statusOutput.setText(msg);
    }

    //endregion
}