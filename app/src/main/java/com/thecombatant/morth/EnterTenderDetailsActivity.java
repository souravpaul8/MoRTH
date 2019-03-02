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
    TextView StartDateofpro;
    TextView EndDateofpro;
    String GetTenderId;
    String Prodate;
    String ProjectStart;
    String ProjectEnd;

    DatePickerDialog.OnDateSetListener startDateProject;
    DatePickerDialog.OnDateSetListener endDateProject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_tender_details);

        StartDateofpro=findViewById(R.id.startDate);
        EndDateofpro=findViewById(R.id.enddate);
        next=findViewById(R.id.nextHome);
        tenderIdTextView = findViewById(R.id.TenderIdtextView);

        final String tender = getIntent().getStringExtra("Tender_ID");
        tenderIdTextView.setText(tender);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 ProjectStart=StartDateofpro.getText().toString();
                 ProjectEnd=EndDateofpro.getText().toString();


                Intent intent=new Intent(EnterTenderDetailsActivity.this,HomeActivity.class);
                intent.putExtra("Tender_01", tender);
                intent.putExtra("startdateProject", ProjectStart);
                intent.putExtra("enddateProject", ProjectEnd);
                startActivity(intent);
                //Toast.makeText(EnterTenderDetailsActivity.this, ProjectStart, Toast.LENGTH_SHORT).show();


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