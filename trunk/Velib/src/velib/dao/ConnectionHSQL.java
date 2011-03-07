/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class ConnectionHSQL {

    /**
	 * URL de connection
	 */
	private static String url = "jdbc:hsqldb:hsql://localhost/TODO";
	/**
	 * Nom du user
	 */
	private static String user = "user";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "passwd";
	/**
	 * Objet Connection
	 */
	private static Connection connect;

	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;
	}	
}
