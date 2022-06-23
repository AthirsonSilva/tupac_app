package com.example.spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    public Spinner date;
    public final List<String> dates = new ArrayList<String>();
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (Spinner) findViewById(R.id.date);

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August"};

        for (String month: months) {
            dates.add(month);
        }

        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dates);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        date.setAdapter(adapter);

        date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(), dates.get(position), Toast.LENGTH_SHORT).show();

                if (date.getSelectedItem().equals("January") || date.getSelectedItem().equals("February")
                        || date.getSelectedItem().equals("March") || date.getSelectedItem().equals("April")) getDialog("Raining month");

                else if (date.getSelectedItem().equals("May") || date.getSelectedItem().equals("June")
                        || date.getSelectedItem().equals("July") || date.getSelectedItem().equals("August")) getDialog("Dry month");


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void getDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Month");
        builder.setMessage(msg).show();
    }

    public void getDates(String dates) {
        Toast myToast;
        myToast = Toast.makeText(this, dates.toString(), Toast.LENGTH_LONG);
        myToast.show();
    }
}