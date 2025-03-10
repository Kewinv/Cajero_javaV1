package com.example;
import java.util.Scanner;

public class CajeroFortnite
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Variables y constantes
        int pinCorrecto = 1234; // PIN inicial
        double saldo = 50000;
        int intentos = 0;
        boolean cuentaBloqueada = false;
        final double LIMITE_RETIRO_DIARIO = 10000; // Limite de retiro diario
        

        // Autenticación según los intentos
        while (intentos < 3) 
        {
            System.out.println("Ingrese su PIN:");
            if (scanner.hasNextInt()) // Verifica si la entrada es un número
            {
                int pinIngresado = scanner.nextInt();

                if (pinIngresado == pinCorrecto) 
                {
                    System.out.println("¡Bienvenido Fortnite player!");
                    break;
                } 
                else 
                {
                    intentos++;
                    System.out.println("Pin Incorrecto. -50 de vida\nIntentos: " + intentos);
                }

                if (intentos == 3) 
                {
                    cuentaBloqueada = true;
                    System.out.println("Se te bloqueó la cuenta, a jugar salvar el mundo");
                }
            } 
            else 
            {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Descarta la entrada no válida
            }
        }

        // Si la cuenta está bloqueada, finaliza el programa
        if (cuentaBloqueada) 
        {
            scanner.close();
            return;
        }

        // Menú del cajero
        int opcion = 0;
        do 
        {
            System.out.println("\n CAJERO FORTNITE");
            System.out.println("1. Consultar pavos");
            System.out.println("2. Retirar pack de inicio");
            System.out.println("3. Depositar");
            System.out.println("4. Consultar límite de retiro diario");
            System.out.println("5. Cambiar PIN");
            System.out.println("6. Salir");
            System.out.println("Selecciona tu opción:");

            if (scanner.hasNextInt()) // Verifica si la entrada es un número
            {
                opcion = scanner.nextInt();

                // Manejo de opciones
                switch (opcion) 
                {
                    case 1:
                        System.out.println("\nTienes en tu cuenta $" + saldo);
                        break;

                    case 2:
                        System.out.println("¿Cuántos pavos deseas sacar? $");
                        if (scanner.hasNextDouble()) // Verifica si la entrada es un número
                        {
                            double retiro = scanner.nextDouble();
                            if (retiro >= 0 && retiro <= saldo && retiro <= LIMITE_RETIRO_DIARIO) 
                            {
                                saldo -= retiro;
                                System.out.println("\n¡Repampanos! Retiraste pavos, tu nuevo saldo es de: " + saldo + " Pavos");
                            } 
                            else if (retiro > LIMITE_RETIRO_DIARIO) 
                            {
                                System.out.println("\nNo puedes retirar más de $" + LIMITE_RETIRO_DIARIO + " en un día.");
                            } 
                            else 
                            {
                                System.out.println("\n¡No tienes esos pavos para retirar! Tu saldo es de: " + saldo);
                            }
                        } 
                        else 
                        {
                            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
                            scanner.next(); // Descarta la entrada no válida
                        }
                        break;

                    case 3:
                        System.out.println("¿Cuántos pavos deseas depositar? $");
                        if (scanner.hasNextDouble()) // Verifica si la entrada es un número
                        {
                            double deposito = scanner.nextDouble();
                            if (deposito > 0) 
                            {
                                saldo += deposito;
                                System.out.println("\n¡Consignación exitosa! Tu nuevo saldo en pavos es de: " + saldo);
                            } 
                            else 
                            {
                                System.out.println("\nEl valor que ingresaste no es posible depositarlo");
                            }
                        } 
                        else 
                        {
                            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
                            scanner.next(); // Descarta la entrada no válida
                        }
                        break;

                    case 4:
                        System.out.println("\nTu límite de retiro diario es de: $" + LIMITE_RETIRO_DIARIO);
                        break;

                    case 5:
                        System.out.println("\nIngrese su nuevo PIN:");
                        if (scanner.hasNextInt()) // Verifica si la entrada es un número
                        {
                            int nuevoPin = scanner.nextInt();
                            pinCorrecto = nuevoPin;
                            System.out.println("\nPIN cambiado exitosamente.");
                        } 
                        else 
                        {
                            System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
                            scanner.next(); // Descarta la entrada no válida
                        }
                        break;

                    case 6:
                        System.out.println("\nGracias por visitarnos ¡Vuelve pronto!");
                        break;

                    default:
                        System.out.println("\nLa opción ingresada no es válida");
                        break;
                }
            } 
            else 
            {
                System.out.println("\nEntrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Descarta la entrada no válida
            }
        } 
        while (opcion != 6);
        scanner.close();
    }
}