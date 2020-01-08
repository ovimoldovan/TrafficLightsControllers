package Components;

import java.util.ArrayList;

import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataOnly.CarQueue;
import DataObjects.DataFloat;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Activation {

	public PetriTransition Parent;

	public String InputPlaceName;
	public String OutputPlaceName;
	public TransitionOperation Condition;
	public Functions util;

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Condition = Condition;
	}

	public void Activate() throws CloneNotSupportedException {

		if (Condition == TransitionOperation.Move) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
			
			if (inputIndex == -1)
				return;
			
			PetriObject temp = Parent.TempMarking.get(inputIndex);

			PetriObject result = null;

			if (temp instanceof DataFloat) {
				result = (PetriObject) ((DataFloat) temp).clone();
			}

			if (temp instanceof DataInteger) {
				result = (PetriObject) ((DataInteger) temp).clone();
			}

			if (temp instanceof DataString) {
				result = (PetriObject) ((DataString) temp).clone();
			}

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			Parent.Parent.PlaceList.set(outputIndex, result);
		}

		if (Condition == TransitionOperation.AddElement) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

			PetriObject temp = Parent.TempMarking.get(inputIndex);

			PetriObject result = null;

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			Parent.Parent.PlaceList.get(outputIndex).AddElement(result);
		}

		if (Condition == TransitionOperation.PopElementWithTarget) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
			PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
					.PopCar(Parent.TransitionName);

			PetriObject result = null;

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			Parent.Parent.PlaceList.set(outputIndex, result);
		}

		if (Condition == TransitionOperation.PopElementWithTargetToQueue) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
			PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
					.PopCar(Parent.TransitionName);

			PetriObject result = null;

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			DataCarQueue out = (DataCarQueue) (Parent.Parent.PlaceList.get(outputIndex));
			out.AddElement(result);
		}

		if (Condition == TransitionOperation.PopElementWithoutTarget) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
			PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
					.PopCartWithoutTarget();

			PetriObject result = null;

			if (temp == null)
				return;

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			Parent.Parent.PlaceList.set(outputIndex, result);
		}

		if (Condition == TransitionOperation.PopElementWithoutTargetToQueue) {

			Integer outputIndex = util.GetIndexByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.Parent.PlaceList);
			PetriObject temp = ((CarQueue) ((DataCarQueue) Parent.Parent.PlaceList.get(inputIndex)).GetValue())
					.PopCartWithoutTarget();

			PetriObject result = null;

			if (temp == null)
				return;

			if (temp instanceof DataCar) {
				result = (PetriObject) ((DataCar) temp).clone();
			}

			result.SetName(OutputPlaceName);
			result.SetValue(temp.GetValue());

			DataCarQueue out = (DataCarQueue) (Parent.Parent.PlaceList.get(outputIndex));
			out.AddElement(result);
		}

		if (Condition == TransitionOperation.SendOverNetwork) {

			PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
			Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

			PetriObject result = null;

			if (output instanceof DataTransfer) {
				result = (PetriObject) ((DataTransfer) output).clone();
			}
			
			if (inputIndex==-1) return;
			
			PetriObject temp = Parent.TempMarking.get(inputIndex);

			if (temp instanceof DataFloat) {
				result.SetValue((PetriObject) ((DataFloat) temp).clone());
			}

			if (temp instanceof DataInteger) {
				result.SetValue((PetriObject) ((DataInteger) temp).clone());
			}

			if (temp instanceof DataString) {
				result.SetValue((PetriObject) ((DataString) temp).clone());
			}

			if (temp instanceof DataCar) {
				result.SetValue((PetriObject) ((DataCar) temp).clone());
			}

		}
	}
}
