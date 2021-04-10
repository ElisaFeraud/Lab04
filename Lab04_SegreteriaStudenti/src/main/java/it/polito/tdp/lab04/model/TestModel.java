package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
        Corso c = new Corso("01KSUPG",8,"Gestione dell'innovazione e sviluppo prodotto",2);
		Model model = new Model();
		//System.out.println(model.getTuttiGliStudenti());
		//System.out.println(model.ottieniCognome(146101));
		model.getStudentiIscrittiAlCorso(c);
		/*
		 * 	Write here your test model
		 */

	}

}
