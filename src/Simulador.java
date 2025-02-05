import java.util.Scanner;

public class Simulador {
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double[] distancias = { 77.0, 61.0, 54.6, 778.0, 1300.0, 2723.0, 4351.4, };
    static String[] descripciones = {
            "Mercurio: Es un planeta rocoso, pequeño y denso, que se encuentra en el Sistema Solar. Es el planeta más cercano al Sol y el más pequeño de todos. ",
            "Venus: Es un planeta rocoso, terrestre y el segundo planeta más cercano al Sol. Es el planeta más caliente del sistema solar y se le conoce como el lucero de la tarde",
            "Marte: Es un planeta terrestre del sistema solar que se caracteriza por su color rojo, su frío y su superficie rocosa",
            "Júpiter: Es el planeta más grande del Sistema Solar, un gigante gaseoso que se encuentra en el quinto lugar desde el Sol. Está compuesto principalmente de hidrógeno y helio, tiene una atmósfera nubosa con manchas y cinturones de colores. ",
            "Saturno: Es el sexto planeta del sistema solar y el segundo más grande, después de Júpiter. Es un gigante gaseoso, compuesto principalmente de hidrógeno y helio, y con una atmósfera densa.",
            "Urano: Es un planeta gigante de hielo que se encuentra en el sistema solar. Es el séptimo planeta desde el Sol y el tercero más grande del sistema solar.",
            "Neptuno: es el último planeta del Sistema Solar y está compuesto por una mezcla de agua, amoniaco y metano. Es un gigante de hielo, frío, oscuro y ventoso."
    };
    static String[] naves = { "Stellar Voyager", "Iron Condor", "Galactic Horizon", "Shadow Phantom", "Celestial Ark" };
    static int naveSeleccionada;
    static int[] cantidadPasajeros = { 12, 8, 20, 5, 100 };
    static int cantidadPasajerosSeleccionada;
    static int[] velocidadesMaximas = { 20, 30, 50, 60, 80 };


    public static void main(String[] args) {
        muestraMenu();
    }


