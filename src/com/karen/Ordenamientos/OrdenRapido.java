package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
//herencia
public class OrdenRapido  extends AlgoritmoOrdenamiento{

    public OrdenRapido(){
        nombre="Orden por quicksort";
    }

    public void ordenar(int[] arreglo){
        ordenamientoRapido(arreglo,0,arreglo.length-1);
    }
    public static void ordenamientoRapido(int arreglo[],int primero, int ultimo){
        int i = primero;
        int j = ultimo;
        if (i >= ultimo) {
            return;
        }
        int pivote = arreglo[(i + j) / 2];
        while (i < j) {
            while (i<j && arreglo[i] < pivote) {
                i++;
            }
            while (i<j && arreglo[j] > pivote) {
                j--;
            }
            if (i < j) {
                int auxiliar = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxiliar;
            }
        }
        if (j < i) {
            int T = j;
            j = i;
            i = T;
        }
        ordenamientoRapido(arreglo, primero, i);
        ordenamientoRapido(arreglo, i == primero ? i+1 : i, ultimo);
    }

}
