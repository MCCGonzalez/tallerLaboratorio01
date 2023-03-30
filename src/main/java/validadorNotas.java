import java.util.Random;
import java.util.Scanner;

public class validadorNotas {

    public static void main(String[] args){

        double[][] estudiantes = new double[50][5];
        int cantidadEstudiantes = 0;

        inicio(estudiantes, cantidadEstudiantes);
    }

    private static void inicio(double[][] estudiantes, int cantidadEstudiantes){

        System.out.println("Bienbenido, ingrese un numero"
        + "\n1) ingresar notas estudiantes"
        + "\n2) ingresar"
        + "\n3) ingresar");

        entrada(estudiantes, cantidadEstudiantes);
    }

    public static void entrada(double[][] estudiantes, int cantidadEstudinates){

        boolean continuar = false;
        Scanner sc = new Scanner(System.in);
        int entrada = 0;

        do{
            System.out.println("ingrese un numero");
            if(sc.hasNextInt()){
                entrada = sc.nextInt();
                if(entrada > 0 && entrada < 4){
                    continuar = true;
                }
            }else{
                sc.nextLine();
                System.out.println("ingrese un valor valido");
            }
        }while(!continuar);

        menu(entrada, estudiantes, cantidadEstudinates);
    }

    public static void menu(int entrada, double[][] estudiantes, int cantidadEstudiantes){

        switch(entrada){

            case 1:cantidadEstudiantes(cantidadEstudiantes);
                   ingresarEstudiante(estudiantes, cantidadEstudiantes);
                   entrada(estudiantes, cantidadEstudiantes);
            case 2:mostrarNotasEstudiantes(estudiantes);
            case 3:
        }
    }
    public static int cantidadEstudiantes(int cantidadEstudiantes){

        cantidadEstudiantes++;

        return cantidadEstudiantes;
    }
    public static double[][] ingresarEstudiante(double[][] estudiantes, int cantidadEstudiantes){

        Random random = new Random();


        do{

            //System.out.println("se ingresan muchos estudiantes");

            for(int fila = 0;  fila < estudiantes.length; fila++){
                for(int columna = 0; columna < estudiantes[fila].length; columna++){

                    estudiantes[fila][columna] = random.nextDouble(7)*10.0/10.0;
                }
            }

        }while(cantidadEstudiantes == 0);

        return estudiantes;
    }

    public static void mostrarNotasEstudiantes(double[][] estudiantes){

        for(int fila = 0; fila < estudiantes.length; fila++){
            for(int columna = 0; columna < estudiantes[fila].length; columna++){

                System.out.print(estudiantes + "   ");
            }
            System.out.println();
        }

    }
}
