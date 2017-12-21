
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PartsOfSpeech {
    
    
    public String part(String word) throws SQLException
    {
    String pt="";
   // System.out.println(word);
    
    Connection conn=null;
    try {
		Class.forName("com.mysql.jdbc.Driver");
	} 
    catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		
	}
   try {
		conn = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/sessions?useSSL=false","root", "root");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		
        }
   Statement st=conn.createStatement();
   String select="select wordtype from entries where word='"+word+"';";
   //st.execute(select);
   ResultSet rs=st.executeQuery(select);
    
   while(rs.next())
   {
       
   pt = rs.getString(1);
   //System.out.println("xx"+pt+"xx");
   }
    return pt;
    
    }
    
}
