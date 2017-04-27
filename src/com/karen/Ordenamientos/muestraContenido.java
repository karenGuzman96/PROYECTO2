package com.karen.Ordenamientos;
/**
 * Created by karen colombia
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class muestraContenido {
        public muestraContenido(String s) {
        }

        public static void muestraContenido (String Ordenamientos )throws FileNotFoundException,IOException {
            String cadena;
            FileReader f = new FileReader(Ordenamientos);
            BufferedReader b = new BufferedReader(f);
            while ((cadena =b.readLine())!=null){
                System.out.println(cadena);
            }
            b.close();
        }
    }
