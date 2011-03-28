package velib.dao;
import java.sql.*;

public class ConnectionHSQL {

	//URL de connection
	private static String url = "jdbc:hsqldb:hsql://localhost/";
        private static String urlDebug = "jdbc:hsqldb:mem:.";

	//Nom du user
	private static String user = "sa";

	 // Mot de passe du user
	private static String passwd = "";

	 //Objet Connection
	private static Connection connect;

        public static Connection getDebugInstance()
        {
            if(connect == null)
            {
                
                try
                {
                    // http://www.willamaze.eu/2009/02/running-hsqldb-in-process-no-suitable-driver-found/
                    // comment/uncomment this line if you get errors on connect
                    Class.forName("org.hsqldb.jdbcDriver");
                }
                catch (java.lang.ClassNotFoundException ex)
                {
                    System.out.println("Whatever");
                }

                try
                {
                    connect = DriverManager.getConnection(urlDebug, user, passwd);
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

	public static Connection getInstance()
        {
            if(connect == null)
            {
              try
                {
                    // http://www.willamaze.eu/2009/02/running-hsqldb-in-process-no-suitable-driver-found/
                    // comment/uncomment this line if you get errors on connect
                    Class.forName("org.hsqldb.jdbcDriver");
                }
                catch (java.lang.ClassNotFoundException ex)
                {
                    System.out.println("Whatever");
                }
                
                try
                {
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


