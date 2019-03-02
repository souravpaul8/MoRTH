package com.thecombatant.morth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EnterTenderIDActivity extends AppCompatActivity {

    Button buttonGO;
    EditText enterTenderId;
    String tenderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_tender_id);

        buttonGO = findViewById(R.id.buttonGo);
        enterTenderId = (EditText) findViewById(R.id.enterTenderID);




        buttonGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tenderId=enterTenderId.getText().toString();
                if (TextUtils.isEmpty(tenderId.trim())) {
                    Toast.makeText(EnterTenderIDActivity.this, "Please enter Tender Id", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(EnterTenderIDActivity.this, EnterTenderDetailsActivity.class);
                    i.putExtra("Tender_ID", tenderId);
                    startActivity(i);

                    //Toast.makeText(EnterTenderIDActivity.this,getName(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}
