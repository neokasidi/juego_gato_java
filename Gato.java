package gato;

import java.util.Scanner;

public class Gato {

    private static String[] dato1;
    private static String[] dato2;
    private static String[] dato3;

    public static void main(String[] args) {
        int numeroFila;
        int numeroColumna;
        String opcion;

        tablero(null, null, null);

        int ok = 0;
        int i = 1;
        while (ok < 1) {

            numeroFila = fila();
            numeroColumna = columna();

            if (i % 2 == 0) {
                opcion = "X";
            } else {
                opcion = "O";
            }
            if (validaCampo(numeroFila, numeroColumna)) {
                boolean retorno = ingresoDatos(numeroFila, numeroColumna, opcion);
                if(!retorno)
                {
                    ok = 2;
                    System.out.println("FIN del JUEGO!!!");
                }
                i++;
            } else {
                System.out.println("Campo Ocupado, debe escoger otro");
                if (validarSalida()) {
                    break;
                }                
            }

        }
    }

    public static boolean ingresoDatos(int fila, int posicion, String entrada) {

        posicion = posicion - 1;

        switch (fila) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    if (i == posicion) {
                        dato1[i] = entrada;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    if (i == posicion) {
                        dato2[i] = entrada;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    if (i == posicion) {
                        dato3[i] = entrada;
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        
        String gano = validarGanadas();
        
        if (gano.isEmpty()) {
            tablero(dato1, dato2, dato3);
            return true;
        }
        else
        {
            System.out.println(gano);
            System.out.println("-----------------------------------------------------");
            System.out.println("|" + dato1[0] + "|" + dato1[1] + "|" + dato1[2] + "|");
            System.out.println("|" + dato2[0] + "|" + dato2[1] + "|" + dato2[2] + "|");
            System.out.println("|" + dato3[0] + "|" + dato3[1] + "|" + dato3[2] + "|");
            System.out.println("-----------------------------------------------------");
            System.out.println("");
            return false;
        }
        
    }

    public static void tablero(String[] entrada1, String[] entrada2, String[] entrada3) {

        if (entrada1 == null && entrada2 == null && entrada3 == null) {
            dato1 = new String[]{"-", "-", "-"};
            dato2 = new String[]{"-", "-", "-"};
            dato3 = new String[]{"-", "-", "-"};
        } else {
            dato1 = entrada1;
            dato2 = entrada2;
            dato3 = entrada3;
        }

        System.out.println("|" + dato1[0] + "|" + dato1[1] + "|" + dato1[2] + "|");
        System.out.println("|" + dato2[0] + "|" + dato2[1] + "|" + dato2[2] + "|");
        System.out.println("|" + dato3[0] + "|" + dato3[1] + "|" + dato3[2] + "|");
        System.out.println("");
    }

    public static int fila() {

        String entrada = "0";
        Scanner entradaTeclado = new Scanner(System.in);
        int ok = 0;
        while (ok < 1) {
            System.out.println("Ingrese Fila:");
            entrada = entradaTeclado.nextLine();

            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                ok = 2;
            } else {
                System.out.println("Debe ingresar una fila de 1 al 3");
            }
        }

        return Integer.parseInt(entrada);
    }

    public static int columna() {

        String entrada = "0";
        Scanner entradaTeclado = new Scanner(System.in);
        int ok = 0;
        while (ok < 1) {
            System.out.println("Ingrese Columna:");
            entrada = entradaTeclado.nextLine();

            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                ok = 2;
            } else {
                System.out.println("Debe ingresar una Columna de 1 al 3");
            }
        }
        return Integer.parseInt(entrada);
    }

    public static boolean validaCampo(int linea, int columna) {
        
        boolean valida = false;
        columna = columna-1;
        
        if (linea == 1) {
            if (dato1[columna].equals("-")) {
                valida = true;
            }
        }
        if (linea == 2) {
            if (dato2[columna].equals("-")) {
                valida = true;
            }
        }
        if (linea == 3) {
            if (dato3[columna].equals("-")) {
                valida = true;
            }
        }
        return valida;
    }
    
    public static String validarGanadas()
    {
        String ganador = "";
       if(dato1[0].equals("X") && dato1[1].equals("X") && dato1[2].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[0].equals("O") && dato1[1].equals("O") && dato1[2].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato2[0].equals("X") && dato2[1].equals("X") && dato2[2].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato2[0].equals("O") && dato2[1].equals("O") && dato2[2].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato3[0].equals("X") && dato3[1].equals("X") && dato3[2].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato3[0].equals("O") && dato3[1].equals("O") && dato3[2].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato1[0].equals("X") && dato2[0].equals("X") && dato3[0].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[0].equals("O") && dato2[0].equals("O") && dato3[0].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato1[1].equals("X") && dato2[1].equals("X") && dato3[1].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[1].equals("O") && dato2[1].equals("O") && dato3[1].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato1[2].equals("X") && dato2[2].equals("X") && dato3[2].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[2].equals("O") && dato2[2].equals("O") && dato3[2].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato1[0].equals("X") && dato2[1].equals("X") && dato3[2].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[0].equals("O") && dato2[1].equals("O") && dato3[2].equals("O")){
           ganador = "El señor O es el ganador";
       }
       if(dato1[2].equals("X") && dato2[1].equals("X") && dato3[0].equals("X")){
           ganador = "El señor X es el ganador";
       }
       if(dato1[2].equals("O") && dato2[1].equals("O") && dato3[0].equals("O")){
           ganador = "El señor O es el ganador";
       }
       
       return ganador;
    }
    
    public static boolean validarSalida()
    {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);        
        int opcion = 0;
        String respuesta;
        
        while(opcion < 1){
            System.out.println("======================");
            System.out.println("Desea salir? (si o no)");
            respuesta = consola.nextLine().toLowerCase();
            
            switch(respuesta){
            case "si":
                salir = true;
                opcion = 2;
                break;
            case "no":
                salir = false;
                opcion = 2;
                break;
            default:
                System.out.println("*****Debe ingresar si o no!!****");
                break;
            }
        }        
        return salir;
    }
}