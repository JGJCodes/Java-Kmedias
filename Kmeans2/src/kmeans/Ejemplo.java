/*
 * Clase que representa un ejemplo o vector
 * con dos cordenadas y una clase o grupo
 */
package kmeans;

/**
 *
 * @author george
 */
public class Ejemplo {
    
    private float X;//Representa la coordenada del eje horizontal 
    private float Y;//Representa la coordenada del eje vertical
    private int C;//Representa la clase o grupo del punto 
    
    /*
    * El metodo constructor inicializa los datos de un punto
    */
    public Ejemplo(float x, float y){
        X = x;
        Y = y;
        C = 0;
    }
    
    /*
    * Son los metodos para asignarles un valor a los
    *atributos de los objetos
    */
    public void posX(float x){
        X = x;
    }
    public void posY(float y){
        Y = y;
    }
    public void posC(int c){
        C = c;
    }
    
    /*
    * Son los metodos para acceder a los valores 
    * de los atributos
    */
    public float getX(){
        return X;
    }
    public float getY(){
        return Y;
    }
    public int getC(){
        return C;
    }
    
}
