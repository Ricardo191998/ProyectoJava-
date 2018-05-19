import java.net.Socket;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

class Cliente{

     public static void main(String [] args){

      MarcoCliente mimarco = new MarcoCliente();

      mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }

}

class MarcoCliente extends JFrame{

      public MarcoCliente(){
          setBounds(300,300,400,200);
          LaminaMarcoCliente milamina = new LaminaMarcoCliente();
          add(milamina);
          setVisible(true);

      }
}

class LaminaMarcoCliente extends JPanel{

     public LaminaMarcoCliente(){

     JLabel texto = new JLabel("CLIENTE");
     add(texto);
     campo1 = new JTextField(20);
     add(campo1);
     miboton = new JButton("Enviar");


     EnviaTexto miEvento = new EnviaTexto();
     miboton.addActionListener(miEvento);

     add(miboton);

     }

     class EnviaTexto implements ActionListener{

           public void actionPerformed(ActionEvent e){
           try{
              Socket miSocket = new Socket("192.168.1.254",9999);
              DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());

              flujo_salida.writeUTF(campo1.getText());

              flujo_salida.close();

            }catch(Exception exc){
              System.out.println("No pudo realizarse la conexion");
           }//System.out.println(campo1.getText());
         }
     }


     private JTextField campo1;
     private JButton miboton;

}
