package com.ahurwitz.adamsobservableex;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;

import rx.Observable;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {
    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    ArrayList<Object> objects = new ArrayList<>();
    Object obj1 = new Object(1, "obj1", true);
    Object obj2 = new Object(2, "obj2", false);
    Object obj3 = new Object(3, "obj3", true);
    Object obj4 = new Object(4, "obj4", false);
    Object obj5 = new Object(5, "obj5", true);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objects.add(obj1);
        objects.add(obj2);
        objects.add(obj3);
        objects.add(obj4);
        objects.add(obj5);

        TextView obj1View = (TextView) findViewById(R.id.obj1_id);
        TextView obj2View = (TextView) findViewById(R.id.obj2_id);
        TextView obj3View = (TextView) findViewById(R.id.obj3_id);
        TextView obj4View = (TextView) findViewById(R.id.obj4_id);
        TextView obj5View = (TextView) findViewById(R.id.obj5_id);

        obj1View.setText(String.valueOf(obj1.getVal()));
        obj2View.setText(String.valueOf(obj2.getVal()));
        obj3View.setText(String.valueOf(obj3.getVal()));
        obj4View.setText(String.valueOf(obj4.getVal()));
        obj5View.setText(String.valueOf(obj5.getVal()));

        Switch switchBtn = (Switch) findViewById(R.id.boolean_switch_btn);

        /*observable.filter(new Func1() {
            @Override
            public java.lang.Object call(java.lang.Object o) {
                return null;
            }
        });*/

        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchBtn.isChecked()) {
                    Observable myObservable = Observable.from(objects);
                    /*myObservable.map(filterList())
                            .toList()
                            .toBlocking()
                            .single();*/
                    Log.v(LOG_TAG, "Transform Observable: " +
                                    myObservable.map(filterList())
                                            .toList()
                                            .toBlocking()
                                            .single()
                    );
                    //TODO: attach tramsformed list to something
                    obj1View.setText(String.valueOf(obj1.getVal()));
                    obj2View.setText(String.valueOf(obj2.getVal()));
                    obj3View.setText(String.valueOf(obj3.getVal()));
                    obj4View.setText(String.valueOf(obj4.getVal()));
                    obj5View.setText(String.valueOf(obj5.getVal()));
                }
            }
        });
    }

    @NonNull
    private Func1<Object, Object> filterList() {
        return filteredObject -> {
            filteredObject.setVal(true);
            return filteredObject;
        };
    }

}

   /*public Action1<Object> getAction()
    {
        return new Action1<Object>() {
            @Override
            public void call(Object object) {

            }
        };
    }*/
