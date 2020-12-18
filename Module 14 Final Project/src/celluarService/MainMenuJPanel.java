package celluarService;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenuJPanel extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton resButton=new JButton("Reserve Service");
	JButton lineButton=new JButton("Start Service");
	JButton newCusButton=new JButton("New customer");
	private final JButton infoButton=new JButton("All Customer Information");;

	/**
	 * Create the panel.
	 */
	public MainMenuJPanel() {
		
		JLabel instructions = new JLabel(" SELECT AN OPTION TO CONTINUE ");
		
		ButtonListener bl = new ButtonListener();
		resButton.addActionListener(bl);
		lineButton.addActionListener(bl);
		newCusButton.addActionListener(bl);
		infoButton.addActionListener(bl);
		
		JPanel buttons = new JPanel();
		setLayout(new BorderLayout());
		add(instructions, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(resButton);
		buttons.add(lineButton);
		buttons.add(newCusButton);
		buttons.add(infoButton);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 * ActionListener for letting button works
	 *
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			if (e.getSource() == resButton) {
				newPanel = new ReserveJPanel();
			} else if (e.getSource() == lineButton) {
				newPanel = new ServiceJPanel();
			} else if (e.getSource() == newCusButton) {
				newPanel = new AddNewCustomerJPanel();
			} else if (e.getSource() == infoButton) {
				newPanel = new ViewAllCustomerJPanel();			
			}
			
			sendToNewPanel(newPanel);

		}
		
		/**
		 * Link to new panel page
		 * @param newPanel
		 */
		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);

		}		
	}	
	
}
