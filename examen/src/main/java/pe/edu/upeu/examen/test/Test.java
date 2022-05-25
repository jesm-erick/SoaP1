/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.test;

import pe.edu.upeu.examen.config.Conexion;

/**
 *
 * @author jhone
 */
public class Test {
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConex()!=null){
            System.out.println("Conectado");
            
        }else{
            System.out.println("No conecntado");
        }
    }
}
