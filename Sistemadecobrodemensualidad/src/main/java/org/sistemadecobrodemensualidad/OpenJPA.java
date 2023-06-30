package org.sistemadecobrodemensualidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.sistemadecobrodemensualidad.control.MensajeControl;
import org.sistemadecobrodemensualidad.control.PersonaControl;
import org.sistemadecobrodemensualidad.control.exceptions.EntidadPreexistenteException;

import org.sistemadecobrodemensualidad.entidades.Persona;
import org.sistemadecobrodemensualidad.entidades.Mensaje;

public class OpenJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona;
        // Creamos la factoría de entity managers y un entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDeDatos");
        
        PersonaControl personaControl = new PersonaControl(emf);
        
        // Pedimos datos del autor
        String nombre = leerTexto("Introduce nombre: ");
        String apellidos = leerTexto("Introduce apellidos: ");
        String email = leerTexto("Introduce el correo electrónico: ");
        persona = new Persona(nombre, apellidos, email);
        try {
            // Lo añadimos a la BD
            System.out.println("Identificador del autor: " + personaControl.insertar(persona));
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(OpenJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Creamos el mensaje
        MensajeControl mensajeControl = new MensajeControl(emf);
        
        String mensajeStr = leerTexto("Introduce mensaje: ");
        Mensaje mens = new Mensaje(mensajeStr, persona);
        // Establecemos los campos
        mens.setFecha(new Date());
        // Y lo guardamos en la BD
        int idMensaje = 0;
        try {
            idMensaje = mensajeControl.insertar(mens);
        } catch (EntidadPreexistenteException ex) {
            Logger.getLogger(OpenJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Identificador del mensaje: " + idMensaje);
        
        System.out.println("============================================");

        List<Persona> results = personaControl.buscaPersonas();
        for(Persona p : results){
            System.out.println(p);
        }
        
        System.out.println("============================================");
        // Marcamos el comienzo de la transacción
        

    }

    static private String leerTexto(String mensaje) {
        String texto;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(mensaje);
            texto = in.readLine();
        } catch (IOException e) {
            texto = "Error";
        }
        return texto;
    }
}
