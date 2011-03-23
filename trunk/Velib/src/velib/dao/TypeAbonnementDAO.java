/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.TypeAbonnement;

/**
 *
 * @author Nicolas
 */
public class TypeAbonnementDAO extends DAO<TypeAbonnement> {

    public TypeAbonnementDAO()
    {
        tableNames = new String[] { "typeabonnement" };
    }

    @Override
    public TypeAbonnement find(long id)
    {
        String typeAbonnementTable = tableNames[0];
        TypeAbonnement typeAbonnement = null;

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
                typeAbonnement =
                        new TypeAbonnement(
                        result.getLong("idtype"),
                        null); // I do not yet know how I will handle this
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
    public TypeAbonnement create(TypeAbonnement obj)
    {
        String typeAbonnementTable = tableNames[0];

        try
        {
            ResultSet result = connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE).executeQuery(
                "CALL NEXT VALUE FOR sequence_clients");

            if(result.first())
            {
                long id = result.getLong(1);

                PreparedStatement prepare =
                        connect.prepareStatement(
                            "INSERT INTO "
                            + typeAbonnementTable
                            + " (idtype, "
                            + "duree, "
                            + "prix) "
                            + "VALUES(?, ?, ?)");
                prepare.setLong(1, id);
                prepare.setInt(2, obj.getDuree());
                prepare.setFloat(3, obj.getPrix());

                prepare.executeUpdate();

                obj = find(id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	return obj;
    }

    @Override
    public TypeAbonnement update(TypeAbonnement obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(TypeAbonnement obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[3];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_typeabonnement START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idtype INTEGER, " +
                    "duree INTEGER, " +
                    "prix INTEGER) " , tableNames[0]);
      statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_typeAbo PRIMARY KEY (idtype)";
        return statementStrings;
    }

}