    static void muestraMenu() {
        int opcion;

        System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:\n");
        System.out.println("1. Seleccionar un planeta de destino.");
        System.out.println("2. Gestionar nave espacial");
        System.out.println("3. Iniciar simulación de viaje");
        System.out.println("4. Salir del programa");

        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                seleccionarPlaneta();
                break;
            case 2:
                gestionNave();
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

    private static void seleccionarPlaneta() { // Método para planetas
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nPlanetas disponibles para el viaje:");
            for (int i = 0; i < planetas.length; i++) {
                System.out.println((i + 1) + ". " + planetas[i]);
            }
            System.out.print("Ingresa el número del planeta al que quieres visitar: ");
            int opcionPlaneta = scanner.nextInt() - 1;

            if (opcionPlaneta >= 0 && opcionPlaneta < planetas.length) {
                System.out.println("\nHas seleccionado " + planetas[opcionPlaneta]);
                System.out.println(descripciones[opcionPlaneta]);
                System.out.println("Distancia desde la tierra: " + distancias[opcionPlaneta] + " Millones de Km");

                String confirmacion = "";
                while (true) {
                    System.out.print("\n¿Deseas continuar con este planeta? (s/n): ");
                    confirmacion = scanner.next();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        continuar = false; // Confirma y sale del bucle
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

    static void gestionNave() {
        var opcion = 0;
        System.out.println("Bienvenido a las opciones de gestión de la nave");
        System.out.println("Seleccione una opción\n");
        System.out.println("1. Seleccionar nave");
        System.out.println("2. Consultar nave seleccionada");
        System.out.println("3. Seleccionar la cantidad de pasajeros");
        System.out.println("4. Calcular la duración del viaje");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                seleccionarNave();
                break;

            case 2:
                consultarNaveSeleccionada();
                break;

            case 3:
                cantidadDePasajeros();
                break;

            case 4:
                calculoDuracionViaje();
                break;

            default:
                System.out.println("Opción no válida");
                gestionNave();
                break;
        }

    }

    static void seleccionarNave() {

        System.out.println("Seleccione una nave espacial\n");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("%d. %s\n", i + 1, naves[i]);
        }

        naveSeleccionada = scanner.nextInt() - 1;

        if (naveSeleccionada >= 0 && naveSeleccionada <= 4) {

            System.out.printf("Ha seleccionado %s\n\n", naves[naveSeleccionada]);
            gestionNave();
        } else {
            System.out.println("Ha seleccionado una nave no válida!");
            seleccionarNave();
        }
    }

    static void consultarNaveSeleccionada() {
        switch (naveSeleccionada) {
            case 0:
                System.out.println("   _____ __       ____              _    __                                 \r\n" + //
                        "  / ___// /____  / / /___ ______   | |  / /___  __  ______ _____ ____  _____\r\n" + //
                        "  \\__ \\/ __/ _ \\/ / / __ `/ ___/   | | / / __ \\/ / / / __ `/ __ `/ _ \\/ ___/\r\n" + //
                        " ___/ / /_/  __/ / / /_/ / /       | |/ / /_/ / /_/ / /_/ / /_/ /  __/ /    \r\n" + //
                        "/____/\\__/\\___/_/_/\\__,_/_/        |___/\\____/\\__, /\\__,_/\\__, /\\___/_/     \r\n" + //
                        "                                             /____/      /____/ \n");
                System.out.printf("Capacidad de pasajeros: %d\n", cantidadPasajeros[0]);
                System.out.printf("Velocidad %d km/s\n", velocidadesMaximas[0]);
                System.out.printf("Cantidad de pasajeros actual: %d - restantes: %d\n", cantidadPasajerosSeleccionada,
                        cantidadPasajeros[naveSeleccionada] - cantidadPasajerosSeleccionada);
                scanner.nextLine();
                System.out.println("Presiona una tecla para continuar...");
                scanner.nextLine();
                gestionNave();
                break;

            case 1:
                System.out.println(
                        "██ ██████   ██████  ███    ██      ██████  ██████  ███    ██ ██████   ██████  ██████  \r\n" + //
                                "██ ██   ██ ██    ██ ████   ██     ██      ██    ██ ████   ██ ██   ██ ██    ██ ██   ██ \r\n"
                                + //
                                "██ ██████  ██    ██ ██ ██  ██     ██      ██    ██ ██ ██  ██ ██   ██ ██    ██ ██████  \r\n"
                                + //
                                "██ ██   ██ ██    ██ ██  ██ ██     ██      ██    ██ ██  ██ ██ ██   ██ ██    ██ ██   ██ \r\n"
                                + //
                                "██ ██   ██  ██████  ██   ████      ██████  ██████  ██   ████ ██████   ██████  ██   ██\n");
                System.out.printf("Capacidad de pasajeros: %d\n", cantidadPasajeros[1]);
                System.out.printf("Velocidad %d km/s\n", velocidadesMaximas[1]);
                System.out.printf("Cantidad de pasajeros actual: %d - restantes: %d\n", cantidadPasajerosSeleccionada,
                        cantidadPasajeros[naveSeleccionada] - cantidadPasajerosSeleccionada);
                scanner.nextLine();
                System.out.println("Presiona una tecla para continuar...");
                scanner.nextLine();
                gestionNave();
                break;

            case 2:
                System.out.println(
                        "  ______ _______        _______ _______ _______ _____ _______      _     _  _____   ______ _____ ______  _____  __   _\r\n"
                                + //
                                " |  ____ |_____| |      |_____| |          |      |   |            |_____| |     | |_____/   |    ____/ |     | | \\  |\r\n"
                                + //
                                " |_____| |     | |_____ |     | |_____     |    __|__ |_____       |     | |_____| |    \\_ __|__ /_____ |_____| |  \\_|\r\n"
                                + //
                                "                                                                                                                      \n");
                System.out.printf("Capacidad de pasajeros: %d\n", cantidadPasajeros[2]);
                System.out.printf("Velocidad %d km/s\n", velocidadesMaximas[2]);
                System.out.printf("Cantidad de pasajeros actual: %d - restantes: %d\n", cantidadPasajerosSeleccionada,
                        cantidadPasajeros[naveSeleccionada] - cantidadPasajerosSeleccionada);
                scanner.nextLine();
                System.out.println("Presiona una tecla para continuar...");
                scanner.nextLine();
                gestionNave();
                break;

            case 3:
                System.out.println(
                        " ____    __                   __                          ____    __                       __                          \r\n"
                                + //
                                "/\\  _`\\ /\\ \\                 /\\ \\                        /\\  _`\\ /\\ \\                     /\\ \\__                       \r\n"
                                + //
                                "\\ \\,\\L\\_\\ \\ \\___      __     \\_\\ \\    ___   __  __  __   \\ \\ \\L\\ \\ \\ \\___      __      ___\\ \\ ,_\\   ___     ___ ___    \r\n"
                                + //
                                " \\/_\\__ \\\\ \\  _ `\\  /'__`\\   /'_` \\  / __`\\/\\ \\/\\ \\/\\ \\   \\ \\ ,__/\\ \\  _ `\\  /'__`\\  /' _ `\\ \\ \\/  / __`\\ /' __` __`\\  \r\n"
                                + //
                                "   /\\ \\L\\ \\ \\ \\ \\ \\/\\ \\L\\.\\_/\\ \\L\\ \\/\\ \\L\\ \\ \\ \\_/ \\_/ \\   \\ \\ \\/  \\ \\ \\ \\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ \\ \\_/\\ \\L\\ \\/\\ \\/\\ \\/\\ \\ \r\n"
                                + //
                                "   \\ `\\____\\ \\_\\ \\_\\ \\__/.\\_\\ \\___,_\\ \\____/\\ \\___x___/'    \\ \\_\\   \\ \\_\\ \\_\\ \\__/.\\_\\ \\_\\ \\_\\ \\__\\ \\____/\\ \\_\\ \\_\\ \\_\\\r\n"
                                + //
                                "    \\/_____/\\/_/\\/_/\\/__/\\/_/\\/__,_ /\\/___/  \\/__//__/       \\/_/    \\/_/\\/_/\\/__/\\/_/\\/_/\\/_/\\/__/\\/___/  \\/_/\\/_/\\/_/\r\n"
                                + //
                                "                                                                                                                       \r\n"
                                + //
                                "                                                                                                                       \n");
                System.out.printf("Capacidad de pasajeros: %d\n", cantidadPasajeros[3]);
                System.out.printf("Velocidad %d km/s\n", velocidadesMaximas[3]);
                System.out.printf("Cantidad de pasajeros actual: %d - restantes: %d\n", cantidadPasajerosSeleccionada,
                        cantidadPasajeros[naveSeleccionada] - cantidadPasajerosSeleccionada);
                scanner.nextLine();
                System.out.println("Presiona una tecla para continuar...");
                scanner.nextLine();
                gestionNave();
                break;

            case 4:
                System.out.println("_________    ______           __________       ______   _______       ______  \r\n"
                        + //
                        "__  ____/_______  /_____________  /___(_)_____ ___  /   ___    |_________  /__\r\n" + //
                        "_  /    _  _ \\_  /_  _ \\_  ___/  __/_  /_  __ `/_  /    __  /| |_  ___/_  //_/\r\n" + //
                        "/ /___  /  __/  / /  __/(__  )/ /_ _  / / /_/ /_  /     _  ___ |  /   _  ,<   \r\n" + //
                        "\\____/  \\___//_/  \\___//____/ \\__/ /_/  \\__,_/ /_/      /_/  |_/_/    /_/|_|  \r\n" + //
                        "                                                                              \n");
                System.out.printf("Capacidad de pasajeros: %d\n", cantidadPasajeros[4]);
                System.out.printf("Velocidad %d km/s\n", velocidadesMaximas[4]);
                System.out.printf("Cantidad de pasajeros actual: %d - restantes: %d\n", cantidadPasajerosSeleccionada,
                        cantidadPasajeros[naveSeleccionada] - cantidadPasajerosSeleccionada);
                scanner.nextLine();
                System.out.println("Presiona una tecla para continuar...");
                scanner.nextLine();
                gestionNave();
                break;
        }
    }

    static void cantidadDePasajeros() {
        System.out.printf(
                "Seleccione la cantidad de pasajeros\ntenga en cuenta que la capacidad de la nave es de %d pasajeros\n",
                cantidadPasajeros[naveSeleccionada]);

        cantidadPasajerosSeleccionada = scanner.nextInt();
        if (!validarCantidadDePasajeros(cantidadPasajerosSeleccionada)) {
            System.out.println("Cantidad de pasajeros no permitida!\n");
            scanner.nextLine();
            System.out.println("Presiona una tecla para continuar...");
            scanner.nextLine();
            cantidadDePasajeros();
        } else {
            System.out.printf("Cantidad de pasajeros seleccionada %d\n", cantidadPasajerosSeleccionada);
            scanner.nextLine();
            System.out.println("Presiona una tecla para continuar...");
            scanner.nextLine();
            gestionNave();

        }

        scanner.nextLine();

    }

    // Validación de cantidad de pasajeros dependiendo de la nave seleccionada
    /**
     * La función valida que la cantidad de pasajeros que viajan sea la correcta,
     * con respecto
     * a la cantidad de pasajeros que soporta la nave.
     * 
     * @param pasajeros Cantidad de pasajeros que viajan
     * @return true si la cantidad de pasajeros es permitida por la nave o false en
     *         caso contrario
     */
    static boolean validarCantidadDePasajeros(int pasajeros) {
        if (pasajeros > cantidadPasajeros[naveSeleccionada] || pasajeros <= 0) {
            return false;
        } else {

            return true;
        }
    }

    static void calculoDuracionViaje() {
        System.out.println("Calculo duración viaje");
    }

    static void simulacionDeViaje() {
        System.out.println("Simulación de viaje");
    }

    private static void iniciarSimulacion(){ //Método de simulación

    }
}
