package com.example.divya.notepal.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divya.notepal.Model.NoteModel;
import com.example.divya.notepal.R;


import java.util.List;

/**
 * Created by Divya on 19-02-2017.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private Context mContext;
    private List<NoteModel> noteList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notes_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NoteModel note = noteList.get(position);
        holder.notes.setText(note.getNote());

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public NotesAdapter(Context mContext, List<NoteModel> noteList) {
        this.mContext = mContext;
        this.noteList = noteList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView notes;
        public MyViewHolder(View itemView) {
            super(itemView);
            notes = (TextView) itemView.findViewById(R.id.note_content);
        }
    }
}
