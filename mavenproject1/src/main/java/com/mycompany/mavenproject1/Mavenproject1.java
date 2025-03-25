/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tareas = new String[100]; // Máximo 100 tareas
        int contador = 0;
        int opcion;

        System.out.println("Bienvenido al Gestor de Tareas Pendientes.");

        do {
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Consultar Tarea");
            System.out.println("4. Mostrar Todas las Tareas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
            try {
                switch (opcion) {
                    case 1:
                        try {
                            if (contador >= tareas.length) {
                                System.out.println("Error: No se pueden agregar más tareas.");
                            } else {
                                System.out.print("Ingrese la descripción de la tarea: ");
                                String tarea = scanner.nextLine();
                                tareas[contador] = tarea;
                                contador++;
                                System.out.println("Tarea agregada correctamente.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error al agregar la tarea: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Ingrese el índice de la tarea a eliminar: ");
                            int indice = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer

                            if (indice < 1 || indice > contador) {
                                System.out.println("Error: Índice fuera de rango.");
                            } else {
                                for (int i = indice - 1; i < contador - 1; i++) {
                                    tareas[i] = tareas[i + 1];
                                }
                                tareas[contador - 1] = null;
                                contador--;
                                System.out.println("Tarea eliminada correctamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Entrada no válida. Debe ingresar un número.");
                            scanner.nextLine(); // Limpiar entrada inválida
                        } catch (Exception e) {
                            System.out.println("Error al eliminar la tarea: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.print("Ingrese el índice de la tarea a consultar: ");
                            int indice = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer

                            if (indice < 1 || indice > contador) {
                                System.out.println("Error: Índice fuera de rango.");
                            } else {
                                System.out.println("Tarea " + indice + ": " + tareas[indice - 1]);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Entrada no válida. Debe ingresar un número.");
                            scanner.nextLine(); // Limpiar entrada inválida
                        } catch (Exception e) {
                            System.out.println("Error al consultar la tarea: " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            if (contador == 0) {
                                System.out.println("No hay tareas pendientes.");
                            } else {
                                System.out.println("Tareas Pendientes:");
                                for (int i = 0; i < contador; i++) {
                                    System.out.println((i + 1) + ". " + tareas[i]);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error al mostrar las tareas: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Gracias por usar el Gestor de Tareas Pendientes.");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Intente de nuevo.");
                scanner.nextLine(); // Limpiar entrada inválida
                opcion = 0; // Reiniciar opción para seguir en el menú
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 5);

        scanner.close();
    }
}
