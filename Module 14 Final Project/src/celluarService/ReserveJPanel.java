package celluarService;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReserveJPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField userid = new JTextField(8);
	private JButton btnBackToMain;
	private JButton submit;
	private JButton decline;
	private JTextField userInput;
	private JLabel info;
	
	/**
	 * Constructor
	 */
	public ReserveJPanel() {
		JPanel res = new JPanel();
		JLabel label = new JLabel("Enter User ID");
				
		userInput = new JTextField(20);
		
		submit = new JButton("Service Now");
		ButtonListener b1 = new ButtonListener();
		submit.addActionListener(b1);
		
		decline = new JButton("Service Later");
		ButtonListener b2 = new ButtonListener();
		submit.addActionListener(b2);
		
		btnBackToMain = new JButton("Back to Main");
        ButtonListener b3 = new ButtonListener();
        btnBackToMain.addActionListener(b3);
        
        info = new JLabel();
		
        res.setLayout(new GridLayout(0, 1));
		res.add(label);
		res.add(userInput);
		res.add(submit);
		res.add(decline);
		res.add(btnBackToMain);
		res.add(info);
		
		add(res);		
	}
	
	/**
	 * ActionListener for letting button works
	 * 
	 *
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(e.getSource() == submit) {
				int id = Integer.parseInt(userInput.getText());
				waitforsever(id);
			}else if(e.getSource() == decline) {
				Userserver.waitqueue.poll();
				info.setText("Reservation Made");
			}else if(e.getSource()==btnBackToMain){
				removeAll();
				   setVisible(false);
		           MainMenuJPanel newPanel = new MainMenuJPanel();
		           add(newPanel);
		           validate();
		           setVisible(true);		          
			}			
		}		
	}
	
	/**
	 * use id to check current line or VIP customer
	 * @param id
	 */
	public void waitforsever(int id) 
	{
		String type;
		User tempuser=Userserver.alluser.get(id);
		type = tempuser.type;
		if(type == "Yes")
		{
			info.setText("VIP User");
		}
		else
		{
			if(Userserver.waitqueue.isEmpty())
			{
				info.setText("Currently no one in the line ");
				Userserver.waitqueue.offer(tempuser);
			}
			else if(tempuser.userid == Userserver.waitqueue.peek().userid)
			{
				info.setText("You are the first one in the line");
			}
			else
			{
				Userserver.waitqueue.offer(tempuser);
				info.setText("You are still need to wait"+(Userserver.waitqueue.size()-1)+" users");
			}
		}	
	}
}
