
/**
 * Enumeration class FuelConsumption - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum FuelConsumption
{
    HIGH("High",8), MEDIUM("Medium",6), LOW ("Low", 4);
    
    private int valor;
    private String nombre;
    
    /**
     * Constructor of enum FuelConsuption
     */
    FuelConsumption(String nombre, int valor)
    {
    this.nombre=nombre;    
    this.valor=valor;
    }

    /**
     * @return valor
     */
    public int getValor()
    {
    return valor;
    }
    
    /**
     * @return nombre
     */
        public String getNombre()
    {
    return nombre;
    }
    
    /**
     * Sets valor
     */
    public void setValor(int valor)
    {
    this.valor=valor;
    }
}
