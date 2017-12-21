
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;


public class Reply {
    public static void main(String args[]) throws SQLException, FileNotFoundException, IOException, ClassCastException, ClassNotFoundException
    {
    
    String name=args[0];
    String rep=args[1];
   // String name,rep="";
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
   String insert="INSERT INTO chat(name,reply) VALUE ('"+name+"' , '"+rep+"');";
   st.executeUpdate(insert);
   
   
   
   
   /*----------------------------*/
   
   
    

     
    Properties props=new Properties();
    props.setProperty("annotators","tokenize, ssplit, pos, lemma, parse, sentiment");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    Annotation annotation;  
    	    
	    PrintWriter out = null;
            out=new PrintWriter("C:\\Users\\Sakshi\\Documents\\NetBeansProjects\\face\\src\\output.txt");
            String nm="";
	    
                 annotation = new Annotation(rep);
                nm+=rep;
 
                 pipeline.annotate(annotation);    
                 pipeline.prettyPrint(annotation, out);
                 
   // pipeline = new StanfordCoreNLP(props);

 annotation = pipeline.process(nm);
 String sentiment="";
List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
for (CoreMap sentence : sentences) 
{
   sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
  System.out.println(sentiment + "\t" + sentence);
  
}
String arg[]=new String[4];
  arg[0]=name;
  arg[1]=rep;
  arg[2]=sentiment;
  
    String model = "english.muc.7class.nodistsim.crf.ser.gz";
    //String text = "locations.txt";

    AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(model);
    
    //classifier.classifyAndWriteAnswers(text);
    String tagged = classifier.classifyToString(rep);
    System.out.println(tagged+"....");
    //System.out.println("Done...");
   arg[3]=tagged;
   /*---------------------------------*/
   
   if(rep.contains(":)")||rep.contains(":D"))
   arg[1]="Positive";
   else if(rep.contains(":("))
   arg[1]="Negative";
   
   new CompReply().main(arg);
    
  

   
   
   
    
    }
    
}
