package celluarService;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddNewCustomerJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField cusId;
	private JTextField cusName;
	private JTextField bill;
	private JTextField pNum;
	private JTextField bookPho;
	private JTextField nwCarrier;
	private JTextField vip;
	private JTextField pass;
	private JButton btnSubmitNewCus;
	private JButton btnClear;
	
	
	private JButton btnBackToMain;
	
	/**
	 * Constructor
	 */
	public AddNewCustomerJPanel() {
		setLayout(new BorderLayout());
		JLabel title = new JLabel("Enter a New Customer Information:");
		add(title, BorderLayout.NORTH);
		JPanel form = new JPanel(new GridLayout(0, 1));
		
		JLabel id = new JLabel("ID:");
		form.add(id);
		
		cusId = new JTextField();
		form.add(cusId);
		cusId.setColumns(5);
		
		JLabel name = new JLabel("Customer Name:");
		form.add(name);
		
		cusName = new JTextField();
		form.add(cusName);
		cusName.setColumns(25);
		
		JLabel pay = new JLabel("Current Bill:");
		form.add(pay);
		
		bill = new JTextField();
		form.add(bill);
		bill.setColumns(25);
		
		JLabel num = new JLabel("Phone Number:");
		form.add(num);
		
		pNum = new JTextField();
		form.add(pNum);
		pNum.setColumns(25);
		
		JLabel phone = new JLabel("Reserved Phone:");
		form.add(phone);
		
		bookPho = new JTextField();
		form.add(bookPho);
		cusId.setColumns(25);
		
		JLabel carrier = new JLabel("Current Carrier:");
		form.add(carrier);
		
		nwCarrier = new JTextField();
		form.add(nwCarrier);
		nwCarrier.setColumns(10);
		
		JLabel viplvl = new JLabel("Please Enter Yes or No:");
		form.add(viplvl);
		
		vip = new JTextField();
		form.add(vip);
		vip.setColumns(5);
		
		JLabel password = new JLabel("Please Enter a random Password:");
		form.add(password);
		
		pass = new JTextField();
		form.add(pass);
		pass.setColumns(5);
		
		btnSubmitNewCus = new JButton("Add New Customer");
		buttonListener bl = new buttonListener();
		btnSubmitNewCus.addActionListener(bl);
		form.add(btnSubmitNewCus);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(bl);
		form.add(btnClear);

		btnBackToMain = new JButton("Back to Main");
		btnBackToMain.addActionListener(bl);
		form.add(btnBackToMain);

		add(form, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * ActionListener for letting button works
	 *
	 */
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSubmitNewCus) {
				String tempid = cusId.getText();
				String tempname = cusName.getText();
				String tempbill = bill.getText();
				String tempNum = pNum.getText();
				String tempPho = bookPho.getText();
				String tempCarr = nwCarrier.getText();
				String tempVip = vip.getText();
				String tempss = pass.getText();
				User newUser = new User(tempid, tempname, tempbill, tempNum, tempPho, tempCarr, tempVip, tempss);
				newUser.printinfo();
				Userserver.alluser.add(newUser);				
			}else if(e.getSource() == btnClear) {
				clearAllFields();
			}else if(e.getSource() == btnBackToMain) {
				sendBackToMainMenuJPanel();
			}			
		}
		
		/**
		 * Clear fields
		 */
		private void clearAllFields() {
			cusId.setText("");
			cusName.setText("");
			bill.setText("");
			pNum.setText("");
			bookPho.setText("");
			nwCarrier.setText("");
			vip.setText("");
			pass.setText("");
		}
		
	}

	/**
	 * back to menu tab function
	 */
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
