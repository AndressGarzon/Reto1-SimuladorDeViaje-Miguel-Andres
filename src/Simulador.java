import java.util.Scanner;
public class Simulador {
    static String[] plantetas ={"Mercurio", "Venus", "Marte", "Júpiter", "Saturno"};
    static double[] distancias ={};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int  opcion;
        do {
            muestraMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: //Planeta
                    break;
                case 2: //Nave
                    break;
                case 3: //Simulación
                    break;
                case 4: //Salir
                System.out.println("Gracias por visitar");
                    break;
                default:
                System.out.println("Opción no válida\n");
                    break;
            }
        } while (opcion!=4);
        scanner.close();
    }


    private static void muestraMenu(){
        System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:");
        System.out.println("1. Seleccionar un planeta de destino.");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Iniciar la simulación del viaje");
        System.out.println("4. Salir del programa");
    }

    private static void seleccionarPlaneta(){ //Método para planetas
        
    }

    private static void gestionarNave(){ //Método para la nave

    }

    private static void iniciarSimulacion(){ //Método de simulación

    }
}
