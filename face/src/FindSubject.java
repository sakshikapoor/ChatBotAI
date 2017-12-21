
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import java.lang.StringBuilder;

public class FindSubject {
    
public String sub() throws FileNotFoundException
{
String sub="";
String Name = new Scanner(new File("src\\output.txt")).useDelimiter("\\Z").next();
if(StringUtils.containsIgnoreCase(Name, "nsubj"))
{
   int i= StringUtils.indexOf(Name, "nsubj");
   i= StringUtils.indexOf(Name, ",", i);
  int j=StringUtils.indexOf(Name, "-", i);
  i=i+2;
  
          
 sub=Name.substring(i, j);
 System.out.println(sub);
}
else
{
    sub="no";
    System.out.println("no");
}
//System.out.println(Name);

return sub;
}
    
}
