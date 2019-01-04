package TareasAdimistracion.Proyecto;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {
	private static UserService userService = new UserService();
	public static Map cities = new HashMap<>();
    private static ObjectMapper om = new ObjectMapper();

	public UserController(final UserService userService) {
		// Start embedded server at this port
        port(8080);
 
        // Main Page, welcome
        get("/", (request, response) -> "Bienvendio al Administrador de Tareas");
 
        // GET - Give me user with this id
        get("/user/:id", (request, response) -> {
            User user = userService.findById(request.params(":id"));
            if (user != null) {
                return om.writeValueAsString(user);
            } else {
                response.status(404); // 404 Not found
                return om.writeValueAsString("user not found");
            }
        });
 
        // Get - Give me all users
        get("/user", (request, response) -> {
            List result = userService.findAll();
            if (result.isEmpty()) {
                return om.writeValueAsString("user not found");
            } else {
                return om.writeValueAsString(userService.findAll());
            }
        });
	}

}
