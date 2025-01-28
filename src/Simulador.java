import java.util.Scanner;

public class Simulador {
    String[] plantetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    double[] distancias = {};

    public static void main(String[] args) {
        muestraMenu();
    }

    static void muestraMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:");
        System.out.println("1. Seleccionar un planeta de destino.");
        System.out.println("2. Seleccionar nave espacial");
        System.out.println("3. Iniciar simulación de viaje");
        System.out.println("4. Salir del programa");

        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                seleccionarPlaneta();
                break;
            case 2:
                seleccionarNave();
                break;
            case 3:
                simulacionDeViaje();
                break;
            case 4: // Salir
                System.out.println("Gracias por visitar");
                break;
            default:
                System.out.println("Opción no válida\n");
                muestraMenu();
                break;
        }
        scanner.close();

    }

    static void seleccionarPlaneta() {
        System.out.println("Seleccionar planeta");
    }

    static void seleccionarNave() {
        System.out.println("Seleccionar nave");
    }

    static void simulacionDeViaje() {
        System.out.println("Simulación de viaje");
    }
}
