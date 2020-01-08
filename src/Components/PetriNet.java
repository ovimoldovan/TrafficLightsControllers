package Components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;
import Utilities.Functions;

public class PetriNet implements PetriObject, Runnable {

	// ----------------------------------------------------------------------------------------------

	public interface DataLoadFinishedListener {
		public void onDataLoadFinishedListener(String data_type);
	}

	public DataLoadFinishedListener m_lDataLoadFinished = new DataLoadFinishedListener() {

		@Override
		public void onDataLoadFinishedListener(String data_type) {
			// TODO Auto-generated method stub

		}
	};

	public void setDataLoadFinishedListener(DataLoadFinishedListener dlf) {
		this.m_lDataLoadFinished = dlf;
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.PetriNet;
	}

	public Object GetValue() {
		return null;
	}

	@Override
	public void SetValue(Object value) {

	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

	public ArrayList<PetriObject> PlaceList;
	public Functions util;

	public PetriNet() {
		util = new Functions();
		Transitions = new ArrayList<PetriTransition>();
		PlaceList = new ArrayList<PetriObject>();
	}

	public ArrayList<PetriTransition> Transitions;

	public String PetriNetName;

	public boolean StopFlag;
	public boolean PauseFlag;
	public Integer Delay = 1000;
	public ArrayList<PetriTransition> ExecutionList;

	Thread networkThread;

	public String msg;

	@Override
	public void Start() {

		networkThread = new Thread();

		NetworkListener myRunnable = new NetworkListener(this);
		networkThread = new Thread(myRunnable);
		networkThread.start();

		msg = "####################  " + PetriNetName + " Started  #####################";
		System.out.println(msg);
		m_lDataLoadFinished.onDataLoadFinishedListener(msg);

		ExecutionList = new ArrayList<PetriTransition>();
		StopFlag = false;
		PauseFlag = false;
		while (!StopFlag) {
			try {
				Thread.sleep(Delay);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			if (PauseFlag) {
				continue;
			}

			PrintPetri();
			for (int i = 0; i < Transitions.size(); ++i) {
				if (!util.TransitionExist(Transitions.get(i).GetName(), ExecutionList)) {
					if (Transitions.get(i).CheckConditions()) {
						try {
							Transitions.get(i).BookTokens();
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							msg = e.getMessage();
							m_lDataLoadFinished.onDataLoadFinishedListener(msg);
							e.printStackTrace();
						}
						PetriTransition trr=Transitions.get(i);
						trr.InitialDelay= trr.Delay;
						ExecutionList.add(trr);
					}
				}
			}
			PrintExeList();
			for (int i = 0; i < ExecutionList.size(); ++i) {
				if (ExecutionList.get(i).InitialDelay >= 0) {
					try {
						ExecutionList.get(i).Activate();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						msg = e.getMessage();
						m_lDataLoadFinished.onDataLoadFinishedListener(msg);
						e.printStackTrace();
					}
					ExecutionList.get(i).InitialDelay--;
				}
			}

			for (int i = 0; i < ExecutionList.size(); ++i) {
				if (ExecutionList.get(i).InitialDelay < 0) {
					//ExecutionList.get(i).InitialDelay = ExecutionList.get(i).InitialDelay;
					ExecutionList.remove(i);
					i--;
				}
			}
		}
	}

	@Override
	public void Stop() {
		for (int i = 0; i < Transitions.size(); ++i) {
			Transitions.get(i).Stop();
		}

		msg = "####################  " + PetriNetName + " Ended  #####################";
		m_lDataLoadFinished.onDataLoadFinishedListener(msg);
		System.out.println(msg);

	}

	public void PrintPetri() {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (PetriObject petriObject : PlaceList) {
			if (petriObject == null)
				temp1.add("NULL");
			else
				if(petriObject.IsPrintable())
				temp1.add(petriObject.toString());
		}

		msg = name + " PlaceList [" + String.join("  ", temp1) + "]";
		m_lDataLoadFinished.onDataLoadFinishedListener(msg);
		System.out.println(msg);
	}

	public void PrintExeList() {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (PetriObject petriObject : ExecutionList) {
			if (petriObject == null)
				temp1.add("NULL");
			else
				temp1.add(petriObject.toString());
		}

		msg = name + " ExecutionList [" + String.join(",", temp1) + "]";
		m_lDataLoadFinished.onDataLoadFinishedListener(msg);
		System.out.println(msg);
	}

	public DataOverNetwork inputdata = new DataOverNetwork();
	public boolean stop;
	public Integer NetworkPort = 1080;

	public class NetworkListener implements Runnable {
		private PetriNet net;

		public NetworkListener(PetriNet net) {
			this.net = net;
		}

		public void run() {
			ServerSocket ss = null;
			try {
				ss = new ServerSocket(NetworkPort);

				msg = "Waiting For Commands over this port:" + NetworkPort;
				m_lDataLoadFinished.onDataLoadFinishedListener(msg);
				System.out.println(msg);

				Socket s;
				ObjectInputStream ois;
				while (!net.stop) {
					s = ss.accept();
					s.setReuseAddress(true);
					ois = new ObjectInputStream(s.getInputStream());

					try {
						net.inputdata = (DataOverNetwork) ois.readObject();
						Integer index = net.util.GetIndexByName(net.inputdata.petriObject.GetName(), net.PlaceList);
						net.PlaceList.set(index, net.inputdata.petriObject);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					msg = "$$$$$$$$$$$$$$$ I got an Input From NetWork";
					m_lDataLoadFinished.onDataLoadFinishedListener(msg);
					System.out.println(msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		Start();
	}
	
	public boolean Printable = true;
	@Override
	public boolean IsPrintable() {
		return Printable;
	}

}
