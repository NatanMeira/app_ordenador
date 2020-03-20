/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author natan
 */
public class Ordenacao {
    
     public long insertionSort(int[] vetor) {

        long tempoinicial = System.currentTimeMillis();
        for (int i = 0; i < vetor.length; i++) {
            int atual = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] >= atual) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = atual;
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de InsertionSort: " + tempototal + "ms");
        return tempototal;
    }

    public long selectionSort(int[] vetor) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = 0; i < vetor.length; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int tmp = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = tmp;
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
    System.out.println("Tempo de Processamento de SelectionSort: " + tempototal + "ms");
        return tempototal;
    }

    public long bubbleSort(int vetor[]) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
     System.out.println("Tempo de Processamento de BubbleSort: " + tempototal + "ms");
        return tempototal;
    }

    public long mergeSort(int[] array) {
        long tempoinicial = System.currentTimeMillis();
        array = MergeSort.sort(array);
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
  System.out.println("Tempo de Processamento de MergeSort: " + tempototal + "ms");
        return tempototal;
    }
    public int[] mergeSorting(int[] array) {
        long tempoinicial = System.currentTimeMillis();
        array = MergeSort.sort(array);
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de MergeSort: " + tempototal + "ms");
        return array;
    }
    
    public long quickSort(int[] array) {
        long tempoinicial = System.currentTimeMillis();
        array = QuickSort.quicksort(array, 0, (array.length - 1));
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
   System.out.println("Tempo de Processamento de QuickSort: " + tempototal + "ms");
        return tempototal;
    }
    
    public long heapSort(int[] array) {
        long tempoinicial = System.currentTimeMillis();
        array = HeapSort.sort(array);
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
  System.out.println("Tempo de Processamento de HeapSort: " + tempototal + "ms");
        return tempototal;
    }
    
    

}
