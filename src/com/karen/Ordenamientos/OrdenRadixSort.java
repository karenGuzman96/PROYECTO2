package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
//herencia
public class OrdenRadixSort  extends AlgoritmoOrdenamiento{

    public OrdenRadixSort(){
        nombre=" Order por radixsort";
    }

    public void ordenamientoRadixSort (int [] array){
        int k,i,j;
        for (k = Integer.SIZE - 1; k >= 0; k--){
            int Auxiliar[] = new int[array.length];
            j=0;
            for (i =0 ;i < array.length;i++){
                boolean Mover = array[i] << k>= 0;
                //uso de Ternario?
                if (k==0 ? !Mover:Mover){
                    Auxiliar[j] = array[i];
                    j++;
                }else{
                    array[i-j] = array[i];
                }
            }
            for (i=j;i<Auxiliar.length;i++){
                Auxiliar[i] = array[i-j];
            }
            array = Auxiliar;
        }

    }
    public void ordenar(int[] array){
        ordenamientoRadixSort(array);
    }

}