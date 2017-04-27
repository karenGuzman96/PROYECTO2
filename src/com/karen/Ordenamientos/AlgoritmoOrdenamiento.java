package com.karen.Ordenamientos;

/**
 * Created by The Colombia karen guzman.
 */
    public abstract class AlgoritmoOrdenamiento {

        protected String nombre;

        public void mostrarArreglo(int[] array) {
            int k;
            for (k = 0; k < array.length; k++) {
                System.out.println("{" + array[k] + "}");
            }
            System.out.println();
        }
        public void ordenar(int[] arreglo){

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

