import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Cuentas{
    public static class CuentasBancarias implements Serializable{
        public static double TasaInteres = 0.10;
        private static int TotalCuentas = 0;
        private static double TotalDinero = 0;
        private int Nip;
        private String NombredelaCuenta;
        private double Saldo;

        public CuentasBancarias(String NewNombredelaCuenta, int NewNip, double NewSaldo){
            TotalCuentas++;
            this.NombredelaCuenta = NewNombredelaCuenta;
            this.Nip = NewNip;
            this.Saldo = NewSaldo;
            TotalDinero += Saldo;
        }

        public String getNombredelaCuenta() {
            return NombredelaCuenta;
        }

        public int getNipCuenta() {
            return Nip;
        }

        public void infoNombredelaCuenta(){
            System.out.println("Nombre de la cuenta: " + NombredelaCuenta);
            System.out.println("Nip de la cuenta: " + Nip);
            System.out.println("Saldo de la cuenta: " + Saldo);
        }

        public void Depositar(double cantidad){
            if(cantidad > 0){
                Saldo += cantidad;
                TotalDinero += cantidad;
            }
        }

        public void Retirar(double cantidad){
            if(cantidad > 0 && cantidad <= Saldo){
                Saldo -= cantidad;
                TotalDinero -= cantidad;
            }
        }

        public void CalcularInteres(){
            double interes = Saldo * TasaInteres;
            Saldo += interes;
            TotalDinero += interes;
            System.out.println("Interes calculado y agregado. Nuevo saldo: " + Saldo);
        }

        public static int getTotalCuentas() {
            return TotalCuentas;
        }

        public static double getTotalDinero() {
            return TotalDinero;
        }

        public double getSaldo() {
            return Saldo;
        }

        public static void setTasaInteres(double nuevaTasa) {
            if(nuevaTasa >= 0){
                TasaInteres = nuevaTasa;
            }
        }

        public static double getTasaInteres() {
            return TasaInteres;
        }
        
    }
}

public class Bank {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean cycle = true;
        ArrayList<Cuentas.CuentasBancarias> cuentas = new ArrayList<>();
        int opc = 1;
        int cont;
        double saldo;

        while(cycle){
            System.out.println("1. Crear cuenta");
            System.out.println("2. Mostrar cuentas");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Calcular interes");
            System.out.println("6. Mostrar tasa de interes");
            System.out.println("7. Cambiar tasa de interes");
            System.out.println("8. Mostrar total de cuentas y dinero en el banco");
            System.out.println("9.Resetear banco (eliminar todas las cuentas)");
            System.out.println("0. Salir");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.print("Ingrese el nombre de la cuenta: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese el nip de la cuenta: ");
                    int nip = sc.nextInt();
                    System.out.print("Ingrese el saldo inicial: ");
                    saldo = sc.nextDouble();
                    cuentas.add(new Cuentas.CuentasBancarias(nombre, nip, saldo));
                    break;
                case 2:
                    cont = 1;
                    for(Cuentas.CuentasBancarias cuenta : cuentas){
                        System.out.println("Cuenta " + cont + ":");
                        cuenta.infoNombredelaCuenta();
                        cont++;
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el numero de cuenta para depositar: ");
                    int numCuentaDep = sc.nextInt();
                    if(numCuentaDep > 0 && numCuentaDep <= cuentas.size()){
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDep = sc.nextDouble();
                        ((Cuentas.CuentasBancarias)cuentas.get(numCuentaDep - 1)).Depositar(cantidadDep);
                    } else {
                        System.out.println("Numero de cuenta invalido.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el numero de cuenta para retirar: ");
                    int numCuentaRet = sc.nextInt();
                    if(numCuentaRet > 0 && numCuentaRet <= cuentas.size()){
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRet = sc.nextDouble();
                        ((Cuentas.CuentasBancarias)cuentas.get(numCuentaRet - 1)).Retirar(cantidadRet);
                    } else {
                        System.out.println("Numero de cuenta invalido.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el numero de cuenta para calcular interes: ");
                    int numCuentaInt = sc.nextInt();
                    if(numCuentaInt > 0 && numCuentaInt <= cuentas.size()){
                        ((Cuentas.CuentasBancarias)cuentas.get(numCuentaInt - 1)).CalcularInteres();
                    } else {
                        System.out.println("Numero de cuenta invalido.");
                    }
                    break;
                case 6:
                    System.out.println("Tasa de interes actual: " + Cuentas.CuentasBancarias.getTasaInteres());
                    break;
                case 7:
                    System.out.print("Ingrese la nueva tasa de interes (en decimal): ");
                    double nuevaTasa = sc.nextDouble();
                    Cuentas.CuentasBancarias.setTasaInteres(nuevaTasa);
                    break;
                case 8:
                    System.out.println("Total de cuentas: " + Cuentas.CuentasBancarias.getTotalCuentas());
                    System.out.println("Total de dinero en el banco: " + Cuentas.CuentasBancarias.getTotalDinero());
                    break;
                case 9:
                    cuentas.clear();
                    System.out.println("Banco reseteado. Todas las cuentas eliminadas.");
                    break;
                case 0:
                    cycle = false;
                    System.out.println("Saliendo del sistema bancario.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
        
    }
        }
    }
}
