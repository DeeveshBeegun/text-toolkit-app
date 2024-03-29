package com.example.sentimentanalyzer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button sentimentAnalysisButton = (Button) view.findViewById(R.id.sentiment_analysis_button);
        Button summarizerButton = (Button) view.findViewById(R.id.summarize_button);
        Button duplicateButton = (Button) view.findViewById(R.id.duplicate_button);
        Button translateButton = (Button) view.findViewById(R.id.tanslate_button);

        sentimentAnalysisButton.setOnClickListener(view1 -> {
            var fragment = new SentimentAnalysisFragment();
            replaceFragment(fragment);
        });

        summarizerButton.setOnClickListener(view2 -> {
            var fragment = new SummarizerFragment();
            replaceFragment(fragment);
        });

        duplicateButton.setOnClickListener(view2 -> {
            var fragment = new DuplicateFragment();
            replaceFragment(fragment);
        });

        translateButton.setOnClickListener(view2 -> {
            var fragment = new TranslateFragment();
            replaceFragment(fragment);
        });

        return view;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}