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


import velib.dao.AbstractDAOFactory;
import velib.dao.DAO;
import velib.dao.FactoryType;
import velib.model.Bornette;
import velib.model.Velo;

public class VeloDAO extends DAO<Velo>
{
    public VeloDAO()
    {
        tableNames = new String[] { "velos" };
    }

    public Velo create(Velo obj)
    {
         String veloTable = tableNames[0];
         try {
                ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_velos"
                                    );
                if(result.first()){
                    long id = result.getLong(1);
                    System.out.println("id :" + id);
                    PreparedStatement prepare = this.connect.prepareStatement(
                                                     "INSERT INTO "+veloTable+
                                                     "(idvelo, etat) VALUES(?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setBoolean(2, obj.getEtat());
                 }
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

    @Override
    public Velo find(long id) {
        Velo velo = new Velo();

	try {
                ResultSet result = this .connect.createStatement(
                                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM velos WHERE idvelo = " + id
                                     );
                if(result.first())
                {
                              
                    Long idvelo = result.getLong("idvelo");
                    boolean etat = result.getBoolean("etat");
                    velo = new Velo(idvelo, etat);
                }

            }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return velo;
    }

    @Override
    public Velo update(Velo obj) {
         String veloTable = tableNames[0];
        try {
                this .connect.createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE " +
                        veloTable +
                        " SET etat = '" + obj.getEtat()+ "',"+
                        " WHERE idvelo = " + obj.getId()
                     );

	obj = this.find(obj.getId());
	    }
        catch (SQLException e)
        {
	  e.printStackTrace();
	}
        return obj;
    }

    @Override
    public void delete(Velo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[3];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_velos START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idvelo INTEGER, " +
                    "etat BOOLEAN) ", tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_velos PRIMARY KEY (idvelo)";
        return statementStrings;
    }


}