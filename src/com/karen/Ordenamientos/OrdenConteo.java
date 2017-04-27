package com.karen.Ordenamientos;

    //herencia
    public class OrdenConteo extends AlgoritmoOrdenamiento {

        public OrdenConteo(){
            nombre="Orden por conteo";
        }

        public static void countSort( int[] arr )
        {
            int N = arr.length;
            if (N == 0)
                return;
            //valores maximos y minimos
            int max = arr[0], min = arr[0];
            for (int i = 1; i < N; i++)
            {
                if (arr[i] > max)
                    max = arr[i];
                if (arr[i] < min)
                    min = arr[i];
            }
            int range = max - min + 1;
            int[] count = new int[range];
            //matriz de cuenta frecuancia
            for (int i = 0; i < N; i++)
                count[arr[i] - min]++;

            //modificacion de cuenta que se obtienen en la posicion final
            for (int i = 1; i < range; i++)
                count[i] += count[i - 1];

            //modificacion de array original
            int j = 0;
            for (int i = 0; i < range; i++)
                while (j < count[i])
                    arr[j++] = i + min;
        }

        public void ordenar(int[] arreglo){
            countSort(arreglo);
        }

    }

