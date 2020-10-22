package test2hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test2Hibernate {

	public static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("Test2Hibernate");
	
	public static void main(String[] args) {
		
		addFilmECinema(1, "Pulp Fiction", "Quentin Tarantino","Capitol");
		addFilmECinema(2, "Apocalypse Now", "Francis Ford Coppola", "Maestoso");
		addFilmECinema(3, "Natural Born Killer ", "Oliver Stone", "Teodolinda");
		addFilmECinema(4, "Jurassic Park", "Steven Spielberg", "(NULL)");
        changeFilm(1, "Le Iene", "Quentin Tarantino");
        changeNomeCinema(2, "Anteo");
        deleteCinema(3);
		
		emf.close();
		
	}
	
	public static void addFilmECinema(int id, String titolo, String regista, String nome){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			Film film = new Film(id, titolo, regista);
			Cinema cinema = new Cinema(id, nome, film);
			em.persist(film);
			em.persist(cinema);
			et.commit();
			
		}catch(Exception ex){
			
			if(et != null) {et.rollback();}
			
			ex.printStackTrace();
		}
		finally{em.close();}
	}
	
	public static void changeFilm(int idFilm, String titolo, String regista){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			Film film = em.find(Film.class, idFilm);
			film.setIdFilm(idFilm);
			film.setTitolo(titolo);
			film.setRegista(regista);
			em.persist(film);
			et.commit();
			
		}catch(Exception ex){
			
            if(et != null) {et.rollback();}
			
			ex.printStackTrace();
		}
		finally{em.close();}
	}
	
	
	
	
	
public static void changeNomeCinema(int idCinema, String nome){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			Cinema cinema = em.find(Cinema.class, idCinema);
			cinema.setNome(nome);
			et.commit();
			
		}catch(Exception ex){
			
            if(et != null) {et.rollback();}
			
			ex.printStackTrace();
		}
		finally{em.close();}
	}
	
	public static void deleteCinema(int idCinema){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try{
			et = em.getTransaction();
			et.begin();
			Cinema cinema = em.find(Cinema.class,  idCinema);
			em.remove(cinema);
		    et.commit();
			
		}catch(Exception ex){
			if(et != null){
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally{em.close();}
	}
	
	

}
