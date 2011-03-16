/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;


import java.sql.Connection;


/**
 *
 * @author andre
 */
public abstract class DAO<T> {

        // TODO shouln't this be protected?
	public Connection connect = ConnectionHSQL.getInstance();

        /*
         * list of used tables for this object
         */
        protected String[] tableNames;

	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);

	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);

	/**
	 * Permet de mettre à jour les données d'une entrée dans la base
	 * @param obj
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);


        /*      Database management     */


        
        /*
         * Creates required tables
         */
        public abstract void createTable();

        public abstract void dropTable();

        /*
         * Returns the list of tables
         */
        public String[] getTableNames()
        {
            return tableNames;
        }
}

