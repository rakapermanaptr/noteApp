package com.example.rakapermanaputra.mynotesapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rakapermanaputra.mynotesapp.entity.Note;

import java.util.LinkedList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private LinkedList<Note> listNotes;
    private Activity activity;

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

    public LinkedList<Note> getListNotes() {
        return listNotes;
    }

    public void setListNotes(LinkedList<Note> listNotes) {
        this.listNotes = listNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Note note = listNotes.get(position);

        holder.tvTitle.setText(note.getTitle());
        holder.tvDate.setText(note.getDate());
        holder.tvDescription.setText(note.getDescription());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, FormAddUpdateActivity.class);
                intent.putExtra(FormAddUpdateActivity.EXTRA_POSITION, position);
                intent.putExtra(FormAddUpdateActivity.EXTRA_NOTE, getListNotes().get(position));
                activity.startActivityForResult(intent, FormAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListNotes().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription, tvDate;
        CardView cvNote;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_item_description);
            tvDate = (TextView) itemView.findViewById(R.id.tv_item_date);
            cvNote = (CardView) itemView.findViewById(R.id.cv_item_note);
        }
    }
}
