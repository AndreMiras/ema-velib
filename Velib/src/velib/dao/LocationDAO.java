/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Location;

/**
 *
 * @author andre
 */
// TODO: finish up
public class LocationDAO extends DAO<Location>
{
    public LocationDAO()
    {
        tableNames = new String[] { "locations" };
    }
    public Location create(Location obj)
    {
        String locationTable = tableNames[0];
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_locations FROM"+locationTable+"as id"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO location (id, date, clientid, veloid) VALUES(?, ?, ?,?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setDate(2, obj.getDateSQL());
				prepare.setLong(3, obj.getClient().getClientId());
                                prepare.setLong(4, obj.getVelo().getId());
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
    public Location update(Location obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Location obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Location find(long id) {
         throw new UnsupportedOperationException("Not supported yet.");
    }

     @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[5];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_locations START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idlocation INTEGER, " +
                    "date DATE, " +
                    "idClient INTEGER, " +
                    "idVelo INTEGER) " , tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_locations PRIMARY KEY (idLocation)";
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_locations_clients FOREIGN KEY (idClient) REFERENCES clients (idclient)";
        statementStrings[4] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_locations_velos FOREIGN KEY (idvelo) REFERENCES velos (idvelo)";
        return statementStrings;
    }

}
