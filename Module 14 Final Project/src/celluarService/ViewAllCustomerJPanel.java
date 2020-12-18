package celluarService;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ViewAllCustomerJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextArea list;
	JScrollPane scroll;
	Userserver sev = new Userserver();
	private JButton btnBackToMain;

	/**
	 * Create the panel.
	 */
	public ViewAllCustomerJPanel() {
		JPanel form = new JPanel();
		JLabel title = new JLabel("Details for customer");
		
		String result = Userserver.getAll();	
		JTextArea textArea = new JTextArea(result,5,20);
	
		scroll = new JScrollPane(textArea);
		
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(450, 200));
        
        btnBackToMain = new JButton("Back to Main");
        ButtonListener bl = new ButtonListener();
        btnBackToMain.addActionListener(bl);
        
		
		form.setLayout(new BorderLayout());
		form.add(title, BorderLayout.NORTH);
		form.add(scroll, BorderLayout.CENTER);
		form.add(btnBackToMain, BorderLayout.SOUTH);
		
		add(form);
	}
	
	/**
	 * 
	 * ActionListener for letting button works
	 *
	 */
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnBackToMain){
				removeAll();
				   setVisible(false);
		           MainMenuJPanel newPanel = new MainMenuJPanel();
		           add(newPanel);		           
		           validate();
		           setVisible(true);		          
			}
			
		}
		
	}
	
}
