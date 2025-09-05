import java.util.ArrayList;
import java.util.Scanner;

abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(String marca, String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public void mostrarInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
    }

    public abstract int calcularPrecioAlquiler(int dias);

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }        
}

class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String marca, String modelo, int anio, int numPuertas){
        super(marca, modelo, anio);
        this.numPuertas = numPuertas;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Número de puertas: " + numPuertas);
    }

    @Override
    public int calcularPrecioAlquiler(int dias){
        int costobasedia = 300;
        return dias * costobasedia; 
    }

    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }    
}

class Motocicleta extends Vehiculo {
    private double cilindrada;

    public Motocicleta(String marca, String modelo, int anio, double cilindrada){
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }

    @Override
    public int calcularPrecioAlquiler(int dias){
        int costobasedia = 150;
        return dias * costobasedia; 
    }

    public double getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }    
}

class Camion extends Vehiculo {
    private int capacidadCarga;

    public Camion(String marca, String modelo, int anio, int capacidadCarga){
        super(marca, modelo, anio);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Capacidad de carga: " + capacidadCarga + " kg");
    }

    @Override
    public int calcularPrecioAlquiler(int dias){
        int costobasedia = 500;
        return dias * costobasedia + capacidadCarga * 10; 
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }    
}   

public class RentVehicles {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("\nSeleccione una opción: ");
            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    mostrarInfoVehiculo();
                    break;
                case 3:
                    calcularPrecioAlquiler();
                    break;
                case 4:
                    System.out.println("\nSaliendo del programa. ¡Hasta luego!\n");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.\n");
            }
            System.out.println();
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("=== Menú de Vehículos ===");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Mostrar información de un vehículo");
        System.out.println("3. Calcular precio de alquiler");
        System.out.println("4. Salir");
    }

    private static void registrarVehiculo() {
        System.out.println("Seleccione el tipo de vehículo a registrar:");
        System.out.println("1. Auto");
        System.out.println("2. Camión");
        System.out.println("3. Motocicleta");
        int tipo = leerEntero("\nOpción: ");

        String marca = leerCadena("Ingrese la marca: ");
        String modelo = leerCadena("Ingrese el modelo: ");
        int anio = leerEntero("Ingrese el año: ");

        switch (tipo) {
            case 1:
                int numPuertas = leerEntero("Ingrese el número de puertas: ");
                Auto auto = new Auto(marca, modelo, anio, numPuertas);
                vehiculos.add(auto);
                System.out.println("Auto registrado correctamente.");
                break;
            case 2:
                int capacidadCarga = leerEntero("Ingrese la capacidad de carga (kg): ");
                Camion camion = new Camion(marca, modelo, anio, capacidadCarga);
                vehiculos.add(camion);
                System.out.println("Camión registrado correctamente.");
                break;
            case 3:
                double cilindrada = leerDouble("Ingrese la cilindrada (cc): ");
                Motocicleta moto = new Motocicleta(marca, modelo, anio, cilindrada);
                vehiculos.add(moto);
                System.out.println("Motocicleta registrada correctamente.");
                break;
            default:
                System.out.println("Tipo de vehículo inválido.");
        }
    }

    private static void mostrarInfoVehiculo() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        mostrarListaVehiculos();
        int indice = leerEntero("\nSeleccione el número del vehículo para mostrar su información: ") - 1;
        if (indice >= 0 && indice < vehiculos.size()) {
            System.out.println("Información del vehículo:");
            vehiculos.get(indice).mostrarInfo();
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void calcularPrecioAlquiler() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        mostrarListaVehiculos();
        int indice = leerEntero("Seleccione el número del vehículo para calcular el precio de alquiler: ") - 1;
        if (indice >= 0 && indice < vehiculos.size()) {
            int dias = leerEntero("Ingrese el número de días para el alquiler: ");
            if (dias <= 0) {
                System.out.println("El número de días debe ser mayor que cero.");
                return;
            }
            int precio = vehiculos.get(indice).calcularPrecioAlquiler(dias);
            System.out.println("El precio del alquiler es: $" + precio);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void mostrarListaVehiculos() {
        System.out.println("Vehículos registrados:");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            System.out.printf("%d. %s %s (%d)%n", i + 1, v.getMarca(), v.getModelo(), v.getAnio());
        }
    }

    private static int leerEntero(String mensaje) {
        int num;
        while (true) {
            System.out.print(mensaje);
            try {
                num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        double num;
        while (true) {
            System.out.print(mensaje);
            try {
                num = Double.parseDouble(scanner.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número decimal válido.");
            }
        }
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
