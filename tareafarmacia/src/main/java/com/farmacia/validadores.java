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
                    System.out.println("Error: El número debe estar dentro del rango especificado.\nIngresa un numero: ");
                }
            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero.\nIngresa un numero: ");
                sc.next();
            }
        } while (true);
    }
}
