package com.thecombatant.morth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class EnterTenderIDActivity extends AppCompatActivity {

    Button buttonGO;
    EditText enterTenderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_tender_id);

        buttonGO = findViewById(R.id.buttonGo);
        enterTenderId = findViewById(R.id.enterTenderID);

        String tenderId = enterTenderId.getText().toString();


        buttonGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(EnterTenderIDActivity.this, EnterTenderDetailsActivity.class);
                startActivity(i);
            }
        });

    }
}
