package org.juandavid.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Facturas {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Clientes clientes;
    private ItemFacturas[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Facturas(String descripcion, Clientes clientes) {
        this.descripcion = descripcion;
        this.clientes = clientes;
        this.items = new ItemFacturas[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public ItemFacturas[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFacturas item) {
        if (indiceItems < MAX_ITEMS) {

            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFacturas item : this.items) {
            //Alternativa
            //if(item instanceof ItemFactura)
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N:");
        sb.append(folio)
                .append("\nClientes: ")
                .append(this.clientes.getNombre())
                .append("\tNIF: ")
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMM, yyyy");
        sb.append("Fecha emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$Cant.\tTotal\n");

        for (ItemFacturas item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
