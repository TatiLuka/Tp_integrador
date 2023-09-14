package trabajoIntegrador;
import java.util.InputMismatchException;
import java.util.Scanner;

public class trabajoIntegrador {
    public static void main(String[] args) {
        char[][] asientos = new char[4][3]; 
        double[] precios = {500, 700, 1000}; 

        double ingresosTotales = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese la fila (A, B, C): ");
                char fila = scanner.next().charAt(0);

                if (fila != 'A' && fila != 'B' && fila != 'C') {
                    throw new InputMismatchException("Fila no válida");
                }

                System.out.print("Ingrese el número de asiento (1-4): ");
                int numeroAsiento = scanner.nextInt();

                if (numeroAsiento < 1 || numeroAsiento > 4) {
                    throw new InputMismatchException("Número de asiento no válido");
                }

                int filaIndex = fila - 'A';

                if (asientos[filaIndex][numeroAsiento - 1] == '\0') { 
                    asientos[filaIndex][numeroAsiento - 1] = 'X'; 
                    double precio = precios[filaIndex];
                    ingresosTotales += precio;
                    System.out.println("Venta exitosa. Precio: $" + precio);
                } else {
                    System.out.println("El asiento está ocupado. Por favor, seleccione otro.");
                }

       
                boolean salaLlena = true;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (asientos[i][j] == '\0') {
                            salaLlena = false;
                            break;
                        }
                    }
                }

                if (salaLlena) {
                    System.out.println("Sala llena.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ");
                scanner.nextLine(); 
            }
        }

        System.out.println("Ingresos totales: $" + ingresosTotales);
       
    }
}
