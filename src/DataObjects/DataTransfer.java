package DataObjects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import DataOnly.Car;
import DataOnly.TransferOperation;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;

public class DataTransfer  implements Interfaces.PetriObject, Cloneable, Serializable  {

	@Override
	public void Execute() {
		
		Socket s;
		try {
			s = new Socket(InetAddress.getByName(Value.IP_Address), Integer.parseInt(Value.Port));
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			DataOverNetwork DataToSend = new DataOverNetwork();

			Value.Value.SetName(Value.TargetPlaceName);
			DataToSend.petriObject = Value.Value;

			DataToSend.NetWorkPort = Integer.parseInt(Value.Port);
			oos.writeObject(DataToSend);
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataTransfer;
	}

	public TransferOperation Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null)
			Value = null;
		if (value instanceof PetriObject) {
			Value.Value = (PetriObject) value;
			Execute();
		}
	}
	
	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataTransfer) super.clone();
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
	
	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub
		
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
