package tp3prog3b;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TP3Prog3B {
 
    public static void main(String[] args) throws SQLException{
        Computadora computadora = new Computadora();
        GestorComputadora gestor = new GestorComputadora();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese los datos de la computadora");
        System.out.println("Codigo:");
        String codigo = sc.nextLine();
        computadora.setCodigo(codigo);
        
        System.out.println("Marca:");
        String marca = sc.nextLine();
        computadora.setMarca(marca);
        
        System.out.println("Modelo:");
        String modelo = sc.nextLine();
        computadora.setModelo(modelo);
        
        int contador = 0;
        List<Componente> componentes = new ArrayList<Componente>();
        
        while(true){
            contador++;
            Componente c = new Componente();
            System.out.println("Inserte los datos del componente " + contador +":");
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            c.setNombre(nombre);
            
            System.out.println("Número de serie:");
            String nroSerie = sc.nextLine();
            c.setNroSerie(nroSerie);
            c.setComputadora(computadora);
            
            componentes.add(c);
            
            System.out.println("Oprima Y para agregar otro componete. De lo contrario, cualquier otra tecla");
            String salida = sc.nextLine();
            if (!salida.toUpperCase().equals("Y")) {
                break;
            }
        }
        
        computadora.setComponentes(componentes);
        
        gestor.insertarHQL(computadora);
        /*for (Componente c : computadora.getComponentes()) {
                gestor.insertarHQL(c);
        }*/
        
        gestor.cerrarConexion();
    }
    
}