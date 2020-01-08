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

public class Lanes_Intersection {
	public static void main(String[] args) {

		// --------------------------------------------------------------------
		// -------------------------------Lane1--------------------------------
		// --------------------------------------------------------------------

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Lanes Intersection";

		DataString green = new DataString();
		green.Printable = false;
		green.SetName("green");
		green.SetValue("green");
		pn.PlaceList.add(green);

		DataCar p10 = new DataCar();
		p10.SetName("P_a1");
		pn.PlaceList.add(p10);

		DataCarQueue p11 = new DataCarQueue();
		p11.Value.Size = 3;
		p11.SetName("P_x1");
		pn.PlaceList.add(p11);

		DataString p12 = new DataString();
		p12.SetName("P_TL1");
		pn.PlaceList.add(p12);

		DataCar p13 = new DataCar();
		p13.SetName("P_b1");
		pn.PlaceList.add(p13);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 2-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p20 = new DataCar(); //p5.Printable = false;
		p20.SetName("P_a2");
		pn.PlaceList.add(p20);

		DataCarQueue p21 = new DataCarQueue(); //p6.Printable = false;
		p21.Value.Size = 3;
		p21.SetName("P_x2");
		pn.PlaceList.add(p21);

		DataString p22 = new DataString(); //p7.Printable = false;
		p22.SetName("P_TL2");
		pn.PlaceList.add(p22);

		DataCar p23 = new DataCar(); //p8.Printable = false;
		p23.SetName("P_b2");
		pn.PlaceList.add(p23);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 3-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p30 = new DataCar(); //p9.Printable = false;
		p30.SetName("P_a3");
		pn.PlaceList.add(p30);

		DataCarQueue p31 = new DataCarQueue(); //p10.Printable = false;
		p31.Value.Size = 3;
		p31.SetName("P_x3");
		pn.PlaceList.add(p31);

		DataString p32 = new DataString(); //p11.Printable = false;
		p32.SetName("P_TL3");
		pn.PlaceList.add(p32);

		DataCar p33 = new DataCar(); //p12.Printable = false;
		p33.SetName("P_b3");
		pn.PlaceList.add(p33);

		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 4-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p51 = new DataCar(); /////////////p51 sau p40?!?!
		p51.SetName("P_a4");
		pn.PlaceList.add(p51);

		DataCarQueue p41 = new DataCarQueue();
		p41.Value.Size = 3;
		p41.SetName("P_x4");
		pn.PlaceList.add(p41);

		DataString p42 = new DataString();
		p42.SetName("P_TL4");
		pn.PlaceList.add(p42);

		DataCar p43 = new DataCar();
		p43.SetName("P_b4");
		pn.PlaceList.add(p43);
		
		
		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 5 the other way- ---------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p50 = new DataCar(); /////////////p51 sau p40?!?!
		p50.SetName("P_a5");
		pn.PlaceList.add(p50);

		DataCarQueue p44 = new DataCarQueue();
		p44.Value.Size = 3;
		p44.SetName("P_x5");
		pn.PlaceList.add(p44);

		DataString p45 = new DataString();
		p45.SetName("P_TL5");
		pn.PlaceList.add(p45);

		DataCar p46 = new DataCar();
		p46.SetName("P_b5");
		pn.PlaceList.add(p46);
		
		
		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 6-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p60 = new DataCar(); 
		p60.SetName("P_a6");
		pn.PlaceList.add(p60);

		DataCarQueue p61 = new DataCarQueue();
		p61.Value.Size = 3;
		p61.SetName("P_x6");
		pn.PlaceList.add(p61);

		DataString p62 = new DataString();
		p62.SetName("P_TL6");
		pn.PlaceList.add(p62);

		DataCar p63 = new DataCar();
		p43.SetName("P_b6");
		pn.PlaceList.add(p63);
		
		// -------------------------------------------------------------------------------------
		// --------------------------------Lane 7-----------------------------------------------
		// -------------------------------------------------------------------------------------

		DataCar p70 = new DataCar(); 
		p70.SetName("P_a7");
		pn.PlaceList.add(p70);

		DataCarQueue p71 = new DataCarQueue();
		p71.Value.Size = 3;
		p71.SetName("P_x7");
		pn.PlaceList.add(p71);

		DataString p72 = new DataString();
		p72.SetName("P_TL7");
		pn.PlaceList.add(p72);

		DataCar p73 = new DataCar();
		p73.SetName("P_b7");
		pn.PlaceList.add(p73);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 1-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p14 = new DataCarQueue(); p14.Printable = false;
		p14.Value.Size = 3;
		p14.SetName("P_o1");
		pn.PlaceList.add(p14);

		DataCar p15 = new DataCar(); p15.Printable = false;
		p15.SetName("P_o1Exit");
		pn.PlaceList.add(p15);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 2-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p24 = new DataCarQueue(); p24.Printable = false;
		p24.Value.Size = 3;
		p24.SetName("P_o2");
		pn.PlaceList.add(p24);

		DataCar p25 = new DataCar(); p25.Printable = false;
		p25.SetName("P_o2Exit");
		pn.PlaceList.add(p25);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 3-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p34 = new DataCarQueue(); p34.Printable = false;
		p34.Value.Size = 3;
		p34.SetName("P_o3");
		pn.PlaceList.add(p34);

		DataCar p35 = new DataCar(); p35.Printable = false;
		p35.SetName("P_o3Exit");
		pn.PlaceList.add(p35);
		
		DataCarQueue p04 = new DataCarQueue(); p04.Printable = false;
		p04.Value.Size = 3;
		p04.SetName("P_o4");
		pn.PlaceList.add(p04);

		DataCar p05 = new DataCar(); p05.Printable = false;
		p05.SetName("P_o4Exit");
		pn.PlaceList.add(p05);

		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 6-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p64 = new DataCarQueue();
		p64.Value.Size = 3;
		p64.SetName("P_o6");
		pn.PlaceList.add(p64);

		DataCar p65 = new DataCar();
		p65.SetName("P_o6Exit");
		pn.PlaceList.add(p65);
		
		
		// ----------------------------------------------------------------------------
		// ----------------------------Exit lane 7-------------------------------------
		// ----------------------------------------------------------------------------

		DataCarQueue p74 = new DataCarQueue();
		p74.Value.Size = 3;
		p74.SetName("P_o6");
		pn.PlaceList.add(p74);

		DataCar p75 = new DataCar();
		p75.SetName("P_o6Exit");
		pn.PlaceList.add(p75);

		// -------------------------------------------------------------------------------------------
		// --------------------------------Intersection 50-----------------------------------------------
		// -------------------------------------------------------------------------------------------

		DataCarQueue P50 = new DataCarQueue();
		P50.Value.Size = 3;
		P50.SetName("P_I");
		pn.PlaceList.add(P50);

		// T10 ------------------------------------------------
		PetriTransition t10 = new PetriTransition(pn);
		t10.TransitionName = "T_u1";
		t10.InputPlaceName.add("P_a1");

		Condition T1Ct1 = new Condition(t10, "P_a1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t10, "P_x1", TransitionCondition.CanAddCars);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t10, "P_a1", TransitionOperation.AddElement, "P_x1"));
		grdT1.Activations.add(new Activation(t10, "isCar", TransitionOperation.SendOverNetwork, "Yu11"));
		grdT1.Activations.add(new Activation(t10, "isCar", TransitionOperation.Move, "isCar"));
		t10.GuardMappingList.add(grdT1);

		t10.Delay = 0;
		pn.Transitions.add(t10);

		// T11 ------------------------------------------------
		PetriTransition t11 = new PetriTransition(pn);
		t11.TransitionName = "T_e1";
		t11.InputPlaceName.add("P_x1");
		t11.InputPlaceName.add("P_TL1");

		Condition T2Ct1 = new Condition(t11, "P_TL1", TransitionCondition.Equal, "green");
		Condition T2Ct2 = new Condition(t11, "P_x1", TransitionCondition.HaveCar);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t11, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
	    grdT2.Activations.add(new Activation(t11, "P_TL1", TransitionOperation.Move, "P_TL1"));
	    
	    t11.GuardMappingList.add(grdT2);

//		t2.Delay = 3;
		pn.Transitions.add(t11);

		// T20 ------------------------------------------------
		PetriTransition t20 = new PetriTransition(pn);
		t20.TransitionName = "T_u2";
		t20.InputPlaceName.add("P_a2");

		Condition T3Ct1 = new Condition(t20, "P_a2", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t20, "P_x2", TransitionCondition.CanAddCars);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t20, "P_a2", TransitionOperation.AddElement, "P_x2"));
		grdT3.Activations.add(new Activation(t20, "P_a2", TransitionOperation.AddElement, "P_x2"));
		grdT3.Activations.add(new Activation(t20, "isCar", TransitionOperation.SendOverNetwork, "Yu12"));
		grdT3.Activations.add(new Activation(t20, "isCar", TransitionOperation.Move, "isCar"));
		t20.GuardMappingList.add(grdT3);

