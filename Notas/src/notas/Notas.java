/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Tiburcio
 */
public class Notas {
    final private static int NUM_ALUMNOS = 5;
    final private static int NUM_EVALUACIONES = 3;
    private static int notas[][] = new int[NUM_ALUMNOS][NUM_EVALUACIONES];
    private static TreeMap<String,Integer> alumnosTreeMap = new TreeMap<>();
    private static TreeMap<String,Integer> evaluacionesTreeMap = new TreeMap<>();
    
    public static void main(String[] args) {
        inicializarColecciones();
        mostrarAlumnoMedia();
        
        ArrayList<Alumno> alumnos = crearArrayListAlumnos();
        mostrarArrayAlumnos(alumnos);
    }
    
    static void mostrarAlumnoMedia(){
        int notaMedia;
        int posicionAlumno;
        boolean suspenso;
        for(String atm : alumnosTreeMap.keySet()){
            posicionAlumno = alumnosTreeMap.get(atm);
            notaMedia = 0;
            suspenso = false;
            for (int i = 0; i < NUM_EVALUACIONES; i++) {
                if(notas[posicionAlumno][i] >= 5){
                    notaMedia += notas[posicionAlumno][i];
                } else {
                    suspenso = true;
                    System.out.println("alumno :" + atm + ", suspenso");
                    break;
                } 
            }
            if(!suspenso){
                System.out.println("alumno :" + atm + ", " + (notaMedia / NUM_EVALUACIONES));
            }
        }
    }

    private static void inicializarColecciones() {
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            System.out.println("");
            System.out.println("alumno: " + i);
            for (int j = 0; j < NUM_EVALUACIONES; j++) {
                notas[i][j] = (int) (Math.random() * 9 + 1);
                System.out.print(", Nota: " + notas[i][j]);
            }
        }
        System.out.println("");
        
        alumnosTreeMap.put("Pepe0", 0);
        alumnosTreeMap.put("Juan1", 1);
        alumnosTreeMap.put("Roberto2", 2);
        alumnosTreeMap.put("Daniel3", 3);
        alumnosTreeMap.put("Soraya4", 4);
        
        evaluacionesTreeMap.put("1ª Evaluación", 0);
        evaluacionesTreeMap.put("2ª Evaluación", 1);
        evaluacionesTreeMap.put("3ª Evaluación", 2);  
    }
    
    static ArrayList<Alumno> crearArrayListAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        for(String atm : alumnosTreeMap.keySet()){
            alumnos.add(new Alumno(atm, notas[alumnosTreeMap.get(atm)][0]
                                      , notas[alumnosTreeMap.get(atm)][1]
                                      , notas[alumnosTreeMap.get(atm)][2]));
        }
        
        return alumnos;
    }
    
    static void mostrarArrayAlumnos(ArrayList<Alumno> alumnos){
        for(Alumno a : alumnos){
            System.out.println(a.toString());
        }
    }
    
}
