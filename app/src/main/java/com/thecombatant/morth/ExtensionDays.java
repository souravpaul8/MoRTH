package com.thecombatant.morth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExtensionDays extends AppCompatActivity {

    EditText Extensiondays;
    Button submit;
    String numberofdays;
    String tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_days);

        Extensiondays = findViewById(R.id.Days);
        submit = findViewById(R.id.submit);


        tender = getIntent().getStringExtra("tenderId");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberofdays = Extensiondays.getText().toString();
                DatabaseReference databaseweather = FirebaseDatabase.getInstance().getReference(tender);
                databaseweather.child("Propose days of extension").setValue(numberofdays);
                Toast.makeText(ExtensionDays.this, "Your Extension Application has been successfully submitted.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(ExtensionDays.this, HomeActivity.class);
                startActivity(i);

            }
        });


    }
}
