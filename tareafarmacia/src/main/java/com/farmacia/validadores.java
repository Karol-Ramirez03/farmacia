package com.farmacia;

import java.util.Scanner;

public class validadores {
    public static int rangeValidator(int minNumber, int maxNumber) {
        Scanner sc = new Scanner(System.in);

        int number;
        do {
            try {
                number = sc.nextInt();

                if (number >= minNumber && number <= maxNumber) {
                    return number;
                } else {
                    limpiarConsola();
                    System.out.println("Error: El número debe estar dentro del rango especificado.\nIngresa un numero: ");
                }
            } catch (Exception e) {
                limpiarConsola();
                System.out.println("Error: Debes introducir un número entero.\nIngresa un numero: ");
                sc.next();
            }
        } while (true);
    }

    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {

                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al borrar la consola.");
        }
    }

    public static void pausa(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Presiona Enter para continuar...");
        scanner.nextLine();
    }
}
