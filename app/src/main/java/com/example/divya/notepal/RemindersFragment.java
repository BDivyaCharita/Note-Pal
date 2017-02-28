package com.example.divya.notepal;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.example.divya.notepal.Model.SpecialDaysModel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Divya on 17-02-2017.
 */

public class RemindersFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    private String finalTitle;
    private String finalDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.reminders,container,false);
        setHasOptionsMenu(true);
        lvItems = (ListView) v.findViewById(R.id.lvItems);
        items = new ArrayList<String>();

        readItems();
        itemsAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        setupListViewListener();

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                final EditText etNewItem = new EditText(ctx);
                AlertDialog dialog = new AlertDialog.Builder(ctx)
                        .setTitle("Remind me to...")
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
            itemsAdapter.add(finalTitle +"\n" + finalDate);

        }
    };
    public void prepareData(){
        SpecialDaysModel s = null;
        s= new SpecialDaysModel(finalTitle, finalDate);

    }



    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
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

                });
    }

    private void readItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "reminders.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "reminders.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
