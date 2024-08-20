package ejemplolambdas;

/**
 * Programa principal que ordena un listado de personas en base a distintos criterios, empleando la clase
 * ComparadorPersona, una clase anónima, y también expresiones lambda. Incluso se combinan expresiones lambda
 * para hacer comparaciones compuestas
 */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("Enrique", 42));
        listaPersonas.add(new Persona("May", 41));

        // Ordenar de menor a mayor edad usando una clase tradicional

        ComparadorPersonas cp = new ComparadorPersonas();
        listaPersonas.sort(cp);
        System.out.println("Personas ordenadas de menor a mayor edad:");
        for(Persona p: listaPersonas)
        {
            System.out.println(p);
        }

        // Ordenar de mayor a menor edad usando una clase anónima

        listaPersonas.sort(new Comparator<Persona>()
        {
            @Override
            public int compare(Persona o1, Persona o2)
            {
                return o2.getEdad() - o1.getEdad();
            }
        });
        System.out.println("Personas ordenadas de mayor a menor edad:");
        for(Persona p: listaPersonas)
        {
            System.out.println(p);
        }

        // Ordenar por nombre (de menor a mayor) usando una expresión lambda

        listaPersonas.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
        System.out.println("Personas ordenadas por nombre:");
        for(Persona p: listaPersonas)
        {
            System.out.println(p);
        }

        // Ordenar por edad ascendente, y en caso de igualdad, por nombre

        Comparator<Persona> cEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();
        Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());

        listaPersonas.sort(cEdad.thenComparing(cNombre));
        System.out.println("Personas ordenadas por edad y luego por nombre:");
        for(Persona p: listaPersonas)
        {
            System.out.println(p);
        }
    }
}
