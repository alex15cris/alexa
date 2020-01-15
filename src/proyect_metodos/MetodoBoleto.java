package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Usuario;
import proyect_gui.GUI_Principal;

public class MetodoBoleto {
    Vector vPrincipal = new Vector();
    
    
    public void crearBoleto(Boleto unBoleto) {
        
         Vector cabeceras = new Vector();
        cabeceras.addElement("numero_boleto");
        cabeceras.addElement("fecha_boleto");
        cabeceras.addElement("hora_boleto");
        cabeceras.addElement("costo_boleto");
                
        //Crear vector con numero fecha hora y costo
        DefaultTableModel mdlTablaP = new DefaultTableModel(cabeceras,0);
        try {
     
            FileReader fr = new FileReader(".\\Pasajero.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;

            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTablaP.addRow(x);
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void guardarBoleto(Boleto unBoleto) {
        vPrincipal.addElement(unBoleto);
    }
    
    //guardar archivo txt
    public void guardarArchivoBoleto(Pasajero pasajero){
        
        try {
            FileWriter fw = new FileWriter (".\\Pasajero.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(pasajero.getId_pasajero());
            pw.print("|"+pasajero.getId_pasajero());
            pw.print("|"+pasajero.getNombre_pasajero());
            pw.print("|"+pasajero.getApellido_pasajero());
            pw.print("|"+pasajero.getTipo_pasajero());
            pw.print("|"+pasajero.getCedula_pasajero());
            pw.println("|"+pasajero.getEdad_pasajero());
            pw.close();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
//mostrar los datos en el jtable
    public DefaultTableModel listaBoleto(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("NUMERO");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("HORA");
        cabeceras.addElement("FECHA");
        //Crear vector con nombre apellido pasajero cedula edad
        DefaultTableModel mdlTablaB = new DefaultTableModel(cabeceras,0);
        try {
            FileReader fr = new FileReader(".\\Pasajero.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTablaB.addRow(x);
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        return mdlTablaB;
    }
    
    public Vector BuscarBoleto(Usuario unUsuario){
      
        try {
            FileReader fr = new FileReader("C:\\Pasajero.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    }
                        String a = x.elementAt(1).toString();
                        if(a.equals(unUsuario)){
                            vPrincipal=x;
                            System.out.println(vPrincipal);     
                }
            }br.close();
            fr.close();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }     
        return vPrincipal;        
    }
    
}
