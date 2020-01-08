package GUIs;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataObjects.DataFloat;
import Utilities.DataOverNetwork;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class InputFloat extends JFrame
{
	
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					InputFloat frame = new InputFloat();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public InputFloat()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtValue = new JTextPane();
		txtValue.setText("0.0");
		txtValue.setToolTipText("");
		txtValue.setBounds(10, 38, 285, 20);
		contentPane.add(txtValue);
		
		JTextPane petriname = new JTextPane();
		petriname.setText("1080");
		petriname.setBounds(10, 201, 285, 20);
		contentPane.add(petriname);
		
		JTextPane txtName = new JTextPane();
		txtName.setText("P");
		txtName.setBounds(10, 7, 285, 20);
		contentPane.add(txtName);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Socket s;
				try
				{
					s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(petriname.getText()));
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					DataOverNetwork DataToSend = new DataOverNetwork();
					DataToSend.petriObject = new DataFloat();
					if (!txtValue.getText().equals("null"))
					{
						DataToSend.petriObject.SetValue(Float.parseFloat(txtValue.getText()));
					}else
					{
						DataToSend.petriObject.SetValue(null);
					}
					DataToSend.petriObject.SetName(txtName.getText());
					
					DataToSend.NetWorkPort = Integer.parseInt(petriname.getText());
					oos.writeObject(DataToSend);
					s.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(166, 232, 129, 44);
		contentPane.add(btnSend);
		
		JButton btnAddNull = new JButton("Null");
		btnAddNull.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				txtValue.setText(txtValue.getText() + "null,");
			}
		});
		btnAddNull.setBounds(10, 167, 89, 23);
		contentPane.add(btnAddNull);
		
		JButton btnAdd = new JButton("0");
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "0,");
			}
		});
		btnAdd.setBounds(109, 167, 89, 23);
		contentPane.add(btnAdd);
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "1,");
			}
		});
		button.setBounds(10, 69, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "2,");
			}
		});
		button_1.setBounds(109, 69, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "3,");
			}
		});
		button_2.setBounds(206, 69, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "4,");
			}
		});
		button_3.setBounds(10, 103, 89, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "5,");
			}
		});
		button_4.setBounds(109, 103, 89, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "6,");
			}
		});
		button_5.setBounds(206, 103, 89, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "7,");
			}
		});
		button_6.setBounds(10, 137, 89, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "8,");
			}
		});
		button_7.setBounds(109, 137, 89, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText(txtValue.getText() + "9,");
			}
		});
		button_8.setBounds(206, 137, 89, 23);
		contentPane.add(button_8);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				txtValue.setText("");
			}
		});
		btnNewButton.setBounds(10, 232, 146, 44);
		contentPane.add(btnNewButton);
		

		
	}
}
