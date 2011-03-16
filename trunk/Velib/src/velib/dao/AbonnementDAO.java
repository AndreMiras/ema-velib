/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Abonnement;

/**
 *
 * @author andre
 */
// TODO: finish up
public class AbonnementDAO extends DAO<Abonnement> {
    public Abonnement create(Abonnement obj)
    {
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "SELECT NEXT VALUE FOR sequence_abonnement FROM abonnement as id"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO abonnement (idabonnement, datedebut, datefin, idclient, idtype) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
				prepare.setDate(2, obj.getDateDebutSQL());
                                prepare.setDate(3, obj.getDateFinSQL());
                                prepare.setLong(4, obj.getClient().getId());
                                prepare.setLong(5, obj.getType().getId());
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
    public Abonnement find(long id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Abonnement update(Abonnement obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Abonnement obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String createTableStatementString()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
