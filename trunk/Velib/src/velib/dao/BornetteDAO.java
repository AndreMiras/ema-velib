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

    public Bornette findLibre(Long idBorne)
    {
        Bornette bornette = new Bornette();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM bornette WHERE etat=false AND idborne='" + idBorne + "'"
                                    );
            if(result.first())
            {

                bornette = new Bornette();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bornette;
    }

    public Bornette findOccupe(Long idBorne)
    {
        Bornette bornette = new Bornette();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM bornette WHERE etat=true AND idborne='" + idBorne + "'"
                                    );
            if(result.first())
            {
                long id = result.getLong("idbornette");
                long idborneDB = result.getLong("idborne");
                long idveloDB = result.getLong("idvelo");
                boolean libre = result.getBoolean("libre");
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

    @Override
    public void createTable()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dropTable()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
