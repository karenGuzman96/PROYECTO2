package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
    //herencia
    public class OrdenInsercion extends AlgoritmoOrdenamiento {

        public OrdenInsercion(){
            nombre="Orden por inserccion";
        }

        public void ordenarInsercion (int [] arreglo, int n){
            int i,j,auxiliar;
            for (i =1;i < n; i++){
                auxiliar=arreglo[i];
                j = i - 1;
                while (j>=0 && arreglo[j] > auxiliar){
                    arreglo[j+1]=arreglo[j];
                    j=j-1;
                }
                arreglo[j+1]=auxiliar;
            }

        }
        public void ordenar(int[] array){
            ordenarInsercion(array,array.length);
        }

    }

