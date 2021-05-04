package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

                // Insert a task
                db.insertNote(editTextNote.getText().toString(), radioGroupStars.getCheckedRadioButtonId());
                db.close();
                
                Toast.makeText(MainActivity.this, "Inserted",
                        Toast.LENGTH_LONG).show();
            }

        });

    }
}
