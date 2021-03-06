package TareasAdimistracion.Proyecto;

import java.time.LocalDate;
import java.util.Date;
import TareasAdimistracion.Proyecto.User;

public class Tarea{

	private String name;
	private String summary;
	private Integer id;
	private Integer userOwner;
	private LocalDate date;
	
	public Tarea (int id, String name, String summary, Integer user, LocalDate date) {
		
		this.name = name;
		this.summary = summary;
		this.userOwner = user;
		this.date = date;
		this.id = id;

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(Integer userOwner) {
		this.userOwner = userOwner;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
