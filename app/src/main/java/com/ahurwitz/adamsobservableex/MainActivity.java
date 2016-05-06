package com.ahurwitz.adamsobservableex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Observable;

import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    ArrayList<Object> objects = new ArrayList<>();
    Object obj1 = new Object(1, "obj1", true);
    Object obj2 = new Object(2, "obj2", false);
    Object obj3 = new Object(3, "obj3", true);
    Object obj4 = new Object(4, "obj4", false);
    Object obj5 = new Object(5, "obj5", true);
    rx.Observable observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch switchBtn = (Switch) findViewById(R.id.boolean_switch_btn);
        //Button filterListBtn = (Button) findViewById(R.id.filterListBtn);

        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        objects.add(obj4);
        objects.add(obj5);

        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               observable.map(filterList(objects));
                if (switchBtn.isChecked()) {
                    Log.v(LOG_TAG, "Filter Observable");
                    //TODO: Create observable and pass in ArrayList of Objects in .map() filter,
                    // print out objects with values
                }
            }
        });
    }

    @NonNull
    private Func1<ArrayList<Object>, ArrayList<Object>> filterList(ArrayList<Object> objects) {
        return filteredObjects -> {
            filteredObjects = objects;
            return Observable
                    .map(filterList(filteredObjects))
                    .toList()
                    .toBlocking()
                    .single();
        };
    }

}
