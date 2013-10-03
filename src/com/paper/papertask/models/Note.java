package com.paper.papertask.models;

public class Note implements Element{
	//privates variables
	int _id;
	String _name;
	String _colour;
	String _text;
	NotePad _notepad;
	
	//empty constructor
	public Note(){
		
	}
	
	//Parametizer constructor
	public Note(int id, String name, String colour, String text, NotePad notepad){
		this._id = id;
		this._name = name;
		this._colour = colour;
		this._text = text;
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

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}

	public NotePad get_notepad() {
		return _notepad;
	}

	public void set_notepad(NotePad _notepad) {
		this._notepad = _notepad;
	}
}
