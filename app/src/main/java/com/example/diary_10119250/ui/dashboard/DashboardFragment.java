//10119250
//Najib Raffi Irdiana
//IF-4

package com.example.diary_10119250.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diary_10119250.MainActivity;
import com.example.diary_10119250.R;
import com.example.diary_10119250.databinding.FragmentDashboardBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class DashboardFragment extends Fragment{

    private MainActivity mainActivity;
    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        ((MainActivity)getActivity()).updateStatusBarColor("#020202");
        View root = binding.getRoot();
        TabLayout tabLayout = binding.profileLayout;
        selectedTab(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    private void selectedTab(int position) {
            Fragment tabFragment = null;
//            if(position == 1){
//                tabFragment = new ContactFragment();
//            } else if(position == 2) {
//                tabFragment = new FindmeFragment();
//            } else {
//                tabFragment = new DetailProfileFragment();
//            }
            if(position == 1){
                tabFragment = new Tempat2Fragment();
            } else if(position == 2) {
                tabFragment = new Tempat3Fragment();
            } else if(position == 3) {
                    tabFragment = new Tempat4Fragment();
            } else if(position == 4) {
                    tabFragment = new Tempat5Fragment();
            } else if(position == 5) {
                tabFragment = new LokasiFragment();
            }else {
                tabFragment = new Tempat1Fragment();
            }

            FragmentManager fm = getChildFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.profile_linear, tabFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.commit();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}