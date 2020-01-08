package DataOnly;

import java.io.Serializable;

import Interfaces.PetriObject;

public class TransferOperation implements Cloneable, Serializable {
	// Overriding clone() method of Object class
	public TransferOperation clone() throws CloneNotSupportedException {
		return (TransferOperation) super.clone();
	}

	public String IP_Address;
	public String Port;
	public String TargetPlaceName;
	public PetriObject Value;

	public TransferOperation(String IP_Address, String Port, String TargetPlaceName) {
		this.IP_Address = IP_Address;
		this.Port = Port;
		this.TargetPlaceName = TargetPlaceName;
		this.Value = null;
	}

	public String toString() {
		return IP_Address + "-" + Port + "-" + TargetPlaceName;
	}
}
