package Components;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import DataOnly.Car;
import DataOnly.CarQueue;
import Enumerations.LogicConnector;
import Enumerations.PetriObjectType;
import Enumerations.TransitionCondition;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Condition {

	public PetriTransition Parent;

	public PetriObject Value1;
	public PetriObject Value2;

	public String PlaceName1;
	public String PlaceName2;

	public TransitionCondition condition;

	public Condition NextCondition;
	public LogicConnector Connector = LogicConnector.AND;
	public Functions util;

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition, String PlaceName2) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.PlaceName2 = PlaceName2;
		this.condition = condition;
	}

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.condition = condition;
	}

	public void refreshData() {
		this.Value1 = util.GetPetriObjectByName(PlaceName1, Parent.Parent.PlaceList);
		this.Value2 = util.GetPetriObjectByName(PlaceName2, Parent.Parent.PlaceList);
	}

	public void SetNextCondition(LogicConnector Connector, Condition NextCondition) {
		this.NextCondition = NextCondition;
		this.Connector = Connector;
	}

	boolean Check() {
		refreshData();
		switch (condition) {
		case NotNull:
			if (Value1 != null && Value1.GetValue() != null)
				return true;
			break;
		case IsNull:
			if (Value1 == null || Value1.GetValue() == null)
				return true;
			break;
		case NotEqual:
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (!Value1.GetValue().equals(Value2.GetValue()))
				return true;
			break;
		case Equal:
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetValue().equals( Value2.GetValue()))
				return true;
			break;
		case MoreThanOrEqual: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() >= (Integer) Value2.GetValue())
					return true;
			case DataFloat:
				if ((Float) Value1.GetValue() >= (Float) Value2.GetValue())
					return true;
			}
			break;
		}
		case LessThanOrEqual: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() <= (Integer) Value2.GetValue())
					return true;
			case DataFloat:
				if ((Float) Value1.GetValue() <= (Float) Value2.GetValue())
					return true;
			}
			break;
		}
		case MoreThan: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() > (Integer) Value2.GetValue())
					return true;
			case DataFloat:
				if ((Float) Value1.GetValue() > (Float) Value2.GetValue())
					return true;
			}
			break;
		}
		case LessThan: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			switch (Value1.GetType()) {
			case DataInteger:
				if ((Integer) Value1.GetValue() < (Integer) Value2.GetValue())
					return true;
			case DataFloat:
				if ((Float) Value1.GetValue() < (Float) Value2.GetValue())
					return true;
			}
			break;
		}
		case Contains: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataString) {
				if (((String) Value1.GetValue()).contains((String) Value2.GetValue()))
					return true;
			}
			break;
		}
		case NotContains: {
			if (Value1 == null || Value2 == null)
				return false;
			if (Value1.GetValue() == null || Value2.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataString) {
				if (!((String) Value1.GetValue()).contains((String) Value2.GetValue()))
					return true;
			}
			break;
		}
		case HaveCarForMe: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (util.HaveCarForMe(Parent, ((CarQueue) Value1.GetValue()).Cars)) {
					return true;
				}
			}
			break;
		}
		case CanAddCars: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (((CarQueue) Value1.GetValue()).CanAddCar()) {
					return true;
				}
			}
			break;
		}
		case HaveCar: {
			if (Value1 == null)
				return false;
			if (Value1.GetValue() == null)
				return false;
			if (Value1.GetType() == PetriObjectType.DataCarQueue) {
				if (util.HaveCar(((CarQueue) Value1.GetValue()).Cars)) {
					return true;
				}
			}
			break;
		}
		}
		return false;
	}

	public ArrayList<Condition> conditionList;

	public boolean CheckCondition() {
		refreshData();
		conditionList = new ArrayList<Condition>();
		FullList(this);

		boolean andCondition = true;
		for (Condition condition : conditionList) {
			if (condition.Connector == Connector.AND) {
				if (!condition.Check()) {
					andCondition = false;
					break;
				}
			}
		}

		if (andCondition)
			return true;

		for (Condition condition : conditionList) {
			if (condition.Connector == Connector.OR) {
				if (condition.Check()) {
					return true;
				}
			}
		}

		return false;
	}

	void FullList(Condition obj) {
		if (obj == null)
			return;
		conditionList.add(obj);
		FullList(obj.NextCondition);
	}
}
