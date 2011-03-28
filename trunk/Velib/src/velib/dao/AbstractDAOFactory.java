package velib.dao;

public abstract class AbstractDAOFactory {

	public abstract DAO getClientDAO();
	public abstract DAO getAbonnementDAO();

	public static AbstractDAOFactory getFactory(FactoryType type){

		if(type.equals(type.DAO_FACTORY))
                {
			return new DAOFactory();
                }

		if(type.equals(type.XML_DAO_Factory))
                {
			return new XMLDAOFactory();
                }

		return null;
	}

}
