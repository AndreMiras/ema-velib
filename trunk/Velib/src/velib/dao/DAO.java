package velib.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<T> {

	protected Connection connect = ConnectionHSQL.getDebugInstance();

        /*
         * list of used tables for this object
         */
        protected String[] tableNames;

	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);

	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);

	/**
	 * Permet de mettre à jour les données d'une entrée dans la base
	 * @param obj
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);


        /*      Database management     */


        
        /*
         * Creates required tables
         */
        public abstract String[] createTablesStatementStrings();

        /*
         * Actually creates the tables from the createTableStatementString()
         */
        public void createTables()
        {
            String[] sqlStrings = createTablesStatementStrings();
            String sqlString;
            Statement statement;

            System.out.println("Creating table(s):" +
                    Arrays.toString(tableNames));
            for (int i=0; i<sqlStrings.length; i++)
            try
            {
                statement = connect.createStatement();

                sqlString = sqlStrings[i];

                System.out.println("SQL: " + sqlString);

                statement.executeUpdate(sqlString);
            }
            catch (SQLException ex)
            {
                System.out.println("Error creating table: " + ex);
                Logger.getLogger(DatabaseManagementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /*
         * Loop in the tableNames list, dropping found tables
         */
        public void dropTables()
        {
            String tableName;

            for (int i=0; i<tableNames.length; i++)
            {
                tableName = tableNames[i];
                System.out.println("Dropping table: " + tableName);
                try
                {
                    Statement statement = connect.createStatement();

                    String sql = "DROP TABLE " + tableName;

                    statement.executeUpdate(sql);
                }
                catch (SQLException e)
                {
                    System.out.println("Error dropping table: " + e);
                }
            }
        }

        /*
         * Returns the list of tables
         */
        public String[] getTableNames()
        {
            return tableNames;
        }
}

