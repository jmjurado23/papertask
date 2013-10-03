package com.paper.papertask.models;

public class Label{
	//privates variables
	int _id;
	String _name;
	String _colour;
	
	//empty constructor
	public Label(){
	}
	
	//parametizer constructor
	public Label(int id, String name, String colour){
		this._id = id;
		this._name = name;
		this._colour = colour;
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
	
	
}
