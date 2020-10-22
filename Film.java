package test2hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Table(name = "film")
public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IdFilm", unique = true)
	private int idFilm;
	
	@Column(name = "Titolo", nullable = false)
	private String titolo;
	
	@Column(name = "Regista", nullable = false)
	private String regista;
	
	public Film(){
		
	}
	
	public Film(int idFilm, String titolo, String regista){
		
		this.idFilm = idFilm;
		this.titolo = titolo;
		this.regista = regista;	
	}
	
	public void setIdFilm(int idFilm){
		
		this.idFilm = idFilm;
	}
	
	public int getIdFilm(){
		
		return idFilm;
	}
        
   public void setTitolo(String titolo){
		
		this.titolo = titolo;
	}
	
	public String getTitolo(){
		
		return titolo;
	}
	
    public void setRegista(String regista){
		
		this.regista = regista;
	}
	
	public String getRegista(){
		
		return regista;
	}
	
		
}
