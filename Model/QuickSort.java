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
public class QuickSort {
    public static int[] quicksort(int vet[], int ini, int fim) {

        int meio;

        if (ini < fim) {

            meio = partition(vet, ini, fim);

            quicksort(vet, ini, meio);

            quicksort(vet, meio + 1, fim);

        }
        
        return vet;

    }

 

    public static int partition(int vet[], int ini, int fim) {

        int pivo, topo, i;

        pivo = vet[ini];

        topo = ini;

 

        for (i = ini + 1; i <= fim; i++) {

            if (vet[i] < pivo) {

                vet[topo] = vet[i];

                vet[i] = vet[topo + 1];

                topo++;

            }

        }

        vet[topo] = pivo;

        return topo;

    }
}
