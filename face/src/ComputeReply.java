
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Calendar;

public class ComputeReply {
 int y;   
    
public void compute(String nm,String meaning,String snt,String subj,String rep,String tag[]) throws IOException, SQLException
{
   
//check time basic info etc if no

    //if no
    
    checksubject(rep,meaning); //check subject
/*Random rn = new Random();
int minimum=1,maximum=5;
int range = maximum - minimum + 1;
int randomNum =  rn.nextInt(range) + minimum;
switch(randomNum)
{
    case 1:
        //dont know
        break;
        
    case 2:
        //you tell me about it
        break;
                       


}*/
}

    public void checksubject(String rep,String meaning) throws IOException, SQLException {
        
   //int l=rep.length();
   
 System.out.println(rep);
 String words[]={};int j=1;
 rep = rep.substring(0,1).toUpperCase() + rep.substring(1);
 String rep2=rep.replaceAll(" the ", " ").replaceAll(" a ", " ").replaceAll(" is ", " ");
 if(rep2.contains("What time")||rep2.contains("Whats time"))
 {
     
 Calendar cal=Calendar.getInstance();    
  SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");   
  String time=sdf.format(cal.getTime());
 // String greet= StringUtils.substring(reply, reply.indexOf("good ")+5, reply.indexOf(reply, reply.indexOf("good ")+5));
 String replies[]={"Why don't you look at the bottom right corner of the screen? It's "+time,"The time is "+time,"It's "+time};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
 
 
 }
 else if(rep2.contains("Whats date")||rep2.contains("What date"))
 {
 LocalDate localdate=LocalDate.now();
String date="Today's Date is "+DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localdate); 
 new ChatForm(1).type(date);
 }
 else if(rep.contains("Whatsup")||rep.contains("What are you doing"))
 {
 String replies[]={"Just chilling ! What about you?","Thinking of my next reply....","Just relaxing :)","Nothing much...you say?"};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
 }
 
 else if(rep.contains("How are you")||rep.contains("How are you doing"))
 {
 String replies[]={"I am awesome as ever","I am fine.. you say?","I am doing good ! :)","I am at my best"};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
 }
 
 else if(rep.contains("Open control panel")||rep.contains("Start control panel"))
 {
 System.out.println("chrome");
 Runtime.getRuntime().exec("cmd /c start control");
 }
 else if(rep.contains("Open my computer")||rep.contains("Start my computer"))
 {
  System.out.println("computer");
 Runtime.getRuntime().exec("cmd /c start explorer");
 }
 else if(rep.contains("Open browser")||rep.contains("Start browser")||rep.contains("Open chrome")||rep.contains("Start chrome"))
 { System.out.println("chrome");
 
 Runtime.getRuntime().exec("cmd /c start chrome.exe");
 }    
 else if(rep.startsWith("Play "))
 {
   try{  
 System.out.println("play song");
 rep=rep.replace(" the ", "").replace("the song", "").replaceAll("Play", "").replaceAll(" ", "+")+"&";
 String url="http://www.google.com/search?q="+"youtube+"+rep;
 String charset="UTF-8";
 String key="java";
System.out.println(rep);
 String query=String.format("%s",URLEncoder.encode(key, charset));
 URLConnection con=new URL(url+ query).openConnection();
 con.setRequestProperty("User-Agent", "Mozilla/5.0(Windows NT 6.1; WOW64) AppleWebKit/537.36(KHTML,like Gecko) Chrome/37.0.2062 Safari/537.36");
 BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
 
 String inputLine,input=null;
 while((inputLine=in.readLine())!=null)
         {
 System.out.println("."+inputLine+".");
 input+=inputLine;
 }
 
 int startlink=input.indexOf("A HREF=\"");
 int endlink=input.indexOf("\"", startlink+10);
 String finallink=input.substring(startlink+8, endlink);
 
  Document doc = Jsoup.connect(finallink).get();
 String  linkURL=null;
   for (Element link : doc.select("*")) {
        //String linkText = link.ownText();
        linkURL = link.absUrl("HREF");
        //System.out.println(linkURL);
        if(linkURL.contains("www.youtube.com"))
        { 
            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome "+linkURL});
            break;
    }
   }
 }
 catch(UnknownHostException e)
 {
         new ChatForm(1).type("Sorry! To enable this feature you'll have to connect to the internet"); 
         
 }
 
 
 
 }
   else if(rep.startsWith("Who is ")||rep.startsWith("What is ")||rep.startsWith("What are ")||rep.startsWith("Who are"))
    {
        j=0;
        System.out.println("******");
        String rep1=rep.replaceAll(" a", "").replaceAll(" the", "").replace("?", "");
        
     words = rep1.split("\\s+");
    for (int i = 0; i < words.length; i++) {
   
    words[i] = words[i].replaceAll("[^\\w]", "");
    System.out.println(words[i]);
    }
    
    String subject="";int len=2;
    if(words.length<5)
    {
    while(len<words.length)
    {
    subject=subject+words[len]+" ";
    len++;
    }
    //System.out.println(",,,,"+subject+",,,,");
     String arg[]={subject.trim()};
     y=new Wikipedia().main(arg);
     if(y==0)
     j=1;
    }
   
    }
    System.out.println(y+";;;;"+j);
if(y==1)
subj(meaning);
else if(j==0)
subj(meaning);  


    
    }

    public void subj(String rep) throws SQLException, FileNotFoundException {
       System.out.println("no wikipedia");
       
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
   rep=(rep.substring(0,1).toLowerCase()+rep.substring(1)).trim();
   
   rep=rep.replaceAll("who |what |which |why |how |when |whose |is |are |was |were |am ", "");
  // System.out.println(".;.;"+rep+".;.;");
 
String[] words = rep.split("\\s+");
for (int i = 0; i < words.length; i++) {
   
    words[i] = words[i].replaceAll("[^\\w]", "");
}

  ResultSet i=null;int c=0;
 Statement st=conn.createStatement();
 String count="select count(*) from meaning;";
  i=st.executeQuery(count);
   while (i.next()){
                    c = i.getInt(1);
                }
   System.out.println(c);//c is count
   String mean="",type="";
   while(c>=0)      //to check from history
   {
    
   st=conn.createStatement();
   String str="select meaning,type from meaning where id="+c;
   ResultSet rs= st.executeQuery(str);
   while (rs.next()){
      mean = rs.getString(1);
     type=rs.getString(2);
     System.out.println(mean+"   "+type);
   }
          if(type.contains("q."))
          {     c--;
              continue;       
          }     
        
   System.out.println(mean);
   int y=0;
  for (String s : words) {
        if (!mean.contains(s))
        {
        y=1;
        break;
        }
    }      
     if(y==0)
     {
     new ChatForm(1).type(mean);
     break;
     }
      else
     {
     c--;
     }
   }
   if(c==-1)
   {
   String replies[]={"Sorry..I don't know how to answer that","Well, I dont know the answer!","I don't know.. maybe you could help me with that!","Sorry I don't know the answer :("};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
   }
    }
}
