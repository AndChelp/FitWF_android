package com.example.fitwf;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitwf.fragment.SettingsFragment;
import com.example.fitwf.fragment.WatchFacesFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private View drawerHeader;
    private LinearLayout drawerLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nd_open, R.string.nd_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerSlideAnimationEnabled(false);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WatchFacesFragment()).commit();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        drawerHeader = navigationView.getHeaderView(0);
        navigationView.setCheckedItem(R.id.mi_wf_list);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLoginButton = drawerHeader.findViewById(R.id.ll_nd_login);
        drawerLoginButton.setOnClickListener(this);

        ImageView logoutIcon = drawerHeader.findViewById(R.id.iv_logout);
        logoutIcon.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_logout:
                drawerLoginButton.setVisibility(View.VISIBLE);
                drawerHeader.findViewById(R.id.nd_logged).setVisibility(View.INVISIBLE);
                Snackbar.make(drawerLayout, "Logged out", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case R.id.ll_nd_login:
                drawerLoginButton.setVisibility(View.INVISIBLE);
                drawerHeader.findViewById(R.id.nd_logged).setVisibility(View.VISIBLE);
                Snackbar.make(drawerLayout, "Logged in", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_wf_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WatchFacesFragment()).commit();
                break;
            case R.id.mi_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}










