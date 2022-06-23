package com.example.tupac_shakur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Discography extends AppCompatActivity {

    ListView albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discography);

        ListView listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("All Eyez On Me");
        list.add("This is Tupac");
        list.add("Greatest Hits");
        list.add("Me Against The World");
        list.add("Strictly 4 My N.I.G.G.A.Z");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        startActivity(new Intent(Discography.this, AllEyezOnMe.class));
                        break;
                        
                    case 1:
                        startActivity(new Intent(Discography.this, ThisIsTupac.class));
                        break;
                        
                    case 2:
                        startActivity(new Intent(Discography.this, GreatestHits.class));
                        break;
                        
                    case 3:
                        startActivity(new Intent(Discography.this, MeAgainstTheWorld.class));
                        break;
                        
                    case 4:
                        startActivity(new Intent(Discography.this, Strictly4MyNiggaz.class));
                        break;


                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
            }
        });

    }
}
