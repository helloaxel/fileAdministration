
package act06_lectura_escritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // Optimizar el acceso a la ruta guardandola en una variable

        String ruta = System.getProperty("user.dir");

        // A partir de la ruta, crear un directorio

        File carpeta = new File(ruta + File.separator + "Authors");

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        File fichero = new File(ruta + File.separator + "Authors" + File.separator + "list.txt");

        if (!fichero.exists()) {
            fichero.createNewFile();
        }

        // Vinculamos el FileWriter con el lugar a trabajar (el fichero)
        // Usamos BufferedWriter para optimizar la escritura en disco evitando accesos constantes
        //Try-with-resources para el cierre automático de los recursos 

        try (FileWriter fw = new FileWriter(fichero, true);
        BufferedWriter bw = new BufferedWriter(fw);
        Scanner sc = new Scanner(System.in);) {
            
                        boolean flag = false;
                                      
                        while (!flag) {
                            
                            System.out.println(" **** Menu **** ");
                            
                            System.out.println("Opción 1: Agregar un nuevo autor/a: ");
                            System.out.println("Opción 2: Mostrar la lista de autores registrados: ");
                            System.out.println("Opción 3: Salir del programa.");
                            
                            int opc = sc.nextInt();
                            
                            sc.nextLine(); // Limpieza de buffer del Scanner entre diferentes tipos de métodos
                
                            switch (opc) {
                                
                                case 1:
                                                        
                                    System.out.println("Introduce los datos del autor/a:");
                                    
                                    
                                    System.out.println("Nombre:");
                                    String nombre = sc.nextLine();
                
                                    System.out.println("Apellido:");
                                    String apellido = sc.nextLine();
                
                                    System.out.println("Edad:");
                                    int edad = sc.nextInt();
                                    
                                    sc.nextLine();
                
                                    System.out.println("Corriente Literaria:");
                                    String corriente = sc.nextLine();
                
                                    System.out.println("Periodo Histórico:");
                                    String periodo = sc.nextLine();
                                    
                                    Autor autor1 = new Autor(nombre, apellido, edad, corriente, periodo);
                
                                    autor1.guardarAutor(bw);
                
                                    break;
                
                                case 2:
                
                                    FileReader fr1 = new FileReader(fichero);
                                    BufferedReader br1 = new BufferedReader(fr1);
                
                                    for (String linea = br1.readLine(); linea != null; linea = br1.readLine()) {
                
                                        // Formato de presentación
                                        String[] trozos = linea.replace(";*", ";\n").split(";");
                
                                        for (String trozo : trozos) {
                                            System.out.println(trozo);
                
                                        }
                                    }
                                 
                
                                    break;
                
                                case 3:
                              
                                    System.out.println("Registro Finalizado");
                
                                    flag = true;
                
                                    break;
                
                            }
                        }
                
        } catch (Exception e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }



    }

}

class Autor {
    String nombre;
    String apellido;
    int edad;
    String corriente;
    String periodo;

    public Autor (String nombre, String apellido, int edad, String corriente, String periodo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.corriente = corriente;
        this.periodo = periodo;
    }

    public void guardarAutor(BufferedWriter bw) throws IOException {
        bw.write(nombre + ";" + apellido + ";" + edad + ";" + corriente + ";" + periodo + ";*");
        bw.newLine();
        bw.flush();
    } 
    



}