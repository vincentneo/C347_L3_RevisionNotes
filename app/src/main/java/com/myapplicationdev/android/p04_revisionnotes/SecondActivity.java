package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	RevisionNotesArrayAdapter listAdapter;
	ArrayAdapter aa;
	ArrayList<Note> note;
	DBHelper dbTask;
	ListView lvData;

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		lvData = (ListView) this.findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);
		note = db.getAllNotes();
		db.close();


		Intent i = getIntent();
		int good = i.getIntExtra("Good",0);
		ArrayList<Note> filteredNotes = new ArrayList<>();
		if (good > 0) {
			for(Note n : note) {
				if (n.getStars() >= good) {
					filteredNotes.add(n);
				}
			}
		} else {
			filteredNotes = note;
		}
		aa= new RevisionNotesArrayAdapter(this, R.layout.row, filteredNotes);
		lvData.setAdapter(aa);

	}


}
