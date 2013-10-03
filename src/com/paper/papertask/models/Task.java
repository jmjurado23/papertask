package com.paper.papertask.models;

public class Task implements Element{
	//privates variables
	int _id;
	String _name;
	String _colour;
	NotePad _notepad;
	
	//empty constructor
	public Task(){
	}
	
	//parametizer constructor
	public Task(int id, String name, String colour, NotePad notepad){
		this._id = id;
		this._name = name;
		this._colour = colour;
		this._notepad = notepad;
	}

	//Getter and Setter
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_colour() {
		return _colour;
	}

	public void set_colour(String _colour) {
		this._colour = _colour;
	}

	public NotePad get_notepad() {
		return _notepad;
	}

	public void set_notepad(NotePad _notepad) {
		this._notepad = _notepad;
	}
}
