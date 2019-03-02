package com.thecombatant.morth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button WeatherRelatedHindrances;
    Button ViewSavedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final String tender = getIntent().getStringExtra("Tender_01");
        final String startdateofProject = getIntent().getStringExtra("startdateProject");
        final String enddateofProject = getIntent().getStringExtra("enddateProject");

        WeatherRelatedHindrances = findViewById(R.id.weatherRelatedHindrances);
        ViewSavedData = findViewById(R.id.viewSavedData);

        WeatherRelatedHindrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(HomeActivity.this, WeatherHindranceActivity.class);
                i.putExtra("Tender_01", tender);
                i.putExtra("startdateProject", startdateofProject);
                i.putExtra("enddateProject", enddateofProject);
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
}
