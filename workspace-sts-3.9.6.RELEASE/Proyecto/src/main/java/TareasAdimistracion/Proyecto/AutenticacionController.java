package TareasAdimistracion.Proyecto;

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AutenticacionController {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String URI = new String("https://gentle-eyrie-95237.herokuapp.com/login");
	private UserHeroku user = new UserHeroku("kinexo","kinexo");
	Gson gson = new Gson();
	 
	public AutenticacionController() {
		URI = new String("https://gentle-eyrie-95237.herokuapp.com/login");
		user = new UserHeroku("kinexo","kinexo");
	}
	public Token getToken(){
		String JSON = gson.toJson(user);
		HttpEntity<String> request = new HttpEntity<String>(JSON);
		ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.POST, request, String.class);
		String TokenJSON = response.getBody();
   	 	Token token = gson.fromJson(TokenJSON, Token.class);
 	 	
		return token;
     }	
	
	public List<User> getUserFromApi(String token) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);
	
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> response = restTemplate.exchange("https://gentle-eyrie-95237.herokuapp.com/users", HttpMethod.GET, entity, String.class);  
		String UserJSON = response.getBody();
   	 	//User[] usersFromApi = gson.fromJson(UserJSON, User[].class);
	   	 	
		Type collectionType = new TypeToken<List<User>>(){}.getType();
		List<User> usersFromApi = (List<User>) new Gson()
		               .fromJson( UserJSON , collectionType);
   	 	
		return usersFromApi;
	}
}
