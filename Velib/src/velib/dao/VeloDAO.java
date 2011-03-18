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
                                       "SELECT NEXT VALUE FOR sequence_velos FROM"+veloTable+" as id"
                                    );
                if(result.first()){
                    long id = result.getLong(1);
                    System.out.println("id :" + id);
                    PreparedStatement prepare = this.connect.prepareStatement(
                                                     "INSERT INTO"+veloTable+ "(idvelo, etat, idbornette) VALUES(?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setBoolean(2, obj.getEtat());
                                prepare.setLong(3, obj.getBornette().getId());
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
                                        "SELECT * FROM velo WHERE id = " + id
                                     );
                if(result.first())
                {
                              
                    Long idvelo = result.getLong("idvelo");
                    Boolean etat = result.getBoolean("etat");
                        Long idBornette = result.getLong("idbornette");
                    velo = new Velo();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Velo obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[4];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_velos START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idvelo INTEGER, " +
                    "etat BOOLEAN, " +
                    "idbornette INTEGER) " , tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_velos PRIMARY KEY (idvelo)";
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_velos_bornette FOREIGN KEY (idbornette) REFERENCES bornettes (idbornette)";
        return statementStrings;
    }


}