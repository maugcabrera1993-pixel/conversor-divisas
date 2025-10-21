package lad.com.alura.conversormoneda;

import java.io.IOException;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bienvenido al Conversor de Monedas!");

        // Iniciar el menú del conversor
        Conversor.eleccionUserMenu();

        System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
    }

    // Método para obtener la tasa de cambio de la API
    public static double obtenerTasa(String monedaBase, String monedaObjetivo) throws IOException, InterruptedException {
        String apiKey = "0511d9757395b2fc069a6f89"; // Tu clave de API
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

        // 1. Crear cliente HTTP
        java.net.http.HttpClient cliente = java.net.http.HttpClient.newHttpClient();

        // 2. Crear solicitud HTTP
        java.net.http.HttpRequest solicitud = java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .GET() // Método GET
                .build();

        // 3. Enviar solicitud y recibir respuesta
        java.net.http.HttpResponse<String> respuesta = cliente.send(solicitud, java.net.http.HttpResponse.BodyHandlers.ofString());

        // Verificar si la solicitud fue exitosa
        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error al obtener datos de la API. Código de estado: " + respuesta.statusCode());
        }

        String respuestaJson = respuesta.body();

        // 4. Parsear JSON usando Gson
        com.google.gson.JsonElement elemento = com.google.gson.JsonParser.parseString(respuestaJson);
        com.google.gson.JsonObject objectRoot = elemento.getAsJsonObject();

        // 5. Verificar el estado de la API
        String estado = objectRoot.get("result").getAsString();
        if (!"success".equals(estado)) {
            throw new RuntimeException("Error en la respuesta de la API: " + objectRoot.get("error-type").getAsString());
        }

        // 6. Obtener tasas (rates) del objeto raíz
        com.google.gson.JsonObject tasasObject = objectRoot.getAsJsonObject("conversion_rates");

        // 7. Obtener la tasa específica para la moneda objetivo
        if (!tasasObject.has(monedaObjetivo)) {
            throw new IllegalArgumentException("Código de moneda objetivo no encontrado: " + monedaObjetivo);
        }

        double tasa = tasasObject.get(monedaObjetivo).getAsDouble();

        return tasa; // Devuelve la tasa de conversión
    }
}