package com.thecombatant.morth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class EnterTenderDetailsActivity extends AppCompatActivity {
    public int j;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Button nextHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_tender_details);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        nextHome = findViewById(R.id.nextHome);

        nextHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EnterTenderDetailsActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner4.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner5.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.date, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner6.setAdapter(adapter5);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                j = Integer.parseInt(text);
                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.month, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner2.setAdapter(adapter1);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 1) {
                            if (j % 400 == 0) {
                                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.date1, android.R.layout.simple_spinner_item);
                                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner3.setAdapter(adapter2);
                            } else {
                                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.date, android.R.layout.simple_spinner_item);
                                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner3.setAdapter(adapter2);
                            }
                        } else {
                            if (position == 7) {
                                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.date3, android.R.layout.simple_spinner_item);
                                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner3.setAdapter(adapter2);
                            }
                            if (position % 2 == 0) {
                                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.date3, android.R.layout.simple_spinner_item);
                                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner3.setAdapter(adapter2);
                            }
                            if (position % 2 != 0 && position != 7) {
                                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(EnterTenderDetailsActivity.this, R.array.date2, android.R.layout.simple_spinner_item);
                                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner3.setAdapter(adapter2);
                            }
                        }

                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                Toast.makeText(EnterTenderDetailsActivity.this, text + " " + "is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}