import static cern.clhep.Units.s;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import org.wikipedia.Wiki;
/**
 *
 * @author Sakshi
 */
public class Wikipedia {

    /**
     * @param args the command line arguments
     */
    public static int main(String[] args) throws IOException  {
        // TODO code application logic here
        String title=args[0];
        System.out.println(title);
        try{
        Wiki wiki=new Wiki ("simple.wikipedia.org");
       // String title="Cghghghloud computing";
       
        String content=wiki.getPageText(title);
        System.out.println(content);
        int y=content.indexOf("\'\'\'");
        String str=content.substring(y, content.indexOf(".", y));
        str=str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\'", "").replaceAll("\\|", " or ").replaceAll("&nbsp;", "");
        
        System.out.println(str);
      new ChatForm(1).type(str);
    }
    catch(UnknownHostException | NullPointerException | StringIndexOutOfBoundsException |SSLHandshakeException u)
    {
    System.out.println("wikipedia not found");
    return 1;
    }
    
    return 0;
    }
    
}
