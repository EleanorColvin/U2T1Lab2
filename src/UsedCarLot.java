import java.util.ArrayList;
/**
 * This class represents a UsedCarLot object
 *
 * @author Eleanor Colvin
 */
public class UsedCarLot {
    /** ArrayList; contains inventory of used cars */
    private ArrayList<Car> inventory;

    /**
     * Instantiates a usedCarLot object.
     */
    public UsedCarLot()
    {
        inventory = new ArrayList<Car>();
    }

    /**
     * Returns the contents of ArrayList inventory
     *
     * @return The ArrayList inventory
     */
    public ArrayList<Car> getInventory()
    {
        return inventory;
    }

    /**
     * Adds a new Car object to inventory
     *
     * @param car the car object to be added to inventory
     */
    public void addCar(Car car)
    {
        inventory.add(car);
    }

    /**
     * Swaps the indices of 2 cars in inventory
     *<p>
     * Returns true if indices are successfully swapped
     * <p>
     * If either idx1 or idx2 are negative or greater than the index of the last object in inventory, returns false
     * <p>
     * If idx1 and idx2 are valid in inventory, a Car variable temp is assigned to idx1, the Car at idx1 in inventory
        is assigned to idx2 and the Car at temp is inventory is assigned to idx2
     * @return True if idx1 and idx2 are successfully swapped
     * @return False if either idx1, idx2, or both are not valid indices for inventory
     * @param idx1 the index of the first car object
     * @param idx2 the index of the second car object
     */
    public boolean swap(int idx1, int idx2)
    {
        if (idx1 < 0|| idx2 < 0 || idx1 > inventory.size() - 1 || idx2 > inventory.size() - 1)
        {
            return false;
        }
        else
        {
            Car temp = inventory.get(idx1);
            inventory.set(idx1, inventory.get(idx2));
            inventory.set(idx2, temp);
            return true;
        }
    }

    /** Adds a Car to the inventory list at the index specified
      by indexToAdd; this method increases the size of inventory by 1
     *<p>
     * PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     *
     * @param carToAdd the Car object being added to inventory
     * @param indexToAdd the index at which carToAdd will be added to inventory
  */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        inventory.add(indexToAdd, carToAdd);
    }

    /** "sells" the Car located at indexOfCarToSell which
        removes it from the inventory list and shifting the remaining
        Cars in the inventory list to the left to fill in the gap;
        this method reduces the size of inventory by 1
     *<p>
       * PRECONDITION: 0 &lt;= indexOfCarToSell &lt; inventory.size()
       *@return the Car that is being "sold" (removed from lot)

       * @param indexOfCarToSell the index of the car to be "sold" and removed from inventory
      */
    public Car sellCarShift(int indexOfCarToSell)
    {
        return (inventory.remove(indexOfCarToSell));
    }

    /** "sells" the Car located at indexOfCarToSell,
       and replaces the Car at indexOfCarToSell
       with null, maintaining the size of inventory
     *<p>
      * PRECONDITION: 0 &lt;= indexOfCarToSell &lt; inventory.size()

     *@return the Car object that is being sold
     *
     * @param indexOfCarToSell the index of the car to be "sold" and replaced with null
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car car = inventory.get(indexOfCarToSell);
        inventory.set(indexOfCarToSell, null);
        return car;
    }

    /** moves Car located at index indexOfCarToMove to index destinationIndex
     * <p>
     * If destinationIndex &lt; indexOfCarToMove, moves the Car to the right in
       inventory
     * <p>
     * If destinationIndex &lt; indexOfCarToMove, moves the Car to the left in the inventory. All other cars in the inventory
       should shift accordingly
     *<p>
     * PRECONDITION: 0 &lt;= indexOfCarToMove &lt; inventory.size()
     * PRECONDITION: 0 &lt;= destinationIndex &lt; inventory.size()
     * @param indexOfCarToMove the index of the Car object that will be moved
     * @param destinationIndex the index that the Car object will move to
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        Car car = inventory.get(indexOfCarToMove);
        inventory.remove(indexOfCarToMove);
        inventory.add(destinationIndex, car);
    }
}
