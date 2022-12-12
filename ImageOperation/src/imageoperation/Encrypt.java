
package imageoperation;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Encrypt {
    
    
    public static void operate( int key) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser .showOpenDialog(null);
         File file = fileChooser.getSelectedFile();
         
         try {
             
             FileInputStream fis = new FileInputStream(file);
             byte [] data =new byte [fis.available()];
             fis.read(data);
             int i = 0;
             for(byte b:data){
                 System.out.println(b);
                 
                data[i] = (byte)(b^key);
                i++;
             }
             
             FileOutputStream fos = new FileOutputStream(file);
             fos.write(data);
             fos.close();
             fis.close();
             JOptionPane.showMessageDialog(null, "Done");
            
        } catch (Exception e) {
             System.out.println(e);
        }
        
    }

    public static void main(String args[]) {
        System.out.println("Hello Mini");
        
       JFrame f = new JFrame();
       f.setSize(500 , 300);
       f.setLocationRelativeTo(null);
       f.setTitle("Image Encryption");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       Font font = new Font("Roboto" , Font.BOLD , 25);
       
       
       JButton button = new JButton();
       button.setText("Open Image");
       button.setFont(font);
       
       
       JTextField textField = new JTextField(10);
       textField.setFont(font);
       
       button.addActionListener(e -> {
           System.out.println("Button clicked");
           String text = textField.getText();
           int temp = Integer.parseInt(text);
           operate(temp);
           
       });
       
       
       f.setLayout(new FlowLayout());
       
       f.add(button);
       f.add(textField);
       f.setVisible(true);
               
       
       f.setVisible(true);
       
    }
}
