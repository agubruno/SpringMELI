package TareasAdimistracion.Proyecto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CityService {
	
	public static Map cities = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger(0);
    
    public City findById(String id) {
        return (City) cities.get(id);
    }
 
    public City add(String name) {
        int currentId = count.incrementAndGet();
        City city = new City(currentId, name);
        cities.put(String.valueOf(currentId), city);
        return city;
    }

}
