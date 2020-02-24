package pima;

import java.util.ArrayList;

public class CalculoFuente
{
    private String txt;
    private ArrayList<String> arrSimbolos;
    private int cantidadSimbolos;

    //Constructor de la clase. Dentro inicializamos la variable global txt donde estará el texto a resolver
    //También se inicializarán los ArrayList necesarios para el programa
    public CalculoFuente(int cantidadSimbolos)
    {
        txt = "La noche cae, brumosa ya y morada.  "
				+ "Vagas claridades malvas y verdes perduran tras la torre de la iglesia.  "
				+ "El camino sube, lleno de sombras, de campanillas, de fragancia de hierba,  "
				+ "de canciones, de cansancio y de anhelo.";

        //En este arryList guardaremos los símbolos que componen el texto
        arrSimbolos = new ArrayList<String>();
        
        //Podremos pasar al programa un parámetro para sabe cada cuántas letras hay un símbolo. (Así tenemos en cuenta el caso del ejercicio 2)
        this.cantidadSimbolos = cantidadSimbolos; 
        
        llenarArraySimbolos();
    }

    //Método utilizado para meter el string txt en el arrSimbolos
    public void llenarArraySimbolos()
    {
        int cont = 0;

        while(cont < txt.length()) //Vamos a recorrer cada uno de los caracteres que forman el texto.
        {
            String aux = "";

            for(int j = 0; j < cantidadSimbolos; j++) //En función de cada cuántos caracteres se componga un símbolo...
            {
                if(cont < txt.length()) //Comprobamos que no hayamos llegado al final del texto (en caso de que este no tenga una longitud tal que pueda dividirse con decimales)
                {
                    aux = aux + String.valueOf(txt.charAt(cont)); //iremos formando Strings para cada símbolo (en función de la longitud que nos hayan dicho que tienen los símbolos)
                    cont++;
                }
            }

            arrSimbolos.add(aux);  //Una vez formado el símbolo lo añadimos al arraylist y así hasta que terminemos el texto
        }
    }

    //Con este método calcularemos cuántas veces se repite cada símbolo.
    public void resolver() 
    {
        ArrayList<String> cadaSimbolo = new ArrayList<String>(); //Aquí guardaremos de forma individual cada uno de los símbolos existentes en el texto.
        ArrayList<Integer> arrCounter = new ArrayList<Integer>(); //En este arrayList guardarmeos un contador para cada posición de los símbolos del anterior arraylist que aumentará para cada símbolo cuando estos se repitan

        for(int i = 0; i < arrSimbolos.size(); i++) //Recorremos el array que contiene todos los símbolos
        {
            if(cadaSimbolo.size() == 0) //Si es el primer símbolo de todos lo añadimos directamente porque no puede estar ya dentro (el array está vacío aún)
            {
                cadaSimbolo.add(arrSimbolos.get(i));
                arrCounter.add(1);
            }
            else  //Si no es el primer símbolo del texto
            {
                boolean comprobacion = false; //Flag para saber si un símbolo está ya dentro de nuestro array de únicos o no

                for(int j = 0; j < cadaSimbolo.size(); j++) //Recorremmos nuestro array de símbolos únicos para comprobar si ha sido añadido ya o no
                {
                    if(cadaSimbolo.get(j).equals(arrSimbolos.get(i))) //Si el símbolo ya está dentro del array
                    {
                        int aux = arrCounter.get(j) + 1; //Aumentamos el contador de esa posición para ese símbolo
                        arrCounter.set(j, aux); //Y sustituimos el valor (vamos, como hacer counter++);
                        comprobacion = true; //Cambiamos el flag para indicar que el símbolo estaba
                    }
                }

                if(!comprobacion) //Si al terminar de comprobar ese símbolo para cada uno de los que ya tenemos guardados, vemos que no ha coincidido, lo añadiremos
                {
                    cadaSimbolo.add(arrSimbolos.get(i));
                    arrCounter.add(1); //Y le creamos su contador
                }
            }
        }
        
        for(int i = 0; i < cadaSimbolo.size(); i++)
        {
        	System.out.print(cadaSimbolo.get(i));
        }
        
        System.out.println("\n");
        
        
        for(int i = 0; i < cadaSimbolo.size(); i++)
        {
        	System.out.print(arrCounter.get(i) + " ");
        }
        
    }
}