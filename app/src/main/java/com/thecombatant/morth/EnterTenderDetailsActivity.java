package com.thecombatant.morth;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class EnterTenderDetailsActivity extends AppCompatActivity {

    Button next;
    TextView tenderIdTextView;
    EditText registerName;
    TextView StartDateofpro;
    TextView EndDateofpro;
    String GetTenderId;
    String Prodate;
    String ProjectStart;
    String ProjectEnd;
    String nameregistered;



    DatePickerDialog.OnDateSetListener startDateProject;
    DatePickerDialog.OnDateSetListener endDateProject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_tender_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        StartDateofpro=findViewById(R.id.startDate);
        EndDateofpro=findViewById(R.id.enddate);
        next=findViewById(R.id.nextHome);
        tenderIdTextView = findViewById(R.id.TenderIdtextView);
        registerName = findViewById(R.id.RegisteredName);

        final String tender = getIntent().getStringExtra("Tender_ID");
        tenderIdTextView.setText(tender);


        //Adding state spinner
        Spinner stateStart = findViewById(R.id.spinnerStatestart);
        Spinner stateEnd = findViewById(R.id.spinnerStateEnd);

        ArrayAdapter<CharSequence> ada = ArrayAdapter.createFromResource(this, R.array.india_states, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ada0 = ArrayAdapter.createFromResource(this, R.array.jharkhand, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ada1 = ArrayAdapter.createFromResource(this, R.array.odisha, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ada2 = ArrayAdapter.createFromResource(this, R.array.bihar, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ada3 = ArrayAdapter.createFromResource(this, R.array.rajasthan, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ada4 = ArrayAdapter.createFromResource(this, R.array.tamilnadu, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ad5 = ArrayAdapter.createFromResource(this, R.array.eastSinghbhum, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ad6 = ArrayAdapter.createFromResource(this, R.array.westSinghbhum, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ad7 = ArrayAdapter.createFromResource(this, R.array.Khordha, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> ad8 = ArrayAdapter.createFromResource(this, R.array.Cuttack, android.R.layout.simple_spinner_item);
        ada.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ada0.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ada1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ada2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ada3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ada4.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ad5.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ad6.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ad7.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ad8.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        stateStart.setAdapter(ada);
        stateEnd.setAdapter(ada);
        stateStart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Spinner s =  findViewById(R.id.spinnerStatestart);
                String word = adapterView.getItemAtPosition(i).toString();
                if (word.equals(word)) {
                    Spinner startDistrict = findViewById(R.id.spinnerDistrictstart);

                    switch (i) {
                        case 0:
                            startDistrict.setAdapter(ada0);
                            startDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    String districtWord = parent.getItemAtPosition(position).toString();
                                    if (districtWord.equals(districtWord)) {
                                        Spinner startLocality = findViewById(R.id.spinnerLocalitystart);
                                        switch (position) {
                                            case 0:
                                                startLocality.setAdapter(ad5);
                                                break;
                                            case 1:
                                                startLocality.setAdapter(ad6);
                                                break;
                                        }
                                    }


                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;
                        case 1:
                            startDistrict.setAdapter(ada1);
                            startDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    String districtWord = parent.getItemAtPosition(position).toString();
                                    if (districtWord.equals(districtWord)) {
                                        Spinner startLocality = findViewById(R.id.spinnerLocalitystart);
                                        switch (position) {
                                            case 0:
                                                startLocality.setAdapter(ad7);
                                                break;
                                            case 1:
                                                startLocality.setAdapter(ad8);
                                                break;
                                        }
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;
                        case 2:
                            startDistrict.setAdapter(ada2);
                            break;
                        case 3:
                            startDistrict.setAdapter(ada3);
                            break;
                        case 4:
                            startDistrict.setAdapter(ada4);
                            break;


                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        stateEnd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view, int position, long id) {
                String word1 = parent1.getItemAtPosition(position).toString();
                if (word1.equals(word1)) {
                    Spinner endDistrict = findViewById(R.id.spinnerDistrictEnd);
                    switch (position) {
                        case 0:
                            endDistrict.setAdapter(ada0);
                            endDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    String districtWord = parent.getItemAtPosition(position).toString();
                                    if (districtWord.equals(districtWord)) {
                                        Spinner endLocality = findViewById(R.id.spinnerLocalityEnd);
                                        switch (position) {
                                            case 0:
                                                endLocality.setAdapter(ad5);
                                                break;
                                            case 1:
                                                endLocality.setAdapter(ad6);
                                                break;
                                        }
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;
                        case 1:
                            endDistrict.setAdapter(ada1);
                            endDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    String districtWord = parent.getItemAtPosition(position).toString();
                                    if (districtWord.equals(districtWord)) {
                                        Spinner endLocality = findViewById(R.id.spinnerLocalityEnd);
                                        switch (position) {
                                            case 0:
                                                endLocality.setAdapter(ad7);
                                                break;
                                            case 1:
                                                endLocality.setAdapter(ad8);
                                                break;
                                        }
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;
                        case 2:
                            endDistrict.setAdapter(ada2);
                            break;
                        case 3:
                            endDistrict.setAdapter(ada3);
                            break;
                        case 4:
                            endDistrict.setAdapter(ada4);
                            break;


                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 ProjectStart=StartDateofpro.getText().toString();
                 ProjectEnd=EndDateofpro.getText().toString();
                nameregistered = registerName.getText().toString();


                Intent intent=new Intent(EnterTenderDetailsActivity.this,HomeActivity.class);
                intent.putExtra("Tender_01", tender);
                intent.putExtra("startdateProject", ProjectStart);
                intent.putExtra("enddateProject", ProjectEnd);
                intent.putExtra("registername", nameregistered);
                startActivity(intent);
                Toast.makeText(EnterTenderDetailsActivity.this, "Thank You for registering on the MoRTH Project Deadline Extension App", Toast.LENGTH_LONG).show();


            }
        });




        StartDateofpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day =  cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterTenderDetailsActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, startDateProject,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        EndDateofpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cale = Calendar.getInstance();
                int year = cale.get(Calendar.YEAR);
                int month = cale.get(Calendar.MONTH);
                int day = cale.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterTenderDetailsActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, endDateProject,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        startDateProject = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("ondate", year + "/" + month + "/" + dayOfMonth);
                Prodate = year + "-" + month + "-" + dayOfMonth;
                StartDateofpro.setText(Prodate);


            }
        };


        endDateProject = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("ondate", year + "/" + month + "/" + dayOfMonth);
                Prodate = year + "-" + month + "-" + dayOfMonth;
                EndDateofpro.setText(Prodate);

            }
        };




    }



}