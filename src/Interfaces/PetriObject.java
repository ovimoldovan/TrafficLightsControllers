package Interfaces;

import Enumerations.PetriObjectType;

public interface PetriObject {
	
	public void Execute();

	public void Start();
	
	public void Stop();
	
	public PetriObjectType GetType();

	public Object GetValue();

	public void SetValue(Object value);
	
	public void AddElement(Object value);
	
	public String GetName();

	public void SetName(String name);
	
	public String toString();
	
	public boolean IsPrintable();
}
