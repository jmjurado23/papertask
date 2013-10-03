package com.paper.papertask.database;

import static com.paper.papertask.database.DatabaseConstants.*;
import android.content.ContentValues;

import com.paper.papertask.models.CheckLine;
import com.paper.papertask.models.Label;
import com.paper.papertask.models.Note;
import com.paper.papertask.models.NotePad;
import com.paper.papertask.models.Task;

public class DatabaseParams {
	//Add elements function
	public static ContentValues addNotepad(NotePad notepad){
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, notepad.get_name()); 
		values.put(KEY_COLOUR, notepad.get_colour()); 

		return values;
	}

	public static ContentValues addNote(Note note){
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, note.get_name());
		values.put(KEY_TEXT, note.get_text());
		values.put(KEY_COLOUR, note.get_colour());
		values.put(FKEY_NOTEPAD, note.get_notepad().get_id());

		return values;
	}

	public static ContentValues addTask(Task task){
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, task.get_name());
		values.put(KEY_COLOUR, task.get_colour());
		values.put(FKEY_NOTEPAD, task.get_notepad().get_id());

		return values;
	}

	public static ContentValues addCheckLine(CheckLine checkline){
		ContentValues values = new ContentValues();
		values.put(KEY_TEXT, checkline.get_text());
		values.put(KEY_CHECKED, checkline.get_checked());
		values.put(FKEY_TASK, checkline.get_task().get_id());

		return values;
	}

	public static ContentValues addLabel(Label label){
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, label.get_name());
		values.put(KEY_COLOUR, label.get_colour());

		return values;
	}

	public static ContentValues addNoteLabel(Label label, Note note){
		ContentValues values = new ContentValues();
		values.put(FKEY_NOTE, note.get_id());
		values.put(FKEY_LABEL, label.get_id());

		return values;
	}

	public static ContentValues addTaskLabel(Label label, Task task){
		ContentValues values = new ContentValues();
		values.put(FKEY_LABEL, task.get_id());
		values.put(FKEY_LABEL, label.get_id());

		return values;
	}
}
