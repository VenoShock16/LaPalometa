
/**
 * Enumeration class reliable - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum reliable
{
    HIGH(10), LOW (5);
    
    private int valor;
    
    reliable(int valor)
    {
    this.valor=valor;
    }
    public int getValor()
    {
    return valor;
    }
    public void setValor(int valor)
    {
    this.valor=valor;
    }
}
