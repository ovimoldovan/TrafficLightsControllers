package Components;

import java.util.ArrayList;

public class GuardMapping {
	public Condition condition;
	public ArrayList<Activation> Activations;
	public GuardMapping() {
		Activations= new ArrayList<Activation>();
	}
	public void Activate() throws CloneNotSupportedException
	{
		for (Activation activation : Activations) {
			activation.Activate();
		}
	}
}
