import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.mysql.cj.Query;
import com.mysql.cj.callback.UsernameCallback;
import com.mysql.cj.conf.ConnectionUrl.Type;
import com.mysql.cj.xdevapi.Result;

public class dbcon {

	public static final int INVALID_USERNAME = 0;
	public static final int FAILED = 1;
	public static final int WRONG_PASSWORD = 2;
	public static final int ERROR = 3;
	public static final int ACCESS_DENIED = 4;
	public static final int SUCCESS=8;
	public static final int ADMIN=9;
	public static final int DONAR_RECIVER=10;
	public static final int PRIMARY_KEY=11;
	
	
	public static int login(String username,String password) {
		Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
			
		} catch(SQLException e) {
			System.out.println("DATABASE ERROR");
			}
	       if(connection!=null)
	       {
	    	 try {
				statement=connection.prepareStatement("select password,user_type from user where username=?");
				statement.setString(1, username);
				resultSet=statement.executeQuery();
				if(resultSet.next())
				{
					String dbpassword=resultSet.getString("password");
					String dbtype = resultSet.getString("user_type");
					if(dbpassword.contentEquals(password))
					{
						if(dbtype.contentEquals("a"))
							return ADMIN;
						if(dbtype.contentEquals("d_r"))
								return DONAR_RECIVER;
						
					} 
					else {
						return WRONG_PASSWORD;
						
					}	
				}
				else {
					return INVALID_USERNAME;
				}
			} catch (SQLException e1) {
				System.out.println("SQLException error");
				return FAILED;
			}  
	    	 finally {
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
					
				}
			}
	       }
	       return ERROR;
	      
		}
	
public static ResultSet get_details(String bloodgroup,String district) {
Connection connection=null;
ResultSet resultSet=null;
PreparedStatement statement=null;
try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
	
} catch(SQLException e3) {
	System.out.println("DATABASE ERROR");
}
if(connection!=null)
{
	 try {
		statement=connection.prepareStatement("select * from Donar where blood_group=? and district=?");
		statement.setString(2, district);
		statement.setString(1, bloodgroup);
		
		resultSet=statement.executeQuery();



	 }
	 catch (Exception e) {
		// TODO: handle exception
	}

	
}
return  resultSet;
}


public static int signup(String username,String password,String name,String phone,String district,String group) {
	Connection connection=null;
    PreparedStatement statement=null;
    try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
		
	} catch(SQLException e) {
		System.out.println("DATABASE ERROR");
		}
       if(connection!=null)
       {
    	 try {
			statement=connection.prepareStatement("insert into Donar values(?,?,?,?,?,?)");
			statement.setString(1, name);
			statement.setString(2, phone);
			statement.setString(3, group);
			statement.setString(4, district);
			statement.setString(5, username);
			statement.setString(6, password);
			statement.executeUpdate();
			return SUCCESS;	
		} catch (SQLIntegrityConstraintViolationException e1) {
			System.out.println("User already exist");
			return PRIMARY_KEY;
		}  catch (SQLException e1) {
			System.out.println("SQLException error");
			return FAILED;
		}
    	 finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
				
			}
		}
       }
       return ERROR;
      
	}


public static int register(String username,String password,String organisation,String phone_no,String address) {
	Connection connection=null;
    PreparedStatement statement=null;
    try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
		
	} catch(SQLException e4) {
		System.out.println("DATABASE ERROR");
		}
       if(connection!=null)
       {
    	 try {
			statement=connection.prepareStatement("insert into Organisation values(?,?,?,?,?)");
			statement.setString(1, organisation);
			statement.setString(2, phone_no);
			statement.setString(3, address);
			statement.setString(4, username);
			statement.setString(5, password);
			statement.executeUpdate();
			return SUCCESS;	
		} catch (SQLIntegrityConstraintViolationException e5) {
			System.out.println("User already exist");
			return PRIMARY_KEY;
		}  catch (SQLException e5) {
			System.out.println("SQLException error");
			return FAILED;
		}
    	 finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e6) {
				e6.printStackTrace();
				
			}
		}
       }
       return ERROR;
      
	}

public static int add(String district,String group,String name,String phoneno,String password,String username) {
	Connection connection=null;
    PreparedStatement statement=null;
    try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
		
	} catch(SQLException e) {
		System.out.println("DATABASE ERROR");
		}
       if(connection!=null)
       { System.out.println("~~~~~~~~~~~");
    	 try {
			statement=connection.prepareStatement("insert into Donar values(?,?,?,?,?,?)");
			statement.setString(1, name);
			System.out.println("2");
			statement.setString(2, phoneno);
			System.out.println("3");
            statement.setString(3, group);
            System.out.println("4");
            statement.setString(4, district);
            System.out.println("5");
			statement.setString(5, username);
			System.out.println("6");
			statement.setString(6, password);
			System.out.println("1");
			statement.executeUpdate();
			System.out.println("7");
			return SUCCESS;	
		} 
    	 catch (SQLIntegrityConstraintViolationException E1) {
			System.out.println("User already exist");
			return PRIMARY_KEY;
		}  
    	 catch (SQLException E1)
    	 {
			System.out.println(E1.toString());
			System.out.println("SQLException error");
			return FAILED;
		}
    	 finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException E2) {
				E2.printStackTrace();
				
			}
		}
       }
       return ERROR;
      
	}

public static int add(String type,String password,String username) {
	Connection connection=null;
    PreparedStatement statement=null;
    try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medici","medici","medici123");
		
	} catch(SQLException e) {
		System.out.println("DATABASE ERROR");
		}
       if(connection!=null)
       { 
    	 try {
			statement=connection.prepareStatement("insert into user values(?,?,?)");
			statement.setString(1, username);
			
			statement.setString(2, password);
			
            statement.setString(3, type);
            
			statement.executeUpdate();
			
			return SUCCESS;	
		} 
    	 catch (SQLIntegrityConstraintViolationException E1) {
			System.out.println("User already exist");
			return PRIMARY_KEY;
		}  
    	 catch (SQLException E1)
    	 {
			System.out.println(E1.toString());
			System.out.println("SQLException error");
			return FAILED;
		}
    	 finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException E2) {
				E2.printStackTrace();
				
			}
		}
       }
       return ERROR;
      
	}

}

