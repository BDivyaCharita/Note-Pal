package com.example.divya.notepal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.OnClick;


/**
 * Created by Divya on 17-02-2017.
 */

public class NotesFragment extends Fragment {

    private EditText passwordInput;
    private View positiveAction;
    // color chooser dialog
    private int primaryPreselect;

    // UTILITY METHODS
    private int accentPreselect;
    private Toast toast;
    private Thread thread;
    private Handler handler;

    private int chooserDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.notes,container,false);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Context ctx=this.getActivity();
        new MaterialDialog.Builder(ctx)
                .title(R.string.title)
                .inputRangeRes(2, 160, R.color.colorPrimaryDark)
                .input(null, null, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        // Do something
                    }
                }).show();
    }
    Context c;
    private void showToast(String message) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(c, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
