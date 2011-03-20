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

    public AbonnementDAO()
    {
        tableNames = new String[] { "abonnements" };
    }

    public Abonnement create(Abonnement obj)
    {
        String abonnementTable = tableNames[0];
         try {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_abonnements"
                                    );
            if(result.first()){
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO "+abonnementTable+"(idabonnement, datedebut, datefin, idclient, idtype) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
				prepare.setDate(2, obj.getDateDebutSQL());
                                prepare.setDate(3, obj.getDateFinSQL());
                                prepare.setLong(4, obj.getClient().getClientId());
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
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[5];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_abonnements START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idabonnement INTEGER, " +
                    "datedebut DATE, " +
                    "datefin DATE, " +
                    "idclient INTEGER, " +
                    "idtype INTEGER) " , tableNames[0]);
          statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_abonnements (idabonnement)";
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_abonnements_clients FOREIGN KEY (idclient) REFERENCES clients (idclient)";
        statementStrings[4] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_abonnements_typeAbo FOREIGN KEY (idType) REFERENCES typeabonnement (idtype)";
        return statementStrings;
    }

}
