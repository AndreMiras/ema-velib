package velib.dao;

import java.lang.String;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
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
        Vector<Borne> borneVector = new Vector<Borne>();
        Borne borne;

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
                borne = find(id);
                borneVector.add(borne);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return borneVector.toArray(new Borne[borneVector.size()]);
    }


    public Borne[] findBorneLibre ()
    {
        String bornesTable = tableNames[0];
        
        Vector<Borne> borneVector = new Vector<Borne>();
        Borne borne;

	try
        {
            ResultSet result = this.connect.createStatement(
                                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY
                                     ).executeQuery(
                                    "SELECT * FROM " +
                                    bornesTable +
                                    " WHERE disponibilite=true"
                                    );
            
            while (result.next())
            {
                Long id = result.getLong("idborne");
                String nom = result.getString("nomBorne");
                borne = new Borne(id, nom);
                borne.setLatLong(
                        result.getDouble("latitude"),
                        result.getDouble("longitude"));

                borneVector.add(borne);
                
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return borneVector.toArray(new Borne[borneVector.size()]);
    }
    @Override
    public Borne find(long id) {
        
        String bornesTable = tableNames[0];
        Borne borne = null;
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
                borne.setLatLong(
                        result.getDouble("latitude"),
                        result.getDouble("longitude"));
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
            PreparedStatement prepare = this.connect.prepareStatement(
                                                    	"INSERT INTO " +
                                                        borneTable +
                                                        " (idborne,"
                                                        + "nomBorne,"
                                                        + "latitude,"
                                                        + "longitude,"
                                                        + "disponibilite)"
                                                        + "VALUES(?, ?, ?, ?, ?)"
                                                    );
				prepare.setLong(1, id);
                                prepare.setString(2, obj.getNomBorne());
                                prepare.setDouble(3, obj.getLatitude());
                                prepare.setDouble(4, obj.getLongitude());
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
      String borneTable = tableNames[0];

        try {
            String sql = "UPDATE " +
                        borneTable +
                        " SET nomBorne = '" + obj.getNomBorne()+ "',"+
                        " latitude = " + obj.getLatitude()+ ","+
                        " longitude = " + obj.getLongitude()+ ","+
                        " disponibilite = " + obj.getEtat()+
                    	" WHERE idborne = " + obj.getIdBorne();
              System.out.println(sql);
             this .connect.createStatement(
                    	ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                     ).executeUpdate(
                    	sql
                     );

	obj = this.find(obj.getIdBorne());
	    }
        catch (SQLException e)
        {
	  e.printStackTrace();
          obj=null;
	}
        return obj;
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
                    "latitude FLOAT, " +
                    "longitude FLOAT, " +
                    "disponibilite BOOLEAN)", tableNames[0]);
      statementStrings[2] =
                "ALTER TABLE "
                + tableNames[0]
                + " ADD CONSTRAINT primary_key_bornes PRIMARY KEY (idBorne)";
        return statementStrings;
    }
}
