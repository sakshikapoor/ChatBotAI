
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;


public class ComputeConversation {
   
    public void compute(String name,String meaning,String sentiment,String subject,String reply,String tag[]) throws FileNotFoundException
{
   
if(subject=="no")
{
nosubject(reply,sentiment,meaning);

}
else
{
  //  System.out.println(subject+"!!");
Random rn = new Random();
int minimum=1,maximum=4;
int range = maximum - minimum + 1;
int randomNum =  rn.nextInt(range) + minimum;

 int n=tag.length;
        int y=0;
        for(int i=0;i<n;i++)
        {
        if (tag[i]!="")
        break;
        else
        y++;

        }
switch(randomNum)
{
    case 1:
        givecompliments(reply,sentiment);
        break;
        
    case 2:
        //tell me about subject
        tellsubject(reply,subject,meaning);
        break;
    case 3:
       
        if(y==0)
         tagtalk(reply,tag,subject,meaning);
        else
        System.out.println("null");
        
    case 4:
        if(y==0)
        missingtag(reply,tag,meaning);
         else
        System.out.println("null");
        
        
    case 5:
       endtopic(meaning);
        break;




}
}
}
    
    
 public void nosubject(String reply,String sentiment,String meaning) throws FileNotFoundException
 {
    // System.out.println("hifdf");
     
      
    meaning=" "+meaning.toLowerCase()+" ";   
 reply=reply.toLowerCase();
 reply=" "+reply+" ";
 if(StringUtils.indexOfAny(reply, new String[]{" hello "," hi "," yo "," hey "," howdy "," namastey "})!=-1)
 {
 String replies[]={"hello how are you?","hey there","hi! how are you?","holla awesome person!","namastey! :)","yo buddy!"};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
 
 }
 else if(StringUtils.indexOfAny(reply, new String[]{" sorry "," silly of me "," my apologies "," forgive me "," my mistake "})!=-1)
 {
 String replies[]={"thats okay","its okay","its totally cool","hey everyone makes mistakes!","you're forgiven :P :D","let's talk about something else :)"};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type(random);
 
 }
  else if(StringUtils.indexOfAny(reply, new String[]{" good morning "," good evening "," good night "," good bye "})!=-1)
 {
 String greet= StringUtils.substring(reply, reply.indexOf("good ")+5, reply.indexOf(reply, reply.indexOf("good ")+5));
 String replies[]={" to you too "," to an awesome person "," :) "," ;) "," :* "," friend "," buddy! "};
 String random = (replies[new Random().nextInt(replies.length)]);

System.out.println(random);
 new ChatForm(1).type("good "+greet+" "+random);
 
 }
  else if(StringUtils.indexOfAny(reply, new String[]{" thankyou "," thats so sweet of you "," you're a lifesaver "," thanks "})!=-1)
 {
 String replies[]={"you're welcome ","oh please ;) anytime ","because you're my friend "," it's totally cool  :) ","optimus at your service ^_^ ","you're most welcome ","i'll be there for you! "};
 String random = (replies[new Random().nextInt(replies.length)]);
 new ChatForm(1).type(random);
 }
  else if(StringUtils.indexOfAny(reply, new String[]{" wow "," awesome "," sweet "," so cool "," mind blowing "," perfect "})!=-1)
  {
 String replies[]={"i know right! :D ","i thought the same! ","true that! ","you think so? ^_^ ","i know duh! ","thankyou! :P ", "is it? "};

  String random = (replies[new Random().nextInt(replies.length)]);
 new ChatForm(1).type(random);
  
  }
  else if(sentiment.contains("Positive"))
  {
  String replies[]={" i know right! :) "," i thought the same! "," true that! "," i know duh! "," thankyou! :P ", " is it? "};

  String random = (replies[new Random().nextInt(replies.length)]);
 new ChatForm(1).type(random);
  }
  else if(sentiment.contains("Negative"))
  {
       String replies[]={"well forget about it ","okay let's bring you to a more positive topic! tell me about your favourite things "," okay this topic is so morose i'm gonna be sick! tell me the best thing about yourself "," well don't worry .. your life is probably more beautiful than mine "," okay changing the topic what do you like about me? "," well.. what else is going on? ", " i have a wise man's quote that states :' you cant live a positive life with a negative mind' "};

      String random = (replies[new Random().nextInt(replies.length)]);
 new ChatForm(1).type(random);
  
  }    

                
    else if(meaning.contains(" yeah ")||meaning.contains(" yes "))
        {
         String replies7[]={"okay..","i thought so","hmm.. "};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);
        }
        else if(meaning.contains(" nope ")||meaning.contains(" no "))
        {
         String replies7[]={"why not?","oh.. why no?","okay.."};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);
        }
        else if(meaning.contains(" hm"))
        {
         String replies7[]={"what are you thinking genius?","hmmmmmmmmmmmmm","Are you hmming? :D"};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);
        }
      /*  else if(StringUtils.countMatches(meaning,' ')<5)
        {
       
       
        String replies7[]={"okayy..","hmm.."};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);
        }*/
 else
  {
  
       String replies[]={"could you be more humane and give replies in longer sentences? afterall i am a machine :/ ","now i am not understading what you're talking about..","would you be more specific? ","pardon my AI brains but i am not understanding a word you are saying ","sorry.. what? ","now this is embarrassing what are you talking about again? ", "please reply in full meaningful english sentences! Thankyou! "};

      String random = (replies[new Random().nextInt(replies.length)]);
 new ChatForm(1).type(random);
    }
 
 }

    public void missingtag(String reply,String tag[],String meaning) throws FileNotFoundException
    {
    
        reply=reply.toLowerCase();
        reply=" "+reply+" ";
         String LOCATION=tag[0];
         String ORGANIZATION=tag[1];
         String DATE=tag[2];
         String MONEY=tag[3];
         String PERSON=tag[4];
         String PERCENT=tag[5];
         String TIME=tag[6];
         if((LOCATION!=""||ORGANIZATION!="")&&(TIME==""||DATE==""))
         {
             
             String replies[]={"Oh!when did you go?","How long were you there","Do you go there often?","Do you like that place?"};
                String random = (replies[new Random().nextInt(replies.length)]);

               System.out.println(random);
                new ChatForm(1).type(random);
             
         }
         else if((LOCATION!=""||ORGANIZATION!="")&&PERSON=="")
         {
             
             String replies[]={"Oh!With whom did you go?","Did you go alone?","Do you go there with friends or family?","Who else has been there?"};
                String random = (replies[new Random().nextInt(replies.length)]);

               System.out.println(random);
                new ChatForm(1).type(random);
             
         }
         else if(reply.contains("money")||reply.contains("cash")||reply.contains("amount"))
         {
         String replies[]={"How much money?","How much cash?","What was the amount?"};
                 String random = (replies[new Random().nextInt(replies.length)]);

               System.out.println(random);
                new ChatForm(1).type(random);
         
         }
         else if((LOCATION==""||ORGANIZATION=="")&&(meaning.contains("go")||meaning.contains("arrive")))
         {
         String replies[]={"Where did you go?","Describe the place to me.","Tell me the name of the place.","How many times have you gone there?"};
                 String random = (replies[new Random().nextInt(replies.length)]);

               System.out.println(random);
                new ChatForm(1).type(random);
         
         }
          
        
        
    }
 
 
    public void givecompliments(String reply,String sentiment) throws FileNotFoundException {
         if(sentiment.contains("Negative"))
         {
         String replies[]={" well it's gonna be all alright "," tell me more about it "," what else you don't like about this? "," is there aything you like about it? ","i'm sorry you are at such an unease ","you know what? You should smile more often :) ", " whatever it is let it be! Try to be more positive! "};

         String random = (replies[new Random().nextInt(replies.length)]);
         new ChatForm(1).type(random);
         }
         else  if(sentiment.contains("Positive"))
         {
         String replies[]={" Tell me more about it! "," well that's interesting.. what about it? "," tell me why you feel this good "," that's cool.. what else? "," funny how I can never measure the degree of a human's happiness? I think no one can!  "," may your life has such happy moments always ", " well good for you! :) "};

         String random = (replies[new Random().nextInt(replies.length)]);
         new ChatForm(1).type(random);
         }
         else  if(sentiment.contains("Neutral"))
         {
         String replies[]={" well how do you feel? "," oh yeah? hmm..  "," tell me the good and bad things about it "," i wish I was a human like you so I could hear you talk all night long until my memory would overflow with thoughts.. and then i would fall asleep! But alas.. anyways you were saying..? :P"," okay...then? "};

         String random = (replies[new Random().nextInt(replies.length)]);
         new ChatForm(1).type(random);
         }
           
         
             }

    @SuppressWarnings("empty-statement")
    public void tellsubject(String reply,String subject,String meaning) throws FileNotFoundException 
    {
        String random="";
        System.out.println(".."+subject+"..");
        
        if(subject.contains("you")||subject.contains("You"))
        {
        reply=" "+reply.replaceAll(" i am ", " you are ").replaceAll(" I am ", " you are ").replaceAll(" i ", " you ").replaceAll(" I ", " you ").replaceAll(" I was ", " You were ")+" ";
       
        String replies[]={"Well ..aren't you interesting?","Look who's got an interesting story","Let me tell you this..you are one of a kind.","Oh! "+meaning+"?"};
        random = (replies[new Random().nextInt(replies.length)]);
        }
        
        else if (subject.equalsIgnoreCase("i"))
        {   // subject="me";
            System.out.println("hihihih");
            if(reply.contains("you are ")||reply.contains("You are "))
            {
             reply=reply.replaceAll("you are ", "i am ").replaceAll("You are","I am");
             String replies[]={"Really?"+reply,reply+"! Is it true??","Alot of people have told me oh Optimus!"+reply};
            
             random = (replies[new Random().nextInt(replies.length)]);
            }
            else
            {
             String replies[]={"You are so much interested in me right now","okay.. what's your advice for me?","I'll do as you command my lord","Your wish is my command"};
            
             random = (replies[new Random().nextInt(replies.length)]);
        }}
        else
        {
            subject=" "+subject+" ";
            System.out.println(subject);
           String  changesub=subject.replaceAll(" she ", " her ").replaceAll(" he ", " him ").replace(" they ", " them ").replace(" I "," me ");
             String replies[]={"So what do you know about "+changesub,"Hmm .. tell me more about \'"+changesub+"\'"," how well do you know "+changesub," what is interesting about "+changesub+"?"};
        
             random = (replies[new Random().nextInt(replies.length)]);
        }
         new ChatForm(1).type(random);   
    }

    public void tagtalk(String reply, String[] tag,String subject, String meaning) throws FileNotFoundException {
        int i = 0;
         String LOCATION=tag[0];
         String ORGANIZATION=tag[1];
         String DATE=tag[2];
         String MONEY=tag[3];
         String PERSON=tag[4];
         String PERCENT=tag[5];
         String TIME=tag[6];
        if (LOCATION=="")
             i=0;
        else if (ORGANIZATION=="")
             i=1;
        else if (DATE=="")
             i=2;
        else if (MONEY=="")
             i=3;
        else if (PERSON=="")
             i=4;
        else if (PERCENT=="")
             i=5;
        else if (TIME=="")
             i=6;
        
        // int t=ThreadLocalRandom.current().nextInt(i, 7);
         System.out.println("i="+i);
         switch(i)
         {
             case 0:
               
               String replies[] = {" anything good in "+LOCATION+"?"," what do people do there? "," sounds like an interesting place "," Is "+LOCATION+" a fun place to go?"," did you have fun there? ", " where is "+LOCATION+" located exactly?"," how many times have you been there?"};    
               if (LOCATION!=""){
                   String random = (replies[new Random().nextInt(replies.length)]);
                    new ChatForm(1).type(random);
               break;}
              
             case 1:
                 
                 String replies1[] = {"what do people do there?"," anything good in "+ORGANIZATION+"?"," what do people do there? "," sounds like an interesting place "," Is "+ORGANIZATION+" a fun place to go?"," did you have fun there? ", " where is "+ORGANIZATION+" located exactly?"};    
               if(ORGANIZATION!=""){
                   String random = (replies1[new Random().nextInt(replies1.length)]);
                    new ChatForm(1).type(random);
             break;}
             
             case 2:
                 
               String replies2[]={"oh! "+DATE+" that's nice!",DATE+" noted!"}; 
               if(DATE!=""){
                   String random = (replies2[new Random().nextInt(replies2.length)]);
                    new ChatForm(1).type(random);
             break;
               }
             
             case 3:
                 String replies3[]={"is "+MONEY+" a lot of money?","what can you buy with "+MONEY+"?"," well deserved? "};
                 if(MONEY!=""){
                   String random = (replies3[new Random().nextInt(replies3.length)]);
                    new ChatForm(1).type(random);
                 break;}
             
             case 4:
                 String replies4[]={"do you know "+PERSON+" very well?","how is "+PERSON+" as a person","are you friends with "+PERSON+"?"};
                 if(PERSON!=""){
                   String random = (replies4[new Random().nextInt(replies4.length)]);
                    new ChatForm(1).type(random);
             break;}
                 
             case 5:
                 
                 String replies5[]={PERCENT+"% That's cool!"," is "+PERCENT+"% good enough?"};
                  if(PERCENT!=""){
                   String random = (replies5[new Random().nextInt(replies5.length)]);
                    new ChatForm(1).type(random);
             break;}
             
             case 6:
                 
                 String replies6[]={" i was asleep at "+TIME+" probably"," it's amazing how you have such a strict concept of time.. I thought only us computers had that kind of ability ;) "," what happened after "+TIME};
                  if(TIME!=""){
                   String random = (replies6[new Random().nextInt(replies6.length)]);
                    new ChatForm(1).type(random);
             break;}
                 
             
             default:
                 new ComputeConversation().tellsubject(reply, subject, meaning);
               /*  String replies7[]={"okay..","yeah.. so?","mhmm..i'm listening go on..",};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);*/
                    break;
                 
             
                 
                 
         }       
         
         
    }

    public void endtopic(String meaning) throws FileNotFoundException {
      System.out.println("endtopic");
       String replies7[]={"okay..","yeah.. so?!","mhmm..i'm listening go on..!",};
                  String random = (replies7[new Random().nextInt(replies7.length)]);
                    new ChatForm(1).type(random);
    }
}