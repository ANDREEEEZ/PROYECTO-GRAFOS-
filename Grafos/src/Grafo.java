/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADREEEEEZ
 */
import java.util.Scanner;
public class Grafo {
    public static void main(String[] args) {
      Scanner leer = new Scanner(System.in);
      System.out.println("INGRESE EL NUMERO DE VERTICES");
      int x = leer.nextInt();
      long matrisA [][] = new long [x][x];
      
      //LLENADO DE MATRIS
      for (int i = 0;i<matrisA.length;i++){
          for(int j =0; j < matrisA.length;j++){
              System.out.println("INGRESE EL VALOR DEL TRABAJO DESDE EL VERTICE : "+(i+1)+"AL BERTISE: "+(j+1));
              System.out.println("SI NO EXISTE CAMINO POR FAVOR INGRESE 9999999999");
               if (i==j){
              matrisA[i][j]=0;
              }
                int w = leer.nextInt();
              
                matrisA[i][j]=w;
          }
      }
      long grafoM [][]=matrisA;
      CaminitooosCortos rutas = new CaminitooosCortos();
      System.out.println(rutas.metodoUnoMatrices(matrisA));
    }
    
}
