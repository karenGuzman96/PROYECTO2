package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
//herencia
public class OrdenMontones extends AlgoritmoOrdenamiento {

    public OrdenMontones(){
        nombre="Orden por heapSort";
    }

    public void heapSort(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            fnSortHeap(arr, i - 1);
        }
    }
    public void fnSortHeap(int arr[], int arr2) {
        int i, o;
        int lCh, rCh, mCh, root, tmp;
        root = (arr2 - 1) / 2;

        for (o = root; o >= 0; o--) {
            for (i = root; i >= 0; i--) {
                lCh = (2 * i) + 1;
                rCh = (2 * i) + 2;
                if ((lCh <= arr2) && (rCh <= arr2)) {
                    if (arr[rCh] >= arr[lCh]) {
                        mCh = rCh;
                    } else {
                        mCh = lCh;
                    }
                } else {
                    if (rCh > arr2) {
                        mCh = lCh;
                    } else {
                        mCh = rCh;
                    }
                }

                if (arr[i] < arr[mCh]) {
                    tmp = arr[i];
                    arr[i] = arr[mCh];
                    arr[mCh] = tmp;
                }
            }
        }
        tmp = arr[0];
        arr[0] = arr[arr2];
        arr[arr2] = tmp;
        return;
    }

    public void ordenar(int[] arreglo){
        heapSort(arreglo);
    }

}

