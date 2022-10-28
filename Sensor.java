public class Sensor {
    static int tamano = 8;
    static Sensor sensores[] = new Sensor[tamano];
    static int posAnadir = 0;
    private String tipo;
    private double valor;

    public Sensor(){

    }

    public Sensor(String tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public String toString(){
        String informacion = "Tipo: " + this.tipo + " Valor: " + this.valor;
        return informacion;
    }

    //Agregar Sensores
    public static void anadirVehiculo(Sensor sen){
        sensores[posAnadir] = sen;
        posAnadir ++;
    }

    public static int cantidadSensores(){
        return posAnadir;
    }

    public static String toStringSensor(){
        String senConcatenado = "";
        for(int i = 0; i < posAnadir; i++){
            senConcatenado += sensores[i].toString() + "\n";
        }
        return senConcatenado;
    }

    //Cantidad sensores por tipo
    public static int cantidadTipo(String tipo){
        int size = 0;

        for(int i = 0; i < posAnadir; i++){
            if((sensores[i].getTipo()).equals(tipo)){
                size++;
            }
        }        
        return size;
    }

    //Sensores por tipo
    public static Sensor[] sensoresTipo(String tipo){
        int size = cantidadTipo(tipo);
        Sensor senTipo[] = new Sensor[size];
        int posicion = 0;

        for(int i = 0; i < posAnadir; i++){
            if(sensores[i].getTipo().equals(tipo)){
                senTipo[posicion] = sensores[i];
                posicion++;
            }
        }
        return senTipo;
    }

    //Sensores ordenados por tipo
    public static Sensor[] sensoresOrdenados(String tipo){
        int size = cantidadTipo(tipo);
        Sensor[] sen = sensoresTipo(tipo);
        Sensor aux;

        for (int i = 0; i < size-1; i++){ //Cuantas vueltas tiene que dar
            for (int j = 0; j < size-1; j++){ //Ordenar, cambia las posiciones
                if(sen[j].getValor() > sen[j+1].getValor()){ // Si numeroActual > numeroSiguiente
                    aux = sen[j]; //num actual
                    sen[j] = sensores[j+1]; // num del siguiente
                    sen[j+1] = aux;
                }
            }
        }

        return sen;
    }

    //Metodo para obtener datos de cualquier lista 
    public static String toStringArray(Sensor sen[]){
        String senConcatenado = "";
        for(int i = 0; i < sen.length; i++){
            senConcatenado += sen[i].toString() + "\n";
        }
        return senConcatenado;
    }
} 
  