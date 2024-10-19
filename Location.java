/**
 * Model a location in a city.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2024.10.07 DP classes 
 */
public class Location
{
    private int x;
    private int y;

    /**
     * Model a location in the city.
     * @param x The x coordinate. Must be positive.
     * @param y The y coordinate. Must be positive.
     * @throws IllegalArgumentException If a coordinate is negative.
     */
    public Location(int x, int y)
    {
        int inferiorLimit=0;
        int superiorLimit=19;
        if(x<inferiorLimit || x>superiorLimit) {
            throw new IllegalArgumentException(
                "x-cordinate is not in range of("+inferiorLimit+"-"+superiorLimit+") the number introduce is: " + x);
        }
        if(y<inferiorLimit || y>superiorLimit) {
            throw new IllegalArgumentException(
                "y-cordinate is not in range of("+inferiorLimit+"-"+superiorLimit+") the number introduce is: " + y);
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
        int distanceInX = destination.getX()-getX();
        int distanceInY = destination.getY()-getY();
        int oneStepX=0;
        int oneStepY=0;
        
        if(distanceInX!=0){
            oneStepX = distanceInX/Math.abs(distanceInX);
        }
        
        if(distanceInY!=0){
            oneStepY = distanceInY/Math.abs(distanceInY);
        }
        Location location=new Location(this.getX()+oneStepX,this.getY()+oneStepY);
        return location;
    }
 
    /**
     * Determine the number of movements required to get
     * from here to the destination.
     * @param destination The required destination.
     * @return the number of movement steps.
     */
    public int distance(Location destination)
    {
        int distance=0;
        Location iterationLocation = this;
        while(!destination.equals(iterationLocation)){
            iterationLocation = iterationLocation.nextLocation(destination);
            distance++;
        }
        return distance;
    }
    
    /**
     * @return  string de las coordenadas separadas con un guion.
     */
    public String getStringConcatenateLocation(){
        return getX()+" - " +getY();
    }

    /**
     * @return A representation of the location.
     */
    public String toString()
    {
        return "location " + x + "," + y;
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
     * Use the top 16 bits for the y value and the bottom for the x.
     * Except for very big grids, this should give a unique hash code
     * for each (x, y) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (y << 16) + x;
    }
}
