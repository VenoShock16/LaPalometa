/**
 * Model a location in a city.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Location extends assignments
{
    private int x;  //TODO cambiar a private
    private int y;  //TODO cambiar a private


    /**
     * Model a location in the city.
     * @param x The x coordinate. Must be positive.
     * @param y The y coordinate. Must be positive.
     * @throws IllegalArgumentException If a coordinate is negative.
     */
    public Location(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                "Negative x-coordinate: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                "Negative y-coordinate: " + y);
        }        
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return The y coordinate.
     */
    public int getY()
    {    
        return y;
    }

    /**
     * Generate the next location to visit in order to
     * reach the destination.
     * @param destination Where we want to get to.
     * @return A location in a direct line from this to
     *         destination.
     */
    public Location nextLocation(Location destination)
    {
        //TODO ahora mismo este método devuelve directamente el destino final
        //PERO DEBERIA ir calculando y devolviendo la siguiente posición por la que 
        // va pasando el taxi hasta llegar al destino
        Location aux= new Location(getX(),getY());
        if(getX()!= destination.getX()){
            if(getX()<destination.getX()){
                aux.setX(getX()+1);
            }
            else{
                aux.setX(getX()-1);
            }
            
        }
        if(getY()!=destination.getY()){
            if(getY()<destination.getY()){
                aux.setY(getY()+1);
            }
            else{
                aux.setY(getY()-1);
            }            
        }
        return aux;
    }

    /**
     * Determine the number of movements required to get
     * from here to the destination.
     * @param destination The required destination.
     * @return the number of movement steps.
     */
    public int distance(Location destination)
    {
        int x2= Math.abs(destination.getX()-getX());
        int y2= Math.abs(destination.getY()-getY());
        if(x2>y2)
        return x2;
        else
        return y2;

    }

    /**
     * Implement content equality for locations.
     * @return true if this location matches the other, false otherwise.
     */
    public boolean equals(Object other)
    {
        if(other instanceof Location) {
            Location otherLocation = (Location) other;
            return x == otherLocation.getX() &&
            y == otherLocation.getY();
        }
        else {
            return false;
        }
    }

    /**
     * @return A representation of the location.
     */
    public String toString()
    {
        return "location " + x + "," + y;
    }

    /**
     * Use the top 16 bits for the y value and the bottom for the x.
     * Except for very big grids, this should give a unique hash code
     * for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
    
   public void setY(int n){
       this.y=n;
   }
   
      public void setX(int n){
       this.x=n;
   } 
    public boolean areAdjacent(Location l1, Location l2){
        int posX = Math.abs(l1.getX() - l2.getX());
        int posY = Math.abs(l1.getY() - l2.getY());
        return (posX <= 1 && posY <= 1) && (posX + posY == 1);
        
   }
}
