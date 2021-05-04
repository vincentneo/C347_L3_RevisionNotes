package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonInsertNote, buttonShowList;
    EditText editTextNote;
    RadioGroup radioGroupStars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsertNote = findViewById(R.id.buttonInsertNote);
        buttonShowList = findViewById(R.id.buttonShowList);
        editTextNote = findViewById(R.id.editTextNote);
        radioGroupStars = findViewById(R.id.radioGroupStars);

        buttonInsertNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                db.onUpgrade(db.getWritableDatabase(), 1, 2);
                // Insert a task
                long status = db.insertNote(editTextNote.getText().toString(), getStarsFromRadioID(radioGroupStars.getCheckedRadioButtonId()));
                db.close();

                String toastValue = (status > -1) ? "Insert (will fail if duplicate)" : "Failed to insert. Check fields";
                Toast.makeText(MainActivity.this, toastValue,
                        Toast.LENGTH_LONG).show();
            }

        });

        buttonShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the DBHelper object, passing in the activity's content
                DBHelper db = new DBHelper(MainActivity.this);

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }

    private int getStarsFromRadioID(int id) {
        switch (id) {
            case R.id.radio1: return 1;
            case R.id.radio2: return 2;
            case R.id.radio3: return 3;
            case R.id.radio4: return 4;
            case R.id.radio5: return 5;
            default: return 0;
        }
    }
}
