/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDREZ
 */
public class CaminitooosCortos {
    
    public String metodoUnoMatrices(long [][] datos){
    int vertices=datos.length;
    long matrizDeDatosA [][]=datos;
    String caminos [][]=new String [vertices][vertices];//KAMINOS KORREKTOS
    String otrosCaminos [][]=new String [vertices][vertices];
    String segmentoVisitado ="",segmento="", camino= "";
    int i,j,k;
    float x1,x2,x3,x4,y1;
    //INICIALIZAR LAS MATRICES
    for (i=0;i<vertices;i++){
        for(j=0;j<vertices;j++){
            caminos[i][j]="";
            otrosCaminos[i][j]="";
        
        }
    }
    for(k=0;k<vertices;k++){
        for(i=0;i<vertices;i++){
            for(j=0;j<vertices;j++){
                x1 = matrizDeDatosA[i][j];
                x2 = matrizDeDatosA[i][k];
                x3 = matrizDeDatosA[k][j];
                x4 = x2+x3;
                //ENCONTRAR AL CAMINO MINIMO
                y1 = Math.min(x1,x4);
                if(x1!=x4){
                    if(y1==x4){
                        segmentoVisitado="";
                        otrosCaminos[i][j]=k+"";
                           caminos[i][j]=caminosR(i,k,otrosCaminos,segmentoVisitado)+(k+1);
                          }
                     }
                matrizDeDatosA[i][j]=(long) y1;
                 }
             }
          }
    //KAMINO MINIMOOOOOOOOO
    for (i=0;i<vertices;i++){
        for(j=0;j<vertices;j++){
            segmento=segmento+"["+matrizDeDatosA[i][j]+"]";
        }
        segmento=segmento + "\n";
    }
    ////////////////////////////////
    for(i=0;i<vertices;i++){
        for(j=0;j<vertices;j++){
            if(matrizDeDatosA[i][j]!=1000000000){
                if (i!=j){
                    if(caminos[i][j].equals("")){
                        camino +="DE ("+(i+1)+"---->"+(j+1)+")TOME EL CAMINO: ("+(i+1)+","+(j+1)+")\n";    
                    }else{
                        camino+="DE ("+(i+1)+"---->"+(j+1)+")TOME EL CAMINO: ("+(i+1)+","+caminos[i][j]+","+(j+1)+")\n";
                    }
                }
            }
        }
    }
    return "UNA MATRIZ DE EXTENSION ADECUADA PARA TU GRAFO ES: \n"+segmento+
            "\n TAMBIEN PUEDE USAR LOS SIGIENTES GRAFOS:\n "+camino;
    }
    public String caminosR(int i, int k, String[][] otrosCaminos, String segmentoVisitado){
        if(otrosCaminos[i][k].equals("")){
            return "";
        }else{
          //METODO REKURSIVO
        segmentoVisitado += caminosR(i,Integer.parseInt(otrosCaminos[i][k].toString()),
                otrosCaminos,
                segmentoVisitado)+(Integer.parseInt(otrosCaminos[i][k].toString())+1)+",";
       return segmentoVisitado;
        } 
    }
}
