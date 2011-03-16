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

    public Velo create(Velo obj)
    {

         try {
                ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_velo FROM velo as id"
                                    );
                if(result.first()){
                    long id = result.getLong(1);
                    System.out.println("id :" + id);
                    PreparedStatement prepare = this.connect.prepareStatement(
                                                     "INSERT INTO velo (idvelo, etat, idbornette) VALUES(?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setBoolean(2, obj.getEtat());
                                prepare.setLong(3, obj.getIdBornette().getId());
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
    public String createTableStatementString()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}