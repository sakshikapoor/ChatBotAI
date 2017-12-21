import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.imgscalr.Scalr;
import org.opencv.core.Size;




public class FaceDetection extends javax.swing.JFrame {

    private int i=0;
    

    private String ans;

   
     public FaceDetection() {
       
         
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
       
      
        getContentPane().setBackground(Color.darkGray);
        System.out.println(FaceDetection.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
         webSource = new VideoCapture(0); 
        myThread = new DaemonThread(); 
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 
        jButton2.setEnabled(true);  
        
    }
   private static final float FACES_FRAC = 0.75f;   
       
 
  private double[][] weights = null;    
  private int numEFs = 0;    
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    Mat image_roi=new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(FaceDetection.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();
    
    
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;
         

        @Override
        public void run() {
           
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel1.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            Rect rectCrop=null;
                            for (Rect rect : faceDetections.toArray()) {
                              
                                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                new Scalar(0, 255, 0));
                                rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);
                                
                            }
                              image_roi = new Mat(frame,rectCrop);
                             Size sz = new Size(130,155);
                             
                             Imgproc.resize( image_roi, image_roi, sz );
                             Imgproc.cvtColor(image_roi, image_roi, Imgproc.COLOR_RGB2GRAY);
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                             buff = Scalr.resize(buff,Scalr.Method.SPEED,Scalr.Mode.AUTOMATIC,130,155);
           
                            if (g.drawImage(buff, 0, 0, 130,155 , 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                    
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("");
                        }
                    }
                }
            }
        }
    }
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Depressionist 3 Revisited", 0, 72)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("OPTIMUS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 270, 120));

        jLabel3.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your intelligent friend");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(130, 155));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 130, 155));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(235, 229, 229));
        jButton2.setText("Pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 70, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(235, 229, 229));
        jButton4.setText("Take Snapshot");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(235, 229, 229));
        jButton1.setText("Start Face Recognition");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, -1, -1));

        jLabel1.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("For New Users");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 150, -1));

        jLabel2.setFont(new java.awt.Font("Source Code Pro Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" For Old Users");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 160, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/518079-background-hd.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -16, 1660, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        myThread.runnable = false;            
        jButton2.setEnabled(false);   

        webSource.release();  

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         
         jButton4.setHorizontalAlignment(SwingConstants.CENTER);
        if(i==0) 
        ans = JOptionPane.showInputDialog(null, "Enter your name");
        
        
        String kans="C:\\Users\\Sakshi\\Documents\\NetBeansProjects\\face\\src\\trainingImages\\"+ans+i+".png";
           i++;
          try {
            Imgcodecs.imwrite(kans, image_roi);
           
        } catch (Exception ex) {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {
            
           
            String kans="C:\\Users\\Sakshi\\Documents\\NetBeansProjects\\face\\src\\test.png";
           
          try {
            Imgcodecs.imwrite(kans, image_roi);
           
               } catch (Exception ex) {
               System.out.println("nope");
               }
           Process pr=Runtime.getRuntime().exec("cmd /c start /wait C:\\Users\\Sakshi\\Documents\\NetBeansProjects\\face\\src\\btch.bat");
         pr.waitFor();
         
         this.setVisible(false);
         new ChatForm();
        } catch (IOException ex) {
            Logger.getLogger(FaceDetection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(FaceDetection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
  public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FaceDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaceDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaceDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaceDetection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaceDetection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
