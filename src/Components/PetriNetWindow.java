package Components;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import Components.PetriNet.NetworkListener;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

import java.awt.Component;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PetriNetWindow extends JFrame {

	public PetriNet petriNet = null;
	Thread networkThread;

	public PetriNetWindow() {
		setBounds(100, 100, 805, 470);
		JTextPane txtName = new JTextPane();
		txtName.setFont(new Font("Consolas", Font.BOLD, 12));

		JScrollPane scrollPane = new JScrollPane();

		MyCellRenderer cellRenderer = new MyCellRenderer(800);
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList lstMsg = new JList(model);
		lstMsg.setCellRenderer(cellRenderer);
		lstMsg.setFont(new Font("Consolas", Font.BOLD, 12));

		scrollPane.setViewportView(lstMsg);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!petriNet.PauseFlag) {
					networkThread = new Thread();
					networkThread = new Thread(petriNet);
					networkThread.start();

					txtName.setText(petriNet.PetriNetName + " [Network Port:" + petriNet.NetworkPort + "]");
					petriNet.setDataLoadFinishedListener(new PetriNet.DataLoadFinishedListener() {
						@Override
						public void onDataLoadFinishedListener(String data_type) {
							addString(model, scrollPane, data_type);
						}
					});
				} else {
					addString(model, scrollPane, "Continued....");
					petriNet.PauseFlag = false;
				}
			}
		});

		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petriNet.PauseFlag = true;
				addString(model, scrollPane, "Paused....");
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart)
						.addComponent(btnPause))
					.addGap(11)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				petriNet.Stop();
				System.exit(0);
			}

			@Override
			public void windowOpened(java.awt.event.WindowEvent e) {
				txtName.setText(petriNet.PetriNetName + " [Network Port:" + petriNet.NetworkPort + "]");
			}

		});
	}

	public void addString(DefaultListModel<String> model, JScrollPane scrollPane, String msg) {
		model.addElement(msg);
		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
		scrollPane.updateUI();
	}

	class MyCellRenderer extends DefaultListCellRenderer {
		public static final String HTML_1 = "<html><body style='width: ";
		public static final String HTML_2 = "px'>";
		public static final String HTML_3 = "</html>";
		private int width;

		public MyCellRenderer(int width) {
			this.width = width;
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			String text = HTML_1 + String.valueOf(width) + HTML_2 + value.toString() + HTML_3;
			return super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
		}

	}

}
