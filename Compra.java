public class Compra {
    private String descripcion;
    private double valor;

    public Compra(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toString() {
        return "Compra [descripcion=" + descripcion + ", valor=" + valor + "]";
    }
    
    
    
}
