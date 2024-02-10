package org.juandavid.appfacturas;

import org.juandavid.appfacturas.modelo.*;

import java.util.Scanner;
public class EjemploFactura {

    public static void main(String[] args) {

        Clientes clientes = new Clientes();
        clientes.setNif("34354354");
        clientes.setNombre("Juan David");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese Descripción de la factura: ");
        String desc = sc.nextLine();
        Facturas facturas = new Facturas(desc,clientes);

        Producto producto;
        //String nombre;
        //float precio;
        //int cantidad;

        System.out.println();

        for(int i=0; i<5;i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ":");
            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad: ");

            facturas.addItemFactura(new ItemFacturas(sc.nextInt(),producto));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(facturas);
    }
}
