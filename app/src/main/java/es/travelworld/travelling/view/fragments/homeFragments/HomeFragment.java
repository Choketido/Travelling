package es.travelworld.travelling.view.fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentHomeBinding;
import es.travelworld.travelling.view.viewmodels.LoginViewModel;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    LoginViewModel loginViewModel;
    public HomeFragment() {}

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHomeBinding.bind(view);
        loginViewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        loginViewModel.setFragmentSelected(this);
    }
}