/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import velib.model.Borne;
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
        String bornetteTable = tableNames[0];
         try {
            ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_bornettes"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO " +
                                                        bornetteTable +
                                                        " (idbornette, numero, libre, idborne, idvelo) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setLong(2, obj.getNumero());
                                prepare.setBoolean(3, obj.getLibre());
                                prepare.setLong(4, obj.getBorne().getIdBorne());
                                prepare.setLong(5, obj.getVelo().getId());

				prepare.executeUpdate();
				obj = this.find(id);
            }
	    }
            catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
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
                                    "SELECT * FROM"+bornetteTable+" WHERE libre=true AND idborne='" + idBorne + "'"
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
                                    "SELECT * FROM"+bornetteTable+" WHERE libre=false AND idborne='" + idBorne + "'"
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
        String bornettesTable = tableNames[0];
        Bornette bornette = new Bornette();
        Borne borne;
        BornesDAO borneDAO = new BornesDAO();
	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    bornettesTable +
                                    " WHERE idBorne="+id
                                    );
           if(result.first())
            {
                long numero = result.getLong("numero");
                borne =  borneDAO.find(result.getLong("idborne"));
                bornette = new Bornette(id, numero, borne);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return bornette;
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
                + "  ADD CONSTRAINT foreign_key_bornettes_velo FOREIGN KEY (idvelo) REFERENCES velos (idvelos)";
        return statementStrings;
    }

}
