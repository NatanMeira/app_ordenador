/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author natan
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Arquivo {
    public static boolean pulaLinha=false;
    public ArrayList lerArquivo(String caminho,ArrayList dados)
        {
            
            File arquivo = new File(caminho);
            String texto = null;
            
            
            try (BufferedReader bufferreader = new BufferedReader(new FileReader(arquivo)))
            {
                while (bufferreader.ready())
                {
                    texto = bufferreader.readLine();
                    
                    
                }   
                
                StringTokenizer token = new StringTokenizer(texto, ";");
                
              
                while (token.hasMoreTokens()) {
                    //importando dados de externa
                    dados.add(Integer.parseInt(token.nextToken()));
                    
                }

            } 
            catch (FileNotFoundException ex) 
            {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null, "Não faço a minima ideia do que esta acontecendo IOException!");
            }

           
            return dados;
        }
    
    public void gravarArquivo(String endereco, ArrayList dados,String nome)
    {
        File arquivo = new File(endereco+nome);
       
        
                
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(endereco+nome));)
            {if (!arquivo.exists()) 
                {
                    arquivo.createNewFile();
                }
                
                for (int counter = 0; counter < dados.size(); counter++) 
                {
                    bw.write(dados.get(counter)+";");
                    if(pulaLinha==true)
                    {
                        bw.newLine();
                    }
                       
                }
                bw.close();
            }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel criar o arquivo");
            System.out.println(ex.getMessage());
        }

    }
    


}
