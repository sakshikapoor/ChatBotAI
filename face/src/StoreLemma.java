
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class StoreLemma {
    
public String lemma() throws FileNotFoundException, SQLException
{
    
String rep = new Scanner(new File("src\\output.txt")).useDelimiter("\\Z").next();
String[] arr = rep.split(" ");
String reply="";
for ( String ss : arr) {

if(ss.contains("Lemma="))
    reply+=ss.replace("Lemma=", " ");

}
reply=reply.trim();
System.out.println(reply);
return reply;



}
    
    
}
