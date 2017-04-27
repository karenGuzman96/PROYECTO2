package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
    public class OrdenMezcla  extends AlgoritmoOrdenamiento{

        public OrdenMezcla(){
            nombre="Orden por mezcla";
        }

        public void ordenamientoMezcla (int [] arreglo){
            int i,j,k;
            if( arreglo.length >1){
                int numElementosIzquierdos = arreglo.length/2;
                int numElementosDerechos = arreglo.length - numElementosIzquierdos;
                int[] arregloIzquierdo  = new int[numElementosIzquierdos];
                int [] arregloDerecho  = new int[numElementosDerechos];
                for (i =0;i < numElementosIzquierdos; i++){
                    arregloIzquierdo[i] = arreglo[i];
                }
                for (i = numElementosIzquierdos; i < numElementosIzquierdos + numElementosDerechos; i++){
                    arregloDerecho[i - numElementosIzquierdos]= arreglo[i];
                }
                //Recursividad

                ordenamientoMezcla(arregloIzquierdo);
                ordenamientoMezcla(arregloDerecho);
                //ordenar
                i=0;
                j=0;
                k=0;
                while (arregloIzquierdo.length != j && arregloDerecho.length !=k){
                    if (arregloIzquierdo[j] < arregloDerecho[k]){
                        arreglo[i] = arregloIzquierdo[j];
                        i++;
                        j++;
                    }else{
                        arreglo[i] = arregloDerecho[k];
                        i++;
                        k++;
                    }
                }
                //areglo final
                while (arregloIzquierdo.length !=j){
                    arreglo[i] = arregloIzquierdo[j];
                    i++;
                    j++;
                }
                while (arregloDerecho.length !=k){
                    arreglo[i]= arregloDerecho[k];
                    i++;
                    k++;
                }
            }
        }
        public void ordenar(int[] arreglo){
            ordenamientoMezcla(arreglo);
        }
    }

