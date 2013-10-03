package com.paper.papertask.database;

import android.database.Cursor;
import static com.paper.papertask.database.DatabaseConstants.*;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseGet {

	//get element from a db
	public static Cursor getNotepad(int id, SQLiteDatabase db){
		Cursor cursor = db.query(TABLE_NOTEPAD, new String[] { KEY_ID,
	            KEY_NAME, KEY_COLOUR }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
	        cursor.moveToFirst();
		return cursor;
	}
	
	public static Cursor getNote(int id, SQLiteDatabase db){
		Cursor cursor = db.query(TABLE_NOTE, new String[] { KEY_ID,
	            KEY_NAME, KEY_TEXT, KEY_COLOUR, FKEY_NOTEPAD }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
	        cursor.moveToFirst();
		return cursor;
	}
	
	public static Cursor getTask(int id, SQLiteDatabase db){
		Cursor cursor = db.query(TABLE_TASK, new String[] { KEY_ID,
	            KEY_NAME, KEY_COLOUR, FKEY_NOTEPAD }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
	        cursor.moveToFirst();
		return cursor;
	}
	
	public static Cursor getCheckLine(int id, SQLiteDatabase db){
		Cursor cursor = db.query(TABLE_CHECKLINE, new String[] { KEY_ID,
	            KEY_TEXT, KEY_CHECKED, FKEY_TASK }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
	        cursor.moveToFirst();
		return cursor;
	}
	
	public static Cursor getLabel(int id, SQLiteDatabase db){
		Cursor cursor = db.query(TABLE_LABEL, new String[] { KEY_ID,
	            KEY_NAME, KEY_COLOUR }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
	        cursor.moveToFirst();
		return cursor;
	}
}
