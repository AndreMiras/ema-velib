
package velib.dao;

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
                                       "CALL NEXT VALUE FOR sequence_banques"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            PreparedStatement prepare = this.connect.prepareStatement(
                                         "INSERT INTO banques "
                                         + "(idbanque, numero, identifiant, "
                                         + "dateExpiration, codeVerif) "
                                         + "VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setString(2, obj.getNumero());
                                prepare.setString(3, obj.getIdentifiant());
                                prepare.setTimestamp(4,
                                        new java.sql.Timestamp(obj.getDateExpiration().getTime()));
                                prepare.setString(5, obj.getCodeVerif());
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
                                    " WHERE idbanque = '" + id +"'"
                                    );
            if(result.first())
            {
                String numero = result.getString("numero");
                String identifiant = result.getString("identifiant");
                //Date date = result.getDate("dateexpiration");
                String codeVerif = result.getString("codeVerif");
               
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
        String banquesTable = tableNames[0];
        try {
                this .connect.createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE " +
                        banquesTable +
                        " SET numero = '" + obj.getNumero()+ "',"+
                        " identifiant = '" + obj.getIdentifiant() + "',"+
                        " dateexpiration = '" +
                       new java.sql.Date(obj.getDateExpiration().getTime())+ "',"+
                        " codeverif = '" + obj.getCodeVerif() + "'"+
                    	" WHERE idbanque = " + obj.getId()
                     );

	obj = this.find(obj.getId());
	    }
        catch (SQLException e)
        {
	  e.printStackTrace();
          obj=null;
	}
        return obj;
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
                    "numero VARCHAR(40), " +
                    "identifiant VARCHAR(100), " +
                    "dateexpiration DATE, " +
                    "codeverif VARCHAR(3)) ", tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_banques PRIMARY KEY (idBanque)";
        return statementStrings;
    }

}
