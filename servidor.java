import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Servidor{

     public static void main(String [] args){

         MarcoServidor mimarco = new MarcoServidor();
         mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }
}

class MarcoServidor extends JFrame implements Runnable{

     public MarcoServidor(){

           setBounds(800,300,400,200);
           JPanel milamina = new JPanel();
           milamina.setLayout(new BorderLayout());
           areatexto = new JTextArea();
           milamina.add(areatexto, BorderLayout.CENTER);
           add(milamina);
           setVisible(true);
           Thread miHilo = new Thread(this);
           miHilo.start();

     }
     private JTextArea areatexto;

     public void run(){

           try{

             ServerSocket server = new ServerSocket(9999);
             Socket miSocket=server.accept();
             DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream());
             String mensaje = flujo_entrada.readUTF();
             areatexto.append("\n"+mensaje);
             miSocket.close();

           } catch(IOException ioe){
             ioe.printStackTrace();
         }
     }

}
