package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Subscription;
import velib.model.SubscriptionType;

// TODO: finish up
public class AbonnementDAO extends DAO<Subscription> {

    public AbonnementDAO()
    {
        tableNames = new String[] { "subscriptions" };
    }

    public Subscription create(Subscription obj)
    {
        String abonnementTable = tableNames[0];

        // Si l'abonnement n'existe pas
        if(obj.getType().getIdType() == 0)
        {
            SubscriptionTypeDAO typeAbonnementDAO = new SubscriptionTypeDAO();
            obj.setType(typeAbonnementDAO.create(obj.getType()));
        }
         try
         {
             ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_subscriptions"
                                    );
            if(result.first())
            {
                long id = result.getLong(1);
                PreparedStatement prepare = this.connect.prepareStatement(
                        "INSERT INTO "
                        + abonnementTable
                        + "(idsubscription,"
                        + "datedebut,"
                        + "datefin,"
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
                        prepare.setLong(4, obj.getType().getIdType());
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
    public Subscription find(long id)
    {
        String typeAbonnementTable = tableNames[0];
        SubscriptionType typeAbonnement;
        SubscriptionTypeDAO typeAbonnementDAO = new SubscriptionTypeDAO();
        Subscription abonnement = null;

        try
        {
            ResultSet result =
                    connect.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM "
                                        + typeAbonnementTable
                                        + " WHERE idsubscription = '" + id + "'"
                                     );
            if(result.first())
            {
                typeAbonnement =
                        typeAbonnementDAO.find(result.getInt("idtype"));
                abonnement =
                        new Subscription(
                        result.getLong("idsubscription"), typeAbonnement);
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
    public Subscription update(Subscription obj)
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
                + " SET idtype = '" + obj.getType().getIdType() + "',"
                + " datedebut = '" + new java.sql.Timestamp(obj.getDateDebut().getTime()) + "',"
                + " datefin = '" + new java.sql.Timestamp(obj.getDateFin().getTime()) + "'"
                + " WHERE idsubscription = " + obj.getId()
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
    public void delete(Subscription obj)
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
                 + " WHERE idsubscription = " + obj.getId()
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
                "CREATE SEQUENCE sequence_subscriptions START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idsubscription INTEGER, " +
                    "datedebut DATETIME, " +
                    "datefin DATETIME, " +
                    // "idclient INTEGER, " +
                    "idtype INTEGER) " , tableNames[0]);
          statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_subscriptions PRIMARY KEY (idsubscription)";
          
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_subscriptions_typeAbo FOREIGN KEY "
                + "(idType) REFERENCES typeabonnement (idtype)";
        return statementStrings;
    }

}
