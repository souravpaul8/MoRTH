package com.thecombatant.morth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SavedHindrancesListActivity extends AppCompatActivity {

    private RecyclerView mHindranceRV;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<
            SavedHindranceData, SavedHindrancesListActivity.HindranceViewHolder> mHindranceRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_hindrances_list);

        final String tender = getIntent().getStringExtra("Tender_01");

        mDatabase = FirebaseDatabase.getInstance().getReference().child(tender).child("Dates");
        mDatabase.keepSynced(true);

        mHindranceRV = findViewById(R.id.savedHindrancesRecyclerView);

        DatabaseReference HindranceRef = FirebaseDatabase.getInstance().getReference().child(tender).child("Dates");
        Query HindranceQuery = HindranceRef.orderByKey();

        mHindranceRV.hasFixedSize();
        mHindranceRV.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions HindranceOptions = new FirebaseRecyclerOptions.Builder<SavedHindranceData>().setQuery(HindranceQuery, SavedHindranceData.class).build();

        mHindranceRVAdapter = new FirebaseRecyclerAdapter<SavedHindranceData, SavedHindrancesListActivity.HindranceViewHolder>(HindranceOptions) {
            @Override
            protected void onBindViewHolder(@NonNull SavedHindrancesListActivity.HindranceViewHolder holder, final int position, @NonNull final SavedHindranceData model) {
                holder.setDate(model.getDate());
                holder.setLocation(model.getLocation());
                holder.setReason(model.getReason());

            }

            @NonNull
            @Override
            public SavedHindrancesListActivity.HindranceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.hindrance_single_row, parent, false);

                return new SavedHindrancesListActivity.HindranceViewHolder(view);
            }
        };

        mHindranceRV.setAdapter(mHindranceRVAdapter);
    }

    public void onStart() {

        super.onStart();
        mHindranceRVAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mHindranceRVAdapter.stopListening();
    }


    public static class HindranceViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public HindranceViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDate(String datePar) {
            TextView date = (TextView) mView.findViewById(R.id.date);
            date.setText(datePar);
        }

        public void setLocation(String locPar) {
            TextView location = (TextView) mView.findViewById(R.id.location);
            location.setText(locPar);
        }

        public void setReason(String reasPar) {

            TextView reason = (TextView) mView.findViewById(R.id.reason);
            reason.setText(reasPar);
        }

    }
}
