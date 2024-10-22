package almacen;

import java.util.concurrent.locks.ReentrantLock;

public class Producto {
    // atributos
    private ReentrantLock cerrojo;
    private PrecioProducto[] precioProv;
    private int sigProveedor;
  
    // constructores
    public Producto(int MaxPreciosProducto) {
        // inicializar.
        sigProveedor = 0;// almacena el siguiente hueco libre .
        cerrojo= new ReentrantLock();
        precioProv = new PrecioProducto[MaxPreciosProducto];
    }

    public Producto(PrecioProducto[] precioProv, int sigProducto) {
        this.precioProv = precioProv;
        this.sigProveedor = sigProducto;
    }

    public int getSigProveedor() {
        return sigProveedor;
    }

    public void setSigProveedor(int sigProducto) {
        this.sigProveedor = sigProducto;
    }

    // getter y setters
    public PrecioProducto[] getPrecioProv() {
        accederSeccionCritica();
        try{
            return precioProv;
        }finally{
            salirSeccionCritica();
        }
    }


    // metodos solicitados
    public void addProducto(String nombreProveedor, float precio) {
        accederSeccionCritica();
        try {
            if (sigProveedor == precioProv.length) {
                System.out.println("No se puede añadir el producto el almacen esta lleno");
            } else { // tengo hueco
                precioProv[sigProveedor] = new PrecioProducto(nombreProveedor, precio);
                sigProveedor++;

            }
        } finally {
            salirSeccionCritica();
        }

    }

    public void mostrarPrecioProveedores() {
        accederSeccionCritica();
        try {
            if (sigProveedor == 0) {
                System.out.println("No hay precios de proovedores para este producto");
            } else {
                for (int i = 0; i < sigProveedor; i++) {
                    System.out.println("El proveedor: " + precioProv[i].getProovedor()
                            + " ofrece el producto "
                            + precioProv[i].getPrecio() + " €");
                }
            }
        } finally {
            salirSeccionCritica();
        }
    }

   public void mostrarMejorPrecio(){
    PrecioProducto mejorProducto= new PrecioProducto(null, Float.POSITIVE_INFINITY);
    float min = Float.POSITIVE_INFINITY;
    accederSeccionCritica();
    try{
    if(sigProveedor<=0){
        System.out.println("No hay informacion disponible para ese producto");
    }else{
    for (int i = 0; i < sigProveedor; i++) {
      if(precioProv[i].getPrecio()<mejorProducto.getPrecio()){
        mejorProducto=precioProv[i];
      } 
    } System.out.println("El mejor precio para el producto es "
    +mejorProducto.getPrecio()+" y es ofrecido por el proovedor "
    +mejorProducto.getProovedor());
}
   }finally{
    salirSeccionCritica();
   }
    
}

    private void accederSeccionCritica() {
        cerrojo.lock();
    }

    private void salirSeccionCritica() {
        cerrojo.unlock();

    }
}