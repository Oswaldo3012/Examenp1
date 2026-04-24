import java.util.Scanner;

public class Gestion_Hotel {
    public static void main(String[] args) {
        int totalSuites = 2;
        int suitesOcupadas = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre de Usuario: ");
        String nombre_usuario = scanner.nextLine();

        long num_identificacion = 0;
        boolean idValida = false;
        while (!idValida) {
            System.out.print("Ingrese el numero de identificacion (máximo 10 dígitos): ");
            if (scanner.hasNextLong()) {
                num_identificacion = scanner.nextLong();
                if (num_identificacion > 0) {
                    idValida = true;
                } else {
                    System.out.println("Número inválido.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese solo números.");
                scanner.next();
            }
        }
        String registro = String.valueOf(num_identificacion);
        String ultimosCuatro = registro.substring(Math.max(0, registro.length() - 4));

        int edad_usuario = 0;
        System.out.print("Ingresa la edad del usuario: ");
        while (true) {
            if (scanner.hasNextInt()) {
                edad_usuario = scanner.nextInt();
                if (edad_usuario >= 18) {
                    break;
                } else {
                    System.out.print("Error, debe ser mayor de 18 años: ");
                }
            } else {
                System.out.print("Entrada inválida, intenta de nuevo: ");
                scanner.next();
            }
        }
        scanner.nextLine();

        String tipo_habitacion = "";
        double precio = 0;
        boolean habitacionValida = false;

        while (!habitacionValida) {
            System.out.print("Ingrese el tipo de Habitacion (Sencilla, Doble, Suite): ");
            tipo_habitacion = scanner.nextLine().toLowerCase();

            switch (tipo_habitacion) {
                case "sencilla":
                    precio = 40.0;
                    habitacionValida = true;
                    break;
                case "doble":
                    precio = 60.0;
                    habitacionValida = true;
                    break;
                case "suite":
                    if (suitesOcupadas < totalSuites) {
                        precio = 80.0;
                        suitesOcupadas++;
                        habitacionValida = true;
                    } else {
                        System.out.println("No hay suites disponibles. Elija otra opción.");
                    }
                    break;
                default:
                    System.out.println("Tipo de habitación no válido.");
            }
        }

        System.out.println("\n--- REGISTRO COMPLETADO ---");
        System.out.println("Cliente: " + nombre_usuario);
        System.out.println("ID: " + num_identificacion);
        System.out.println("Código Registro: " + ultimosCuatro);
        System.out.println("Edad: " + edad_usuario);
        System.out.println("Tipo Habitación: " + tipo_habitacion);
        System.out.println("Total a Pagar: $" + precio);
        System.out.println("---------------------------");

        scanner.close();
    }
}
