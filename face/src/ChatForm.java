
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;


public class ChatForm extends javax.swing.JFrame {

    

    public static String n; 
    
   public ChatForm(int i)
   {
   getContentPane();
   
   }
    public void type(String rp) throws FileNotFoundException
    {
   // System.out.println(rp);
    //Frame js[]=Frame.getFrames();
    //this.getContentPane();
      //this.getContentPane().getComponent(4);
        rp=rp.trim();
       rp= WordUtils.capitalize(rp, new char[] { '.' });
    ChatForm.textArea1.append("\n\nOptimus: "+rp);
    
   
    
    }
    public ChatForm() throws FileNotFoundException  {
        getContentPane().setBackground(Color.darkGray);
         
        
        initComponents(); //inbuilt initialization
     
        //textArea1.setBackground(new Color(0,0,0,0));

        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        JOptionPane.showMessageDialog(null,"\n\nWelcome! I am Optimus ! \nI am here to be your friend :) ");
        
        this.setVisible(true);
      
      
     String Name = new Scanner(new File("src\\name.txt")).useDelimiter("\\Z").next();//extract name from name.txt
    n=Name;
        textArea1.append("Optimus: Welcome "+Name+ " !");
       textField1.addActionListener(button1.getActionListeners()[0]); //enter =send

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        textField1 = new java.awt.TextField();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea1.setBackground(new java.awt.Color(255, 255, 255));
        textArea1.setEditable(false);
        textArea1.setName(""); // NOI18N

        textField1.setBackground(new java.awt.Color(233, 255, 255));

        button1.setLabel("Send");
        button1.setMaximumSize(new java.awt.Dimension(57, 24));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/518079-background-hd - Copy.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1260, 1260, 1260)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(630, 630, 630)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    String reply=textField1.getText();
   String yu= WordUtils.capitalize(reply, new char[] { '.' });//1st letter capital
        textArea1.append("\n\n"+n +" : "+yu);
        textField1.setText("");
        reply=" "+reply+" ";
        reply=reply.replaceAll(" im ", "i am ").replaceAll(" youre ", " you are ").replaceAll(" theyre ", " they are ").replaceAll(" hes ", " he is ")
                .replaceAll(" shes ", " she is ").replaceAll("n't ", " not ").replaceAll("'ll ", " will ").replaceAll("'s ", " is ").replaceAll("'re ", " are ");
        
        String ar[]=new String[2];
        ar[0]=n;//name
        ar[1]=reply;//reply
        try {
            Reply.main(ar);
        } catch (SQLException | IOException | ClassCastException | ClassNotFoundException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_button1ActionPerformed

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    new ChatForm().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    public static java.awt.TextArea textArea1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
