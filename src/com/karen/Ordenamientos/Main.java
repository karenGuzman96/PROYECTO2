package com.karen.Ordenamientos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args)throws IOException {
        //leer txt
        new muestraContenido("C:\\Users\\karen\\Desktop\\PROYECTO2.txt");
        //escribir fichero
        String ruta = "C:\\Users\\karen\\Desktop\\PROYECTO2.txt";
        File Ordenamientos = new File(ruta);
        BufferedWriter bw;
        if (Ordenamientos.exists()){
            bw = new BufferedWriter(new FileWriter(Ordenamientos));
            bw.write("El fichero de texto ya estaba creado");
        }else {
            bw = new BufferedWriter(new FileWriter(Ordenamientos));
            bw.write("Acabo de crear el fichero de texto");
        }
        bw.close();

        char seleccionAlgoritmo = seleccionAlgoritmo();
        AlgoritmoOrdenamiento algoritmo = instanciarAlgoritmo(seleccionAlgoritmo);
        char seleccion1 = primeraOpcion();
        int tamano = cantidadNumeros(seleccion1);
        int[] arreglo = generarNumeros(tamano);
        int[] arregloOrdenado=null;
        char seleccion2 = segundaOpcion();
        boolean imprimirPantalla=  imprimirSN(seleccion2);
        ordenarArreglo(algoritmo,arreglo, imprimirPantalla);
    }

    private static void ordenarArreglo(AlgoritmoOrdenamiento algoritmo,int[] arreglo,  boolean imprimir) {
        long inicio = System.currentTimeMillis();
        if (imprimir){
            System.out.println("Orden original");
            algoritmo.mostrarArreglo(arreglo);
            System.out.println(algoritmo.getNombre());
            algoritmo.ordenar(arreglo);
            algoritmo.mostrarArreglo(arreglo);
        }else{
            algoritmo.ordenar(arreglo);
        }
        long fin = System.currentTimeMillis();

        long total = fin - inicio;
        System.out.println("-------------------------\n");
        System.out.println("Duracion total: " +total+" milisegundos");
    }

    private static AlgoritmoOrdenamiento instanciarAlgoritmo(char seleccionAlgoritmo) {
        AlgoritmoOrdenamiento algoritmo=null;
        switch (seleccionAlgoritmo){

            case 'a':
                algoritmo = new OrdenInsercion();
                break;

            case 'b':
                algoritmo = new OrdenMezcla();
                break;

            case 'c':
                algoritmo = new OrdenMontones();
                break;

            case 'd':
                algoritmo = new OrdenRapido();
                break;

            case 'e':
                algoritmo = new OrdenConteo();
                break;

            case 'f':
                algoritmo = new OrdenRadixSort();
                break;
            case 'g':
                exit(0);
                break;
            default:
                exit(0);
                break;
        }
        return algoritmo;
    }

    private static boolean imprimirSN(int seleccion2) {
        boolean imprimir=false;
        if (seleccion2 == 'a'){
            imprimir = true;
        }else if(seleccion2 == 'b'){
            imprimir = false;
        }else{
            exit(0);
        }
        return imprimir;
    }

    private static char seleccionAlgoritmo() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Que algoritmo desea utilizar?");
        System.out.println("-------------------------\n");
        System.out.println("a. Ordernamiento por insercion ");
        System.out.println("b. Ordernamiento por mezcla");
        System.out.println("c. Ordernamiento por montones (heap sort)");
        System.out.println("d. Ordernamiento rapido (quicksort)");
        System.out.println("e. Ordernamiento por conteo (counting sort)");
        System.out.println("f. Ordernamiento por radix sort");
        System.out.println("g. Salir");
        return entrada.next().charAt(0);
    }

    private static char primeraOpcion() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Cuanto enteros desea ordenar?");
        System.out.println("-------------------------\n");
        System.out.println("a. 1 Millon de datos ");
        System.out.println("b. 2 Millones de datos");
        System.out.println("c. 5 Millones de datos");
        System.out.println("d. 10 Millones de datos");
        System.out.println("e. 20 Millones de datos");
        System.out.println("f. Salir");
        return entrada.next().charAt(0);
    }

    private static char segundaOpcion() {
        Scanner entrada = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Desea imprimir los valores?");
        System.out.println("-------------------------\n");
        System.out.println("a. Si ");
        System.out.println("b. No");
        System.out.println("c. Salir");
        return entrada.next().charAt(0);
    }

    private static int cantidadNumeros(char seleccion) {
        int tamano=0;

        switch (seleccion){

            case 'a':
                tamano=1000;
                break;
            case 'b':
                tamano=2000;
                break;
            case 'c':
                tamano=5000;
                break;
            case 'd':
                tamano=10000;
                break;
            case 'e':
                tamano=20000;
                break;
            case 'f':
                exit(0);
                break;

        }
        return tamano;
    }

    private static int[] generarNumeros(int tamano) {
        int[] arreglo;Random aleatorio = new Random();
        arreglo= new int[tamano];
        boolean bandera = false;
        for(int i=0; i< tamano; i++ ){
            arreglo[i] = aleatorio.nextInt(99999) ;
            if (!bandera){
                arreglo[i] = arreglo[i]*-1;
            }
            bandera = !bandera;
        }
        return arreglo;
    }

}