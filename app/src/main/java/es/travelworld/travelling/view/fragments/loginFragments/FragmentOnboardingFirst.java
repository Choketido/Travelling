package es.travelworld.travelling.view.fragments.loginFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentOnboardingFirstBinding;
import es.travelworld.travelling.view.viewmodels.LoginViewModel;

public class FragmentOnboardingFirst extends Fragment {

    private FragmentOnboardingFirstBinding binding;
    private LoginViewModel loginViewModel;

    public FragmentOnboardingFirst() {
    }

    public static FragmentOnboardingFirst newInstance() {
        return new FragmentOnboardingFirst();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        listeners();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_OnboardingActivity);
        return inflater.cloneInContext(contextTheme);
    }

    private void listeners() {
        binding.ob2NextBtn.setOnClickListener(v -> {
            ViewPager2 viewPager = requireActivity().findViewById(R.id.obViewPager);
            viewPager.setCurrentItem(1);
        });
    }
}