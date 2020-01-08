package Test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataFloat;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Exp1 {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Main Petri";

		DataFloat p1 = new DataFloat();
		p1.SetName("P1");
		p1.SetValue(1.0f);
		pn.PlaceList.add(p1);

		DataFloat p2 = new DataFloat();
		p2.SetName("P2");
		p2.SetValue(2.0f);
		pn.PlaceList.add(p2);

		DataFloat p3 = new DataFloat();
		p3.SetName("P3");
		pn.PlaceList.add(p3);

		DataFloat p4 = new DataFloat();
		p4.SetName("P4");
		pn.PlaceList.add(p4);

		DataFloat p5 = new DataFloat();
		p5.SetName("P5");
		pn.PlaceList.add(p5);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T1";
		t1.InputPlaceName.add("P1");
		t1.InputPlaceName.add("P2");

		Condition T1Ct1 = new Condition(t1, "P1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "P1", TransitionCondition.LessThanOrEqual, "P2");
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition= T1Ct1;
		grdT1.Activations.add(new Activation(t1, "P1", TransitionOperation.Move, "P3"));
		t1.GuardMappingList.add(grdT1);
		
		t1.Delay = 0;
		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T2";
		t2.InputPlaceName.add("P3");

		Condition T2Ct1 = new Condition(t2, "P3", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition= T2Ct1;
		grdT2.Activations.add(new Activation(t2, "P3", TransitionOperation.Move, "P4"));
		t2.GuardMappingList.add(grdT2);
		
//		t2.ActivationList.add(new Activation(t2, "P3", TransitionOperation.Move, "P1"));
//		t2.ActivationList.add(new Activation(t2, "P3", TransitionOperation.Move, "P2"));
		t2.Delay = 0;
		pn.Transitions.add(t2);
		// -------------------------------------------

		// PetriTransition t3 = new PetriTransition(pn);
		// pn.Transitions.add(t3);

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000;
		//pn.Start();
		
		PetriNetWindow frame = new PetriNetWindow();
		frame.petriNet = pn;
		frame.setVisible(true);

	}
}
