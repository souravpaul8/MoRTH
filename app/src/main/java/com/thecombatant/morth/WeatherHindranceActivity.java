package com.thecombatant.morth;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import static android.os.Build.VERSION_CODES.O;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import javax.xml.transform.Result;


public class WeatherHindranceActivity extends AppCompatActivity implements Dialog_box.ExampleDialog {


    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final int RESULT_LOAD_IMAGE = 1;
    public String text;
    Button getLocation, save;
    Button extension;
    TextView city;
    TextView date;
    EditText othercauses;
    TextView enddate;
    String mdate;
    TextView textView1, textView2, textView3;
    LocationManager locationManager;
    Button btn;
    LocationListener locationListener;
    double longitude;
    double latitude;
    String latLngString;
    //Button x;
    String Ext;
    String result;
    String otherReason;
    DatePickerDialog.OnDateSetListener startDateset;
    DatePickerDialog.OnDateSetListener endDateset;
    private ImageButton mSelectBtn;
    private RecyclerView mUploadList;
    private List<String> fileNameList;
    private List<String> fileDoneList;
    TextView Select_file;


    //for date
    private UploadListAdapter uploadListAdapter;
    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_hindrance);


        getLocation = findViewById(R.id.getLocation);
        save = findViewById(R.id.save);
        extension=findViewById(R.id.Extension);
        city = findViewById(R.id.location);
        date = findViewById(R.id.date);
        enddate = findViewById(R.id.enddate);
        othercauses = findViewById(R.id.reason);
        //x = findViewById(R.id.x);

        FirebaseApp.initializeApp(this);

        mStorage = FirebaseStorage.getInstance().getReference();

        mSelectBtn = findViewById(R.id.select_btn);
        mUploadList = findViewById(R.id.upload_list);
        Select_file=findViewById(R.id.select_file);

        fileNameList = new ArrayList<>();
        fileDoneList = new ArrayList<>();
        uploadListAdapter = new UploadListAdapter(fileNameList, fileDoneList);

        mUploadList.setLayoutManager(new LinearLayoutManager(this));
        mUploadList.setHasFixedSize(true);
        mUploadList.setAdapter(uploadListAdapter);

        mSelectBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select File"), RESULT_LOAD_IMAGE);
            }
        });

        // textView1 = (TextView) findViewById(R.id.latitude);
        // textView2 = (TextView) findViewById(R.id.longitude);
        //textView3=(TextView)findViewById(R.id.textView2);
        // btn=(Button)findViewById(R.id.search);

        /*x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WeatherHindranceActivity.this, OtherUploadActivity.class);
                startActivity(i);
            }
        });*/

        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(WeatherHindranceActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(WeatherHindranceActivity.this, new String[]
                                    {Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_LOCATION_PERMISSION);
                }
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                        String stringLatitude = Double.toString(latitude);
                        String stringLongitude = Double.toString(longitude);
                        latLngString = stringLatitude + "," + stringLongitude;
                        //
                        //textView1.setText("Latitude"+":"+latitude+"\n"+"Longitude"+":"+longitude);
                        //get the location name from latitude and longitude
                        Geocoder geocoder = new Geocoder(getApplicationContext());
                        try {
                            List<Address> addresses =
                                    geocoder.getFromLocation(latitude, longitude, 1);
                            result = addresses.get(0).getLocality();
                            //result += addresses.get(0).getCountryName();
                            //textView2.setText("postalcode"+":"+addresses.get(0).getPostalCode());
                            city.setText(result + "," + addresses.get(0).getPostalCode());
                            // LatLng latLng = new LatLng(latitude, longitude);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }
        });


        //for date set
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        WeatherHindranceActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, startDateset,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cale = Calendar.getInstance();
                int year = cale.get(Calendar.YEAR);
                int month = cale.get(Calendar.MONTH);
                int day = cale.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        WeatherHindranceActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, endDateset,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        startDateset = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("ondate", year + "/" + month + "/" + dayOfMonth);
                mdate = year + "-" + month + "-" + dayOfMonth;
                date.setText(mdate);

            }
        };

        endDateset = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d("ondate", year + "/" + month + "/" + dayOfMonth);
                mdate = year + "-" + month + "-" + dayOfMonth;
                enddate.setText(mdate);

            }
        };


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(WeatherHindranceActivity.this, R.array.Causes, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text = parent.getItemAtPosition(position).toString();
                if (text.equals("Others")) {
                    othercauses.setVisibility(view.VISIBLE);    //for other reasons
                    mSelectBtn.setVisibility(view.VISIBLE);
                    Select_file.setVisibility(view.VISIBLE);
                    mUploadList.setVisibility(view.VISIBLE);
                } else {
                    mSelectBtn.setVisibility(view.INVISIBLE);
                    othercauses.setVisibility(view.GONE);
                    Select_file.setVisibility(view.GONE);
                    mUploadList.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FirebaseApp.initializeApp(WeatherHindranceActivity.this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (text.equals("Rain")) {


                    searchrain();
                } else if (text.equals("Wind")) {

                    searchwind();
                }
                else if(text.equals("Others")){
                    otherCauseDetail();
                }

            }
        });

       extension.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openDialog();
           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {

            if (data.getClipData() != null) {

                int totalItemSelected = data.getClipData().getItemCount();
                for (int i = 0; i < totalItemSelected; i++) {

                    Uri fileUri = data.getClipData().getItemAt(i).getUri();

                    String fileName = getFileName(fileUri);

                    fileNameList.add(fileName);
                    fileDoneList.add("Uploading");
                    uploadListAdapter.notifyDataSetChanged();

                    StorageReference fileToUpload = mStorage.child("Images").child(fileName);
                    final int finalI = i;
                    fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //Toast.makeText(UploadActivity.this, "Done",Toast.LENGTH_SHORT).show();\
                            fileDoneList.remove(finalI);
                            fileDoneList.add(finalI, "done");

                            uploadListAdapter.notifyDataSetChanged();
                        }
                    });


                }
                //Toast.makeText(UploadActivity.this, "Selected Multiple Files", Toast.LENGTH_LONG).show();
            } else if (data.getData() != null) {

                int totalItemSelected = 1;
                for (int i = 0; i < totalItemSelected; i++) {

                    Uri fileUri = data.getData();

                    String fileName = getFileName(fileUri);

                    fileNameList.add(fileName);
                    fileDoneList.add("Uploading");
                    uploadListAdapter.notifyDataSetChanged();

                    StorageReference fileToUpload = mStorage.child("Images").child(fileName);
                    final int finalI = i;
                    fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //Toast.makeText(UploadActivity.this, "Done",Toast.LENGTH_SHORT).show();\
                            fileDoneList.remove(finalI);
                            fileDoneList.add(finalI, "done");

                            uploadListAdapter.notifyDataSetChanged();
                        }
                    });


                }

                /*Uri fileUri = data.getData();
                String fileName = getFileName(fileUri);
                StorageReference fileToUpload = mStorage.child("Images").child(fileName);

                fileToUpload.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Toast.makeText(UploadActivity.this, "Done",Toast.LENGTH_SHORT).show();;
                        uploadListAdapter.notifyDataSetChanged();
                    }
                });*/

                //Toast.makeText(UploadActivity.this,"Selected Single File", Toast.LENGTH_LONG).show();
            }
        }

    }


    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public void searchrain() {

        String sdate = date.getText().toString();

        String edate = enddate.getText().toString();

      //  EnterTenderIDActivity ob=new EnterTenderIDActivity();

      //  String tender=tenderId;

        DatabaseReference databaseweather = FirebaseDatabase.getInstance().getReference("Tender 01");


        String content;
        Hindrance weather = new Hindrance();

        try {
            content = weather.execute("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=168c1c9492f0485c9c440414192602&q=" + latLngString + "&format=json&date=" + sdate + "&enddate=" + edate + "&tp=12").get();

            //Toast.makeText(WeatherHindranceActivity.this, "Rain", Toast.LENGTH_SHORT).show();
            //Log.d("hitesh", content);

            //JSON

            JSONObject jobj = new JSONObject(content);

            JSONObject j = jobj.getJSONObject("data");

            JSONArray o = j.getJSONArray("weather");

            for (int i = 0; i < o.length(); i++) {

                JSONObject b = o.getJSONObject(i);

                JSONArray jo = b.getJSONArray("hourly");

                JSONObject job = jo.getJSONObject(0);

                double rainfall = job.getDouble("precipMM");


                String cdate = b.getString("date");

                String cause = "Rain";


                //Log.d("sourav", cdate);

                if (rainfall > 0.0) {

                    String id = databaseweather.push().getKey();

                    weather weath = new weather(id, cdate, rainfall, cause, result);

                    databaseweather.child("Reason").child(cdate).setValue(weath);




                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void searchwind() {

        String sdate = date.getText().toString();

        String edate = enddate.getText().toString();


        DatabaseReference databaseweather = FirebaseDatabase.getInstance().getReference("Tender 01");


        String content;
        Hindrance weather = new Hindrance();

        try {
            content = weather.execute("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=168c1c9492f0485c9c440414192602&q=" + latLngString + "&format=json&date=" + sdate + "&enddate=" + edate + "&tp=24").get();


            //JSON

            JSONObject jobj = new JSONObject(content);

            JSONObject j = jobj.getJSONObject("data");

            JSONArray o = j.getJSONArray("weather");

            for (int i = 0; i < o.length(); i++) {

                JSONObject b = o.getJSONObject(i);

                JSONArray jo = b.getJSONArray("hourly");

                JSONObject job = jo.getJSONObject(0);

                int datap = job.getInt("windspeedKmph");

                String cdate = b.getString("date");


                String cause = "Wind";

                if (datap > 5) {

                    String id = databaseweather.push().getKey();

                    Wind weath = new Wind(id, cdate, datap, cause, result);

                    databaseweather.child(cdate).setValue(weath);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void otherCauseDetail(){

       otherReason=othercauses.getText().toString();


        String sdate = date.getText().toString();

        String edate = enddate.getText().toString();

        DatabaseReference databaseweather = FirebaseDatabase.getInstance().getReference("Tender 01");


        String content;
        Hindrance weather = new Hindrance();

        try {
            content = weather.execute("http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=168c1c9492f0485c9c440414192602&q=" + latLngString + "&format=json&date=" + sdate + "&enddate=" + edate + "&tp=12").get();

            //Toast.makeText(WeatherHindranceActivity.this, "Rain", Toast.LENGTH_SHORT).show();
            //Log.d("hitesh", content);

            //JSON

            JSONObject jobj = new JSONObject(content);

            JSONObject j = jobj.getJSONObject("data");

            JSONArray o = j.getJSONArray("weather");

            for (int i = 0; i < o.length(); i++) {

                JSONObject b = o.getJSONObject(i);



                String cdate = b.getString("date");



                //Log.d("sourav", cdate);



                    String id = databaseweather.push().getKey();

                    OtherReasonDetails other=new OtherReasonDetails(id,cdate,otherReason,result);

                    databaseweather.child("Reason").child(cdate).setValue(other);



            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void openDialog(){

        Dialog_box dialog_box=new Dialog_box();
        dialog_box.show(getSupportFragmentManager(),"dialog");

    }

    @Override
    public void applyText(String days) {

        Ext=days;
        //Toast.makeText(WeatherHindranceActivity.this, Ext, Toast.LENGTH_SHORT).show();
        DatabaseReference databaseweather = FirebaseDatabase.getInstance().getReference("Tender 01");
        databaseweather.child("Extension date").setValue(Ext);
    }

    class Hindrance extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... address) {

            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream is = connection.getInputStream();

                InputStreamReader isr = new InputStreamReader(is);

                int data = isr.read();
                String content = "";
                char ch;

                while (data != -1) {
                    ch = (char) data;
                    content = content + ch;
                    data = isr.read();
                }

                return content;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

   /* @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }*/


}