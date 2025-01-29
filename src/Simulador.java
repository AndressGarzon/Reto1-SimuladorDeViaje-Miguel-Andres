import java.util.Scanner;

public class Simulador {
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double [] distancias = {77.0, 61.0, 54.6, 778.0, 1300.0 ,2723.0, 4351.4,};
    static String[] descripciones={
        "Mercurio: Es un planeta rocoso, pequeño y denso, que se encuentra en el Sistema Solar. Es el planeta más cercano al Sol y el más pequeño de todos. ",
        "Venus: Es un planeta rocoso, terrestre y el segundo planeta más cercano al Sol. Es el planeta más caliente del sistema solar y se le conoce como el lucero de la tarde",
        "Marte: Es un planeta terrestre del sistema solar que se caracteriza por su color rojo, su frío y su superficie rocosa",
        "Júpiter: Es el planeta más grande del Sistema Solar, un gigante gaseoso que se encuentra en el quinto lugar desde el Sol. Está compuesto principalmente de hidrógeno y helio, tiene una atmósfera nubosa con manchas y cinturones de colores. ",
        "Saturno: Es el sexto planeta del sistema solar y el segundo más grande, después de Júpiter. Es un gigante gaseoso, compuesto principalmente de hidrógeno y helio, y con una atmósfera densa.",
        "Urano: Es un planeta gigante de hielo que se encuentra en el sistema solar. Es el séptimo planeta desde el Sol y el tercero más grande del sistema solar.",
        "Neptuno: es el último planeta del Sistema Solar y está compuesto por una mezcla de agua, amoniaco y metano. Es un gigante de hielo, frío, oscuro y ventoso."
    };
    static String[] naves = {};

    public static void main(String[] args) {
        muestraMenu();
    }

    private static void muestraMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:");
        do {
            System.out.println("\n-------------Menú-------------------");
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
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
    
        while (continuar) {
            System.out.println("\nPlanetas disponibles para el viaje:");
            for (int i = 0; i < planetas.length; i++) {
                System.out.println((i + 1) + ". " + planetas[i]);
            }
            System.out.print("Ingresa el número del planeta al que quieres visitar: ");
            int opcionPlaneta = scanner.nextInt()-1;
    
            if (opcionPlaneta >= 0 && opcionPlaneta < planetas.length) {
                System.out.println("\nHas seleccionado " + planetas[opcionPlaneta]);
                System.out.println(descripciones[opcionPlaneta]);
                System.out.println("Distancia desde la tierra: " + distancias[opcionPlaneta] + " Millones de Km");
                
                String confirmacion = "";
                while (true) {
                    System.out.print("\n¿Deseas continuar con este planeta? (s/n): ");
                    confirmacion = scanner.next();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        continuar = false;  // Confirma y sale del bucle
                        break;
                    } else if (confirmacion.equalsIgnoreCase("n")) {
                        System.out.println("Puedes elegir otro planeta.");
                        break;
                    } else {
                        System.out.println("Respuesta no válida. Ingresa 's' para sí o 'n' para no.");
                    }
                }
            } else {
                System.out.println("Opción no válida. Vuelve a intentarlo.");
            }
        }
    }

    private static void gestionarNave(){ //Método para la nave

    }

    private static void iniciarSimulacion(){ //Método de simulación

    }
}
