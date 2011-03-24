/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import velib.model.Client;
import velib.model.Location;
import velib.model.Velo;

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
                                       "CALL NEXT VALUE FOR sequence_locations"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO locations "
                                                        + "(idlocation,"
                                                        + " dateDebutLocation,"
                                                        + " dateFinLocation,"
                                                        + " idclient,"
                                                        + " idvelo) VALUES(?,?,?,?,?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setTimestamp(2,
                                            new java.sql.Timestamp(obj.getDateDebutLocation().getTime()));
                                if(obj.getDateFinLocation()== null)
                                        {
                                                prepare.setDate(3,null);
                                        }
                                         else
                                        {
                                          prepare.setTimestamp(3,
                                              new java.sql.Timestamp(
                                                obj.getDateFinLocation().getTime()));
                                        }

                           
				prepare.setLong(4, obj.getClient().getClientId());
                                prepare.setLong(5, obj.getVelo().getId());
				prepare.executeUpdate();
				obj = this.find(id);
            }
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

    public Location[] findAllLocation ()
    {
        String locationsTable = tableNames[0];

        Vector<Location> locationVector = new Vector<Location>();
        Location location;
        Client client;
        Velo velo;
        ClientDAO clientDAO = new ClientDAO();
        VeloDAO veloDAO = new VeloDAO();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    locationsTable
                                    );
            while (result.next())
            {
                Long id = result.getLong("idlocation");
                client = clientDAO.find(result.getLong("idclient"));
                velo = veloDAO.find(result.getLong("idvelo"));
                location = new Location(id, client, velo);
                locationVector.add(location);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return locationVector.toArray(new Location[locationVector.size()]);
    }
    
    public Location find (Client client)
    {
        String locationsTable = tableNames[0];
        Location location = null;
        Velo velo;
        VeloDAO veloDAO = new VeloDAO();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    locationsTable +
                                    " WHERE idClient = " + client.getClientId() 
                                    + "AND dateFinLocation is null"
                                    );
            
            if (result.first())
            {
                Long id = result.getLong("idlocation");
                velo = veloDAO.find(result.getLong("idvelo"));
                location = new Location(id, client, velo);
                location.setDateDebutLocation(result.getTimestamp("DateDebutLocation"));
                location.setDateFinLocation(result.getTimestamp("DateFinLocation"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return location;
    }



    @Override
    public Location update(Location obj)
    {
          String locationsTable = tableNames[0];
        try {
                this .connect.createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	"UPDATE " +
                        locationsTable +
                        " SET idlocation = '" + obj.getId()+ "',"+
                        " dateDebutLocation = '"
                        + new java.sql.Timestamp(obj.getDateDebutLocation().getTime()) + "',"
                        
                        + " dateFinLocation = '"
                        + new java.sql.Timestamp(obj.getDateFinLocation().getTime()) + "',"
                        + " idclient = '" + obj.getClient().getClientId() + "',"
                        + " idvelo = '" + obj.getVelo().getId() + "'"
                    	+ " WHERE idlocation = " + obj.getId()
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
    public void delete(Location obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Location find(long id) {

        String locationsTable = tableNames[0];
        Location location = new Location();
        Velo velo;
        VeloDAO veloDAO = new VeloDAO();
        Client client;
        ClientDAO clientDAO = new ClientDAO();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    locationsTable +
                                    " WHERE idlocation = " + id
                                    );
            if (result.first())
            {
                client = clientDAO.find(result.getLong("idclient"));
                velo = veloDAO.find(result.getLong("idvelo"));
                location = new Location(id, client, velo);
                location.setDateDebutLocation(result.getDate("DateDebutLocation"));
                location.setDateFinLocation(result.getDate("DateFinLocation"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return location;
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
                    "dateDebutLocation DATETIME, " +
                    "dateFinLocation DATETIME, " +
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
