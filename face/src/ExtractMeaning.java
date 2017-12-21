
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;


public class ExtractMeaning {
    
    
    @SuppressWarnings("empty-statement")
    public String extract(String name, String rep, String sentiment) throws SQLException
    {
           
       rep=" "+rep+" ";
       rep=rep.toLowerCase();
       Map<String, String> replacements = new HashMap<String, String>() {{
   // put(" yourself "," myself ");
    put(" i "," you ");
   // put(" mine "," yours ");
   // put(" yours "," mine ");
    put(" you "," i ");
  //  put(" myself "," yourself ");
}};


//String regexp = " i | yourself | mine | yours | you | myself ";
String regexp = " i | you ";
StringBuffer sb = new StringBuffer();
Pattern p = Pattern.compile(regexp);
Matcher m = p.matcher(rep);

while (m.find())
    m.appendReplacement(sb, replacements.get(m.group()));
m.appendTail(sb);



String str=sb.toString();
 System.out.println("meaning:"+str);
str=StringUtils.replaceEach(str, new String[]{" mine "," yours "," yourself "," myself "," my "," your "},new String[]{" yours "," mine "," myself "," yourself "," your "," mine "});
//System.out.println("..."+str);
//MultiReplaceUtil.replaceAll{str,{",", ""}, {"cat", "dog"}, {"football", "rugby"}};
str=str.replace(" are i ", " am i ").replace(" you was ", " you were ").replace(" i were ", " i was ")
        .replace(" i are ", " i am ").replace(" you am ", " you are ")
       .replace(" am you ", " are you ").replace(" i ", " I ");
       // System.out.println("xix"+str+"xix");
        
        if(str.contains("I"))
        {
        int index=str.indexOf("I");
        int sp=str.lastIndexOf(" ", index-2);
        String word=str.substring(sp+1, index-1);
       // System.out.println("xx"+word+"xx");
        String pos=new PartsOfSpeech().part(word);
        if(pos.contains("v.")||pos.contains("imp.")||pos.contains("prep.")){
          //  System.out.println("true");
        str=str.replace("I", "me");}
       // System.out.println(str);
       
        
        }
        str= str.trim();
        System.out.println("meaning:"+str);
      return str;  
    }
    
}
