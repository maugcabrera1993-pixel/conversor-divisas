package lad.com.alura.conversormoneda;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {

    private static final Scanner lectura = new Scanner(System.in);

    public static void eleccionUserMenu() throws IOException, InterruptedException {
        int opcion = 0;
        while (opcion != 7) {
            System.out.println("""
                *** Sea bienvenido/a al Conversor de Moneda ***

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir

                Elija una opción válida:
                """);
            try {
                opcion = Integer.parseInt(lectura.nextLine());

                switch (opcion) {
                    case 1:
                        convertirMoneda("USD", "ARS");
                        break;
                    case 2:
                        convertirMoneda("ARS", "USD");
                        break;
                    case 3:
                        convertirMoneda("USD", "BRL");
                        break;
                    case 4:
                        convertirMoneda("BRL", "USD");
                        break;
                    case 5:
                        convertirMoneda("USD", "COP");
                        break;
                    case 6:
                        convertirMoneda("COP", "USD");
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
            System.out.println("\n--- Presione Enter para continuar ---");
            lectura.nextLine(); // Pausa para que el usuario vea el resultado
            System.out.println("\n"); // Línea en blanco para limpiar
        }
    }

    private static void convertirMoneda(String monedaBase, String monedaObjetivo) throws IOException, InterruptedException {
        System.out.print("Ingrese el valor en " + monedaBase + " que desea convertir: ");
        try {
            double valorIngresado = Double.parseDouble(lectura.nextLine());

            // Obtener la tasa de cambio
            double tasa = ConversorApp.obtenerTasa(monedaBase, monedaObjetivo);

            // Calcular el valor convertido
            double valorConvertido = valorIngresado * tasa;

            System.out.println(valorIngresado + " " + monedaBase + " equivale a " + valorConvertido + " " + monedaObjetivo);

        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese un valor numérico válido.");
        } catch (Exception e) { // Captura errores de la API o códigos no encontrados
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}