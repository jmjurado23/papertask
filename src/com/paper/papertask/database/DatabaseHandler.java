package com.paper.papertask.database;

import static com.paper.papertask.database.DatabaseConstants.*;
import static com.paper.papertask.database.DatabaseGet.*;
import static com.paper.papertask.database.DatabaseParams.*;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.paper.papertask.models.CheckLine;
import com.paper.papertask.models.Label;
import com.paper.papertask.models.Note;
import com.paper.papertask.models.NotePad;
import com.paper.papertask.models.Task;

public class DatabaseHandler extends SQLiteOpenHelper{

	//static variables
	//Database version
	//private static final int DATABASE_VERSION = 1;
	
	//Database Name
	//private static final String DATABASE_NAME = "PaperTask";
	
	//Parametizer constructor
	public DatabaseHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//NOTEPAD table create
		String CREATE_NOTEPAD_TABLE = "CREATE TABLE "  +TABLE_NOTEPAD + "(" + 
				KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + 
				KEY_COLOUR + " TEXT" + ")" ;
		//NOTE table create
		String CREATE_NOTE_TABLE = "CREATE TABLE " + TABLE_NOTE + "(" + 
				KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + 
				KEY_TEXT + " TEXT," + KEY_COLOUR + " TEXT" + 
				" FOREIGN KEY(" + FKEY_NOTEPAD +") REFERENCES  " + TABLE_NOTEPAD + 
				"(" + KEY_ID + ") )" ;
		//TASK table create
		String CREATE_TASK_TABLE = "CREATE TABLE " + TABLE_TASK + "(" + 
				KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + 
				KEY_COLOUR + " TEXT," + " FOREIGN KEY(" + FKEY_NOTEPAD +
				") REFERENCES  " + TABLE_NOTEPAD + "(" + KEY_ID + ") )" ;
		//CHECKLINE table create
		String CREATE_CHECKLINE_TABLE = "CREATE TABLE " + TABLE_CHECKLINE + "(" + 
				KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEXT + " TEXT," + 
				KEY_CHECKED + " INTEGER," + " FOREIGN KEY(" + FKEY_TASK +
				") REFERENCES  " + TABLE_TASK + "(" + KEY_ID + ") )" ;
		//LABEL table create
		String CREATE_LABEL_TABLE = "CREATE TABLE " + TABLE_LABEL + "(" + 
				KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + 
				KEY_COLOUR + " TEXT" + ")" ;
		//NOTE_LABEL table create
		String CREATE_NOTE_LABEL_TABLE = "CREATE TABLE " + TABLE_NOTE_LABEL + "(" + 
				"FOREIGN KEY(" + FKEY_NOTE + ") REFERENCES  " + TABLE_NOTE + "(" + KEY_ID + "), " +
				"FOREIGN KEY(" + FKEY_LABEL + ") REFERENCES  " + TABLE_LABEL + "(" + KEY_ID + ") )";
		//TASK_LABEL table create
		String CREATE_TASK_LABEL_TABLE = "CREATE TABLE " + TABLE_TASK_LABEL + "(" + 
				"FOREIGN KEY(" + FKEY_TASK + ") REFERENCES  " + TABLE_TASK + "(" + KEY_ID + "), " +
				"FOREIGN KEY(" + FKEY_LABEL + ") REFERENCES  " + TABLE_LABEL + "(" + KEY_ID + ") )"; 
		
		db.execSQL(CREATE_NOTEPAD_TABLE);
		db.execSQL(CREATE_NOTE_TABLE);
		db.execSQL(CREATE_TASK_TABLE);
		db.execSQL(CREATE_CHECKLINE_TABLE);
		db.execSQL(CREATE_LABEL_TABLE);
		db.execSQL(CREATE_NOTE_LABEL_TABLE);
		db.execSQL(CREATE_TASK_LABEL_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTEPAD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKLINE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE_LABEL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK_LABEL);
 
