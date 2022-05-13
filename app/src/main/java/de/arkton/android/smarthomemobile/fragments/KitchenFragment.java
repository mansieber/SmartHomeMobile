package de.arkton.android.smarthomemobile.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import de.arkton.android.smarthomemobile.activities.MainActivity;
import de.arkton.android.smarthomemobile.R;

/**
 * Instance of the class represents the kitchen tab of the display.
 */
public class KitchenFragment extends Fragment {
    private static final String LOG_CLASS = KitchenFragment.class.getSimpleName();

    public KitchenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_CLASS,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kitchen, container, false);
    }

}
