package celluarService;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.*;
/**************************************************************************
 * Name: Carrier Operating System
 * Author: Jason Shi
 * Created: 12/12/2020
 * Version: 1.0
 * OS: Windows x64
 * Copyright: This is my own original work based on specifications issued by our instructor
 * Description: Input: nothing
 *              Output: GUI interface
 * Academic Honesty: I attest that this is my original work.
 *                  I have not used unauthorized source code, either modified or
 *                  unmodified. I have not given other fellow student(s) access to my program 
 **************************************************************************/
public class Userserver {
	public static ArrayList<User> alluser = new ArrayList<User>();;
	public static LinkedBlockingQueue<User> waitqueue=new LinkedBlockingQueue<User>(100);
	
	/**
	 * Constructor
	 */
	public Userserver() {		
		
	}
	
	/**
	 * Output all user information
	 * @return 
	 */
	public static String getAll(){
		String result = "Customer Information: \n";

		for (User user: alluser){
			result += user.getInfo();
		}

		return result;
	}

	/**
	 * Main Function/Driver
	 * @param args
	 */
	public static void main(String[] args) {		
		JFrame frame = new JFrame();
		MainMenuJPanel panel = new MainMenuJPanel();
		frame.add(panel);
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

}
