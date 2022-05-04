package de.arkton.android.smarthomemobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import de.arkton.android.smarthomemobile.R;

public class OutsideActivity extends AppCompatActivity {
    private static final String LOG_CLASS = OutsideActivity.class.getSimpleName();

    // region 1 Live cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_CLASS,"onStart");

        setContentView(R.layout.activity_outside);
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
    }

    //endregion
}