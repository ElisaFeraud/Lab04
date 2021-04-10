package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Model;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		Model stdao = new Model();
		System.out.println(stdao.ottieniCognome(146101));
		
		
	}

}
