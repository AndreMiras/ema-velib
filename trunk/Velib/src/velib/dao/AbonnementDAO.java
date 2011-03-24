/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Abonnement;
import velib.model.TypeAbonnement;

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

        //Si l'abonnement n'existe pas
        
        if(obj.getType().getId() == 0)
        {
            TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
            obj.setType(typeAbonnementDAO.create(obj.getType()));
        }
         try
         {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_abonnements"
                                    );
            if(result.first())
            {
                long id = result.getLong(1);
                PreparedStatement prepare = this.connect.prepareStatement(
                        "INSERT INTO "
                        + abonnementTable
                        + "(idabonnement,"
                        + "datedebut,"
                        + "datefin,"
                        // + "idclient,"
                        + "idtype) "
                        + "VALUES(?, ?, ?, ?)"
                    );
                        prepare.setLong(1, id);
                        prepare.setTimestamp(2,
                                new java.sql.Timestamp(
                                    obj.getDateDebut().getTime()));
                        prepare.setTimestamp(3,
                                new java.sql.Timestamp(
                                    obj.getDateFin().getTime()));
                        // prepare.setLong(4, obj.getClient().getClientId());
                        prepare.setLong(4, obj.getType().getId());
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
        String typeAbonnementTable = tableNames[0];
        TypeAbonnement typeAbonnement;
        TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
        Abonnement abonnement = null;

        try
        {
            ResultSet result =
                    connect.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM "
                                        + typeAbonnementTable
                                        + " WHERE idabonnement = '" + id + "'"
                                     );
            if(result.first())
            {
                typeAbonnement =
                        typeAbonnementDAO.find(result.getInt("idtype"));
                abonnement =
                        new Abonnement(
                        result.getLong("idabonnement"), typeAbonnement);
                abonnement.setDateDebut(result.getTimestamp("datedebut"));
                abonnement.setDateFin(result.getTimestamp("datefin"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return abonnement;
    }

    @Override
    public Abonnement update(Abonnement obj)
    {
        String clientTable = tableNames[0];
        try
        {
                  this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
         ).executeUpdate(
                "UPDATE "
                + clientTable
                + " SET idtype = '" + obj.getType().getId() + "',"
                + " datedebut = '" + new java.sql.Timestamp(obj.getDateDebut().getTime()) + "',"
                + " datefin = '" + new java.sql.Timestamp(obj.getDateFin().getTime()) + "'"
                + " WHERE idabonnement = " + obj.getId()
         );

            obj = this.find(obj.getId());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            obj = null;
        }

        return obj;
    }

    @Override
    public void delete(Abonnement obj)
    {
        String abonnementTable = tableNames[0];
        try
        {

            this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
         ).executeUpdate(
         //TODO remove that shit, man
                "DELETE FROM "
                 + abonnementTable
                 + " WHERE idabonnement = " + obj.getId()
         );

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[4];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_abonnements START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idabonnement INTEGER, " +
                    "datedebut DATETIME, " +
                    "datefin DATETIME, " +
                    // "idclient INTEGER, " +
                    "idtype INTEGER) " , tableNames[0]);
          statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_abonnements PRIMARY KEY (idabonnement)";
          /*
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_abonnements_clients FOREIGN KEY (idclient) REFERENCES clients (idclient)";
           * 
           */
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_abonnements_typeAbo FOREIGN KEY (idType) REFERENCES typeabonnement (idtype)";
        return statementStrings;
    }

}
