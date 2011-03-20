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
import velib.model.Bank;

public class BanqueDAO extends DAO<Bank>
{

    public BanqueDAO()
    {
        tableNames = new String[] { "banques" };
    }

    public Bank create(Bank obj)
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
                                                     "INSERT INTO banques (idbanque, numero, identifiant, dateExpiration, codeVerif) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setLong(2, obj.getNumero());
                                prepare.setString(3, obj.getIdentifiant());
                                prepare.setDate(4, obj.getDateExpirationSQL());
                                prepare.setLong(5, obj.getCodeVerif());
				prepare.executeUpdate();
				obj = this.find(id);
			}
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

    @Override
    public Bank find(long id) {
        Bank compteBanque = new Bank();
        String banquesTable = tableNames[0];
        Client client;
        ClientDAO clientDAO = new ClientDAO();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    banquesTable +
                                    "WHERE idbanque = '" + id
                                    );
            if(result.first())
            {
                System.out.println("I'm in the result");

                Long numero = result.getLong("numero");
                String identifiant = result.getString("identifiant");
                //Date date = result.getDate("dateexpiration");
                Long codeVerif = result.getLong("codeVerif");
               
                System.out.println("id =" + id);

               compteBanque = new Bank(id, numero, identifiant, codeVerif);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return compteBanque;
    }

    @Override
    public Bank update(Bank obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Bank obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[3];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_banques START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idbanque INTEGER, " +
                    "numero INTEGER, " +
                    "identifiant VARCHAR(100), " +
                    "dateexpiration DATE, " +
                    "codeverif INTEGER, ", tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_bornes PRIMARY KEY (idBanque)";
        return statementStrings;
    }

}