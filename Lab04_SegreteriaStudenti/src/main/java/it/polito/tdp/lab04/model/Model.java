package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
   private CorsoDAO corsoDao;
   private StudenteDAO studenteDao;
   public Model() {
	   corsoDao = new CorsoDAO();
	   studenteDao= new StudenteDAO();
	   
   }
   public List<Corso> getTuttiICorsi() {
	   return corsoDao.getTuttiICorsi();
   }
   public List<Studente> getTuttiGliStudenti() {
	   return studenteDao.getTuttiGliStudenti();
   }
   public String ottieniCognome(Integer matricola) {
	   return studenteDao.ottieniCognome(matricola);
   }
   public String ottieniNome(Integer matricola) {
	   return studenteDao.ottieniNome(matricola);
   }
   public List<Studente>  getStudentiIscrittiAlCorso(Corso corso) {
	   return corsoDao.getStudentiIscrittiAlCorso(corso);
   }
   public List<Corso> corsiStudente(Integer matricola){
	   return corsoDao.corsiStudente(matricola);
   }
   public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
	   return corsoDao.inscriviStudenteACorso(studente, corso);
   }
   
}
