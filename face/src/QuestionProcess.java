
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class QuestionProcess {
    
 public void question(String name, String rep, String sentiment,String tag[]) throws FileNotFoundException, SQLException, IOException
 {
     
 String str=  new ExtractMeaning().extract(name,rep,sentiment);
 String subject=new FindSubject().sub();
  
  if (subject=="no")
 {
 //exclamation
 }
  
  /*
 else
           
  {
 int in=rep.indexOf(subject);
 String ss="";
 while(str.charAt(in)!=' ')
 {
   ss+= str.charAt(in);
           in++;
 }
 subject=ss;
 
  }*/
       
         int l=rep.length();
          if(rep.charAt(l-1)=='?')
         {
           StringBuilder sb = new StringBuilder(rep);
         rep=sb.insert(l-1, ' ').toString();
         System.out.println("..."+rep+"...");
         }
         new QuestionProcess().store(name, rep, sentiment, str,subject,tag);
         
     }
    
    
    public void store(String name, String rep, String sentiment,String str,String subject,String tag[]) throws SQLException, FileNotFoundException, IOException
    {
    Connection conn=null;
    String nm=name,rp=rep,snt=sentiment,meaning=str,subj=subject;
    
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
   String insert="INSERT INTO meaning(name,meaning,sentiment,subject,reply,type) VALUES ('"+nm+"','"+meaning+"','"+snt+"','"+subj+"','"+rep+"','q.');";
   st.executeUpdate(insert);
    
   new ComputeReply().compute(nm,meaning,snt,subj,rep,tag);
    }
    
}
