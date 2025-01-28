import java.util.Scanner;

public class Simulador {
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double[] distancias = {};
    static String[] naves = {};

    public static void main(String[] args) {
        muestraMenu();
    }

    private static void muestraMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:");
            System.out.println("1. Seleccionar un planeta de destino.");
            System.out.println("2. Seleccionar una nave espacial.");
            System.out.println("3. Iniciar la simulación del viaje.");
            System.out.println("4. Salir del programa.");
            System.out.print("Ingresa una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarPlaneta();
                    break;
                case 2:
                    gestionarNave();
                    break;
                case 3:
                    iniciarSimulacion();
                    break;
                case 4:
                    System.out.println("Gracias por visitar.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.\n");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }


    private static void seleccionarPlaneta(){ //Método para planetas
        
    }

    private static void gestionarNave(){ //Método para la nave

    }

    private static void iniciarSimulacion(){ //Método de simulación

    }
}
