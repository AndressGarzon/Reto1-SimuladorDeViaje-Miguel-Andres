import java.util.Random;
import java.util.Scanner;

public class Simulador {
    // Variables globales
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static int planetaSeleccionado = -1;
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
    static int naveSeleccionada = -1;
    static int[] cantidadPasajeros = { 12, 8, 20, 5, 100 };
    static int cantidadTanquesOxigeno = -1;
    static int cantidadTanquesCombustible = -1;
    static int oxigeno = 100;
    static int combustible = 100;
    static int cantidadPasajerosSeleccionada = -1;
    static int[] velocidadesMaximas = { 2000, 3000, 5000, 6000, 8000 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        muestraMenu(scanner);
        scanner.close();
    }

    private static void muestraMenu(Scanner scanner) {
        int opcion;
        System.out.println("Bienvenido a este viaje interplanetario. Elige tu próxima travesía:");
        do {
            System.out.println("\n-------------Menú-------------------");
            System.out.println("1. Seleccionar un planeta de destino.");
            System.out.println("2. Seleccionar una nave espacial.");
            System.out.println("3. Gestionar los recursos para el viaje.");
            System.out.println("4. Iniciar la simulación del viaje.");
            System.out.println("5. Salir del programa.");
            System.out.print("Ingresa una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer de entrada

            switch (opcion) {
                case 1:
                    seleccionarPlaneta(scanner);
                    break;
                case 2:
                    gestionNave(scanner);
                    break;
                case 3:
                    gestionarRecursos(scanner);
                    break;
                case 4:
                    iniciarSimulacion();
                    break;
                case 5:
                    System.out.println("Gracias por visitar!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.\n");
                    muestraMenu(scanner);
            }
        } while (opcion != 5);
    }

    // Método para seleccionar un planeta
    private static void seleccionarPlaneta(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nPlanetas disponibles para el viaje:");
            for (int i = 0; i < planetas.length; i++) {
                System.out.println((i + 1) + ". " + planetas[i]);
            }
            System.out.print("Ingresa el número del planeta al que quieres visitar: ");
            int opcionPlaneta = scanner.nextInt() - 1;
            scanner.nextLine();

            if (opcionPlaneta >= 0 && opcionPlaneta < planetas.length) {
                System.out.println("\nHas seleccionado " + planetas[opcionPlaneta]);
                System.out.println(descripciones[opcionPlaneta]);
                System.out.println("Distancia desde la tierra: " + distancias[opcionPlaneta] + " Millones de Km");

                String confirmacion = "";
                while (true) {
                    System.out.print("\n¿Deseas continuar con este planeta? (s/n): ");
                    confirmacion = scanner.nextLine();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        planetaSeleccionado = opcionPlaneta;
                        continuar = false; // Confirma y sale del bucle
                        seleccionarNave(scanner);
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

    // Método para gestionar la nave
    static void gestionNave(Scanner scanner) {
        var opcion = 0;
        System.out.println("\n----Bienvenido a las opciones de gestión de la nave----");
        System.out.println("Seleccione una opción\n");
        System.out.println("1. Seleccionar nave");
        System.out.println("2. Consultar nave seleccionada");
        System.out.println("3. Seleccionar la cantidad de pasajeros");
        System.out.println("4. Volver al menú principal");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                seleccionarNave(scanner);
                break;

            case 2:
                consultarNaveSeleccionada();
                break;

            case 3:
                cantidadDePasajeros();
                break;

            case 4:
                muestraMenu(scanner);

            default:
                System.out.println("Opción no válida");
                gestionNave(scanner);
                break;
        }

    }

    // Método para seleccionar la nave
    static void seleccionarNave(Scanner scanner) {

        System.out.println("\n>>>Seleccione una nave espacial<<<\n");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("%d. %s\n", i + 1, naves[i]);
        }

        naveSeleccionada = scanner.nextInt() - 1;
        scanner.nextLine();

        if (naveSeleccionada >= 0 && naveSeleccionada <= 4) {

            System.out.printf("\nHa seleccionado %s\n\n", naves[naveSeleccionada]);
            cantidadDePasajeros();
        } else {
            System.out.println("Ha seleccionado una nave no válida!");
            seleccionarNave(scanner);
        }

    }

    // Método para consultar la nave seleccionada
    static void consultarNaveSeleccionada() {
        Scanner scanner = new Scanner(System.in);
        if (naveSeleccionada == -1) {
            System.out.println("No has seleccionado ninguna nave aún. Por favor, selecciona una nave primero.");
            scanner.nextLine();
            System.out.println("Presiona una tecla para continuar...");
            scanner.nextLine();
            gestionNave(scanner);
        }
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
                gestionNave(scanner);
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
                gestionNave(scanner);
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
                gestionNave(scanner);
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
                gestionNave(scanner);
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
                gestionNave(scanner);
                break;
        }
    }

    // Método para seleccionar la cantidad de pasajeros
    static void cantidadDePasajeros() {
        Scanner scanner = new Scanner(System.in);
        if (naveSeleccionada == -1) {
            System.out.println("No has seleccionado una nave aún. Por favor, selecciona una nave primero.");
            System.out.println("Presiona una tecla para continuar...");
            scanner.nextLine();
            gestionNave(scanner);
        }
        System.out.printf(
                "Seleccione la cantidad de pasajeros\n\nTenga en cuenta que la capacidad de la nave es de (%d) pasajeros\n",
                cantidadPasajeros[naveSeleccionada]);
        cantidadPasajerosSeleccionada = scanner.nextInt();
        scanner.nextLine();

        if (!validarCantidadDePasajeros(cantidadPasajerosSeleccionada)) {
            System.out.println("Cantidad de pasajeros no permitida!\n");
            System.out.println("Presiona una tecla para continuar...");
            scanner.nextLine();
            cantidadDePasajeros();
        } else {
            System.out.printf("Cantidad de pasajeros seleccionada %d\n", cantidadPasajerosSeleccionada);
            System.out.println("\nPresiona una tecla para continuar...");
            scanner.nextLine();
            gestionarOxigeno(scanner);

        }
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

    // Función para calcular la duración del viaje
    static String calculoDuracionViaje() {
        var distanciaEnMillonesDeKm = distancias[planetaSeleccionado] * Math.pow(10, 6);
        var segundosPorDia = 86400;
        /*
         * La fórmula para calcular el tiempo de viaje en segundos es
         * Distancia * 10 ^ 6 / Velocidad
         */
        var tiempoDeViajeEnSegundos = distanciaEnMillonesDeKm / velocidadesMaximas[naveSeleccionada];
        var tiempoDeViajeEnHoras = Math.round(tiempoDeViajeEnSegundos / 3600);
        var tiempoDeViajeEnDias = Math.round(tiempoDeViajeEnSegundos / segundosPorDia);
        return "La duración estimada del viaje es de: " + tiempoDeViajeEnHoras + " horas " + "(" + tiempoDeViajeEnDias
                + " días)";

    }

    // Función para mostrar la información completa del viaje
    static void informacionCompletaDeViaje() {
        System.out.println("\n*****- Información general del viaje -*****\n");
        System.out.printf("Planeta destino: %s\n", planetas[planetaSeleccionado]);
        System.out.printf("Nave Seleccionada: %s\n", naves[naveSeleccionada]);
        System.out.println(
                cantidadTanquesOxigeno > 1 ? "Cantidad de oxígeno seleccionado: " + cantidadTanquesOxigeno + " tanques"
                        : "Cantidad de oxígeno seleccionado: " + cantidadTanquesOxigeno + " tanque");
        System.out.println(cantidadTanquesCombustible > 1
                ? "Cantidad de combustible seleccionado: " + cantidadTanquesCombustible + " tanques"
                : "Cantidad de combustible seleccionado: " + cantidadTanquesCombustible + " tanque");
        System.out.printf("Cantidad de pasajeros a bordo: %d\n", cantidadPasajerosSeleccionada);
        System.out.printf("Distancia desde la tierra hasta %s es de: %.0f millones de Kilómetros\n",
                planetas[planetaSeleccionado], distancias[planetaSeleccionado]);
        System.out.println(calculoDuracionViaje());
        System.out.println("\nPresione una tecla para continuar...");
    }

    // Función que muestra el menú para gestionar los recursos
    static void gestionarRecursos(Scanner scanner) {
        System.out.println("Seleccione el recurso a gestionar:\n");
        System.out.println("1. Oxígeno");
        System.out.println("2. Combustible");
        System.out.println("3. Volver al menú principal");
        int opcion = 0;
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                gestionarOxigeno(scanner);

            case 2:
                gestionarCombustible(scanner);

            case 3:
                muestraMenu(scanner);

            default:
                System.out.println("No has seleccionado una opción válida, vuelve a intentarlo!");
                gestionarRecursos(scanner);
                break;
        }
    }

    // Función que muestra el menú para gestionar el oxígeno
    static void gestionarOxigeno(Scanner scanner) {
        System.out.println("**- Gestionar Oxígeno -**\n");
        System.out.println("Seleccione la cantidad de oxígeno que llevará para este viaje\n");
        System.out.println("1. 1 Tanque");
        System.out.println("2. 2 Tanques");
        System.out.println("3. 4 Tanques");

        cantidadTanquesOxigeno = scanner.nextInt();

        switch (cantidadTanquesOxigeno) {
            case 1:
                System.out.println("Has seleccionado: " + cantidadTanquesOxigeno + " tanque de oxígeno\n");
                gestionarCombustible(scanner);
            case 2:
                System.out.println("Has seleccionado: " + cantidadTanquesOxigeno + " tanques de oxígeno\n");
                gestionarCombustible(scanner);
            case 3:
                System.out.println("Has seleccionado: " + cantidadTanquesOxigeno + " tanques de oxígeno\n");
                gestionarCombustible(scanner);
            default:
                System.out.println("Opción no válida!");
                gestionarRecursos(scanner);
                break;
        }

    }

    // Función que muestra el menú para gestionar el combustible
    static void gestionarCombustible(Scanner scanner) {
        System.out.println("**- Gestionar Combustible -**\n");
        System.out.println("Seleccione la cantidad de combustible que llevará para este viaje");
        System.out.println("1. 1 Tanque");
        System.out.println("2. 2 Tanques");
        System.out.println("3. 4 Tanques");

        cantidadTanquesCombustible = scanner.nextInt();

        switch (cantidadTanquesCombustible) {
            case 1:
                System.out.println("Has seleccionado: " + cantidadTanquesCombustible + " tanque de combustible\n");
                muestraMenu(scanner);
            case 2:
                System.out.println("Has seleccionado: " + cantidadTanquesCombustible + " tanques de combustible\n");
                muestraMenu(scanner);
            case 3:
                System.out.println("Has seleccionado: " + cantidadTanquesCombustible + " tanques de combustible\n");
                muestraMenu(scanner);
            default:
                System.out.println("Opción no válida!");
                gestionarRecursos(scanner);
                break;
        }
    }

    // Función que valída que los recursos se hayan seleccionado y inicia la
    // simulación
    static void iniciarSimulacion() {
        Scanner scanner = new Scanner(System.in);
        if (planetaSeleccionado == -1 && naveSeleccionada == -1) {
            System.out.println(
                    "No has seleccionado un planeta ni una nave. Selecciónalos antes de iniciar la simulación.");
            scanner.nextLine();
        } else if (planetaSeleccionado == -1) {
            System.out.println("No has seleccionado un planeta. Selecciónalo antes de iniciar la simulación.");
            scanner.nextLine();
        } else if (naveSeleccionada == -1) {
            System.out.println("No has seleccionado una nave. Selecciónala antes de iniciar la simulación.");
            scanner.nextLine();
        } else if (cantidadPasajerosSeleccionada <= 0) {
            System.out.println(
                    "No has seleccionado la cantidad de pasajeros. Selecciónalos antes de iniciar la simulación.");
            scanner.nextLine();
        } else if (cantidadTanquesOxigeno == 0 && cantidadTanquesCombustible == 0) {
            System.out.println(
                    "No has seleccionado la cantidad de oxígeno y combustible. Seleccionalos antes de inciar la simulación");
            scanner.nextLine();
        } else if (cantidadTanquesOxigeno == 0) {
            System.out.println(
                    "No has seleccionado la cantidad de tanques de oxígeno. Seleccionalos antes de inciar la simulación");
            scanner.nextLine();
        } else if (cantidadTanquesCombustible == 0) {
            System.out.println(
                    "No has seleccionado la cantidad de tanques de combustible. Seleccionalos antes de iniciar la simulación");
            scanner.nextLine();
        } else {

            informacionCompletaDeViaje();
            scanner.nextLine();
            simulacion();

        }
    }

    static void simulacion() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int eventoAleatorio1 = random.nextInt(100);
        int eventoAleatorio2 = random.nextInt(100);
        StringBuilder advance = new StringBuilder();
        char head = '>';
        char body = '=';
        advance.append(head);

        try {
            Thread.sleep(1000);
            System.out.println("Preparando despegue...");
            Thread.sleep(3000);
            System.out.println("Calibrando sistema de direccionamiento...");
            Thread.sleep(3000);
            System.out.println("Conectando oxígeno y combustible...");
            Thread.sleep(3000);
            System.out.println("Despegue en:");
            Thread.sleep(1000);
            System.out.println("5");
            Thread.sleep(1000);
            System.out.println("4");
            Thread.sleep(1000);
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
            Thread.sleep(2000);
            System.out.println("Despegando!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        switch (planetaSeleccionado) {
            case 0, 1, 2:
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                        pantalla4(i, oxigeno, combustible, advance);
                        advance.insert(0, body);
                        Thread.sleep(100);
                        pantalla3(i, oxigeno, combustible, advance);
                        Thread.sleep(100);
                        pantalla2(i, oxigeno, combustible, advance);
                        Thread.sleep(100);
                        pantalla1(i, oxigeno, combustible, advance);
                        oxigeno--;
                        combustible--;

                        if (oxigeno < -2) {
                            adicionarTanqueOxigeno(scanner);
                        } else if (combustible < -2) {
                            adicionarTanqueCombustible(scanner);
                        } else if (eventoAleatorio1 == i) {
                            lluviaAsteroides(scanner);
                        } else if (eventoAleatorio2 == i) {
                            falloSistema(scanner);
                        } else if (i == 100) {
                            System.out.println("\n¡Has llegado al planeta destino!");
                            oxigeno = 100;
                            combustible = 100;
                            scanner.nextLine();
                            muestraMenu(scanner);
                        }

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

            case 3, 4:
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(200);
                        pantalla4(i, oxigeno, combustible, advance);
                        advance.insert(0, body);
                        Thread.sleep(200);
                        pantalla3(i, oxigeno, combustible, advance);
                        Thread.sleep(200);
                        pantalla2(i, oxigeno, combustible, advance);
                        Thread.sleep(200);
                        pantalla1(i, oxigeno, combustible, advance);
                        oxigeno -= 2;
                        combustible -= 2;

                        if (oxigeno < -2) {
                            adicionarTanqueOxigeno(scanner);
                        } else if (combustible < -2) {
                            adicionarTanqueCombustible(scanner);
                        } else if (eventoAleatorio1 == i) {
                            lluviaAsteroides(scanner);
                        } else if (eventoAleatorio2 == i) {
                                falloSistema(scanner);
                            } else if (i == 100) {
                            System.out.println("\n¡Has llegado al planeta destino!");
                            oxigeno = 100;
                            combustible = 100;
                            scanner.nextLine();
                            muestraMenu(scanner);
                        }

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

            case 5, 6:
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(300);
                        pantalla1(i, oxigeno, combustible, advance);
                        advance.insert(0, body);
                        Thread.sleep(300);
                        pantalla2(i, oxigeno, combustible, advance);
                        Thread.sleep(300);
                        pantalla3(i, oxigeno, combustible, advance);
                        Thread.sleep(300);
                        pantalla4(i, oxigeno, combustible, advance);
                        oxigeno -= 4;
                        combustible -= 4;

                        if (oxigeno < 0) {
                            cantidadTanquesOxigeno -= 1;
                            adicionarTanqueOxigeno(scanner);
                        } else if (combustible < 0) {
                            cantidadTanquesCombustible -= 1;
                            adicionarTanqueCombustible(scanner);
                        } else if (eventoAleatorio1 == i) {
                            lluviaAsteroides(scanner);
                        } else if (eventoAleatorio2 == i) {
                                falloSistema(scanner);
                        } else if (i == 100) {
                            System.out.println("\n¡Has llegado al planeta destino!");
                            oxigeno = 100;
                            combustible = 100;
                            scanner.nextLine();
                            muestraMenu(scanner);
                        }

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
        }

    }

    static void pantalla1(int porcentaje, int oxigeno, int combustible, StringBuilder advance) {
        System.out.println("""
                *     *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *     *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *     *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *     *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                """ + advance + "\nPorcentaje de avance: " + porcentaje + "% " + "(Oxígeno: " + oxigeno
                + ") (Combustible: " + combustible + ")");
    }

    static void pantalla2(int porcentaje, int oxigeno, int combustible, StringBuilder advance) {
        System.out.println("""
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *     *
                      *     *     *     *     *     *     *     *     *     *     *     *     *
                 """ + advance + "\nPorcentaje de avance: " + porcentaje + "% " + "(Oxígeno: " + oxigeno
                + ") (Combustible: " + combustible + ")");
    }

    static void pantalla3(int porcentaje, int oxigeno, int combustible, StringBuilder advance) {
        System.out.println("""
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *
                *    *     *     *     *     *     *     *     *     *     *     *     *     *
                  *     *     *     *     *     *     *     *     *     *     *     *     *     *
                    *     *     *     *     *     *     *     *     *     *     *     *     *
                      *     *     *     *     *     *     *     *     *     *     *     *     *
                """ + advance + "\nPorcentaje de avance: " + porcentaje + "% " + "(Oxígeno: " + oxigeno
                + ") (Combustible: " + combustible + ")");
    }

    static void pantalla4(int porcentaje, int oxigeno, int combustible, StringBuilder advance) {
        System.out.println("""
                   *     *     *     *     *     *     *     *     *     *     *     *     *     *
                 *   *     *     *     *     *     *     *     *     *     *     *     *     *
                       *     *     *     *     *     *     *     *     *     *     *     *     *
                   *     *     *     *     *     *     *     *     *     *     *     *     *     *
                     *     *     *     *     *     *     *     *     *     *     *     *     *
                 *     *     *     *     *     *     *     *     *     *     *     *     *     *
                   *     *     *     *     *     *     *     *     *     *     *     *     *     *
                     *     *     *     *     *     *     *     *     *     *     *     *     *
                 *    *     *     *     *     *     *     *     *     *     *     *     *     *
                   *     *     *     *     *     *     *     *     *     *     *     *     *     *
                     *     *     *     *     *     *     *     *     *     *     *     *     *
                       *     *     *     *     *     *     *     *     *     *     *     *     *
                """ + advance + "\nPorcentaje de avance: " + porcentaje + "% " + "(Oxígeno: " + oxigeno
                + ") (Combustible: " + combustible + ")");
    }

    static void adicionarTanqueOxigeno(Scanner scanner) {
        String opcion = "";
        System.out.println("Oxígeno bajo, ¿desea utilizar el siguiente tanque?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                if (cantidadTanquesOxigeno != 0) {
                    System.out.println("¡Se ha conectado otro tanque de oxígeno!");
                    System.out.printf("Tanques de oxígeno restantes: %d", cantidadTanquesOxigeno);
                    scanner.nextLine();
                    oxigeno = 100;

                } else {
                    System.out.println("No tienes más tanques de oxígeno, el viaje no se pudo completar...");
                    scanner.nextLine();
                    oxigeno = 100;
                    combustible = 100;
                    muestraMenu(scanner);
                }
                break;

            case "2":
                System.out.println("No tienes más tanques de oxígeno, el viaje no se pudo completar...");
                scanner.nextLine();
                oxigeno = 100;
                combustible = 100;
                muestraMenu(scanner);
                break;
            default:
                System.out.println("Opcion no válida");
                adicionarTanqueOxigeno(scanner);
                break;
        }
    }

