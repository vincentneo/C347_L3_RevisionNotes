package com.myapplicationdev.android.p04_revisionnotes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	RevisionNotesArrayAdapter listAdapter;
	ArrayAdapter aa;
	ArrayList<Note> note;
	DBHelper dbTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		lvData = (ListView) this.findViewById(R.id.lv);
		DBHelper db = new DBHelper(SecondActivity.this);
		note = db.getAllNotes();
		db.close();

		aa= new RevisionNotesArrayAdapter(this, R.layout.row, note);
		lvData.setAdapter(aa);

	}


}
