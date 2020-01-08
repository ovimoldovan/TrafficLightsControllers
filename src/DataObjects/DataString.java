package DataObjects;

import java.io.Serializable;

import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataString implements Interfaces.PetriObject, Cloneable, Serializable {

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataString;
	}
	public String Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null)
			Value = null;
		if (value instanceof String) {
			Value = (String) value;
		}
	}
	
	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataString) super.clone();
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

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub
		
	}
}
