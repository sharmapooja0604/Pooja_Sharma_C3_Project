import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        Iterator<Restaurant> it = restaurants.iterator();
        Restaurant found = null;
        while (it.hasNext()) {
            Restaurant restaurant = it.next();
            if (restaurant.getName().equals(restaurantName)) {
                found = restaurant;
                break;
            }
        }
        if (found == null) {
            throw new restaurantNotFoundException(restaurantName);
        } else {
            return found;
        }
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public int getCartValue(Restaurant restaurant, List<String> selectedItems) {

        return restaurant.getOrderTotal(selectedItems);
    }
}
