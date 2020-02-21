/*
 * Implementación del clasificador K-medias
 */
package kmeans;


/**
 *
 * @author george
 */
public class Main {
    
   //Metodo principal de la clase
    public static void main(String[] args) {
        Main.Menu();
    }
    
    //Metodo que presenta un menu de opciones para el usuario
    public static void Menu(){
        short opcion = 0;
          while(opcion!=2){
               System.out.println("***********************");
               System.out.println("*CLASIFICADOR K-MEDIAS*");
               System.out.println("***********************");
               System.out.println("*Opciones**************");
               System.out.println("*1.-Clasificar puntos**");
               System.out.println("*2.-Salir**************");
               System.out.println("***Elige una opción****");
               opcion = Leer.datoShort();
               switch(opcion){
                    case 1:Main.ClasificarPuntos(); opcion = 2;
                    case 2:System.out.println("***Fin del programa****"); break;
                    default:System.out.println("Opcion incorrecta... pulse <enter> para continuar"); Leer.dato();
               }
          }
    }
    
    //Metodo que ejecuta el algoritmo del clasificador
    public static void ClasificarPuntos(){
        System.out.println("***********************");
        System.out.println("***CLASIFICAR PUNTOS***");
        System.out.println("***********************");
        Ejemplo puntos[] = Main.CapturarPuntos();
        System.out.println("***********************");
        System.out.print("Núm. de grupos a clasificar:");
        int k = Leer.datoInt();
        while(k<=1 || k>=puntos.length){
            System.out.print("¡Error! Intente con otro número:");
            k = Leer.datoInt();
        }
        char distancia = 'm';//Main.ElegirDistancia();
        System.out.println("***********************");
        Kmeans resultados = new Kmeans(k,puntos);
        int iteraciones = resultados.Algoritmo(distancia);
        Main.ImprimirResultados(resultados, iteraciones);
    }
    
    //Metodo que captura los puntos a clasificar
    public static Ejemplo[] CapturarPuntos(){
        System.out.print("Núm. total de puntos:");
        int n = Leer.datoInt();
        while(n<=2){
            System.out.print("¡Error! Intente con otro número:");
            n = Leer.datoInt();
        }
        System.out.println("***********************");
        System.out.println("Ingresar los puntos(x,y)");
        System.out.println("***********************");
        Ejemplo puntos[]= new Ejemplo[n];
        float X[]= new float[n]; 
        float Y[] = new float[n];
        for(int i=0;i<=n-1;i++){
            float x,y;
            boolean repetido = false;
            do{ 
                if(repetido==true)
                    repetido =false;
                System.out.print("Ingresar x del punto " + (i+1) + ":");
                x = Leer.datoFloat();
                System.out.print("Ingresar y del punto " + (i+1) + ":");
                y = Leer.datoFloat();
                for(int j=0;j<X.length;j++){
                    if(X[j]==x && Y[j]==y)
                        repetido = true;
                }   
                if(repetido==true)
                    System.out.println("¡Error! punto repetido");
            }while(repetido!=false);
            X[i]=x; Y[i]=y;
            puntos[i] = new Ejemplo(x,y);
        }
        return puntos;
    }
    
    //Metodo que permite seleccionar el tipo de distancia a calcular
    public static char ElegirDistancia(){
        System.out.println("***********************");
        System.out.println("Elegir tipo distancia:");
        System.out.println("***********************");
        System.out.println("*1.-Cuadrada***********");
        System.out.println("*2.-Euclidiana*********");
        System.out.println("*3.-Manhattan**********");
        System.out.println("***Elige una opción****");
        char distancia = ' ';
        while(distancia!='c' && distancia!='e' && distancia!='m'){
            distancia = Leer.datoChar();
            switch(distancia){
                case '1': distancia = 'c';break;
                case '2': distancia = 'e';break;
                case '3': distancia = 'm';break;
            }
            if(distancia!='c' && distancia!='e' && distancia!='m')
                System.out.println("Opcion incorrecta... intentelo de nuevo");
        }
        return distancia;
    }
     
    //Metodo que imprime en pantalla los resultados del algoritmo
    public static void ImprimirResultados(Kmeans resultados, int iteraciones){
        System.out.println("***********************");
        System.out.println("*******Resultados******");
        System.out.println("***********************");
        System.out.println("****Iteracion "+ (iteraciones+1) +"******");
        System.out.println("*Puntos clasificados***");
        System.out.println("X\tY\tGrupo");
        for (Ejemplo Ejemplo : resultados.Ejemplos) {
            System.out.println(Ejemplo.getX() + "\t" + Ejemplo.getY() + "\t" + Ejemplo.getC());
        }
        System.out.println("***********************");
        System.out.println("*Centroides************");
        System.out.println("X\tY\tGrupo");
        for (Ejemplo Centroide : resultados.Centroides) {
            System.out.println(Centroide.getX() + "\t" + Centroide.getY() + "\t" + Centroide.getC());
        }
        System.out.println("***********************");
      /*System.out.println("*Numero de iteraciones realizadas:" + (iteraciones+1));
        System.out.println("***********************");*/
    }

}