		t20.Delay = 0;
		pn.Transitions.add(t20);

		// T21 ------------------------------------------------
		PetriTransition t21 = new PetriTransition(pn);
		t21.TransitionName = "T_e2";
		t21.InputPlaceName.add("P_x2");
		t21.InputPlaceName.add("P_TL2");

		Condition T4Ct1 = new Condition(t21, "P_TL2", TransitionCondition.Equal, "green");
		Condition T4Ct2 = new Condition(t21, "P_x2", TransitionCondition.HaveCar);
		T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;
		grdT4.Activations.add(new Activation(t21, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
		grdT4.Activations.add(new Activation(t21, "P_TL2", TransitionOperation.Move, "P_TL2"));
		t21.GuardMappingList.add(grdT2);

		t21.Delay = 0;
		pn.Transitions.add(t21);

		// T30 ------------------------------------------------
		PetriTransition t30 = new PetriTransition(pn);
		t30.TransitionName = "T_u3";
		t30.InputPlaceName.add("P_a3");

		Condition T5Ct1 = new Condition(t30, "P_a3", TransitionCondition.NotNull);
		Condition T5Ct2 = new Condition(t30, "P_x3", TransitionCondition.CanAddCars);
		T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5Ct1;
		grdT5.Activations.add(new Activation(t30, "P_a3", TransitionOperation.AddElement, "P_x3"));
		grdT5.Activations.add(new Activation(t30, "P_a3", TransitionOperation.AddElement, "P_x3"));
		grdT5.Activations.add(new Activation(t30, "isCar", TransitionOperation.SendOverNetwork, "Yu13"));
		grdT5.Activations.add(new Activation(t30, "isCar", TransitionOperation.Move, "isCar"));
		t30.GuardMappingList.add(grdT5);

		t30.Delay = 0;
		pn.Transitions.add(t30);

		// T31 ------------------------------------------------
		PetriTransition t31 = new PetriTransition(pn);
		t31.TransitionName = "T_e3";
		t31.InputPlaceName.add("P_x3");
		t31.InputPlaceName.add("P_TL3");

		Condition T6Ct1 = new Condition(t31, "P_TL3", TransitionCondition.Equal, "green");
		Condition T6Ct2 = new Condition(t31, "P_x3", TransitionCondition.HaveCar);
		T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

		GuardMapping grdT6 = new GuardMapping();
		grdT6.condition = T6Ct1;
		grdT6.Activations.add(new Activation(t31, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
		grdT6.Activations.add(new Activation(t31, "P_TL3", TransitionOperation.Move, "P_TL3"));
		t31.GuardMappingList.add(grdT6);

		t31.Delay = 0;
		pn.Transitions.add(t31);

		// T40 ------------------------------------------------
		PetriTransition t40 = new PetriTransition(pn);
		t40.TransitionName = "T_u4";
		t40.InputPlaceName.add("P_a4");

		Condition T7Ct1 = new Condition(t40, "P_a4", TransitionCondition.NotNull);
		Condition T7Ct2 = new Condition(t40, "P_x4", TransitionCondition.CanAddCars);
		T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

		GuardMapping grdT7 = new GuardMapping();
		grdT7.condition = T7Ct1;
		grdT7.Activations.add(new Activation(t40, "P_a4", TransitionOperation.AddElement, "P_x4"));
		grdT7.Activations.add(new Activation(t40, "P_a4", TransitionOperation.AddElement, "P_x4"));
		grdT7.Activations.add(new Activation(t40, "isCar", TransitionOperation.SendOverNetwork, "Yu14"));
		grdT7.Activations.add(new Activation(t40, "isCar", TransitionOperation.Move, "isCar"));
		t40.GuardMappingList.add(grdT7);

		t40.Delay = 0;
		pn.Transitions.add(t40);

		// T41 ------------------------------------------------
		PetriTransition t41 = new PetriTransition(pn);
		t41.TransitionName = "T_e4";
		t41.InputPlaceName.add("P_x4");
		t41.InputPlaceName.add("P_TL4");

		Condition T8Ct1 = new Condition(t41, "P_TL4", TransitionCondition.Equal, "green");
		Condition T8Ct2 = new Condition(t41, "P_x4", TransitionCondition.HaveCar);
		T6Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

		GuardMapping grdT8 = new GuardMapping();
		grdT8.condition = T8Ct1;
		grdT8.Activations.add(new Activation(t41, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
		grdT8.Activations.add(new Activation(t41, "P_TL4", TransitionOperation.Move, "P_TL4"));
		t41.GuardMappingList.add(grdT8);

		t41.Delay = 0;
		pn.Transitions.add(t41);

		// T14----------------------------------------------------------------

		PetriTransition t14 = new PetriTransition(pn);
		t14.TransitionName = "T_g1Exit";
		t14.InputPlaceName.add("P_o1");

		Condition T9Ct1 = new Condition(t14, "P_o1", TransitionCondition.HaveCar);

		GuardMapping grdT9 = new GuardMapping();
		grdT9.condition = T9Ct1;
		grdT9.Activations.add(new Activation(t14, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1Exit"));
		t14.GuardMappingList.add(grdT9);

		t14.Delay = 0;
		pn.Transitions.add(t14);

		// T24----------------------------------------------------------------

		PetriTransition t24 = new PetriTransition(pn);
		t24.TransitionName = "T_g2Exit";
		t24.InputPlaceName.add("P_o2");

		Condition T10Ct1 = new Condition(t24, "P_o2", TransitionCondition.HaveCar);

		GuardMapping grdT10 = new GuardMapping();
		grdT10.condition = T10Ct1;
		grdT10.Activations.add(new Activation(t24, "P_o2", TransitionOperation.PopElementWithoutTarget, "P_o2Exit"));
		t24.GuardMappingList.add(grdT10);

		t24.Delay = 0;
		pn.Transitions.add(t24);

		// T34----------------------------------------------------------------

		PetriTransition t34 = new PetriTransition(pn);
		t34.TransitionName = "T_g3Exit";
		t34.InputPlaceName.add("P_o3");

		Condition T11Ct1 = new Condition(t34, "P_o3", TransitionCondition.HaveCar);

		GuardMapping grdT11 = new GuardMapping();
		grdT11.condition = T11Ct1;
		grdT11.Activations.add(new Activation(t34, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o3Exit"));
		t34.GuardMappingList.add(grdT11);

		t34.Delay = 0;
		pn.Transitions.add(t34);

		
//		Exit from lane 4 
		// T44 exit ----------------------------------------------------------------

		PetriTransition t44e = new PetriTransition(pn);
		t44e.TransitionName = "T_g44Exit";
		t44e.InputPlaceName.add("P_o4");

		Condition T12Ct1 = new Condition(t44e, "P_o4", TransitionCondition.HaveCar);

		GuardMapping grdT12 = new GuardMapping();
		grdT12.condition = T12Ct1;
		grdT12.Activations.add(new Activation(t44e, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4Exit"));
		t44e.GuardMappingList.add(grdT12);

		t44e.Delay = 0;
		pn.Transitions.add(t44e);

		// --------------------------------------first part-------------------------------------------

		// T12 ------------------------------------------------
		PetriTransition t12 = new PetriTransition(pn);
		t12.TransitionName = "T_i1";
		t12.InputPlaceName.add("P_b1");

		Condition T13Ct1 = new Condition(t12, "P_b1", TransitionCondition.NotNull);
		Condition T13Ct2 = new Condition(t12, "P_I", TransitionCondition.CanAddCars);
		T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

		GuardMapping grdT13 = new GuardMapping();
		grdT13.condition = T13Ct1;
		grdT13.Activations.add(new Activation(t12, "P_b1", TransitionOperation.AddElement, "P_I"));
		t12.GuardMappingList.add(grdT13);

		t12.Delay = 0;
		pn.Transitions.add(t12);

//	probabil ca e in plus	// T22-----------------------------------------------------------
//		PetriTransition t14 = new PetriTransition(pn);
//		t14.TransitionName = "T_g1";
//		t14.InputPlaceName.add("P_I");
//
//		Condition T14Ct1 = new Condition(t14, "P_I", TransitionCondition.HaveCarForMe);
//
//		GuardMapping grdT14 = new GuardMapping();
//		grdT14.condition = T14Ct1;
//		grdT14.Activations.add(new Activation(t14, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
//		t14.GuardMappingList.add(grdT14);
//
//		t14.Delay = 0;
//		pn.Transitions.add(t14);

		// ---------------------------------Second Part-------------------------------------------

		// T22 ------------------------------------------------
		PetriTransition t22 = new PetriTransition(pn);
		t22.TransitionName = "T_i2";
		t22.InputPlaceName.add("P_b2");

		Condition T15Ct1 = new Condition(t22, "P_b2", TransitionCondition.NotNull);
		Condition T15Ct2 = new Condition(t22, "P_I", TransitionCondition.CanAddCars);
		T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

		GuardMapping grdT15 = new GuardMapping();
		grdT15.condition = T15Ct1;
		grdT15.Activations.add(new Activation(t22, "P_b2", TransitionOperation.AddElement, "P_I"));
		t22.GuardMappingList.add(grdT15);

		t22.Delay = 0;
		pn.Transitions.add(t22);

//		// T16-----------------------------------------------------------
//		PetriTransition t16 = new PetriTransition(pn);
//		t16.TransitionName = "T_g2";
//		t16.InputPlaceName.add("P_I");
//
//		Condition T16Ct1 = new Condition(t16, "P_I", TransitionCondition.HaveCarForMe);
//
//		GuardMapping grdT16 = new GuardMapping();
//		grdT16.condition = T16Ct1;
//		grdT16.Activations.add(new Activation(t16, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
//		t16.GuardMappingList.add(grdT16);
//
//		t16.Delay = 0;
//		pn.Transitions.add(t16);

		// ----------------------Third Part----------------------------------------------------------------

		// T32 ------------------------------------------------
		PetriTransition t32 = new PetriTransition(pn);
		t32.TransitionName = "T_i3";
		t32.InputPlaceName.add("P_b3");

		Condition T17Ct1 = new Condition(t32, "P_b3", TransitionCondition.NotNull);
		Condition T17Ct2 = new Condition(t32, "P_I", TransitionCondition.CanAddCars);
		T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

		GuardMapping grdT17 = new GuardMapping();
		grdT17.condition = T17Ct1;
		grdT17.Activations.add(new Activation(t32, "P_b3", TransitionOperation.AddElement, "P_I"));
		t32.GuardMappingList.add(grdT17);

		t32.Delay = 0;
		pn.Transitions.add(t32);

		
// 
//		// T18---------------------------------------------------------
//
//		PetriTransition t18 = new PetriTransition(pn);
//		t18.TransitionName = "T_g3";
//		t18.InputPlaceName.add("P_I");
//
//		Condition T18Ct1 = new Condition(t18, "P_I", TransitionCondition.HaveCarForMe);
//
//		GuardMapping grdT18 = new GuardMapping();
//		grdT18.condition = T18Ct1;
//		grdT18.Activations.add(new Activation(t18, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
//		t18.GuardMappingList.add(grdT18);
//
//		t18.Delay = 0;
//		pn.Transitions.add(t18);

		// -------------------------------------Fourth Part------------------------------------------

		// T42 ------------------------------------------------
		PetriTransition t42 = new PetriTransition(pn);
		t42.TransitionName = "T_i4";
		t42.InputPlaceName.add("P_b4");

		Condition T19Ct1 = new Condition(t42, "P_b4", TransitionCondition.NotNull);
		Condition T19Ct2 = new Condition(t42, "P_I", TransitionCondition.CanAddCars);
		T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);

		GuardMapping grdT19 = new GuardMapping();
		grdT19.condition = T19Ct1;
		grdT19.Activations.add(new Activation(t42, "P_b4", TransitionOperation.PopElementWithoutTarget, "P_I"));
		t42.GuardMappingList.add(grdT19);

		t42.Delay = 0;
		pn.Transitions.add(t42);

//	// T20---------------------------------------------------------
//
//		PetriTransition t20 = new PetriTransition(pn);
//		t20.TransitionName = "T_g4";
//		t20.InputPlaceName.add("P_I");
//
//		Condition T20Ct1 = new Condition(t20, "P_I", TransitionCondition.HaveCarForMe);
//
//		GuardMapping grdT20 = new GuardMapping();
//		grdT20.condition = T20Ct1;
//		grdT20.Activations.add(new Activation(t20, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
//		t20.GuardMappingList.add(grdT20);
//
//		t20.Delay = 0;
//		pn.Transitions.add(t20);
		
		
		
		
		// -------------------------------------------------------------------------------------------
				// --------------------------------Intersection 51-----------------------------------------------
				// -------------------------------------------------------------------------------------------
				
		DataTransfer p_aux1 = new DataTransfer();
		p_aux1.SetName("Yu11");
		p_aux1.Value = new TransferOperation("localhost", "1081", "Y11");
		pn.PlaceList.add(p_aux1);
		
		DataTransfer p_aux2 = new DataTransfer();
		p_aux2.SetName("Yu12");
		p_aux2.Value = new TransferOperation("localhost", "1081", "Y12");
		pn.PlaceList.add(p_aux2);
		
		DataTransfer p_aux3 = new DataTransfer();
		p_aux3.SetName("Yu13");
		p_aux3.Value = new TransferOperation("localhost", "1081", "Y13");
		pn.PlaceList.add(p_aux3);
		
		DataTransfer p_aux4 = new DataTransfer();
		p_aux4.SetName("Yu14");
		p_aux4.Value = new TransferOperation("localhost", "1081", "Y14");
		pn.PlaceList.add(p_aux4);
		
		DataTransfer p_aux5 = new DataTransfer();
		p_aux5.SetName("Yu21");
		p_aux5.Value = new TransferOperation("localhost", "1082", "Y21");
		pn.PlaceList.add(p_aux5);
		
		DataTransfer p_aux6 = new DataTransfer();
		p_aux6.SetName("Yu22");
		p_aux6.Value = new TransferOperation("localhost", "1082", "Y22");
		pn.PlaceList.add(p_aux6);
		
//		DataTransfer p_aux7 = new DataTransfer();
//		p_aux7.SetName("Yu23");
//		p_aux7.Value = new TransferOperation("localhost", "1082", "Y23");
//		pn.PlaceList.add(p_aux7);
		
		DataString isCar = new DataString();
		isCar.SetName("isCar");
		isCar.SetValue("isCar");
		pn.PlaceList.add(isCar);
		
		
		
		
		
		
		
				
				DataCarQueue P51 = new DataCarQueue();
				P51.Value.Size = 3;
				P51.SetName("P_I2");
				pn.PlaceList.add(P51);
				
				// T44 Intrare in intersectia 51 ------------------------------------------------
				PetriTransition t44 = new PetriTransition(pn);
				t44.TransitionName = "T_u5";
				t44.InputPlaceName.add("P_a5");

				Condition T1Ct11 = new Condition(t44, "P_a5", TransitionCondition.NotNull);
				Condition T1Ct21 = new Condition(t44, "P_x5", TransitionCondition.CanAddCars);
				T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct21);

				GuardMapping grdT111 = new GuardMapping();
				grdT111.condition = T1Ct11;
				grdT111.Activations.add(new Activation(t44, "P_a6", TransitionOperation.AddElement, "P_x1"));
				t44.GuardMappingList.add(grdT111);

				t44.Delay = 0;
				pn.Transitions.add(t44);

				// T45 ------------------------------------------------
				PetriTransition t45 = new PetriTransition(pn);
				t45.TransitionName = "T_e6";
				t45.InputPlaceName.add("P_x6");
				t45.InputPlaceName.add("P_TL6");

				Condition T2Ct11 = new Condition(t45, "P_TL6", TransitionCondition.Equal, "green");
				Condition T2Ct21 = new Condition(t45, "P_x6", TransitionCondition.HaveCar);
				T2Ct11.SetNextCondition(LogicConnector.AND, T2Ct21);

				GuardMapping grdT21 = new GuardMapping();
				grdT21.condition = T2Ct11;
				grdT21.Activations.add(new Activation(t45, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_b1"));
			    grdT21.Activations.add(new Activation(t45, "P_TL6", TransitionOperation.Move, "P_TL1"));
			    
			    t45.GuardMappingList.add(grdT21);

				t45.Delay = 3;
				pn.Transitions.add(t45);

				// T60 ------------------------------------------------
				PetriTransition t60 = new PetriTransition(pn);
				t60.TransitionName = "T_u6";
				t60.InputPlaceName.add("P_a6");

				Condition T1Ct111 = new Condition(t60, "P_a6", TransitionCondition.NotNull);
				Condition T1Ct211 = new Condition(t60, "P_x6", TransitionCondition.CanAddCars);
				T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct211);

				GuardMapping grdT1111 = new GuardMapping();
				grdT1111.condition = T1Ct111;
				grdT1111.Activations.add(new Activation(t60, "P_a6", TransitionOperation.AddElement, "P_x1"));
				t60.GuardMappingList.add(grdT1111);

				t60.Delay = 0;
				pn.Transitions.add(t60);

				// T61 ------------------------------------------------
				PetriTransition t61 = new PetriTransition(pn);
				t61.TransitionName = "T_e6";
				t61.InputPlaceName.add("P_x6");
				t61.InputPlaceName.add("P_TL6");

				Condition T2Ct111 = new Condition(t61, "P_TL6", TransitionCondition.Equal, "green");
				Condition T2Ct211 = new Condition(t61, "P_x6", TransitionCondition.HaveCar);
				T2Ct111.SetNextCondition(LogicConnector.AND, T2Ct211);

				GuardMapping grdT211 = new GuardMapping();
				grdT211.condition = T2Ct111;
				grdT211.Activations.add(new Activation(t61, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_b1"));
			    grdT211.Activations.add(new Activation(t61, "P_TL6", TransitionOperation.Move, "P_TL1"));
			    
			    t61.GuardMappingList.add(grdT211);

//				t2.Delay = 3;
				pn.Transitions.add(t61);

				// T70 ------------------------------------------------
				PetriTransition t70 = new PetriTransition(pn);
				t70.TransitionName = "T_u7";
				t70.InputPlaceName.add("P_a7");

				Condition T3Ct11 = new Condition(t70, "P_a7", TransitionCondition.NotNull);
				Condition T3Ct21 = new Condition(t70, "P_x7", TransitionCondition.CanAddCars);
				T3Ct11.SetNextCondition(LogicConnector.AND, T3Ct21);

				GuardMapping grdT31 = new GuardMapping();
				grdT31.condition = T3Ct11;
				grdT31.Activations.add(new Activation(t70, "P_a2", TransitionOperation.AddElement, "P_x2"));
				t70.GuardMappingList.add(grdT31);

				t70.Delay = 0;
				pn.Transitions.add(t70);

				// T71 ------------------------------------------------
				PetriTransition t71 = new PetriTransition(pn);
				t71.TransitionName = "T_e2";
				t71.InputPlaceName.add("P_x2");
				t71.InputPlaceName.add("P_TL2");

				Condition T4Ct11 = new Condition(t71, "P_TL2", TransitionCondition.Equal, "green");
				Condition T4Ct21 = new Condition(t71, "P_x2", TransitionCondition.HaveCar);
				T4Ct11.SetNextCondition(LogicConnector.AND, T4Ct21);

				GuardMapping grdT41 = new GuardMapping();
				grdT41.condition = T4Ct11;
				grdT41.Activations.add(new Activation(t71, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
				grdT41.Activations.add(new Activation(t71, "P_TL2", TransitionOperation.Move, "P_TL2"));
				t21.GuardMappingList.add(grdT211);

				t71.Delay = 0;
				pn.Transitions.add(t71);

				
				// T64----------------------------------------------------------------

				PetriTransition t64 = new PetriTransition(pn);
				t64.TransitionName = "T_g6Exit";
				t64.InputPlaceName.add("P_o6");

				Condition T9Ct11 = new Condition(t64, "P_o1", TransitionCondition.HaveCar);

				GuardMapping grdT91 = new GuardMapping();
				grdT91.condition = T9Ct11;
				grdT91.Activations.add(new Activation(t64, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o1Exit"));
				t64.GuardMappingList.add(grdT91);

				t64.Delay = 0;
				pn.Transitions.add(t64);

				// T74----------------------------------------------------------------

				PetriTransition t74 = new PetriTransition(pn);
				t74.TransitionName = "T_g7Exit";
				t74.InputPlaceName.add("P_o7");

				Condition T10Ct11 = new Condition(t74, "P_o2", TransitionCondition.HaveCar);

				GuardMapping grdT101 = new GuardMapping();
				grdT101.condition = T10Ct11;
				grdT101.Activations.add(new Activation(t74, "P_o2", TransitionOperation.PopElementWithoutTarget, "P_o2Exit"));
				t74.GuardMappingList.add(grdT101);

				t74.Delay = 0;
				pn.Transitions.add(t74);

				
				
//				Exit from lane 5 is done by lane 4
				// T40 exit----------------------------------------------------------------
				
				

				PetriTransition t40e = new PetriTransition(pn);
				t40e.TransitionName = "T_g40Exit";
				t40e.InputPlaceName.add("P_o4");

				Condition T12Ct11 = new Condition(t40e, "P_o4", TransitionCondition.HaveCar);

				GuardMapping grdT121 = new GuardMapping();
				grdT121.condition = T12Ct11;
				grdT121.Activations.add(new Activation(t40e, "P_o4", TransitionOperation.PopElementWithoutTarget, "P_o4Exit"));
				t40e.GuardMappingList.add(grdT121);

				t40e.Delay = 0;
				pn.Transitions.add(t40e);
				
///
				
				
				PetriTransition t40p = new PetriTransition(pn);
				t40p.TransitionName = "T_g44";
				t40p.InputPlaceName.add("P_I");
		
				Condition T40pCt1 = new Condition(t40p, "P_I", TransitionCondition.HaveCarForMe);
		
				GuardMapping grdT40p = new GuardMapping();
				grdT40p.condition = T40pCt1;
				grdT40p.Activations.add(new Activation(t40p, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
				t40p.GuardMappingList.add(grdT40p);
		
				t40p.Delay = 0;
				pn.Transitions.add(t40p);
				

				// --------------------------------------first part-------------------------------------------

				// T62 ------------------------------------------------
				PetriTransition t62 = new PetriTransition(pn);
				t62.TransitionName = "T_i6";
				t62.InputPlaceName.add("P_b6");

				Condition T13Ct11 = new Condition(t62, "P_b6", TransitionCondition.NotNull);
				Condition T13Ct21 = new Condition(t62, "P_I2", TransitionCondition.CanAddCars);
				T13Ct11.SetNextCondition(LogicConnector.AND, T13Ct21);

				GuardMapping grdT131 = new GuardMapping();
				grdT131.condition = T13Ct11;
				grdT131.Activations.add(new Activation(t62, "P_b6", TransitionOperation.AddElement, "P_I"));
				t62.GuardMappingList.add(grdT131);

				t62.Delay = 0;
				pn.Transitions.add(t62);

//			probabil ca e in plus	// T22-----------------------------------------------------------
//				PetriTransition t14 = new PetriTransition(pn);
//				t14.TransitionName = "T_g1";
//				t14.InputPlaceName.add("P_I");
		//
//				Condition T14Ct1 = new Condition(t14, "P_I", TransitionCondition.HaveCarForMe);
		//
//				GuardMapping grdT14 = new GuardMapping();
//				grdT14.condition = T14Ct1;
//				grdT14.Activations.add(new Activation(t14, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
//				t14.GuardMappingList.add(grdT14);
		//
//				t14.Delay = 0;
//				pn.Transitions.add(t14);

				// ---------------------------------Second Part-------------------------------------------

				// T72 ------------------------------------------------
				PetriTransition t72 = new PetriTransition(pn);
				t72.TransitionName = "T_i2";
				t72.InputPlaceName.add("P_b2");

				Condition T15Ct11 = new Condition(t72, "P_b7", TransitionCondition.NotNull);
				Condition T15Ct21 = new Condition(t72, "P_I2", TransitionCondition.CanAddCars);
				T15Ct11.SetNextCondition(LogicConnector.AND, T15Ct21);

				GuardMapping grdT151 = new GuardMapping();
				grdT151.condition = T15Ct11;
				grdT151.Activations.add(new Activation(t72, "P_b7", TransitionOperation.AddElement, "P_I"));
				t72.GuardMappingList.add(grdT151);

				t72.Delay = 0;
				pn.Transitions.add(t72);

//			probabil ca e in plus	// T16-----------------------------------------------------------
//				PetriTransition t16 = new PetriTransition(pn);
//				t16.TransitionName = "T_g2";
//				t16.InputPlaceName.add("P_I");
		//
//				Condition T16Ct1 = new Condition(t16, "P_I", TransitionCondition.HaveCarForMe);
		//
//				GuardMapping grdT16 = new GuardMapping();
//				grdT16.condition = T16Ct1;
//				grdT16.Activations.add(new Activation(t16, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
//				t16.GuardMappingList.add(grdT16);
		//
//				t16.Delay = 0;
//				pn.Transitions.add(t16);

				// ----------------------Third Part----------------------------------------------------------------

				// T46 ------------------------------------------------
				PetriTransition t46 = new PetriTransition(pn);
				t46.TransitionName = "T_i5";
				t46.InputPlaceName.add("P_b5");

				Condition T17Ct11 = new Condition(t46, "P_b5", TransitionCondition.NotNull);
				Condition T17Ct21 = new Condition(t46, "P_I2", TransitionCondition.CanAddCars);
				T17Ct11.SetNextCondition(LogicConnector.AND, T17Ct21);

				GuardMapping grdT171 = new GuardMapping();
				grdT171.condition = T17Ct11;
				grdT171.Activations.add(new Activation(t46, "P_b5", TransitionOperation.AddElement, "P_I"));
				t46.GuardMappingList.add(grdT171);

				t46.Delay = 0;
				pn.Transitions.add(t46);

				
		// probabil ca e in plus
//				// T18---------------------------------------------------------
		
				PetriTransition t18 = new PetriTransition(pn);
				t18.TransitionName = "T_g3";
				t18.InputPlaceName.add("P_I");
		
				Condition T18Ct1 = new Condition(t18, "P_I", TransitionCondition.HaveCarForMe);
		
				GuardMapping grdT18 = new GuardMapping();
				grdT18.condition = T18Ct1;
				grdT18.Activations.add(new Activation(t18, "P_I", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
				t18.GuardMappingList.add(grdT18);
		
				t18.Delay = 0;
				pn.Transitions.add(t18);

				

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
