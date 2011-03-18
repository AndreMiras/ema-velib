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

    public BanqueDAO()
    {
        tableNames = new String[] { "banques" };
    }
    public Banque create(Banque obj)
    {
           
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_banques FROM banques as id"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                     "INSERT INTO banques (idbanque, numero, identifiant, dateExpiration, codeVerif, idClient) VALUES(?, ?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setLong(2, obj.getNumero());
                                prepare.setString(3, obj.getIdentifiant());
                                prepare.setDate(4, obj.getDateExpirationSQL());
                                prepare.setLong(5, obj.getCodeVerif());
                                prepare.setLong(6, obj.getClient().getClientId());
				
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

   @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[4];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_banques START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idbanque INTEGER, " +
                    "(numero INTEGER, " +
                    "identifiant VARCHAR(100), " +
                    "dateexpiration DATE, " +
                    "(codeverif INTEGER, " +
                    "idclient INTEGER) " , tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_bornes PRIMARY KEY (idBanque)";
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_banques_clients FOREIGN KEY (idclient) REFERENCES clients (idclient)";
        return statementStrings;
    }

}