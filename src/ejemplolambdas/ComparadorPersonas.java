package ejemplolambdas;

import java.util.Comparator;

/**
 * Comparador de personas definido a partir de una implementación "tradicional" de la interfaz Comparator
 * En este caso, compara dos personas por edad, en orden ascendente
 */

public class ComparadorPersonas implements Comparator<Persona>
{
    @Override
    public int compare(Persona o1, Persona o2)
    {
        return o1.getEdad() - o2.getEdad();
    }
}
