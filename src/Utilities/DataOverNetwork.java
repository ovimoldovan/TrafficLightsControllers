package Utilities;

import java.io.Serializable;

import Interfaces.PetriObject;


public class DataOverNetwork implements Serializable
{
	public PetriObject petriObject; // could have task or vector
	public int NetWorkPort = 1080;// default in case none initiated
	public String IP = "127.0.0.1";// default in case none initiated
/*
	public String toString()
	{
		String st = " ";
		if (INPUTmarking != null)
		{
			for (int i = 0; i < INPUTmarking.length; ++i)
			{
				if (INPUTmarking[i] == null)
				{
					st += "Null-";
				}else
				{
				   st += INPUTmarking[i] + "-";
				}
			}
		}
		return st.substring(0, st.length() - 1);
	}
	*/
	public String toString()
	{
//		String st = "";
//		if (INPUTmarking != null)
//		{
//			for (int i = 0; i < INPUTmarking.length; ++i)
//			{
//				if (INPUTmarking[i] == null)
//				{
//					st += "Null-";
//				} else
//				{
//					if (ObjectHandler.FindOutType(INPUTmarking[i]) == VectorTypes.TypeTask)
//					{
//						PetriData pdToString=PetriData.class.cast(INPUTmarking[i]);
//						st += "(task)"+pdToString.Name+":" + pdToString.State + "-";
//					} else
//					{
//						st += "(" + ObjectHandler.FindOutType(INPUTmarking[i]).toString().replace("Type", "") + ")" + INPUTmarking[i].toString() + "-";
//					}
//				}
//			}
//		}
//	return st.substring(0, st.length() - 1);
		return "";
	}

	public DataOverNetwork(PetriObject petriObject, int NetWorkPort, String IP)
	{
		this.petriObject = petriObject;
		this.NetWorkPort = NetWorkPort;
		this.IP = IP;
	}

	public DataOverNetwork()
	{
	}
}
