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
        System.out.println("2. Calcular distancia y tiempo de viaje");
        System.out.println("3. Gestionar recursos de la nave");
        System.out.println("4. Monitorear estado del viaje");
        System.out.println("5. Salir del programa");

        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                seleccionarPlaneta();
                break;
            case 2:
                calcularDistanciaTiempo();
                break;
            case 3:
                gestionarRecursos();
                break;
            case 4:
                monitorearEstado();
                break;
            case 5: // Salir
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

    static void calcularDistanciaTiempo() {
        System.out.println("Calcular distancia y tiempo de viaje");
    }

    static void gestionarRecursos() {
        System.out.println("Gestionar Recursos de la nave");
    }

    static void monitorearEstado() {
        System.out.println("Monitorear estado del viaje");
    }
}
