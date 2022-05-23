package de.arkton.android.smarthomemobile.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.arkton.android.smarthomemobile.activities.MainActivity;
import de.arkton.android.smarthomemobile.R;
import de.arkton.android.smarthomemobile.support.MqttSender;

/**
 * Instance of the class represents the guest room tab of the display.
 */
public class GuestFragment extends Fragment {
    private static final String LOG_CLASS = GuestFragment.class.getSimpleName();
    private static final String TOPIC_STAIR = "/mimahome/guest/stair/lightControl";
    private static final String TOPIC_MAIN = "/mimahome/guest/main/lightSwitch";
    private MqttSender sender;

    public GuestFragment(MqttSender sender) {
        this.sender = sender;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_CLASS, "onCreateView called");
        return inflater.inflate(R.layout.fragment_guest, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btn;

        btn = (Button) getView().findViewById(R.id.buttonGuestMainOn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sender.sendMessage(TOPIC_MAIN, "Set", "ON");
                Log.d(LOG_CLASS, "Guest Main On");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonGuestMainOff);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sender.sendMessage(TOPIC_MAIN, "Set", "OFF");
                Log.d(LOG_CLASS, "Guest Main Off");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonGuestStairOn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sender.sendMessage(TOPIC_STAIR, "Set", "ON");
                Log.d(LOG_CLASS, "Guest Stair On");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonGuestStairOff);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sender.sendMessage(TOPIC_STAIR, "Set", "OFF");
                Log.d(LOG_CLASS, "Guest Stair Off");
            }
        });
    }
}

