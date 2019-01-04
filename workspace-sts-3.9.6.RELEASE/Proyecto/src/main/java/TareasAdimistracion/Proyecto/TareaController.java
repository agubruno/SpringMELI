package TareasAdimistracion.Proyecto;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TareaController {
	
	private static TareaService tareaService = new TareaService();
    private static ObjectMapper om = new ObjectMapper();
    
    public TareaController(final TareaService tareaService) {
    	 // POST - Add a tarea
        post("/tarea/add", (request, response) -> {
        	
            String name = request.queryParams("name");
            String summary = request.queryParams("summary");
            String dateString = request.queryParams("date");
            String userString = request.queryParams("user");

            int user = Integer.parseInt(userString);	
            LocalDate date = LocalDate.parse(dateString);
            																									
            Tarea tarea = tareaService.add(name, summary, user, date);
            response.status(201); // 201 Created
            return om.writeValueAsString(tarea);
 
        });
 
        // GET - Give me user with this id
        get("/tarea/:id", (request, response) -> {
            Tarea tarea = tareaService.findById(request.params(":id"));
            if (tarea != null) {
                return om.writeValueAsString(tarea);
            } else {
                response.status(404); // 404 Not found
                return om.writeValueAsString("tarea not found");
            }
        });
 
        // Get - Give me all users
        get("/tarea", (request, response) -> {
            List result = tareaService.findAll();
            if (result.isEmpty()) {
                return om.writeValueAsString("tarea not found");
            } else {
                return om.writeValueAsString(tareaService.findAll());
            }
        });
 
        // PUT - Update user
        put("/tarea/:id", (request, response) -> {
            String id = request.params(":id");
            Tarea tarea = tareaService.findById(id);
            if (tarea != null) {
            	String name = request.queryParams("name");
	            String summary = request.queryParams("summary");
	            String dateString = request.queryParams("date");
	            String userString = request.queryParams("user");
	            int user = Integer.parseInt(userString);	
	            LocalDate date = LocalDate.parse(dateString);
	            																						
	            tareaService.update(id, name, summary, user, date);
                
                return om.writeValueAsString("tarea with id " + id + " is updated!");
            } else {
                response.status(404);
                return om.writeValueAsString("tarea not found");
            }
        });
 
        // DELETE - delete user
        delete("/tarea/:id", (request, response) -> {
            String id = request.params(":id");
            Tarea tarea = tareaService.findById(id);
            if (tarea != null) {
            	tareaService.delete(id);
                return om.writeValueAsString("tarea with id " + id + " is deleted!");
            } else {
                response.status(404);
                return om.writeValueAsString("tarea not found");
                }
            });
    }
}
