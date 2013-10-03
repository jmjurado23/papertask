package com.paper.papertask.database;

public final class DatabaseConstants {

	//Database tables names
	public static final String TABLE_NOTEPAD =    "notepad";
	public static final String TABLE_NOTE =       "note";
	public static final String TABLE_TASK =       "task";
	public static final String TABLE_CHECKLINE =  "checkline";
	public static final String TABLE_LABEL =      "label";
	public static final String TABLE_NOTE_LABEL = "note_label";
	public static final String TABLE_TASK_LABEL = "note_label";

	//Database tables fields
	public static final String KEY_ID =       "id";
	public static final String KEY_NAME =     "name";
	public static final String KEY_COLOUR =   "colour";
	public static final String KEY_TEXT =     "text";
	public static final String KEY_CHECKED =  "checked";
	public static final String FKEY_NOTEPAD = "notepad_id";
	public static final String FKEY_NOTE =    "note_id";
	public static final String FKEY_TASK =    "task_id";
	public static final String FKEY_LABEL =   "label_id";
}
