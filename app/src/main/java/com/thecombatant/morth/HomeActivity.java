package com.thecombatant.morth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button WeatherRelatedHindrances;
    Button ViewSavedData;

    //for DrawerLayout
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //for DrawerLayout
        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(this);

        final String tender = getIntent().getStringExtra("Tender_01");
        final String startdateofProject = getIntent().getStringExtra("startdateProject");
        final String enddateofProject = getIntent().getStringExtra("enddateProject");
        final String registername = getIntent().getStringExtra("registername");

        final String StartStateLocation = getIntent().getStringExtra("StartStateLocation");
        final String StartDistrictLocation = getIntent().getStringExtra("StartDistrictLocation");
        final String EndDistrictLocation = getIntent().getStringExtra("EndDistrictLocation");
        final String EndStateLocation = getIntent().getStringExtra("EndStateLocation");

        final String Contact1 = getIntent().getStringExtra("ContactSite1");
        final String Contact2 = getIntent().getStringExtra("ContactSite2");

        WeatherRelatedHindrances = findViewById(R.id.weatherRelatedHindrances);
        ViewSavedData = findViewById(R.id.viewSavedData);

        WeatherRelatedHindrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(HomeActivity.this, WeatherHindranceActivity.class);
                i.putExtra("Tender_01", tender);
                i.putExtra("startdateProject", startdateofProject);
                i.putExtra("enddateProject", enddateofProject);
                i.putExtra("registername", registername);
                i.putExtra("StartStateLocation", StartStateLocation);
                i.putExtra("StartDistrictLocation", StartDistrictLocation);
                i.putExtra("EndDistrictLocation", EndDistrictLocation);
                i.putExtra("EndStateLocation", EndStateLocation);
                i.putExtra("Contact1", Contact1);
                i.putExtra("Contact2", Contact2);
                startActivity(i);
            }
        });


        ViewSavedData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SavedHindrancesListActivity.class);
                i.putExtra("Tender_01", tender);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
