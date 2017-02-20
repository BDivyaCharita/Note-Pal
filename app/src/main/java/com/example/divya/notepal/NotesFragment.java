package com.example.divya.notepal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.divya.notepal.Adapter.NotesAdapter;
import com.example.divya.notepal.Model.NoteModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;


/**
 * Created by Divya on 17-02-2017.
 */

public class NotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotesAdapter adapter;
    private List<NoteModel> noteList;
    private Context c;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.notes,container,false);
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        noteList = new ArrayList<>();
        adapter = new NotesAdapter(c,noteList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add : {
                Context ctx=this.getActivity();
                new MaterialDialog.Builder(ctx)
                        .title(R.string.title)
                        .inputRangeRes(2, 160, R.color.colorPrimaryDark)
                        .input(null, null, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                NoteModel n = new NoteModel(input.toString());
                                noteList.add(n);
                                adapter.notifyDataSetChanged();
                            }
                        }).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
