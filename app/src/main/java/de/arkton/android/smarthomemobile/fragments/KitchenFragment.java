package de.arkton.android.smarthomemobile.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.arkton.android.smarthomemobile.R;

import de.arkton.android.smarthomemobile.activities.MainActivity;

/**
 * Instance of the class represents the kitchen tab of the display.
 */
public class KitchenFragment extends Fragment {
    private static final String LOG_CLASS = KitchenFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_CLASS, "onCrateView called");
        return inflater.inflate(R.layout.fragment_kitchen, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btn;

        btn = (Button) getView().findViewById(R.id.buttonKitchenStripeOn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Kitchen Stripe On");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonKitchenStripeOff);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Kitchen Stripe Off");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonKitchenStripePlus);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Kitchen Stripe Increase");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonKitchenStripeMinus);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Kitchen Stripe Decrease");
            }
        });
    }
}
