import java.util.Scanner;

public class Simulador {
    static Scanner scanner = new Scanner(System.in);
    static String[] plantetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static long[] distancias = {};
    static String[] naves = {"Stellar Voyager", "Iron Condor", "Galactic Horizon", "Shadow Phantom", "Celestial Ark"};
    static String naveSeleccionada;

    public static void main(String[] args) {
        muestraMenu();
    }

    static void muestraMenu() {
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

    }

    static void seleccionarPlaneta() {
        System.out.println("Seleccionar planeta");
    }

    static void seleccionarNave() {
        var seleccionNave = 0;

        System.out.println("Seleccione una nave espacial");
        for(int i = 0 ; i < naves.length; i++)
        {
            System.out.println(i+1 + ". " + naves[i]);
        }

        seleccionNave = scanner.nextInt();

        switch(seleccionNave)
        {
            case 1:
            naveSeleccionada = naves[0];
            System.out.println("Ha seleccionado " + naveSeleccionada);
            break;
            case 2:
            naveSeleccionada = naves[1];
            System.out.println("Ha seleccionado " + naveSeleccionada);
            break;
            case 3:
            naveSeleccionada = naves[2];
            System.out.println("Ha seleccionado " + naveSeleccionada);
            case 4:
            naveSeleccionada = naves[3];
            System.out.println("Ha seleccionado " + naveSeleccionada);
            break;
            case 5:
            naveSeleccionada = naves[4];
            System.out.println("Ha seleccionado " + naveSeleccionada);
            break;

        }

    }

    static void simulacionDeViaje() {
        System.out.println("Simulación de viaje");
    }
}
