package objetosServicio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La clase Fecha extiende la clase GregorianCalendar y proporciona métodos adicionales
 * para trabajar con fechas, como calcular vencimientos, obtener el lapso entre dos fechas,
 * y formatear la fecha a un formato de cadena.
 */
public class Fecha extends GregorianCalendar {

    /**
     * Constructor sin parámetros que inicializa la fecha con la fecha y hora actuales.
     */
    public Fecha() {
        super();
        set(Calendar.HOUR, 0);
        set(Calendar.MINUTE, 0);
        set(Calendar.MILLISECOND, 0);
    }

    /**
     * Constructor que inicializa la fecha con un año, mes y día específicos.
     *
     * @param dia  Día del mes.
     * @param mes  Mes del año (1-12).
     * @param anio Año.
     */
    public Fecha(int dia, int mes, int anio) {
        super(anio, mes - 1, dia);
        set(Calendar.HOUR, 0);
        set(Calendar.MINUTE, 0);
        set(Calendar.MILLISECOND, 0);
    }

    /**
     * Constructor de copia que crea una nueva instancia de Fecha a partir de otra fecha.
     *
     * @param fecha Objeto Fecha a copiar.
     */
    public Fecha(Fecha fecha) {
        super(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Constructor que inicializa la fecha a partir de una cadena con el formato "dd/MM/yyyy".
     *
     * @param fecha Cadena de fecha en formato "dd/MM/yyyy".
     */
    public Fecha(String fecha) {
        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]) - 1;
        int anio = Integer.parseInt(partes[2]);
        set(anio, mes, dia);
        set(Calendar.HOUR, 0);
        set(Calendar.MINUTE, 0);
        set(Calendar.MILLISECOND, 0);
    }

    /**
     * Establece la fecha a un año, mes y día específicos.
     *
     * @param dia  Día del mes.
     * @param mes  Mes del año (1-12).
     * @param anio Año.
     */
    public void setFecha(int dia, int mes, int anio) {
        set(anio, mes - 1, dia);
    }

    /**
     * Calcula la fecha de vencimiento sumando una cantidad de días, meses y años a la fecha actual.
     *
     * @param dias  Número de días a sumar.
     * @param mes   Número de meses a sumar.
     * @param anios Número de años a sumar.
     * @return Nueva fecha calculada.
     */
    public Fecha vencimiento(int dias, int mes, int anios) {
        Fecha fechaVencimiento = new Fecha(this);
        fechaVencimiento.add(Calendar.YEAR, anios);
        fechaVencimiento.add(Calendar.MONTH, mes);
        fechaVencimiento.add(Calendar.DAY_OF_MONTH, dias);
        return fechaVencimiento;
    }

    /**
     * Calcula la fecha de vencimiento sumando una cantidad de días y meses a la fecha actual.
     *
     * @param dias Número de días a sumar.
     * @param mes  Número de meses a sumar.
     * @return Nueva fecha calculada.
     */
    public Fecha vencimiento(int dias, int mes) {
        return vencimiento(dias, mes, 0);
    }

    /**
     * Calcula la fecha de vencimiento sumando solo una cantidad de días a la fecha actual.
     *
     * @param dias Número de días a sumar.
     * @return Nueva fecha calculada.
     */
    public Fecha vencimiento(int dias) {
        return vencimiento(dias, 0, 0);
    }

    /**
     * Calcula el lapso en días entre la fecha actual y otra fecha.
     *
     * @param desde Fecha con la que se comparará.
     * @return Número de días de diferencia.
     */
    public int lapso(Fecha desde) {
        return (int) ((desde.getTimeInMillis() - this.getTimeInMillis()) / (1000 * 60 * 60 * 24));
    }

    /**
     * Obtiene el año de la fecha.
     *
     * @return Año de la fecha.
     */
    public int getAnio() {
        return get(GregorianCalendar.YEAR);
    }

    /**
     * Obtiene el mes de la fecha.
     *
     * @return Mes de la fecha (1-12).
     */
    public int getMes() {
        return get(GregorianCalendar.MONTH) + 1;
    }

    /**
     * Obtiene el día del mes de la fecha.
     *
     * @return Día del mes.
     */
    public int getDia() {
        return get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * Establece el año de la fecha.
     *
     * @param anio Año a establecer.
     */
    public void setAnio(int anio) {
        set(GregorianCalendar.YEAR, anio);
    }

    /**
     * Establece el mes de la fecha.
     *
     * @param mes Mes a establecer (1-12).
     */
    public void setMes(int mes) {
        set(GregorianCalendar.MONTH, mes - 1);
    }

    /**
     * Establece el día del mes de la fecha.
     *
     * @param dia Día del mes a establecer.
     */
    public void setDia(int dia) {
        set(GregorianCalendar.DAY_OF_MONTH, dia);
    }

    /**
     * Convierte la fecha a una cadena con el formato "dd/MM/yyyy".
     *
     * @return Representación en cadena de la fecha en formato "dd/MM/yyyy".
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getTime());
    }
}
