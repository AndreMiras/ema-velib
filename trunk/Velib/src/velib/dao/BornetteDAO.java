/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Bornette;

/**
 *
 * @author Nicolas
 */
// TODO: finish up
public class BornetteDAO extends DAO<Bornette>
{
    public Bornette create(Bornette obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Bornette findLibre(String identifiant, String password)
    {
        Bornette bornette = new Bornette();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM bornette WHERE "
                                    );
            if(result.first())
            {
                String passwordDB = result.getString("password");
                Long id = result.getLong("id");
                bornette = new Bornette();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bornette;
    }

    @Override
    public Bornette update(Bornette obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Bornette obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Bornette find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
