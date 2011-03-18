/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

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

    @Override
    public Borne find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Borne create(Borne obj) {
        throw new UnsupportedOperationException("Not supported yet.");
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
                    "(numeroborne INTEGER, " +
                    "(nomBorne VARCHAR(100), " +
                    "positionX INTEGER, " +
                    "positionY INTEGER, " , tableNames[0]);
      statementStrings[2] =
                "ALTER TABLE"
                + tableNames[0]
                + "ADD CONSTRAINT primary_key_bornes PRIMARY KEY (idBorne)";
        return statementStrings;
    }
}
