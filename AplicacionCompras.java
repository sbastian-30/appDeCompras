import java.util.Scanner;

public class AplicacionCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("===== APLICACIÓN DE COMPRAS =====");
        System.out.print("Ingrese el límite de su tarjeta de crédito: $");
        double limite = 0;
        
        // Validacion de numero positivo
        boolean limiteValido = false;
        while (!limiteValido) {
            try {
                limite = Double.parseDouble(scanner.nextLine());
                if (limite <= 0) {
                    System.out.print("El límite debe ser mayor a cero. Intente nuevamente: $");
                } else {
                    limiteValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número válido: $");
            }
        }
        
        // Instanciando la tarjeta de crédito
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);
        System.out.println("Tarjeta creada con éxito. Límite: $" + limite);
        
        // Iniciando compras
        boolean continuarComprando = true;
        
        while (continuarComprando && tarjeta.obtenerSaldoDisponible() > 0) {
            System.out.println("\nSaldo disponible: $" + tarjeta.obtenerSaldoDisponible());
            
            
            System.out.print("Ingrese la descripción de la compra (o 'salir' para terminar): ");
            String descripcion = scanner.nextLine();
            
            if (descripcion.equalsIgnoreCase("salir")) {
                continuarComprando = false;
                continue;
            }
            
            
            System.out.print("Ingrese el valor de la compra: $");
            double valor = 0;
            boolean valorValido = false;
            
            while (!valorValido) {
                try {
                    valor = Double.parseDouble(scanner.nextLine());
                    if (valor <= 0) {
                        System.out.print("El valor debe ser mayor a cero. Intente nuevamente: $");
                    } else {
                        valorValido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Ingrese un número válido: $");
                }
            }
            
            // Creando la compra 
            try {
                Compra compra = new Compra(descripcion, valor);
                boolean compraExitosa = tarjeta.realizarCompra(compra);
                
                if (compraExitosa) {
                    System.out.println("¡Compra realizada con éxito!");
                } else {
                    System.out.println("¡Saldo insuficiente para realizar esta compra!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            // Si el saldo se agotó, informar al usuario
            if (tarjeta.obtenerSaldoDisponible() <= 0) {
                System.out.println("\n¡El saldo de la tarjeta se ha agotado!");
                continuarComprando = false;
            } else {
                // Preguntar si desea continuar comprando
                System.out.print("\n¿Desea realizar otra compra? (s/n): ");
                String respuesta = scanner.nextLine();
                continuarComprando = respuesta.equalsIgnoreCase("s");
            }
        }
        
        // Mostrar el resumen de compras
        System.out.println("\n" + tarjeta.generarResumen());
        System.out.println("===== GRACIAS POR USAR LA APLICACIÓN =====");
        
        scanner.close();
    }
}