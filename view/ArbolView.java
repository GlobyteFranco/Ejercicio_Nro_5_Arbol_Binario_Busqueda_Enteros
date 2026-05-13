package view;

import java.util.Scanner;

import controller.ArbolController;
import model.ArbolBinario;

public class ArbolView implements View {
    ArbolController miArbolController = new ArbolController(new ArbolBinario());
    Scanner scanner = new Scanner(System.in);

    public void enterData() {
        int variableIngreso;

        System.out.println(
                "A continuacion por favor ingrese los datos para llenar el arbol o tipee una letra para terminar y verlo... \n\n");

        while (true) {
            try {
                variableIngreso = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingreso de de datos finalizado... Por favor a continuacion ingrese el valor a buscar");
                break;
            }
            miArbolController.insertar(variableIngreso);
            System.out.println("Ingrese otro valor por favor... \n\n");

        }

        buscarValor();
        displayData();
    }

    public void displayData() {
        System.out.println(
                "A continuacion, como detalle soberbio, se imprimira el arbol binario \n\n");
        for (Integer valor : miArbolController.devolverOrdenado()) {
            System.out.println(valor + "\n");
        }

    }

    public void buscarValor() {
        System.out.println("A continuacion ingrese el valor a buscar");
        int valor = scanner.nextInt();

        if (miArbolController.buscar(valor))
            System.out.println("El valor ha sido encontradi");
        else
            System.out.println("El valor no ha sido encontrado");

    }
}
