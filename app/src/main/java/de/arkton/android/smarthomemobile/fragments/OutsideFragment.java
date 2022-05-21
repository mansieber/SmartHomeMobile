package de.arkton.android.smarthomemobile.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.arkton.android.smarthomemobile.R;

/**
 * Instance of the class represents the outside tab of the display.
 */
public class OutsideFragment extends Fragment {
    private static final String LOG_CLASS = OutsideFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_CLASS, "onCreateView called");
        return inflater.inflate(R.layout.fragment_outside, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button btn;

        btn = (Button) getView().findViewById(R.id.buttonOutsideEastLightOn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Outside East Light On");
            }
        });

        btn = (Button) getView().findViewById(R.id.buttonOutsideEastLightOff);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(LOG_CLASS, "Outside East Light Off");
            }
        });
    }
}