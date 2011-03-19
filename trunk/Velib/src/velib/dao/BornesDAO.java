/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velib.dao;

import java.lang.String;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import velib.model.Borne;

/**
 *
 * @author Nicolas
 */
public class BornesDAO  extends DAO<Borne>{

    public BornesDAO()
    {
        tableNames = new String[] { "bornes" };
    }

    public Borne[] findAllBorne ()
    {
        String bornesTable = tableNames[0];
        Borne[] tableauBorne = new Borne[10];
        Borne borne;
        int i=0;

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    bornesTable
                                    );
            while (result.next())
            {
                Long id = result.getLong("idborne");
                String nom = result.getString("nomBorne");
                borne = new Borne(id, nom);
                tableauBorne[i]=borne;
                i=i+1;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return tableauBorne;
    }


    public Borne[] findBorneLibre ()
    {
        String bornesTable = tableNames[0];
        Borne[] tableauBorne = new Borne[10];
        Borne borne;
        int i=0;

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    bornesTable +
                                    " WHERE etat=true"
                                    );
            while (result.next())
            {
                Long id = result.getLong("idborne");
                String nom = result.getString("nomBorne");
                borne = new Borne(id, nom);
                tableauBorne[i]=borne;
                i=i+1;
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return tableauBorne;
    }
    @Override
    public Borne find(long id) {
        
        String bornesTable = tableNames[0];
        Borne borne = new Borne();
	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    bornesTable +
                                    " WHERE idBorne="+id
                                    );
           if(result.first())
            {
                String nom = result.getString("nomBorne");
                borne = new Borne(id, nom);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return borne;

    }

    @Override
    public Borne create(Borne obj) {
        String borneTable = tableNames[0];
         try {
            ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                      		ResultSet.CONCUR_UPDATABLE
                                    ).executeQuery(
                                       "CALL NEXT VALUE FOR sequence_bornes"
                                    );
            if(result.first())
            {
            long id = result.getLong(1);
            System.out.println("id :" + id);
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO " +
                                                        borneTable +
                                                        " (idborne, nomBorne, positionX, positionY, etat) VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setString(2, obj.getNomBorne());
                                prepare.setLong(3, obj.getPositionX());
                                prepare.setLong(4, obj.getPositionY());
                                prepare.setBoolean(5, obj.getEtat());

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
    public Borne update(Borne obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Borne obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] createTablesStatementStrings()
    {
        String[] statementStrings = new String[3];
        statementStrings[0] =
                "CREATE SEQUENCE sequence_bornes START WITH 1 INCREMENT BY 1";
        statementStrings[1] =
                    String.format("CREATE TABLE %s" +
                    "(idborne INTEGER, " +                    
                    "nomBorne VARCHAR(100), " +
                    "positionX INTEGER, " +
                    "positionY INTEGER, " +
                    "etat BOOLEAN)", tableNames[0]);
      statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_bornes PRIMARY KEY (idBorne)";
        return statementStrings;
    }
}
