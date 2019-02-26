package com.thecombatant.morth;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UploadListAdapter extends RecyclerView.Adapter<UploadListAdapter.ViewHolder> {

    public List<String> fileNameList;
    public List<String> fileDoneList;

    public UploadListAdapter(List<String> fileNameList, List<String> fileDoneList) {

        this.fileNameList = fileNameList;
        this.fileDoneList = fileDoneList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.upload_list_item_single, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        String fileName = fileNameList.get(position);
        viewHolder.fileNameView.setText(fileName);

        String fileDone = fileDoneList.get(position);

        if (fileDone.equals("Uploading")) {

            viewHolder.fileDoneView.setImageResource(R.drawable.progress);

        } else {

            viewHolder.fileDoneView.setImageResource(R.drawable.checked);

        }

    }


    @Override
    public int getItemCount() {

        return fileNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fileNameView;
        public ImageView fileDoneView;
        View mView;

        public ViewHolder(View itemView) {

            super(itemView);

            mView = itemView;

            fileNameView = mView.findViewById(R.id.upload_filename);
            fileDoneView = mView.findViewById(R.id.upload_loading);
        }
    }
}
