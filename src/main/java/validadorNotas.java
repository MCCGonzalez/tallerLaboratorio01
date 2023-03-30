import java.util.Random;
import java.util.Scanner;

public class validadorNotas {

    public static void main(String[] args){

        variablesIniciales();
    }
    public static void variablesIniciales(){

        double[][] estudiantes = new double[50][5];
        int cantidadEstudiantes = 0;

        inicio(estudiantes, cantidadEstudiantes);
    }

    private static void inicio(double[][] estudiantes, int cantidadEstudiantes){

        System.out.println("Bienvenido, ingrese un numero"
        + "\n1) ingresar notas estudiantes"
        + "\n2) ver notas estudiantes"
        + "\n3) estudiantes aprobados"
        + "\n4) estudiantes reprobados"
        + "\n5) estudiantes que van a examen"
        + "\n6) estado del estudiante"
        + "\n7) salir");

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
                   inicio(estudiantes, cantidadEstudiantes);
            case 2:mostrarNotasEstudiantes(estudiantes);
            case 3:estudiantesAprobados(estudiantes);
            case 4:estudiantesReprobados(estudiantes);
            case 5:estudiantesExamen(estudiantes);
            case 6:estadoEstudiante(estudiantes);
            case 7:salir();
        }
    }
    public static int cantidadEstudiantes(int cantidadEstudiantes){

        Random random = new Random();

        if(cantidadEstudiantes == 0) {

            cantidadEstudiantes += random.nextInt(50) + 1;
            System.out.println(cantidadEstudiantes);

        }
            cantidadEstudiantes ++;

        return cantidadEstudiantes;
    }
    public static double[][] ingresarEstudiante(double[][] estudiantes, int cantidadEstudiantes){

        Random random = new Random();

            for (int fila = 0; fila < cantidadEstudiantes; fila++) {
                for (int columna = 0; columna < estudiantes[fila].length; columna++) {

                    estudiantes[fila][columna] = Math.round(random.nextDouble(7) * 10.0) / 10.0;
                }
            }

        return estudiantes;
    }

    public static void mostrarNotasEstudiantes(double[][] estudiantes){

        for(int fila = 0; fila < estudiantes.length; fila++){
            for(int columna = 0; columna < estudiantes[fila].length; columna++){

                System.out.print(estudiantes[fila][columna] + "   ");
            }
            System.out.println();
        }

    }
    public static void estudiantesAprobados(double[][] estudiantes){

        int estudiantesAprobados = 0;
        int notaEstudiante = 0;

        for(int fila = 0; fila < estudiantes.length; fila++){
            for(int columna = 0; columna < estudiantes[fila].length; columna ++){

                notaEstudiante += estudiantes[fila][columna];
            }
            notaEstudiante /= 5;
            if(notaEstudiante >= 3.94){
                estudiantesAprobados ++;
            }
        }
        System.out.println("estudiantes aprobados: " + estudiantesAprobados);
    }
    public static void estudiantesReprobados(double[][] estudiantes){

        int estudiantesReprobados = 0;
        int notaEstudiante = 0;

        for(int fila = 0; fila < estudiantes.length; fila++){
            for(int columna = 0; columna < estudiantes[fila].length; columna ++){

                notaEstudiante += estudiantes[fila][columna];
            }
            notaEstudiante /= 5;
            if(notaEstudiante <= 3.54){
                estudiantesReprobados ++;
            }
        }
        System.out.println("estudiantes reporbados: " + estudiantesReprobados);
    }
    public static void estudiantesExamen(double[][] estudiantes){

        int estudiantesExamen = 0;
        int notaEstudiante = 0;

        for(int fila = 0; fila < estudiantes.length; fila++){
            for(int columna = 0; columna < estudiantes[fila].length; columna ++){

                notaEstudiante += estudiantes[fila][columna];
            }
            notaEstudiante /= 5;
            if(notaEstudiante > 3.54 && notaEstudiante <= 3.94){
                estudiantesExamen++;
            }
        }
        System.out.println("estudiantes que van a examen: " + estudiantesExamen);
    }
    public static void estadoEstudiante(double[][] estudiantes){

        Scanner sc = new Scanner(System.in);
        int estudiante = sc.nextInt();
        int promedio = 0;

        for(int pocision = 0; pocision < estudiantes[estudiante].length; pocision++){

            promedio += estudiantes[estudiante][pocision];
        }
        promedio /= 5;

        if(promedio > 0 && promedio <= 3.54){

            System.out.println("el estudiante reprobo");

        }else if(promedio > 3.54 && promedio <= 3.94 ){

            System.out.println("El estudiante va a examen");
        }else if(promedio > 3.94 && promedio <= 7.0){

            System.out.println("el estudiante aprobo");
        }else{
            System.out.println("El promedio no es valido");
        }
    }
    public static void salir(){
        
        System.exit(1);
    }
}

