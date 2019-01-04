package TareasAdimistracion.Proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TareaService {

	public static Map tareas = new HashMap<>();
    private static final AtomicInteger count = new AtomicInteger(0);
 
    public Tarea findById(String id) {
        return (Tarea) tareas.get(id);
    }
 
    public Tarea add(String name, String summary, int user, LocalDate date) {
        int currentId = count.incrementAndGet();
        Tarea tarea = new Tarea(currentId, name, summary, user, date);
        tareas.put(String.valueOf(currentId), tarea);
        return tarea;
    }
 
    public Tarea update(String id, String name, String summary, int user, LocalDate date) {
 
        Tarea tarea = (Tarea) tareas.get(id);
        if (name != null) {
            tarea.setName(name);
        }
 
        if (summary != null) {
            tarea.setSummary(summary);
        }
        
        if (user != -1) {
            tarea.setUserOwner(user);
        }
        
        if (date != null) {
            tarea.setDate(date);
        }
        
        tareas.put(id, tarea);
 
        return tarea;
 
    }
 
    public void delete(String id) {
        tareas.remove(id);
    }
 
    public List findAll() {
        return new ArrayList<>(tareas.values());
    }
 
    public TareaService() {
    }
		
}
