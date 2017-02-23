package com.example.divya.notepal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.divya.notepal.Adapter.SpecialDaysAdapter;
import com.example.divya.notepal.Model.SpecialDaysModel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Divya on 17-02-2017.
 */

public class SpecialDaysFragment extends Fragment {

    private List<SpecialDaysModel> specialDayList;
    private SpecialDaysAdapter adapter;
    private RecyclerView recyclerView;
    int year_x, month_x,day_x;
    static final int DIALOG_ID = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.special_days,container,false);
        setHasOptionsMenu(true);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        specialDayList= new ArrayList<>();
        readItems();

        adapter = new SpecialDaysAdapter(getContext(), specialDayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);

        setupListViewListener();

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
    private String finalTitle;
    private String finalDate;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add : {
                Context ctx=this.getActivity();
               /* final EditText etNewItem = new EditText(ctx);
                new MaterialDialog.Builder(ctx)
                        .title(R.string.title)
                        .customView(R.layout.dialog_date_picker, false)
                        .positiveText(android.R.string.ok)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                // TODO

                            }
                        })
                        .negativeText(android.R.string.cancel)
                        .show();*/
                final EditText etNewItem = new EditText(ctx);
                AlertDialog dialog = new AlertDialog.Builder(ctx)
                        .setTitle("Birthday or Anniversary of...")
                        .setView(etNewItem)
                        .setPositiveButton("Pick a date", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String itemText = etNewItem.getText().toString();
                                 finalTitle = itemText;
                                DatePickerFragment date = new DatePickerFragment();
                                /**
                                 * Set Up Current Date Into dialog
                                 */
                                Calendar calender = Calendar.getInstance();
                                Bundle args = new Bundle();
                                args.putInt("year", calender.get(Calendar.YEAR));
                                args.putInt("month", calender.get(Calendar.MONTH));
                                args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
                                date.setArguments(args);
                                /**
                                 * Set Call back to capture selected date
                                 */
                                date.setCallBack(ondate);
                                date.show(getActivity().getFragmentManager(), "Date Picker");

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();

                return true;

            }
        }
        return super.onOptionsItemSelected(item);
    }


    android.app.DatePickerDialog.OnDateSetListener ondate = new android.app.DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            finalDate = (String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear+1)
                    + "-" + String.valueOf(year));
            SpecialDaysModel s = null;
            s= new SpecialDaysModel(finalTitle, finalDate);

            specialDayList.add(s);
        }
    };

    private void setupListViewListener() {
       /* lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        writeItems();
                        return true;
                    }

                }); */
    }

    private void readItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "specialDays.txt");
        try {
            specialDayList = new ArrayList<SpecialDaysModel>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            specialDayList = new ArrayList<SpecialDaysModel>();
        }
    }

    private void writeItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "specialDays.txt");
        try {
            FileUtils.writeLines(todoFile, specialDayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
