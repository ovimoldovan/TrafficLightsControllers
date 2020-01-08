package Utilities;

import java.util.ArrayList;

import Components.PetriTransition;
import DataObjects.DataCar;
import DataOnly.CarQueue;
import Interfaces.PetriObject;

public class Functions {

	public PetriObject GetPetriObjectByName(String name, ArrayList<PetriObject> list) {
		for (PetriObject petriObject : list) {
			if (petriObject != null)
				if (petriObject.GetName().equals(name))
					return petriObject;
		}
		return null;
	}

	public Integer GetIndexByName(String name, ArrayList<PetriObject> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null)
				if (list.get(i).GetName().equals(name))
					return i;
		}
		return -1;
	}

	public boolean TransitionExist(String name, ArrayList<PetriTransition> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).GetName().equals(name))
				return true;
		}
		return false;
	}

	public boolean HaveCarForMe(PetriTransition t, ArrayList<DataCar> list) {
		if (list == null)
			return false;
		if (t == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				if (list.get(i).Value.Targets.contains(t.TransitionName))
					return true;
		}
		return false;
	}

	public Integer CarIndexForMe(PetriTransition t, ArrayList<DataCar> list) {
		if (list == null)
			return -1;
		if (t == null)
			return -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				if (list.get(i).Value.Targets.contains(t.TransitionName))
					return i;
		}
		return -1;
	}
	
	public boolean HaveCar(ArrayList<DataCar> list) {
		if (list == null)
			return false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).Value != null)
				return true;			
		}
		return false;
	}
}
