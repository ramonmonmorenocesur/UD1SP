package almacen;
public class PrecioProducto {

    //atributos
    private String proovedor;
    private float precio;
    public PrecioProducto(String proovedor, float precio) {
        this.proovedor = proovedor;
        this.precio = precio;
    }
    public String getProovedor() {
        return proovedor;
    }
    public void setProovedor(String proovedor) {
        this.proovedor = proovedor;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}