package com.paper.papertask.models;

public class CheckLine {
	//privates variables
	int _id;
	String _text;
	int _checked;
	Task _task;

	//empty constructor
	public CheckLine(){
	}

	//parametizer constructor
	public CheckLine(int id, String text, int checked, Task task){
		this._id = id;
		this._text = text;
		this._checked = checked;
		this._task = task;
	}

	//Getter and Setter
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}

	public int get_checked() {
		return _checked;
	}

	public void set_checked(int _checked) {
		this._checked = _checked;
	}

	public Task get_task() {
		return _task;
	}

	public void set_task(Task _task) {
		this._task = _task;
	}
}
