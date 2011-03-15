/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

/**
 *
 * @author andre
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import velib.model.Client;
import velib.dao.AbstractDAOFactory;
import velib.dao.DAO;
import velib.dao.FactoryType;
import velib.model.Banque;

public class BanqueDAO extends DAO<Banque>
{

    public Banque create(Banque obj)
    {
           
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_banque FROM client as id"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                     "INSERT INTO banque (idbanque, numero, identifiant, dateExpiration, codeVerif, idClient) VALUES(?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setLong(2, obj.getNumero());
                                prepare.setString(3, obj.getIdentifiant());
                                prepare.setDate(4, obj.getDateExpirationSQL());
                                prepare.setLong(5, obj.getCodeVerif());
                                prepare.setLong(6, obj.getClient().getId());
				
			}
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }


    @Override
    public Banque find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Banque update(Banque obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Banque obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}