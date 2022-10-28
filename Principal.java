import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("BIENVENIDO A VEHICULOS Y SENSORES");
        System.out.println("*****MENU*****");
        String menu = ("*******INGRESE UN NUMERO******* \n"
            + "0: Salir del programa\n"
            + "1: Ingresar un vehiculo nuevo \n"
            + "2: Obtener la información de los vehiculos \n"    
            + "3: Cantidad de vehiculos \n"
            + "4: Vehiculos verdes \n"
            + "5: Obtener la informacion de los vehiculos de modelo entre 2000-2021 \n"
            + "6: Ingresar un sensor nuevo \n"
            + "7: Obtener la información de los sensores \n"
            + "8: Cantidad de sensores \n"
            + "9: Obtener sensores de tipo temperatura \n"
            + "10: Obtener la informacion de todos los sensores del tipo que ingrese \n"
            + "11: Cantidad total de sensores segun el tipo que ingrese \n"
            + "12: Sensores del tipo que ingrese ordenados de manera ascendente \n"
            + "13: Abrir menu \n"
            + "666: Sensores de tipo temperatura ordenados de manera ascendente \n");      

        System.out.println(menu);

        while(true){
            int num = in.nextInt();

            switch (num) {
                case 1: 
                    if(Vehiculo.posAnadir < 10){
                        System.out.println("Ingrese el modelo del vehiculo: ");
                        int modelo = in.nextInt(); 
                        System.out.println("Ingrese el marca del vehiculo: ");    
                        String marca = in.next(); 
                        System.out.println("Ingrese el valor comercial del vehiculo: ");    
                        double valorComercial = in.nextDouble(); 
                        System.out.println("Ingrese el color del vehiculo: ");    
                        String color = in.next();
                        Vehiculo vehiculo = new Vehiculo(modelo, marca, valorComercial, color);
                        vehiculo.anadirVehiculo(vehiculo);
                    }else{
                        System.out.println("Error base de datos llena");
                    }
                    break;
                case 2:
                    System.out.println("*****VEHICULOS ALMACENADOS*****");
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println("*****CANTIDAD TOTAL DE VEHICULOS*****");
                    System.out.println(Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    System.out.println("*****VEHICULOS DE COLOR VERDE*****");
                    System.out.println(Vehiculo.toStringVehiculos("verde"));
                    break;
                case 5:
                    System.out.println("*****VEHICULOS MODELOS ENTRE 2000-2021*****");
                    System.out.println(Vehiculo.toStringVehiculosModelo(2000, 2021));
                    break;
                case 6:
                    if(Sensor.posAnadir < 8){
                        System.out.println("Ingrese el tipo del sensor: ");    
                        String tipo = in.next(); 
                        System.out.println("Ingrese el valor del sensor: ");    
                        double valor = in.nextDouble();
                        Sensor sensor = new Sensor(tipo, valor);
                        Sensor.anadirVehiculo(sensor);
                    }else{
                        System.out.println("Error base de datos llena");
                    }
                    break;
                case 7:
                    System.out.println("*****SENSORES ALAMACENADOS*****");
                    System.out.println(Sensor.toStringSensor());
                    break;
                case 8:
                    System.out.println("*****CANTIDAD TOTAL DE SENSORES*****");
                    System.out.println(Sensor.cantidadSensores());
                    break;
                case 9:
                    System.out.println("*****SENSORES DE TIPO TEMPERATURA*****");
                    Sensor senTipo[] = Sensor.sensoresTipo("temperatura");
                    System.out.println(Sensor.toStringArray(senTipo));
                    break;
                case 10:
                    System.out.println("Ingrese el tipo de sensor: ");
                    String tipo = in.next(); 
                    String tipoM = tipo.toUpperCase();
                    Sensor senTipoIngresado[] = Sensor.sensoresTipo(tipo);
                    System.out.println("*****SENSORES DE TIPO " + tipoM + "*****");
                    System.out.println(Sensor.toStringArray(senTipoIngresado));
                    break;
                case 11:
                    String tipoCantidad = in.next(); 
                    String tipoCantidadM = tipoCantidad.toUpperCase();
                    System.out.println("*****CANTIDAD TOTAL DE SENSORES " + tipoCantidadM + "*****");
                    System.out.println(Sensor.cantidadTipo(tipoCantidad));
                    break;
                case 12:
                    System.out.println("Ingrese el tipo de sensor: ");
                    String tipoAscendente = in.next(); 
                    String tipoAscendenteM = tipoAscendente.toUpperCase();
                    Sensor senOrdenadTipo[] = Sensor.sensoresOrdenados("temperatura");
                    System.out.println("*****SENSORES ORDENADO DE FORMA ASCENDENTE DE TIPO " + tipoAscendenteM + "*****");
                    System.out.println(Sensor.toStringArray(senOrdenadTipo));
                    break;
                case 13:
                    System.out.println("*****MENU*****");
                    System.out.println(menu);
                    break;
                case 666:
                    Sensor senOrdenado[] = Sensor.sensoresOrdenados("temperatura");
                    System.out.println("*****SENSORES ORDENADO DE FORMA ASCENDENTE DE TIPO TEMEPERATURA*****");
                    System.out.println(Sensor.toStringArray(senOrdenado));
                    break;
                default:
                    System.out.println("Numero no valido");
                }
                
            if(num == 0){
                break;
            }
        }
    }
}