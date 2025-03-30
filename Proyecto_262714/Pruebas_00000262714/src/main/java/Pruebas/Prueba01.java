package Pruebas;

import objetosServicio.Fecha;
import objetosServicio.Periodo;

import java.util.Calendar;

/**
 * Clase de prueba para la funcionalidad de las clases Fecha y Periodo.
 */
public class Prueba01 {
    public static void main(String[] args) {
        /*
        a. Crea dos objetos de tipo Fecha llamados: hoy y ayer e inicializarlos a las fechas del sistema y a 15/08/2030, respectivamente.
         */
        Fecha ayer = new Fecha(15,8,2030);
        Fecha hoy = new Fecha();

        /*
        b. Crea un objeto de tipo Fecha: manhana copiándolo del objeto hoy.
         */
        Fecha manhana = new Fecha(hoy);

        /*
        c. Cambia el año de manhana agregándole un año.
         */
        manhana.add(Calendar.YEAR,1);

        /*
        d. Despliega las tres fechas.
         */
        System.out.println(ayer);
        System.out.println(hoy);
        System.out.println(manhana);

        /*
        e. Despliega el mes de hoy.
         */
        System.out.println(hoy.getMes());

        /*
        f. Cambia la fecha ayer a 12/06/2018.
         */
        ayer = new Fecha("12/6/2018");

        /*
        g. Despliega la fecha ayer.
         */
        System.out.println(ayer);

        /*
        h. Despliega un mensaje con el número de días entre hoy y manhana. Ambas fechas aparecen en el mensaje.
         */
        System.out.println("La cantidad de días entre " + hoy + " y " + manhana + " es de " + hoy.lapso(manhana) + " días");

        /*
        i. Despliega un mensaje indicando si hoy es diferente de hoy. Ambas fechas aparecen en el mensaje.
         */
        if (hoy.equals(hoy)) {
            System.out.println(hoy + " es igual a " + hoy);
        } else {
            System.out.println(hoy + " es diferente a " + hoy);
        }

        /*
        j. Despliega un mensaje indicando si ayer está después o es igual a manhana. Ambas fechas aparecen en el mensaje.
         */
        if (ayer.before(manhana)) {
            System.out.println("La fecha " + ayer + " es antes que " + manhana);
        } else if (ayer.after(manhana)) {
            System.out.println("La fecha " + ayer + " es después que " + manhana);
        } else {
            System.out.println("La fecha " + ayer + " y la fecha " + manhana + " son iguales");
        }

        /*
        k. Despliega un mensaje indicando si hoy es antes que manhana. Ambas fechas aparecen en el mensaje.
         */
        if (hoy.before(manhana)) {
            System.out.println("La fecha " + hoy + " es antes que " + manhana);
        } else if (hoy.after(manhana)) {
            System.out.println("La fecha " + hoy + " es después que " + manhana);
        } else {
            System.out.println("La fecha " + hoy + " y la fecha " + manhana + " son iguales");
        }

        /*
        l. Crea un objeto de tipo Periodo llamado periodo que va desde 05/02/2015 a hoy.
         */
        Periodo periodo = new Periodo(new Fecha("05/02/2015"), hoy);

        /*
        m. Despliega periodo.
         */
        System.out.println(periodo);

        /*
        n. Despliega un mensaje indicando si ayer está dentro de periodo. Tanto la fecha como el periodo aparecen en el mensaje.
         */
        if (periodo.contiene(ayer)) {
            System.out.println("La fecha " + ayer + " sí está dentro del período " + periodo);
        } else {
            System.out.println("La fecha " + ayer + " no está dentro del período " + periodo);
        }
    }
}
