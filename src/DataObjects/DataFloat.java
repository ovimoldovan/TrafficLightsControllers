package DataObjects;

import java.io.Serializable;

import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataFloat implements Interfaces.PetriObject, Cloneable, Serializable {

	public Float Value;

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Execute() {
	}

	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataFloat) super.clone();
	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataFloat;
	}

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null)
			Value = null;
		if (value instanceof Float) {
			Value = (Float) value;
		}
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}

	public boolean Printable = true;
	@Override
	public boolean IsPrintable() {
		return Printable;
	}
	public String toString() {
		if (Value != null) {
			return GetName() + "(" + GetValue().toString() + ")";
		} else {
			return GetName() +"(Null)";
		}
	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

}
