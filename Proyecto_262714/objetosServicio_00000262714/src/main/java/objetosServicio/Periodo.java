package objetosServicio;

import java.text.SimpleDateFormat;

/**
 * La clase Periodo extiende la clase Fecha y representa un intervalo de tiempo
 * definido por dos fechas: "desde" y "hasta". Proporciona métodos para verificar
 * si una fecha está dentro de ese período y para obtener las fechas de inicio y fin del período.
 */
public class Periodo extends Fecha {

    private Fecha desde; // Fecha de inicio del periodo.
    private Fecha hasta; // Fecha de fin del periodo.

    /**
     * Constructor que inicializa el periodo con dos fechas: "desde" y "hasta".
     *
     * @param desde Fecha de inicio del período.
     * @param hasta Fecha de fin del período.
     */
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * Verifica si una fecha específica está contenida dentro del período, es decir,
     * si la fecha está entre la fecha de inicio (desde) y la fecha de fin (hasta).
     *
     * @param fecha Fecha a verificar.
     * @return {@code true} si la fecha está dentro del período, {@code false} en caso contrario.
     */
    public boolean contiene(Fecha fecha) {
        return !fecha.before(this.desde) && !fecha.after(this.hasta);
    }

    /**
     * Obtiene la fecha de inicio del periodo.
     *
     * @return La fecha de inicio del período.
     */
    public Fecha getDesde() {
        return desde;
    }

    /**
     * Establece la fecha de inicio del periodo.
     *
     * @param desde Nueva fecha de inicio del período.
     */
    public void setDesde(Fecha desde) {
        this.desde = desde;
    }

    /**
     * Obtiene la fecha de fin del periodo.
     *
     * @return La fecha de fin del período.
     */
    public Fecha getHasta() {
        return hasta;
    }

    /**
     * Establece la fecha de fin del periodo.
     *
     * @param hasta Nueva fecha de fin del período.
     */
    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }

    /**
     * Devuelve una representación en cadena del periodo en el formato "dd/MM/yyyy - dd/MM/yyyy".
     *
     * @return Cadena representando el período en formato "dd/MM/yyyy - dd/MM/yyyy".
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(this.desde.getTime()) + " - " + formato.format(this.hasta.getTime());
    }
}
