
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//import com.mysql.jdbc.Driver;


public class Sessions {
    
    
    
    public static void session(String name) throws FileNotFoundException 
    {
    
        String nm=name;
        nm = nm.substring(0, 1).toUpperCase() + nm.substring(1);
        try(  PrintWriter out = new PrintWriter( "name.txt" )  ){
             out.println( nm );
}
   
    }
    
   
    
    
    
}
