/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.CECAR.logicanegocio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase para realizar tets a la clase Operaciones
 * @author Grupo de trabajo cuello, rios, rodrigez, sierra
 * @version 2.0
 * Fecha 27/05/2015
 */
public class OperacionTest {
    
    public OperacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of abrir method, of class Operacion.
     */
    
    
    @Test
    public void testAbrir() {
        System.out.println("metodo abrir clase operaciones");
        String ruta = "C:\\Users\\JESUS\\Desktop\\prueba\\prueba.txt";
        String expResult = "contenido del fichero";
        String resultado = Operacion.abrir(ruta);
        assertEquals(expResult, resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   
    

    /**
     * Test of guardar method, of class Operacion.
     */
    
    @Test
    public void testGuardar() {
        System.out.println("metodo guardar");
        String ruta = "C:\\Users\\JESUS\\Desktop\\prueba\\prueba.txt";
        String contenido = "documento guardado con exito";
        boolean expResult = true;
        boolean result = Operacion.guardar(ruta, contenido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
  
}
