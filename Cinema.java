package test2hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.io.Serializable;

@Entity
@Table(name = "Cinema")
public class Cinema implements Serializable{

	private static final long serialVersionUID = 1L;
     
	@Id
	@Column(name = "IdCinema", unique = true)
	private int idCinema;
	
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "Film", nullable = false)
	private Film film;
	
	public Cinema(){
		
	}
	
	public Cinema(int idCinema, String nome, Film film){
		
		this.idCinema = idCinema;
		this.nome = nome;
		this.film = film;
	}
	
    public void setIdCinema(int idCinema){
		
		this.idCinema = idCinema;
	}
	
	public int getIdCinema(){
		
		return idCinema;
	}
        
   public void setNome(String nome){
		
		this.nome = nome;
	}
	
	public String getNome(){
		
		return nome;
	}
	
    public void setFilm(Film film){
		
		this.film= film;
	}
	
	public Film getFilm(){
		
		return film;
	}
}
