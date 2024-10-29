import almacen.GestionAlmacen;
import almacen.Producto;

public class App {
    public static void main(String[] args) throws Exception {
       

        Producto pera = new Producto(10);
        Producto cacahuete= new Producto(16);

        GestionAlmacen gestor = new GestionAlmacen(pera, pera.getPrecioProv().length);
        GestionAlmacen gestor2 =new GestionAlmacen(cacahuete, 15);

       pera.getPrecioProv().l
    }
}
