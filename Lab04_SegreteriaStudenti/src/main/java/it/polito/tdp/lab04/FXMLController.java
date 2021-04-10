package it.polito.tdp.lab04;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.lang.Integer;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private CheckBox btnCheck;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;
    
    @FXML
    private ComboBox<String> boxCorsi;
    @FXML
    private TextArea txtInfo;

    @FXML
    private Button btnReset;

	private Model modello;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	String matricolaStringa = txtMatricola.getText();
        Integer matricola;
        try {
      	  matricola = Integer.parseInt(matricolaStringa);
      	    
            
         
           
            
      	  
        }catch (NumberFormatException ne) {
      	  txtCognome.setText("Errore");
      	  txtNome.setText("Errore");
      	  return;
        }
      List<Corso> corsiLista = new LinkedList<Corso>();
      corsiLista=modello.corsiStudente(matricola);
      txtInfo.setText(""+corsiLista);
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
      String nomeCorso = boxCorsi.getValue();
      Corso corsoScelto=null;
      List<Corso> corsiLista = new LinkedList<Corso>();
      if(nomeCorso!="") {
    	   corsiLista = modello.getTuttiICorsi();
      }
      for(Corso c: corsiLista) {
    	  if(c.getNome().equals(nomeCorso))
    		  corsoScelto = new Corso(c.getCodins(), c.getNumeroCrediti(), nomeCorso, c.getPeriodoDidattico());
      }
      List<Studente> studenti = modello.getStudentiIscrittiAlCorso(corsoScelto);
      txtInfo.setText(""+studenti);
      
    }

    @FXML
    void doCheck(ActionEvent event) {
          String matricolaStringa = txtMatricola.getText();
          Integer matricola;
          try {
        	  matricola = Integer.parseInt(matricolaStringa);
        	    
              
           
             
              
        	  
          }catch (NumberFormatException ne) {
        	  txtCognome.setText("Errore");
        	  txtNome.setText("Errore");
        	  return;
          }
          String cognome = modello.ottieniCognome(matricola);
          String nome = modello.ottieniNome(matricola);
          txtCognome.setText(cognome);
          txtNome.setText(nome);
        
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	 String matricolaStringa = txtMatricola.getText();
         Integer matricola;
         try {
       	  matricola = Integer.parseInt(matricolaStringa);              
       	  
         }catch (NumberFormatException ne) {
       	  txtCognome.setText("Errore");
       	  txtNome.setText("Errore");
       	  return;
         }
         this.doCheck(event);
         Studente stud = null;
         for(Studente s: modello.getTuttiGliStudenti())
        	 if(s.getMatricola().equals(matricola)) {
        		 stud=s;
        		 break;
        	 }
         String nomeCorso = boxCorsi.getValue();
         Corso corsoScelto=null;
         List<Corso> corsiLista = new LinkedList<Corso>();
         if(nomeCorso!="") {
       	   corsiLista = modello.getTuttiICorsi();
         }
         for(Corso c: corsiLista) {
       	  if(c.getNome().equals(nomeCorso))
       		  corsoScelto = new Corso(c.getCodins(), c.getNumeroCrediti(), nomeCorso, c.getPeriodoDidattico());
         }
        if(modello.inscriviStudenteACorso(stud, corsoScelto)) {
        	txtInfo.setText("Studente iscritto al corso!");
        }
        if(!modello.inscriviStudenteACorso(stud, corsoScelto)) {
        	txtInfo.setText("Studente non iscritto al corso!");
        }
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert txtInfo != null : "fx:id=\"txtInfo\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'lab4scene.fxml'.";
        assert boxCorsi != null : "fx:id=\"boxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    public void setModel(Model model) {
    	String lista;
    	boxCorsi.getItems().add("");
    	for(Corso s: model.getTuttiICorsi()) {
    		lista= s.getNome();
    		boxCorsi.getItems().add(lista);
    	}
    	modello=model;
    }
    
}
