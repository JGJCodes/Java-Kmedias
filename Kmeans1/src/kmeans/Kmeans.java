/*
 * Clase que implememnta el clasificador K-Medias 
 * con una estructura basada en objetos
 */
package kmeans;

import java.util.ArrayList;

/**
 *
 * @author george
 */
public class Kmeans {
    private final int K; //Representa el numero total de grupos
    public Ejemplo []Ejemplos; //Representa el conjunto de puntos a clasificar
    public Ejemplo []Centroides; //Representa los centroides de los grupos
    
    //Metodo constructor que inicializa el objeto Kmeans
    public Kmeans(int k, Ejemplo []puntos){
        K = k;
        Centroides = new Ejemplo[k];
        Ejemplos = new Ejemplo[puntos.length];
        Ejemplos = puntos;
    }
    
    //Metodo que ejecuta el algoritmo del clasificador K-medias
    public int Algoritmo(char distancia){
        int iteraciones=0;
        Ejemplo[] centInicio;
        do{
            centInicio = Centroides;
            Centroides = CalcularCentroides(iteraciones);
            for(int i=0;i<Ejemplos.length;i++){
                ClasificarEjemplo(i, distancia);
            }
            iteraciones+=1;
            centInicio = Centroides;
            Centroides = CalcularCentroides(iteraciones);
        }while(Centroides.equals(centInicio));
        return iteraciones;
    }
    
    //Metodo que calcula los centroides de los grupos
    public Ejemplo[] CalcularCentroides(int iteraciones){
        Ejemplo centroides[] = new Ejemplo[K];
        if(iteraciones==0){//Cuando los centroides se eligen al azar
            int pos;
            ArrayList <Integer> numAleatorios = new ArrayList<Integer>();;
            for(int i=0;i<K;i++){
                pos = (int) Math.floor(Math.random()*Ejemplos.length);
                while(numAleatorios.contains(pos)) {
                    pos = (int) Math.floor(Math.random()*Ejemplos.length);
                }
                numAleatorios.add(pos);
            }
            for(int j=0;j<=K-1;j++){
                centroides[j]=Ejemplos[numAleatorios.get(j)];
                centroides[j].posC(j+1);
            }
        }else{//Calcular centroides con la media aritmetica
            for(int i=1;i<=K;i++){
                float centX = 0, centY = 0; int numPuntos = 0;
                for(int j=0;j<Ejemplos.length;j++){
                    if(Ejemplos[j].getC()==i){
                        centX += Ejemplos[j].getX();
                        centY += Ejemplos[j].getY();
                        numPuntos++;
                    }
                }
                centX = centX/numPuntos; 
                centY = centY/numPuntos;
                centroides[i-1] = new Ejemplo(centX,centY);
                centroides[i-1].posC(i);
            }
        }
        return centroides;
    }
    
    //Metodo que claficia un punto con respecto a sus distancias con los centroides de los grupos
    public void ClasificarEjemplo(int numEjemplo,char distancia){
        float []distancias = CalcularDistancias(distancia,numEjemplo);
        int grupo = 0;
        for(int i=0;i<K;i++){
            if(distancias[grupo] > distancias[i])
                grupo = i;
        }
        Ejemplos[numEjemplo].posC(grupo+1); 
    }
    
    //Metodo que calcula las distancias de un punto entre los centroides 
    public float[] CalcularDistancias(char tipo, int numEjemplo){
        float []distancias = new float[K]; 
        for(int i=0;i<=K-1;i++){
            switch(tipo){//Permite seleccionar que tipo de distancia calcular
                case 'c':distancias[i] = DistanciaCuadrada(Ejemplos[numEjemplo], Centroides[i]);break;
                case 'e':distancias[i] = DistanciaEuclidiana(Ejemplos[numEjemplo], Centroides[i]);break;
                case 'm':distancias[i] = DistanciaManhattan(Ejemplos[numEjemplo], Centroides[i]);break;
            }
        }
        return distancias;
    }
    
    //Metodo que calcula la distancia cuadrada entre dos puntos
    public float DistanciaCuadrada(Ejemplo x1, Ejemplo x2){
        return (float) (Math.pow((x1.getX()-x2.getX()),2) + Math.pow((x1.getY()-x2.getY()),2));
    }
    
    //Metodo que calcula la distancia euclidiana entre dos puntos
    public float DistanciaEuclidiana(Ejemplo x1, Ejemplo x2){
        return (float) (Math.sqrt(Math.pow((x1.getX()-x2.getX()),2) + Math.pow((x1.getY()-x2.getY()),2)));
    }
    
    //Metodo que calcula la distancia manhattan entre dos puntos
    public float DistanciaManhattan(Ejemplo x1, Ejemplo x2){
        return (float) ((Math.abs(x2.getX()-x1.getX())) + (Math.abs(x2.getY()-x1.getY())));
    }
}
