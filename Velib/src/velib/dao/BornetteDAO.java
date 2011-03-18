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

    public BornetteDAO()
    {
        tableNames = new String[] { "bornettes" };
    }

    public Bornette create(Bornette obj)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Bornette findLibre(Long idBorne)
    {
        String bornetteTable = tableNames[0];
        Bornette bornette = new Bornette();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM"+bornetteTable+" WHERE libre=false AND idborne='" + idBorne + "'"
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
        String bornetteTable = tableNames[0];
        Bornette bornette = new Bornette();

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM"+bornetteTable+" WHERE libre=true AND idborne='" + idBorne + "'"
                                    );
            if(result.first())
            {
                long id = result.getLong("idbornette");
                long idborneDB = result.getLong("idborne");
                long idveloDB = result.getLong("idvelo");
                boolean libre = result.getBoolean("libre");
                long numero = result.getLong("numero");
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
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[5];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_bornettes START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idbornette INTEGER, " +
                    "libre BOOLEAN, " +
                    "numero INTEGER, " +
                    "idborne INTEGER, " +
                    "idvelo INTEGER) " , tableNames[0]);
        statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_bornettes PRIMARY KEY (idbornette)";
        statementStrings[3] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_bornettes_borne FOREIGN KEY (idborne) REFERENCES bornes (idbornes)";
        statementStrings[4] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT foreign_key_bornettes_velo FOREIGN KEY (idvelo) REFERENCES velos (idvelos)";
        return statementStrings;
    }

}
