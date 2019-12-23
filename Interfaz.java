import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
public class Interfaz{
    private JFrame frame;
    private JPanel[][] paneles;
    public Interfaz(){
        frame=new JFrame("Aplicacion");
        frame.setSize(1000,1000);
        frame.setLayout(new GridLayout(8,8));
        paneles=new JPanel[8][8];
        setPaneles();
        frame.setVisible(true);
    }

    public void setPaneles(){
        for(int f=0;f<paneles.length;++f){
            for(int c=0;c<paneles[0].length;++c){
                paneles[f][c]=new JPanel();
                if(f%2==0){
                    if(c%2==0){
                        paneles[f][c].setBackground(Color.WHITE);
                    }
                    else{
                        paneles[f][c].setBackground(Color.BLACK);
                    }
                }
                else{
                    if(c%2==0){
                        paneles[f][c].setBackground(Color.BLACK);
                    }
                    else{
                        paneles[f][c].setBackground(Color.WHITE);
                    }

                }
                frame.add(paneles[f][c]);
            }
        }
    }
    public void quitarNumeros(){
        for(int f=0; f<paneles.length; f++){
            for(int c=0;c<paneles[0].length;++c){
                paneles[f][c].removeAll();
            }
        }
    }
    public void ponerNumero(int f,int c,int contador){
        /*
        JLabel label=new JLabel();
        Image imagen=new ImageIcon("caballo.png").getImage();
        Image nuevaImagen=imagen.getScaledInstance(paneles[0][0].getWidth(),paneles[0][0].getHeight(),Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(nuevaImagen));
        paneles[f][c].add(label);
        frame.revalidate();
        */
        
        JLabel texto=new JLabel(""+contador);
        texto.setForeground(Color.RED);
        texto.setFont(new Font("Arial",Font.PLAIN,50));
        quitarNumeros();
        paneles[f][c].add(texto);
        frame.repaint();
        frame.revalidate();
         
    }
}