    static void adicionarTanqueCombustible(Scanner scanner) {
        String opcion = "";
        System.out.println("Combustible bajo, ¿desea utilizar el siguiente tanque?");
        System.out.println("1. Si");
        System.out.println("2. No");
        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                if (cantidadTanquesCombustible != 0) {
                    System.out.println("¡Se ha conectado otro tanque de combustible!");
                    System.out.printf("Tanques de combustible restantes: %d", cantidadTanquesCombustible);
                    scanner.nextLine();
                    oxigeno = 100;
                    combustible = 100;

                } else {
                    System.out.println("No tienes más tanques de combustible, el viaje no se pudo completar...");
                    scanner.nextLine();
                    oxigeno = 100;
                    combustible = 100;
                    muestraMenu(scanner);
                }
                break;

            case "2":
                System.out.println("No tienes más tanques de combustible, el viaje no se pudo completar...");
                scanner.nextLine();
                oxigeno = 100;
                combustible = 100;
                muestraMenu(scanner);
                break;
            default:
                System.out.println("Opcion no válida");
                adicionarTanqueOxigeno(scanner);
                break;
        }
    }

    static void lluviaAsteroides(Scanner scanner) {
        String opcion = "";
        System.out.println("Estás cerca a una lluvia de asteroides");
        System.out.println("Que quieres hacer?");
        System.out.println("1. Realizar un desvío");
        System.out.println("2. Seguir el rumbo normal");
        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("\nHas esquivado la lluvia de asteroides con éxito!");
                scanner.nextLine();
                break;
            case "2":
                System.out.println(
                        "\nLa nave ha colisionado contra los asteroides sufriendo irreparables daños, el viaje no se pudo completar...");
                scanner.nextLine();
                oxigeno = 100;
                combustible = 100;
                muestraMenu(scanner);
                break;

            default:
                System.out.println("Opción inválida!");
                scanner.nextLine();
                lluviaAsteroides(scanner);
                break;
        }

    }

    static void falloSistema(Scanner scanner) {
        String opcion = "";
        System.out.println("El sistema de navegación está presentando un fallo:");
        System.out.println("Que quieres hacer?");
        System.out.println("1. Reparar el sistema");
        System.out.println("2. No reparar el sistema");
        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("\nHas reparado el sistema de navegación con éxito!");
                scanner.nextLine();
                break;
            case "2":
                System.out.println(
                        "\nNo reparaste el sistema y la nave tomó un rumbo inesperado!, el viaje no se pudo completar...");
                scanner.nextLine();
                oxigeno = 100;
                combustible = 100;
                muestraMenu(scanner);
                break;

            default:
                System.out.println("Opción inválida!");
                scanner.nextLine();
                lluviaAsteroides(scanner);
                break;
        }
    }

}
