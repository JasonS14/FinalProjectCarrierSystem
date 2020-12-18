package celluarService;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServiceJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton checkBill = new JButton("Check Bill");
	JButton changeCarr = new JButton("Change Carrier");
	JButton resNewPhone = new JButton("Reserve a new Phone");
	JButton changPNum = new JButton("Change Phone Number");
	
	JLabel info = new JLabel();
	JTextField userID = new JTextField("User ID", 5);
	JTextField phone = new JTextField("New Phone Model", 5);
	JTextField numb = new JTextField("New Phone Number", 5);
	
	private JButton btnBackToMain;
	
	/**
	 * Constructor
	 */
	public ServiceJPanel() {
		JLabel instructions = new JLabel("Select one of the service");
		
		ButtonListener b = new ButtonListener();
		checkBill.addActionListener(b);
		changeCarr.addActionListener(b);
		resNewPhone.addActionListener(b);
		changPNum.addActionListener(b);
		
		btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(b);
		
		
		JPanel panel = new JPanel();
		setLayout(new BorderLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(instructions, BorderLayout.NORTH);
		panel.add(userID);
		panel.add(checkBill);
		panel.add(info);
		panel.add(changeCarr);
		panel.add(phone);
		panel.add(resNewPhone);
		panel.add(numb);
		panel.add(changPNum);
		panel.add(btnBackToMain);
		
		
		add(panel, BorderLayout.CENTER);		
	}
	
	/**
	 * 
	 * ActionListener for letting button successful and also contain functions such as show messages
	 *
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int id;
			if(e.getSource() == checkBill) {
				id = Integer.parseInt(userID.getText());
				User temp = Userserver.alluser.get(id);
				info.setText(temp.pay);				
			}else if(e.getSource() == changeCarr) {
				id = Integer.parseInt(userID.getText());
				User temp = Userserver.alluser.get(id);
				String op = "Verizon";
				temp.operator = op;				
				Userserver.alluser.set(id, temp);
			}else if(e.getSource() == resNewPhone) {
				id = Integer.parseInt(userID.getText());
				User temp = Userserver.alluser.get(id);
				String ph = phone.getText();
				temp.bookpho = ph;
				Userserver.alluser.set(id, temp);
			}else if(e.getSource() == changPNum) {
				id = Integer.parseInt(userID.getText());
				User temp = Userserver.alluser.get(id);
				String nm = numb.getText();
				temp.tel = nm;
				Userserver.alluser.set(id, temp);
			}else if(e.getSource() == btnBackToMain) {
				sendBackToMainMenuJPanel();
			}	
			
		}
		
	}
	
	private void sendBackToMainMenuJPanel() {
		removeAll();
		setVisible(false);
		MainMenuJPanel newPanel = new MainMenuJPanel();
		add(newPanel);
		validate();
		setVisible(true);
		repaint();

	}
}
