package org.example;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("==== conversor de divisas ====");
        Scanner sc = new Scanner(System.in);

        ConvertidorDivisas conv = new ConvertidorDivisas();
        int opcion = 0;
        do{
            
            String menu =
                            "\n1) Dólar estadounidense =>> Peso Argentino \n" +
                            "2) Peso Argentino ==> Dólar \n" +
                            "3) Dólar ==> Real brasileño \n" +
                            "4) Real brasileño =>> Dólar \n" +
                            "5) Dólar ==> Peso colombiano\n" +
                            "6) Peso colombiano ==> Dólar \n" +
                            "7) Dólar ==> Peso mexicano \n" +
                            "8) Peso mexicano ==> Dólar \n" +
                            "9) Salir \n";
            System.out.println(menu);
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 9)  {
                System.out.println("Saliendo del sistema....");
            }
            else{
                conv.setApi_url("https://v6.exchangerate-api.com/v6/d38ca9265b908bfa779f20b0/pair/");
                System.out.println("Ingrese la cantidad a convertir: ");
                double cantidad = sc.nextDouble();

                switch (opcion){
                    case 1:

                        conv.setPaisOrigenDivisa("USD");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("ARG");

                        String resConversion = conv.Conversion();
                        System.out.println(resConversion);
                        break;

                    case 2:
                        conv.setPaisOrigenDivisa("ARG");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("USD");

                        String resConversion2 = conv.Conversion();
                        System.out.println(resConversion2);
                        break;

                    // Dólar ==> Real brasileño
                    case 3:

                        conv.setPaisOrigenDivisa("USD");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("BRL");

                        String resConversion3 = conv.Conversion();
                        System.out.println(resConversion3);
                        break;

                    case 4:
                        conv.setPaisOrigenDivisa("BRL");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("USD");

                        String resConversion4 = conv.Conversion();
                        System.out.println(resConversion4);
                        break;

                    case 5:

                        conv.setPaisOrigenDivisa("USD");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("COL");

                        String resConversion5 = conv.Conversion();
                        System.out.println(resConversion5);
                        break;

                    case 6:
                        conv.setPaisOrigenDivisa("COL");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("USD");

                        String resConversion6 = conv.Conversion();
                        System.out.println(resConversion6);
                        break;

                    case 7:

                        conv.setPaisOrigenDivisa("USD");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("MXN");

                        String resConversion7 = conv.Conversion();
                        System.out.println(resConversion7);
                        break;

                    case 8:
                        conv.setPaisOrigenDivisa("MXN");
                        conv.setCantidadConvertir(cantidad);
                        conv.setPaisDestinoDivisa("USD");

                        String resConversion8 = conv.Conversion();
                        System.out.println(resConversion8);
                        break;
                }
            }


        }while (opcion!=9);

        sc.close();
    }
}