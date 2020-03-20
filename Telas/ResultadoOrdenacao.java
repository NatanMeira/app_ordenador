/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import static Model.Dados.dados;
import Model.Ordenacao;
import static Telas.EscolhaOrdenacao.selecionados;
import static Telas.EscolhaOrdenacao.insercao;
import static Telas.EscolhaOrdenacao.selecao;
import static Telas.EscolhaOrdenacao.mergesort;
import static Telas.EscolhaOrdenacao.heapsort;
import static Telas.EscolhaOrdenacao.quicksort;
import static Telas.EscolhaOrdenacao.bubblesort;
import java.util.ArrayList;
import java.util.Arrays;



import javax.swing.JLabel;

/**
 *
 * @author natan
 */
public class ResultadoOrdenacao extends javax.swing.JFrame {
    long[] time;
    int[] desordenado = new int[dados.size()];
    static ArrayList<Integer> ordenado = new ArrayList();
  
    /**
     * Creates new form ResultadoOrdenacao
     */
    public ResultadoOrdenacao() {
        this.time = new long[selecionados.size()];
        initComponents();
        this.setVisible(true);
        setLocationRelativeTo( null );
        
        lbl_QtdNumeros.setText(Integer.toString(dados.size()));
        
        Ordenacao ordenar = new Ordenacao();
        
        
        if (insercao==true)
        {
            resetaVetorDesordenado();
            time[0]=ordenar.insertionSort(desordenado);
       
        }
        if (selecao==true)
        {
            resetaVetorDesordenado();
            for(int i = 0;i<=5;i++)
            {
                if(time[i]==0)
                {
                    time[i]=ordenar.selectionSort(desordenado);
                    break;
                }
            }
        }
        if (bubblesort==true)
        {
            resetaVetorDesordenado();
            for(int i = 0;i<=5;i++)
            {
                if(time[i]==0)
                {
                    time[i]=ordenar.bubbleSort(desordenado);
                    break;
                }
            }
        }   
        if (quicksort==true)
        {
            resetaVetorDesordenado();
                        for(int i = 0;i<=5;i++)
            {
                if(time[i]==0)
                {
                    time[i]=ordenar.quickSort(desordenado);
                    break;
                }
            }
        }
        if (mergesort==true)
        {
            resetaVetorDesordenado();
            for(int i = 0;i<=5;i++)
            {
                if(time[i]==0)
                {
                    time[i]=ordenar.mergeSort(desordenado);
                    break;
                }
                
            }
            desordenado=ordenar.mergeSorting(desordenado);
        }
        if (heapsort==true)
        {
            resetaVetorDesordenado();
                        for(int i = 0;i<=5;i++)
            {
                if(time[i]==0)
                {
                    time[i]=ordenar.heapSort(desordenado);
                    break;
                }
            }
        }
   
        
        
        
        
        switch (selecionados.size())
        {  
          case 1:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
                
            break;
          case 2:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
              setarResultados(lbl_Resultado2,lbl_Tempo2,1);
            break;
          case 3:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
              setarResultados(lbl_Resultado2,lbl_Tempo2,1);
              setarResultados(lbl_Resultado3,lbl_Tempo3,2);
            break;
          case 4:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
              setarResultados(lbl_Resultado2,lbl_Tempo2,1);
              setarResultados(lbl_Resultado3,lbl_Tempo3,2);
              setarResultados(lbl_Resultado4,lbl_Tempo4,3);
            break;
          case 5:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
              setarResultados(lbl_Resultado2,lbl_Tempo2,1);
              setarResultados(lbl_Resultado3,lbl_Tempo3,2);
              setarResultados(lbl_Resultado4,lbl_Tempo4,3);
              setarResultados(lbl_Resultado5,lbl_Tempo5,4);
            break;
          case 6:
              setarResultados(lbl_Resultado1,lbl_Tempo1,0);
              setarResultados(lbl_Resultado2,lbl_Tempo2,1);
              setarResultados(lbl_Resultado3,lbl_Tempo3,2);
              setarResultados(lbl_Resultado4,lbl_Tempo4,3);
              setarResultados(lbl_Resultado5,lbl_Tempo5,4);
              setarResultados(lbl_Resultado5,lbl_Tempo5,5);
            break;
        }
        
        
        
        compararResultado(time);
        
             
        
    }
    private void resetaVetorDesordenado()
    {
        for(int i = 0;i<=dados.size()-1;i++)
        {
            desordenado[i]=dados.get(i);
        }
    }
    private void transfereValor()
    {
        for(int i = 0;i<=desordenado.length-1;i++)
        {
            ordenado.add(desordenado[i]);
        }
    }
    private void compararResultado(long[] time)
    {
        int maior= (int) time[0];
        int menor=(int) time[0];
        int indiceMaior = 0;
        int indiceMenor = 0;
        //Encontra o maior valor
        for(int i=1;i<=time.length-1;i++)
        {
            if(time[i]> maior)
            {
                maior = (int) time[i];
                indiceMaior=i;
            }   
        }
        for(int i=1;i<=time.length-1;i++)
        {
            if(time[i]< menor)
            {
                
                menor = (int) time[i];
                indiceMenor=i;
            }   
        }
        System.out.println("INDICE MENOR :"+indiceMenor);
        System.out.println("MENOR TEMPO :"+time[indiceMenor]);
        System.out.println("INDICE MAIOR :"+indiceMaior);
        System.out.println("MAIOR TEMPO :"+time[indiceMaior]);
        System.out.println("SELECIONADO SIZE :"+selecionados.size());
        
        System.out.println("TIME :");
        System.out.println(Arrays.toString(time));
        System.out.println("SELECIONADOS :");
        System.out.println(selecionados);
        
        lbl_Rapido.setText(selecionados.get(indiceMenor));
        lbl_Lento.setText(selecionados.get(indiceMaior));
        
    }
    
    
    private void setarResultados(JLabel resultado, JLabel tempo,int posicao)
    {
        resultado.setText(selecionados.get(posicao));
        tempo.setText(Long.toString(time[posicao])+" ms");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        lbl_Resultado1 = new javax.swing.JLabel();
        lbl_Resultado2 = new javax.swing.JLabel();
        lbl_Resultado3 = new javax.swing.JLabel();
        lbl_Resultado4 = new javax.swing.JLabel();
        lbl_Resultado5 = new javax.swing.JLabel();
        lbl_Resultado6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_Tempo1 = new javax.swing.JLabel();
        lbl_Tempo2 = new javax.swing.JLabel();
        lbl_Tempo3 = new javax.swing.JLabel();
        lbl_Tempo4 = new javax.swing.JLabel();
        lbl_Tempo5 = new javax.swing.JLabel();
        lbl_Tempo6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_Rapido = new javax.swing.JLabel();
        lbl_Lento = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        lbl_QtdNumeros = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESULTADO ORDENAÇÃO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setText("MÉTODO DE ORDENAÇÃO :");

        jLabel8.setText("TEMPO :");

        jLabel15.setText("QUANTIDADE DE DADOS ORDENADOS :");

        jLabel17.setText("MÉTODO MAIS RAPIDO :");

        jLabel18.setText("MÉTODO MAIS LENTO :");

        lbl_Rapido.setText("jLabel19");

        lbl_Lento.setText("jLabel20");

        jButton7.setText("LISTA ORDENADA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lbl_QtdNumeros.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Tempo1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Tempo2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Tempo3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_Tempo4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_Tempo5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Resultado6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_Tempo6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_QtdNumeros))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_Rapido))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_Lento))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton7)))
                .addGap(261, 261, 261))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_Tempo1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lbl_Resultado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Resultado2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Tempo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Tempo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_Resultado3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Tempo4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Resultado4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Resultado5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Tempo5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_Tempo6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lbl_Resultado6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbl_QtdNumeros))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lbl_Rapido))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(lbl_Lento))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        transfereValor();
        new ResultadoLista();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResultadoOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultadoOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultadoOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultadoOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultadoOrdenacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbl_Lento;
    private javax.swing.JLabel lbl_QtdNumeros;
    private javax.swing.JLabel lbl_Rapido;
    private javax.swing.JLabel lbl_Resultado1;
    private javax.swing.JLabel lbl_Resultado2;
    private javax.swing.JLabel lbl_Resultado3;
    private javax.swing.JLabel lbl_Resultado4;
    private javax.swing.JLabel lbl_Resultado5;
    private javax.swing.JLabel lbl_Resultado6;
    private javax.swing.JLabel lbl_Tempo1;
    private javax.swing.JLabel lbl_Tempo2;
    private javax.swing.JLabel lbl_Tempo3;
    private javax.swing.JLabel lbl_Tempo4;
    private javax.swing.JLabel lbl_Tempo5;
    private javax.swing.JLabel lbl_Tempo6;
    // End of variables declaration//GEN-END:variables
}
