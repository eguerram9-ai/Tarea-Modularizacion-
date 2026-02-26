import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class code {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    //menu principal
    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Números primos");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Cálculo de factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Intercambio de números");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("0. Salir");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> ejercicio1Calculadora();
            case 2 -> ejercicio2ValidacionContrasena();
            case 3 -> ejercicio3NumerosPrimos();
            case 4 -> ejercicio4SumaPares();
            case 5 -> ejercicio5ConversionTemperatura();
            case 6 -> ejercicio6ContadorVocales();
            case 7 -> ejercicio7Factorial();
            case 8 -> ejercicio8Adivinanza();
            case 9 -> ejercicio9Intercambio();
            case 10 -> ejercicio10TablaMultiplicar();
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.next();
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido.");
                scanner.next();
            }
        }
    }

    private static void ejercicio1Calculadora() {
        System.out.println("\n--- CALCULADORA BÁSICA ---");
        double num1 = leerDouble("Ingrese el primer número: ");
        double num2 = leerDouble("Ingrese el segundo número: ");

        System.out.println("Operaciones:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        int op = leerEntero("Elija una opción (1-4): ");

        double resultado;
        switch (op) {
            case 1 -> resultado = sumar(num1, num2);
            case 2 -> resultado = restar(num1, num2);
            case 3 -> resultado = multiplicar(num1, num2);
            case 4 -> {
                if (num2 == 0) {
                    System.out.println("Error: No se puede dividir entre cero.");
                    return;
                }
                resultado = dividir(num1, num2);
            }
            default -> {
                System.out.println("Opción no válida.");
                return;
            }
        }
        System.out.println("Resultado: " + resultado);
    }

    private static double sumar(double a, double b) { return a + b; }
    private static double restar(double a, double b) { return a - b; }
    private static double multiplicar(double a, double b) { return a * b; }
    private static double dividir(double a, double b) { return a / b; }


    private static void ejercicio2ValidacionContrasena() {
        System.out.println("\n--- VALIDACIÓN DE CONTRASEÑA ---");
        final String PASSWORD_CORRECTA = "1234";
        String ingreso;
        do {
            System.out.print("Ingrese la contraseña: ");
            ingreso = scanner.next();
            if (!ingreso.equals(PASSWORD_CORRECTA)) {
                System.out.println("Contraseña incorrecta. Intente de nuevo.");
            }
        } while (!ingreso.equals(PASSWORD_CORRECTA));
        System.out.println("Acceso concedido.");
    }


    private static void ejercicio3NumerosPrimos() {
        System.out.println("\n--- NÚMEROS PRIMOS ---");
        int num = leerEntero("Ingrese un número entero positivo: ");
        if (num <= 0) {
            System.out.println("Debe ingresar un número positivo.");
            return;
        }
        if (esPrimo(num)) {
            System.out.println(num + " es primo.");
        } else {
            System.out.println(num + " no es primo.");
        }
    }

    private static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    private static void ejercicio4SumaPares() {
        System.out.println("\n--- SUMA DE NÚMEROS PARES ---");
        System.out.println("Ingrese números enteros (0 para terminar):");
        int suma = 0;
        int num;
        while (true) {
            num = leerEntero("Número: ");
            if (num == 0) break;
            if (num % 2 == 0) {
                suma += num;
            }
        }
        System.out.println("Suma de los números pares: " + suma);
    }


    private static void ejercicio5ConversionTemperatura() {
        System.out.println("\n--- CONVERSIÓN DE TEMPERATURA ---");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        int op = leerEntero("Elija opción (1 o 2): ");
        double temp = leerDouble("Ingrese la temperatura: ");
        double resultado;
        switch (op) {
            case 1 -> resultado = celsiusAFahrenheit(temp);
            case 2 -> resultado = fahrenheitACelsius(temp);
            default -> {
                System.out.println("Opción no válida.");
                return;
            }
        }
        System.out.println("Resultado: " + resultado);
    }

    private static double celsiusAFahrenheit(double c) { return (c * 9/5) + 32; }
    private static double fahrenheitACelsius(double f) { return (f - 32) * 5/9; }


    private static void ejercicio6ContadorVocales() {
        System.out.println("\n--- CONTADOR DE VOCALES ---");
        System.out.print("Ingrese una cadena de texto: ");
        scanner.nextLine();
        String cadena = scanner.nextLine();
        int total = contarVocales(cadena);
        System.out.println("La cadena contiene " + total + " vocales.");
    }

    private static int contarVocales(String texto) {
        int cont = 0;
        String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ";
        for (char c : texto.toCharArray()) {
            if (vocales.indexOf(c) != -1) cont++;
        }
        return cont;
    }

    private static void ejercicio7Factorial() {
        System.out.println("\n--- CÁLCULO DE FACTORIAL ---");
        int n = leerEntero("Ingrese un número entero no negativo: ");
        if (n < 0) {
            System.out.println("El factorial no está definido para números negativos.");
            return;
        }
        long fact = factorial(n);
        System.out.println(n + "! = " + fact);
    }

    private static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    private static void ejercicio8Adivinanza() {
        System.out.println("\n--- JUEGO DE ADIVINANZA ---");
        Random rand = new Random();
        int secreto = rand.nextInt(100) + 1;
        int intento;
        do {
            intento = leerEntero("Adivina el número (1-100): ");
            if (intento < secreto) {
                System.out.println("El número es mayor.");
            } else if (intento > secreto) {
                System.out.println("El número es menor.");
            }
        } while (intento != secreto);
        System.out.println("¡Correcto! Has adivinado el número.");
    }

    // 9. Intercambio de números (simulación paso por referencia)
    private static void ejercicio9Intercambio() {
        System.out.println("\n--- INTERCAMBIO DE NÚMEROS ---");
        int[] par = new int[2];
        par[0] = leerEntero("Ingrese el primer número: ");
        par[1] = leerEntero("Ingrese el segundo número: ");

        System.out.println("Antes del intercambio: a = " + par[0] + ", b = " + par[1]);
        intercambiar(par);
        System.out.println("Después del intercambio: a = " + par[0] + ", b = " + par[1]);
    }

    private static void intercambiar(int[] valores) {
        if (valores.length != 2) return;
        int temp = valores[0];
        valores[0] = valores[1];
        valores[1] = temp;
    }

    private static void ejercicio10TablaMultiplicar() {
        System.out.println("\n--- TABLA DE MULTIPLICAR ---");
        int num = leerEntero("Ingrese un número: ");
        mostrarTabla(num);
    }

    private static void mostrarTabla(int n) {
        System.out.println("Tabla del " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}