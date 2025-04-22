import java.util.ArrayList;

public class TarjetaDeCredito {
    private double limiteCredito;
    private double saldoDisponible;
    private ArrayList<Compra> compras;

    public TarjetaDeCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        this.saldoDisponible = limiteCredito;
        this.compras = new ArrayList<Compra>();
    }

    public boolean realizarCompra(Compra compra) {
        if (compra.getValor() <= saldoDisponible) {
            obtenerHistorialCompras().add(compra);
            saldoDisponible -= compra.getValor();
            return true;
        }
        return false;
    }

    public ArrayList<Compra> obtenerHistorialCompras() {
        return compras;
    }

    public double obtenerSaldoDisponible() {
        return saldoDisponible;
    }

    public double obtenerTotalGastado() {
        return limiteCredito - saldoDisponible;
    }

    public String generarResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("===== RESUMEN DE COMPRAS =====\n");
        resumen.append("Límite de crédito: $").append(limiteCredito).append("\n");
        resumen.append("Total gastado: $").append(obtenerTotalGastado()).append("\n");
        resumen.append("Saldo disponible: $").append(saldoDisponible).append("\n");
        resumen.append("\nDetalle de compras:\n");

        if (obtenerHistorialCompras().isEmpty()) {
            resumen.append("No se realizaron compras.\n");
        } else {
            for (int i = 0; i < obtenerHistorialCompras().size(); i++) {
                resumen.append(i + 1).append(". ")
                        .append(obtenerHistorialCompras().get(i).toString()).append("\n");
            }
        }

        return resumen.toString();
    }
}
