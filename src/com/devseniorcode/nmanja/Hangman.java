package com.devseniorcode.nmanja;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    public static void starGame(){

        //Lista de palabras para adivinar

        var words = List.of("gato", "perro", "casa", "mesa", "sol", "flor", "luna", "pez", "agua", "vino", 
            "mariposa", "montaña", "caballo", "planeta", "ventana", "zapato", "cultura", 
            "escuela", "nublado", "guitarra", "arquitectura", "cronometro", "electricidad", 
            "otorrinolaringologo", "xilofono", "constelacion", "embarcadero", "jurisprudencia", 
            "termodinamica", "autoconciencia");
        
            var sc = new Scanner(System.in);
            var rnd = new Random();

            var playAgain = false;

            do { 

                //Me da una palabra de una posición aleatoria

                var word = words.get(rnd.nextInt(words.size())).toUpperCase();
                System.out.println(word);


                //Empieza el juego

                System.out.println("¿Desea jugar de nuevo? (S7N): ");
                var option = sc.nextLine();
                playAgain = !option.equalsIgnoreCase("N");


            } while (playAgain);
            System.out.println("Adiossss");

    }

    private static void playGame(String word){

        //Lista de letras probadas
        var guessed = new ArrayList<Character>();
        //Lista de letras de la palabra
        var letters = new ArrayList<Character>(word.length());

        for (int i = 0; i < word.length(); i++) {
            letters.add('_');
        }

        var errors = 0;
        var endGame = false;
        while(!endGame){
            //Mostrar en pantalla

            //Pedir la letra del usuario
        }

    }

}
