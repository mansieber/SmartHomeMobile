package de.arkton.android.smarthomemobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import de.arkton.android.smarthomemobile.R;
import de.arkton.android.smarthomemobile.fragments.GuestFragment;
import de.arkton.android.smarthomemobile.fragments.KitchenFragment;
import de.arkton.android.smarthomemobile.fragments.OutsideFragment;
import de.arkton.android.smarthomemobile.support.MqttSender;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_CLASS = MainActivity.class.getSimpleName();
    private MqttSender sender;

    // region 1 Live cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout;
        TabLayout tabLayout;

        Log.d(LOG_CLASS,"onCreate");

        setContentView(R.layout.activity_main);

        sender = new MqttSender(this);
        sender.connect();

//        TextView logOutput = (TextView) findViewById(R.id.textViewLogData);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        TabLayout.Tab guestTab = tabLayout.newTab();
        guestTab.setText(R.string.labelTabGuest);
        tabLayout.addTab(guestTab);

        TabLayout.Tab kitchenTab = tabLayout.newTab();
        guestTab.setText(R.string.labelTabKitchen);
        tabLayout.addTab(kitchenTab);

        TabLayout.Tab outsideTab = tabLayout.newTab();
        guestTab.setText(R.string.labelTabOutside);
        tabLayout.addTab(outsideTab);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch ( tab.getPosition() ) {
                    case 0:
                        fragment = new GuestFragment();
                        break;
                    case 1:
                        fragment = new KitchenFragment();
                        break;
                    case 2:
                        fragment = new OutsideFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
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