        // Create tables again
        onCreate(db);
	}
	
	public void addElement(Object object){
		SQLiteDatabase db = this.getWritableDatabase();
		
		if (object.getClass() == NotePad.class){
			ContentValues values = addNotepad((NotePad) object);
			db.insert(TABLE_NOTEPAD, null, values);
		}else if(object.getClass() == Note.class){
			ContentValues values = addNote((Note) object);
			db.insert(TABLE_NOTE, null, values);
		}else if(object.getClass() == Task.class){
			ContentValues values = addTask((Task) object);
			db.insert(TABLE_TASK, null, values);
		}else if(object.getClass() == CheckLine.class){
			ContentValues values = addCheckLine((CheckLine) object);
			db.insert(TABLE_CHECKLINE, null, values);
		}else if(object.getClass() == Label.class){
			ContentValues values = addLabel((Label) object);
			db.insert(TABLE_LABEL, null, values);
		}
		
		db.close(); // Closing database connection
	}
	
	//Update Element
	public int updateElement(Object object){
		SQLiteDatabase db = this.getWritableDatabase();
		
		if (object.getClass() == NotePad.class){
			ContentValues values = addNotepad((NotePad) object);
			db.update(TABLE_NOTEPAD, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(((NotePad) object).get_id()) });
		}else if(object.getClass() == Note.class){
			ContentValues values = addNote((Note) object);
			db.update(TABLE_NOTE, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Note) object).get_id()) });
		}else if(object.getClass() == Task.class){
			ContentValues values = addTask((Task) object);
			db.update(TABLE_TASK, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Task) object).get_id()) });
		}else if(object.getClass() == CheckLine.class){
			ContentValues values = addCheckLine((CheckLine) object);
			db.update(TABLE_CHECKLINE, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(((CheckLine) object).get_id()) });
		}else if(object.getClass() == Label.class){
			ContentValues values = addLabel((Label) object);
			db.update(TABLE_LABEL, values, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Label) object).get_id()) });
		}
		
		db.close(); // Closing database connection
		return -1;
	}
	
	
	//Delete Element
	public void deleteContact(Object object) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    if (object.getClass() == NotePad.class){
	    	db.delete(TABLE_NOTEPAD, KEY_ID + " = ?",
		            new String[] { String.valueOf(((NotePad) object).get_id()) });
		}else if(object.getClass() == Note.class){
			db.delete(TABLE_NOTE, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Note) object).get_id()) });
		}else if(object.getClass() == Task.class){
			db.delete(TABLE_TASK, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Task) object).get_id()) });
		}else if(object.getClass() == CheckLine.class){
			db.delete(TABLE_CHECKLINE, KEY_ID + " = ?",
		            new String[] { String.valueOf(((CheckLine) object).get_id()) });
		}else if(object.getClass() == Label.class){
			db.delete(TABLE_LABEL, KEY_ID + " = ?",
		            new String[] { String.valueOf(((Label) object).get_id()) });
		}
	    
	    db.close();
	}
	
	//GET ELEMENT
	public Object getElement(Object object, int id){
		SQLiteDatabase db = this.getReadableDatabase();
		Object element = null;
		
		if (object.getClass() == NotePad.class){
			Cursor cursor = getNotepad(id, db);
			element = new NotePad(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
			
		}else if(object.getClass() == Note.class){
			Cursor cursor = getNote(id, db);
			element = new Note(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2),cursor.getString(3),
					(NotePad) getElement(NotePad.class, Integer.parseInt(cursor.getString(4))));
			
		}else if(object.getClass() == Task.class){
			Cursor cursor = getTask(id, db);
			element = new Task(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2),
					(NotePad) getElement(NotePad.class, Integer.parseInt(cursor.getString(3))));
			
		}else if(object.getClass() == CheckLine.class){
			Cursor cursor = getCheckLine(id, db);
			element = new CheckLine(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), Integer.parseInt(cursor.getString(2)),
					(Task) getElement(Task.class, Integer.parseInt(cursor.getString(3))));
			
		}else if(object.getClass() == Label.class){
			Cursor cursor = getLabel(id, db);
			element = new Label(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
			
		}
		
		return element;
	}
	
	public List<Object> getAllNotes() {
	    List<Object> objectList = new ArrayList<Object>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_NOTE;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Note note = new Note();
	            note.set_id(Integer.parseInt(cursor.getString(0)));
	            note.set_name(cursor.getString(1));
	            note.set_text(cursor.getString(2));
	            note.set_colour(cursor.getString(3));
	            // Adding contact to list
	            objectList.add(note);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return objectList;
	}
	
	public List<Object> getAllTasks() {
	    List<Object> objectList = new ArrayList<Object>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_TASK;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            Task task = new Task();
	            task.set_id(Integer.parseInt(cursor.getString(0)));
	            task.set_name(cursor.getString(1));
	            task.set_colour(cursor.getString(2));
	            // Adding contact to list
	            objectList.add(task);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return objectList;
	}
	
	public int getElementCount(Object object) {
		String countQuery = "";
		if (object.getClass() == NotePad.class){
			countQuery = "SELECT  * FROM " + TABLE_NOTEPAD;
		}else if(object.getClass() == Note.class){
			countQuery = "SELECT  * FROM " + TABLE_NOTE;
		}else if(object.getClass() == Task.class){
			countQuery = "SELECT  * FROM " + TABLE_TASK;
		}else if(object.getClass() == CheckLine.class){
			countQuery = "SELECT  * FROM " + TABLE_CHECKLINE;
		}else if(object.getClass() == Label.class){
			countQuery = "SELECT  * FROM " + TABLE_LABEL;
		}
		
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
}