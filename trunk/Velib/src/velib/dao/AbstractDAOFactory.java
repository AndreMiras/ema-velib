/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

/**
 *
 * @author andre
 */
public abstract class AbstractDAOFactory {

	public abstract DAO getClientDAO();
	public abstract DAO getAbonnementDAO();

	/**
	 * Méthode nous permettant de récupérer une factory de DAO
	 * @param type
	 * @return AbstractDAOFactory
	 */
	public static AbstractDAOFactory getFactory(FactoryType type){

		if(type.equals(type.DAO_FACTORY))
			return new DAOFactory();

		if(type.equals(type.XML_DAO_Factory))
			return new XMLDAOFactory();

		return null;
	}

}
