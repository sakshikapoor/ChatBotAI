
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TagStore {
    
    public String[] tag(String tagged,String lem) throws SQLException
    {
    
        
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
   String[] arr = tagged.split(" ");    
String  LOCATION="",  ORGANIZATION="",  DATE="",  MONEY="",  PERSON="",  PERCENT="",  TIME="";
 for ( String ss : arr) {

     if(ss.contains("LOCATION"))
         LOCATION+=ss.replace("/LOCATION", " ");
     else if(ss.contains("ORGANIZATION"))
         ORGANIZATION+=ss.replace("/ORGANIZATION", " ");
     else if(ss.contains("DATE"))
         DATE+=ss.replace("/DATE", " ");
     else if(ss.contains("MONEY"))
         MONEY+=ss.replace("/MONEY", " ");
     else if(ss.contains("PERSON"))
         PERSON+=ss.replace("/PERSON", " ");
     else if(ss.contains("PERCENT"))
         PERCENT+=ss.replace("/PERCENT", " ");
     else if(ss.contains("TIME"))
         TIME+=ss.replace("/TIME", " ");
     //ss.
       //System.out.println(ss);
  }
   String insert="INSERT INTO tag(LOCATION,ORGANIZATION,DATE,MONEY,PERSON,PERCENT,TIME,LEMMA) VALUE ('"+LOCATION+"' , '"+ORGANIZATION+"', '"+DATE+"', '"+MONEY+"', '"+PERSON+"', '"+PERCENT+"', '"+TIME+"', '"+lem+"');";
   st.executeUpdate(insert);
    String tag[]={LOCATION,ORGANIZATION,DATE,MONEY,PERSON,PERCENT,TIME};
    return tag;
    }
    
}
