/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.SubscriptionType;
import velib.model.SubscriptionTypeEnum;

/**
 *
 * @author Nicolas
 */
public class TypeAbonnementDAO extends DAO<SubscriptionType> {

    public TypeAbonnementDAO()
    {
        tableNames = new String[] { "typeabonnement" };
    }

    @Override
    public SubscriptionType find(long id)
    {
        String typeAbonnementTable = tableNames[0];
        SubscriptionType typeAbonnement = null;

        try
        {
            ResultSet result =
                    connect.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                        "SELECT * FROM "
                                        + typeAbonnementTable
                                        + " WHERE idtype = '" + id + "'"
                                     );
            if(result.first())
            {
                // TODO: hardcoded value
                typeAbonnement =
                        new SubscriptionType(
                        SubscriptionTypeEnum.HALF_DAY);
                typeAbonnement.setDuree(result.getInt("duree"));
                typeAbonnement.setPrix(result.getFloat("prix"));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return typeAbonnement;
    }

    @Override
    public SubscriptionType create(SubscriptionType obj)
    {
        String typeAbonnementTable = tableNames[0];

        try
        {
            long idtype = obj.getIdType();

            PreparedStatement prepare =
                    connect.prepareStatement(
                        "INSERT INTO "
                        + typeAbonnementTable
                        + " (idtype, "
                        + "duree, "
                        + "prix) "
                        + "VALUES(?, ?, ?)");
            prepare.setLong(1, idtype);
            prepare.setInt(2, obj.getDuree());
            prepare.setFloat(3, obj.getPrix());

            prepare.executeUpdate();

            obj = find(idtype);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	return obj;
    }

    @Override
    public SubscriptionType update(SubscriptionType obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(SubscriptionType obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[3];
        statementStrings[0] =
                    String.format("CREATE TABLE %s" +
                    "(idtype INTEGER, " +
                    "duree INTEGER, " +
                    "prix INTEGER) " , tableNames[0]);
      statementStrings[1] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_typeAbo PRIMARY KEY (idtype)";
        return statementStrings;
    }

}
