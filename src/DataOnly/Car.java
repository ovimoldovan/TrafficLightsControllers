package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Cloneable, Serializable {
	
	// Overriding clone() method of Object class
	public Car clone() throws CloneNotSupportedException {
		return (Car) super.clone();
	}
	public String Model;
	public String Number;
	public List<String> Targets;

	public Car(String Model, String Number, ArrayList<String> Targets) {
		this.Model = Model;
		this.Number = Number;
		this.Targets = new ArrayList<String>();
		this.Targets.addAll(Targets);
	}
	
	public Car(String Model, String Number, String[] Targets) {
		this.Model = Model;
		this.Number = Number;
		this.Targets = new ArrayList<String>();
		for (String string : Targets) {
			this.Targets.add(string);
		}
	}

	public String toString() {
		return Model + "-" + Number;
	}
};

