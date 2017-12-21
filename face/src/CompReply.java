
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
// import java.lang.StringBuffer;

import org.apache.commons.lang3.StringUtils;
//import edu.stanford.nlp.maxent.DataGeneric;

public class CompReply {
    
    public static void main(String args[]) throws SQLException, FileNotFoundException, IOException
    {
    
    String name=args[0];
    String rep=args[1];
    String sentiment=args[2];
    String tagged=args[3];
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sessions?useSSL=false","root", "root");
    System.out.println(name+"   "+rep+"  "+sentiment+" "+tagged);
    String lem=new StoreLemma().lemma();//store lemma
    String tag[]=new TagStore().tag(tagged,lem);//store tags
    
    rep=rep.trim();
    rep=rep.substring(0, 1).toUpperCase()+rep.substring(1);
    String start[]={"Why ","What","Which ","Who ","When ","How ","Is ","Did ","Was ","Do ","Does ","Play "};
       String rep1=rep.toLowerCase();
   if(StringUtils.startsWithAny(rep, start)) {
      
  System.out.println("Type: Question");
  new QuestionProcess().question(name,rep,sentiment,tag);
    }
   else if(StringUtils.endsWith(rep,"?"))
   {
    System.out.println("Type: Question");
   new QuestionProcess().question(name,rep,sentiment,tag);
   }
  
   else if(rep1.startsWith("open")||rep1.startsWith("start"))
       {
    System.out.println("Type: Question");
   new QuestionProcess().question(name,rep,sentiment,tag);
   }
   
   else 
   {
         System.out.println("Type: Statement");
   new StatementProcess().statement(name,rep,sentiment,tag);
   }
    
    
    //Statement st=conn.createStatement();
  
    
    }
    
    
    
}
