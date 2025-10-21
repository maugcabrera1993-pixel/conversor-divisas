# 💰 Conversor de Monedas 💱

¡Convierte entre tus monedas favoritas al instante! Este proyecto es una aplicación de consola escrita en **Java** que aprovecha una **API externa** para obtener tasas de cambio actualizadas.

## 🚀 Características

*   **Conversión en tiempo real:** Utiliza datos actualizados de [ExchangeRate-API](https://exchangerate-api.com/).
*   **Soporte para múltiples monedas:** Incluye Dólar (USD), Peso Argentino (ARS), Real Brasileño (BRL) y Peso Colombiano (COP).
*   **Interfaz amigable:** Menú interactivo en consola para una fácil navegación.
*   **Tecnologías modernas:** Desarrollado en Java con `HttpClient` y `Gson` para manejar solicitudes y respuestas JSON.

## 🧰 Tecnologías Utilizadas

*   **Java (8+):** Lenguaje de programación principal.
*   **IntelliJ IDEA:** Entorno de desarrollo integrado (IDE).
*   **Maven:** (Opcional, dependiendo de la estructura del proyecto) Gestión de dependencias y compilación.
*   **Gson:** Biblioteca para parsear JSON.
*   **ExchangeRate-API:** Fuente de datos para las tasas de cambio.

## 📋 Requisitos

*   [Java Development Kit (JDK)](https://adoptium.net/) versión 11 o superior.
*   [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (u otro IDE compatible).

## 🛠️ Instalación y Uso

1.  **Clona el repositorio:**

    ```bash
    git clone <URL_DEL_REPOSITORIO>
    ```

2.  **Abre el proyecto en IntelliJ IDEA:**
    *   `File` -> `Open` -> Selecciona la carpeta del proyecto clonado.
    *   IntelliJ debería reconocerlo automáticamente como un proyecto Java (o Maven si aplica).

3.  **Asegura que Gson esté como dependencia:**
    *   **Si es un proyecto Maven:** Verifica que `gson` esté en tu `pom.xml` y haz `Reload project`.
    *   **Si es un proyecto simple:** Asegúrate de haber añadido Gson como biblioteca siguiendo los pasos del código.

4.  **Compila y Ejecuta:**
    *   Haz clic derecho en el archivo `ConversorApp.java`.
    *   Selecciona `Run 'ConversorApp.main()'`.

5.  **¡Sigue las instrucciones en la consola!** Elige una opción del menú, ingresa la cantidad y observa la conversión mágica.
