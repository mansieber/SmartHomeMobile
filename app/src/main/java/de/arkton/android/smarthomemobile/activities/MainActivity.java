package de.arkton.android.smarthomemobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import de.arkton.android.smarthomemobile.R;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_CLASS = MainActivity.class.getSimpleName();

    // region 1 Live cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_CLASS,"onCreate");

        setContentView(R.layout.activity_main);

        EditText logOutput = (EditText) findViewById(R.id.editLogData);
        Button guestButton = (Button) findViewById(R.id.buttonGuest);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                logOutput.append("Guest Button Clicked\n");
                startGuestActivity();
            }
        });
        Button kitchenButton = (Button) findViewById(R.id.buttonKitchen);
        kitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                logOutput.append("Kitchen Button Clicked\n");
                startKitchenActivity();
            }
        });
        Button outsideButton = (Button) findViewById(R.id.buttonOutside);
        outsideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View buttonView) {
                logOutput.append("Outside Button Clicked\n");
                startOutsideActivity();
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
    }

    //endregion

    // region 2 Private methods
    private void startGuestActivity() {
        Log.d(LOG_CLASS, "Start GuestActivity");
        Intent intent = new Intent(this, GuestActivity.class);
        startActivity(intent);
    }

    private void startKitchenActivity() {
        Log.d(LOG_CLASS, "Start KitchenActivity");
        Intent intent = new Intent(this, KitchenActivity.class);
        startActivity(intent);
    }

    private void startOutsideActivity() {
        Log.d(LOG_CLASS, "Start OutsideActivity");
        Intent intent = new Intent(this, OutsideActivity.class);
        startActivity(intent);
    }

    //endregion
}