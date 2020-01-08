package Test;
import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class ControllerProject2 {

	public static void main (String []args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Controller";
		pn.SetName("Controller");
		pn.NetworkPort = 1082;
		
		DataString ini = new DataString();
		//ini.Printable = false;
		ini.SetName("ini");
		ini.SetValue("red");
		pn.PlaceList.add(ini);
		
		DataString red = new DataString();
		//red.Printable = false;
		red.SetName("red");
		red.SetValue("red");
		pn.PlaceList.add(red);
		
		DataString green = new DataString();
		//green.Printable = false;
		green.SetName("green");
		green.SetValue("green");
		pn.PlaceList.add(green);
		
		DataString yellow = new DataString();
		//yellow.Printable = false;
		yellow.SetName("yellow");
		yellow.SetValue("yellow");
		pn.PlaceList.add(yellow);
		
		DataString p1 = new DataString();
		p1.SetName("r1r2");
		p1.SetValue("signal");
		pn.PlaceList.add(p1);
		
		DataString p2 = new DataString();
		p2.SetName("g1r2");
		pn.PlaceList.add(p2);
		
		DataString p3 = new DataString();
		p3.SetName("y1r2");
		pn.PlaceList.add(p3);
		
		DataString p4 = new DataString();
		p4.SetName("r1g2");
		pn.PlaceList.add(p4);
		
		DataString p5 = new DataString();
		p5.SetName("r1y2");
		pn.PlaceList.add(p5);
		
		DataTransfer p6 = new DataTransfer();
		p6.SetName("OP1");
		p6.Value = new TransferOperation("localhost", "1080" , "P_TL6");
		pn.PlaceList.add(p6);
		
		DataTransfer p7 = new DataTransfer();
		p7.SetName("OP2");
		p7.Value = new TransferOperation("localhost", "1080" , "P_TL7");
		pn.PlaceList.add(p7);
		
		DataString p14 = new DataString();
		p14.SetName("Y21");
		pn.PlaceList.add(p14);
		
		DataString p15 = new DataString();
		p15.SetName("Y22");
		pn.PlaceList.add(p15);
		
		DataString p16 = new DataString();
		p16.SetName("Y23");
		pn.PlaceList.add(p16);
		
//		DataTransfer p8 = new DataTransfer();
//		p8.SetName("OP3");
//		p8.Value = new TransferOperation("localhost", "1080" , "P_TL3");
//		pn.PlaceList.add(p8);
//		
//		DataTransfer p9 = new DataTransfer();
//		p9.SetName("OP4");
//		p9.Value = new TransferOperation("localhost", "1080" , "P_TL4");
//		pn.PlaceList.add(p9);
		
		
		//----------------------------iniT------------------------------------
		PetriTransition iniT = new PetriTransition(pn);
		iniT.TransitionName = "iniT";
		iniT.InputPlaceName.add("ini");
		
		Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

		GuardMapping grdiniT = new GuardMapping();
		grdiniT.condition= iniTCt1;
		
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
		grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
		//grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP3"));
		//grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP4"));
		
		iniT.GuardMappingList.add(grdiniT);
	
		iniT.Delay = 5;
		pn.Transitions.add(iniT);
		
		
		
		//----------------------------T1------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "T1";
		t1.InputPlaceName.add("r1r2");
		t1.InputPlaceName.add("green");
		
		
		Condition T1Ct1 = new Condition(t1, "r1r2", TransitionCondition.NotNull);

		Condition T1Ct2 = new Condition(t1, "Y21", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition= T1Ct1;
		grdT1.Activations.add(new Activation(t1, "r1r2", TransitionOperation.Move, "g1r2"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
		//grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP3"));
		grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.Move, "green"));
		t1.GuardMappingList.add(grdT1);
	
		t1.Delay = 5;
		pn.Transitions.add(t1);
		
		//----------------------------T2------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "T2";
		t2.InputPlaceName.add("g1r2");
		t2.InputPlaceName.add("yellow");
		
		
		Condition T2Ct1 = new Condition(t2, "g1r2", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition= T2Ct1;
		grdT2.Activations.add(new Activation(t2, "g1r2", TransitionOperation.Move, "y1r2"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
		//grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
		grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.Move, "yellow"));
		
		t2.GuardMappingList.add(grdT2);
	
		t2.Delay = 5;
		pn.Transitions.add(t2);
		
		
		//----------------------------T3------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "T3";
		t3.InputPlaceName.add("y1r2");
		t3.InputPlaceName.add("green");
		t3.InputPlaceName.add("red");
		
		
		
		Condition T3Ct1 = new Condition(t3, "y1r2", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "Y22", TransitionCondition.NotNull);
		
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition= T3Ct1;
		grdT3.Activations.add(new Activation(t3, "y1r2", TransitionOperation.Move, "r1g2"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
		//grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP3"));
		grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));
		//grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP4"));
		grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.Move, "red"));
		grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.Move, "green"));
				
		t3.GuardMappingList.add(grdT3);
	
		t3.Delay = 5;
		pn.Transitions.add(t3);
		
		
		//----------------------------T4------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "T4";
		t4.InputPlaceName.add("r1g2");
		t4.InputPlaceName.add("yellow");
		
		
		Condition T4Ct1 = new Condition(t4, "r1g2", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition= T4Ct1;
		grdT4.Activations.add(new Activation(t4, "r1g2", TransitionOperation.Move, "r1y2"));
		grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
		//grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
		grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.Move, "yellow"));
		
		t4.GuardMappingList.add(grdT4);
	
		t4.Delay = 5;
		pn.Transitions.add(t4);
		
		
		//----------------------------T5------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "T4";
		t5.InputPlaceName.add("r1y2");
		t5.InputPlaceName.add("red");
		
		
		Condition T5Ct1 = new Condition(t2, "r1y2", TransitionCondition.NotNull);
		Condition T5Ct2 = new Condition(t1, "Y23", TransitionCondition.NotNull);
		
		T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2); 

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition= T5Ct1;
		grdT5.Activations.add(new Activation(t5, "r1y2", TransitionOperation.Move, "r1r2"));
		grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
		//grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP4"));
		grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.Move, "red"));
		
		t5.GuardMappingList.add(grdT5);
	
		t5.Delay = 5;
		pn.Transitions.add(t5);
		
		
		//YELLOW CYCLES
		
		//----------------------------T10------------------------------------
		PetriTransition t10 = new PetriTransition(pn);
		t10.TransitionName = "T10";
		t10.InputPlaceName.add("r1r2");
		t10.InputPlaceName.add("Y21");
		t10.InputPlaceName.add("yellow");
		t10.InputPlaceName.add("red");
		
		GuardMapping grdT10 = new GuardMapping();
		Condition T10Ct1 = new Condition(t10, "r1r2", TransitionCondition.NotNull);

		grdT10.condition= T10Ct1;
		
		grdT10.Activations.add(new Activation(t10, "r1r2", TransitionOperation.Move, "y1r2"));

		grdT10.Activations.add(new Activation(t10, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

		
		grdT10.Activations.add(new Activation(t3, "yellow", TransitionOperation.Move, "yellow"));
		
				
		Condition T10Ct2 = new Condition(t10, "Y21", TransitionCondition.IsNull);
		
		T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2); //token in both locations so that a car should be in the lane

		
		
		t10.GuardMappingList.add(grdT10);
	
		t10.Delay = 5;
		pn.Transitions.add(t10);
		
		//------------T11
		
		PetriTransition t11 = new PetriTransition(pn);
		t11.TransitionName = "T11";
		t11.InputPlaceName.add("y1r2");
		t11.InputPlaceName.add("Y22");
		t11.InputPlaceName.add("red");
		t11.InputPlaceName.add("yellow");


		
		
		Condition T11Ct1 = new Condition(t11, "y1r2", TransitionCondition.NotNull);
		Condition T11Ct2 = new Condition(t11, "Y22", TransitionCondition.IsNull);
		
		T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2); //token in both locations so that a car should be in the lane

		GuardMapping grdT11 = new GuardMapping();
		grdT11.condition= T11Ct1;
		grdT11.Activations.add(new Activation(t11, "y1r2", TransitionOperation.Move, "r1y2"));
		grdT11.Activations.add(new Activation(t11, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT11.Activations.add(new Activation(t11, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
		
		grdT11.Activations.add(new Activation(t11, "red", TransitionOperation.Move, "red"));
		grdT11.Activations.add(new Activation(t11, "yellow", TransitionOperation.Move, "yellow"));
				
		t11.GuardMappingList.add(grdT11);
	
		t11.Delay = 5;
		pn.Transitions.add(t11);
		
		//----------------------------T12------------------------------------
		PetriTransition t12 = new PetriTransition(pn);
		t12.TransitionName = "T12";
		t12.InputPlaceName.add("r1y2");
		t12.InputPlaceName.add("yellow");
		t12.InputPlaceName.add("red");

		t12.InputPlaceName.add("Y23");

		
		
		Condition T12Ct1 = new Condition(t12, "r1y2", TransitionCondition.NotNull);
		Condition T12Ct2 = new Condition(t12, "Y23", TransitionCondition.IsNull);

		T12Ct1.SetNextCondition(LogicConnector.AND, T12Ct2); //token in both locations so that a car should be in the lane

		GuardMapping grdT12 = new GuardMapping();
		grdT12.condition= T12Ct1;
		grdT12.Activations.add(new Activation(t12, "r1y2", TransitionOperation.Move, "r1r2"));
		//grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
		//grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP4"));
		grdT12.Activations.add(new Activation(t12, "red", TransitionOperation.SendOverNetwork, "OP1"));
		grdT12.Activations.add(new Activation(t12, "red", TransitionOperation.SendOverNetwork, "OP2"));

		grdT12.Activations.add(new Activation(t12, "yellow", TransitionOperation.Move, "yellow"));
		
		t12.GuardMappingList.add(grdT12);
	
		t12.Delay = 5;
		pn.Transitions.add(t12);
		
		// -------------------------------------------------------------------------------------
		// ----------------------------PN Start-------------------------------------------------
		// -------------------------------------------------------------------------------------

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 2000;
		// pn.Start();

		PetriNetWindow frame = new PetriNetWindow();
		frame.petriNet = pn;
		frame.setVisible(true);
		
		
			
		
		
	}
}
