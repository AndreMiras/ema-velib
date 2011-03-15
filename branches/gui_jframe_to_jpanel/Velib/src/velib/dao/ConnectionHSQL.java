package velib.dao;
import java.sql.*;

public class ConnectionHSQL {

	//URL de connection
	private static String url = "jdbc:hsqldb:hsql://localhost/";

	//Nom du user
	private static String user = "sa";

	 // Mot de passe du user
	private static String passwd = "";

	 //Objet Connection
	private static Connection connect;

	public static Connection getInstance()
        {
            if(connect == null)
            {
                try
                {
                    // http://www.willamaze.eu/2009/02/running-hsqldb-in-process-no-suitable-driver-found/
                    // Class.forName("org.hsqldb.jdbcDriver");
                    //Class.forName("org.hsqldb.jdbcDriver");
                    connect = DriverManager.getConnection(url, user, passwd);
                }
                catch (SQLException e)
                {
                    System.out.println("sql exception");
                    while (e!=null)
                    {
                        System.out.println(e.getErrorCode());
                        System.out.println(e.getMessage());
                        System.out.println(e.getSQLState());
                        e.printStackTrace();
                        e=e.getNextException();}
                    }
                        catch(Exception e)
                        {
                                e.printStackTrace();
                        }
                    }
            return connect;
	}
}


