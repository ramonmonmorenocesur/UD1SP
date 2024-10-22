import almacen.GestionAlmacen;
import almacen.PrecioProducto;
import almacen.Producto;

public class App {
    public static void main(String[] args) throws Exception {
       Thread.currentThread().setName("Principal");
        Producto manzana = new Producto(10);
        GestionAlmacen gestor = new GestionAlmacen(manzana, manzana.getPrecioProv().length);
        gestor.run();
        for (int i = 0; i < manzana.getPrecioProv().length; i++) {
            manzana.addProducto("proovedor"+1, i*10+1);
        }
        manzana.mostrarPrecioProveedores();
    }
}
