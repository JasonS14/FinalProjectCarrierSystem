package celluarService;

public class User {
	public String userid;//user id
	public String username;
	public String pay;
	public String tel;
	public String bookpho;//reserved phone
	public String operator;//carrier
	public String type;//check VIP level
	public String passwd;
	
	/**
	 * Constructor
	 * @param userid
	 * @param username
	 * @param pay
	 * @param tel
	 * @param bookpho
	 * @param operator
	 * @param type
	 * @param passwd
	 */
    User(String userid,String username,String pay,String tel,String bookpho,String operator,String type,String passwd)
	{
		this.userid=userid;
		this.username=username;
		this.pay=pay;
		this.tel=tel;
		this.bookpho=bookpho;
		this.operator=operator;
		this.type=type;
		this.passwd=passwd;
		
	}
    
    /**
     * User information display
     */
    public void printinfo()
    {
		System.out.print("User Id:"+userid+" Username:"+username+" User Bill:"+pay+" Phone Number:"+tel+" Reserved Phone:"+bookpho+" Carrier:"+operator+'\n');
    }
    
    /**
     * User information get() method
     * @return
     */
    public String getInfo() {
		return "      User Id: "+userid+"\n            Username: "+username+"\n            User Bill: "+pay+"\n            Phone Number: "+tel+"\n            Reserved Phone: "+bookpho+"\n            Carrier: "+operator+'\n';
	}
	
}
