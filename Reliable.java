
/**
 * Enumeration class Reliable - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Reliable
{
    HIGH("High",10), LOW ("Low", 5);
    
    private int valor;
    private String nombre;
    
    Reliable(String nombre, int valor)
    {
    this.nombre=nombre;    
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
