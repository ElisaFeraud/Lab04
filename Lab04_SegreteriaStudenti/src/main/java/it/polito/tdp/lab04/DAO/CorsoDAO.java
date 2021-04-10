package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
                Corso corso = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(corso);
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		/*List<Corso> corsi = getTuttiICorsi();
		C
		for(Corso c: corsi) {
			if(c.getCodins().equals(corso.getCodins()))
				
		}*/
		
		
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		final String sql = "SELECT * FROM studente s, iscrizione i WHERE s.matricola=i.matricola AND i.codins= ? ORDER BY cognome ";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
               Studente s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"),rs.getString("CDS"));
				studenti.add(s);
				System.out.println(s);
				
			}
            rs.close();
            st.close();
			conn.close();
			
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return studenti;
	
	}
	public List<Corso> corsiStudente(Integer matricola){
		final String sql = "SELECT * FROM iscrizione i, corso c WHERE matricola=? AND c.codins=i.codins ";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				 Corso corso = new Corso(codins,numeroCrediti,nome,periodoDidattico);
					corsi.add(corso);
				
			}
            rs.close();
            st.close();
			conn.close();
			
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return corsi;
	}
	

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		final String sql = "SELECT * "
				+ "FROM iscrizione i, corso c "
				+ "WHERE matricola=? AND c.codins=? AND c.codins=i.codins ";

		List<Corso> corsi = new LinkedList<Corso>();
         boolean trovato=false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, studente.getMatricola());
            st.setString(2, corso.getCodins());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				 Corso corso2 = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				for(Corso c: this.getTuttiICorsi()) {
					if(c.getCodins().equals(corso.getCodins())) {
						trovato=true;
					break;}
				}
				
			}
            rs.close();
            st.close();
			conn.close();
			
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		return trovato;
	}

}
