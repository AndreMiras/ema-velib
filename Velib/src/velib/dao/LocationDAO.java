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
    public Location create(Location obj)
    {
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_location FROM location as id"
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
				prepare.setLong(3, obj.getClient().getId());
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
}
