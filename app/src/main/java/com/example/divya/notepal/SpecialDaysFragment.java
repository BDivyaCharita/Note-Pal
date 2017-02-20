package com.example.divya.notepal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Divya on 17-02-2017.
 */

public class SpecialDaysFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.special_days,container,false);
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
                        .customView(R.layout.dialog_date_picker, false)
                        .positiveText(android.R.string.ok)
                        .negativeText(android.R.string.cancel)
                        .show();

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
