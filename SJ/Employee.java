import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Employee extends JPanel implements ActionListener{
	private int id;
	private String name;
	private double pay;
	private String position;
	private String date_in;
	private String phone;
	
	public Employee() {
		String title[] = {"번호", "이름" ,"급여","직급", "입사일", "연락처"};
		String info[][]= {
		};
		DefaultTableModel model = new DefaultTableModel(info,title);
		JTable table= new JTable(model);
		JScrollPane sp= new JScrollPane(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		
		JTextField numberfield =new JTextField(5);
		JTextField namefield = new JTextField(5);
		JTextField payfield = new JTextField(5);
		JTextField positionfield = new JTextField(5);
		JTextField datefield = new JTextField(10);
		JTextField phonefield = new JTextField(10);
		
		panel.add(numberfield);
		panel.add(namefield);
		panel.add(payfield);
		panel.add(positionfield);
		panel.add(datefield);
		panel.add(phonefield);
		
		JButton addBtn =new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputStr[] =new String[6];
				
				inputStr[0]= numberfield.getText();
				inputStr[1]= namefield.getText();
				inputStr[2]= payfield.getText();
				inputStr[3]= positionfield.getText();
				inputStr[4]= datefield.getText();
				inputStr[5]= phonefield.getText();
				model.addRow(inputStr);
				
				numberfield.setText("");
				namefield.setText("");
				payfield.setText("");
				positionfield.setText("");
				datefield.setText("");
				phonefield.setText("");
				
			}
		});
		
		JButton delBtn = new JButton("삭제");
		delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow() == -1)
					return;
				else
					model.removeRow(table.getSelectedRow());
			}
		});
		
	    panel.add(addBtn);
		panel.add(delBtn);
		
		add(sp,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}