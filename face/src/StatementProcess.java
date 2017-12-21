
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class StatementProcess {
    public void statement(String name, String rep, String sentiment,String tag[]) throws FileNotFoundException, SQLException
    {
    
        
       String str=  new ExtractMeaning().extract(name,rep,sentiment);
         String subject=new FindSubject().sub();
         System.out.println("subject then:"+subject+"..");
         if (subject=="no")
            {
            //exclamation
            }
         else if(subject.equalsIgnoreCase("I")||subject.equalsIgnoreCase("me"))
         {
         subject="you";
         }
         else if(subject.equalsIgnoreCase("you"))
         {
         subject="i";
         }
         System.out.println("subject now:"+subject+"..");
          /* 
  {
   System.out.println("subject then:"+subject+"ll");
 int in=str.indexOf(subject);
 
 if(in<0)
 {
 in=rep.indexOf(subject);
 System.out.println("in:"+in);
 String ss="";
 if(in<0)
 in=0;
 while(str.charAt(in)!=' ')
 {
   ss+= str.charAt(in);
           in++;
 }
 subject=ss;
 }
 
 
 System.out.println("subject now:"+subject+"ll");
  }*/
         
         int l=rep.length();
         if(rep.charAt(l-1)=='.'||rep.charAt(l-1)=='!')
         {
          StringBuilder sb = new StringBuilder(rep);
         rep=sb.insert(l-1,' ').toString();
        System.out.println("..."+rep+"...");
         }
         new StatementProcess().store(name, rep, sentiment, str,subject,tag);
         
     }
    
    
    public void store(String name, String rep, String sentiment,String str,String subject,String tag[]) throws SQLException, FileNotFoundException
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
   String insert="INSERT INTO meaning(name,meaning,sentiment,subject,reply,type) VALUES ('"+nm+"','"+meaning+"','"+snt+"','"+subj+"','"+rep+"','s.');";
   st.executeUpdate(insert);
     new ComputeConversation().compute(nm,meaning,snt,subj,rep,tag);
    }
    
}
