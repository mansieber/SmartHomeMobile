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
 * Instance of the class represents the guest room tab of the display.
 */
public class GuestFragment extends Fragment {
    private static final String LOG_CLASS = GuestFragment.class.getSimpleName();

    public GuestFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_CLASS,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guest, container, false);
    }

}

