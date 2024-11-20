package com.devseniorcode.nmanja;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    static Scanner sc = new Scanner(System.in);
    
    public static void starGame(){

        //Lista de palabras para adivinar

        var words = List.of("gato", "perro", "casa", "mesa", "sol", "flor", "luna", "pez", "agua", "vino", 
            "mariposa", "montaña", "caballo", "planeta", "ventana", "zapato", "cultura", 
            "escuela", "nublado", "guitarra", "arquitectura", "cronometro", "electricidad", 
            "otorrinolaringologo", "xilofono", "constelacion", "embarcadero", "jurisprudencia", 
            "termodinamica", "autoconciencia"); // Lista de palabras
        
             //entrada del usuario
            var rnd = new Random();  //Variable Aleatorio

            var playAgain = false;

            do { 

                //Me da una palabra de una posición aleatoria

                var word = words.get(rnd.nextInt(words.size())).toUpperCase(); //de la lista words, obtenga una palabra aleatoria. La posicion la damos colocando la clase random, que trae numeros desde 0 hasta la cantidad que haya en la lista y por ultimo, todo esto en mayusculas
                

                playGame(word);
                //Empieza el juego

                System.out.println("¿Desea jugar de nuevo? (S/N): ");
                var option = sc.nextLine();
                playAgain = !option.equalsIgnoreCase("N");


            } while (playAgain);
            System.out.println("Adiossss");
            sc.close();

    }

    // Métodos



    private static void playGame(String word){

        //Lista de letras probadas
        var guessed = new ArrayList<Character>();

        //Lista de letras de la palabra
        var letters = new ArrayList<Character>(word.length()); //guarda la longitud de la letra

        for (int i = 0; i < word.length(); i++) {
            letters.add('_');
        }   

        var errors = 0;
        var endGame = false;
        while(!endGame){


            //Mostrar en pantalla

            showScreen(letters, guessed, errors);

            //Pedir la letra del usuario

            System.out.println("Ingresa una letra: ");
            var letter = sc.nextLine().toUpperCase().charAt(0);

            if(word.indexOf(letter) != -1){  //Si no se encuentra en el indice, el indexOf devuelve -1
                guessed.add(letter);
                for (int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == letter){ //si encuentra la letra en palabras
                        letters.set(i, letter); //en la lista de las lineas, reemplace en el indice la letra adivinada // i=posicion letter = letra ingresada
                    }
                }
            }


            //Verificas la letra en la palabra
                //Si existe, agregamos la letra a la cadena adivinada
            //si no, 
                //incremento error
                //agrego una linea al muñeco del ahorcado


            //Verificar si ya perdió
                //Termina el juego
            //Verificar si ya ganó
                //Termina el juego

                endGame = true;



        }

    }

    private static void showScreen(List<Character> letters, List<Character> guessed, int errors){
        System.out.println("Palabra a adivinar: ");
        for(var letter : letters){      //Por cada caracter en la listra letters
            System.out.printf("%c ",letter);
        }
        System.out.println();

        System.out.println("Letras intentadas: ");
        for(var letter : guessed){      //Por cada caracter en la listra letters
            System.out.printf("%c ",guessed);
        }
        System.out.println();

        //Horca según el número de errores

        var draw = switch(errors){
            default -> """
                           +------+
                           |      |
                           |      
                           |     
                           |      
                           |     
                           |
                        +--+--+
                        |     |
                        """;
        };

        System.out.println(draw);
    }



}
