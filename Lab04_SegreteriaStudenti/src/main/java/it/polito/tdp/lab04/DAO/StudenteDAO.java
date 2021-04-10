package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cDS = rs.getString("CDS");

				System.out.println(matricola + " " + cognome + " " + nome + " " + cDS);
                Studente studente = new Studente(matricola,cognome,nome,cDS);
				studenti.add(studente);
				// Crea un nuovo JAVA Bean Studente
				// Aggiungi il nuovo oggetto Studente alla lista studenti
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

    public String ottieniCognome(Integer matricola) {
    	
		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();
         String cognomeTrovato=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola1 = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cDS = rs.getString("CDS");

				System.out.println(matricola1 + " " + cognome + " " + nome + " " + cDS);
                Studente studente = new Studente(matricola1,cognome,nome,cDS);
				studenti.add(studente);
				
				
				
				// Crea un nuovo JAVA Bean Studente
				// Aggiungi il nuovo oggetto Studente alla lista studenti
			}

			
			for(Studente s: studenti) {
				if( s.getMatricola().equals(matricola))
					cognomeTrovato=s.getCognome();
			}
			conn.close();
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return cognomeTrovato;
    }
public String ottieniNome(Integer matricola) {
    	
		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();
         String nomeTrovato=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola1 = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cDS = rs.getString("CDS");

				System.out.println(matricola1 + " " + cognome + " " + nome + " " + cDS);
                Studente studente = new Studente(matricola1,cognome,nome,cDS);
				studenti.add(studente);
				
				
				
				// Crea un nuovo JAVA Bean Studente
				// Aggiungi il nuovo oggetto Studente alla lista studenti
			}

			
			for(Studente s: studenti) {
				if( s.getMatricola().equals(matricola))
					nomeTrovato=s.getNome();
			}
			conn.close();
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return nomeTrovato;
    }
}
