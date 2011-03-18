/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.dao;

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
    public TypeAbonnement find(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TypeAbonnement create(TypeAbonnement obj) {
        throw new UnsupportedOperationException("Not supported yet.");
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
                    "prix INTEGER, " , tableNames[0]);
      statementStrings[2] =
                "ALTER TABLE"
                + tableNames[0]
                + "ADD CONSTRAINT primary_key_typeAbo PRIMARY KEY (idtype)";
        return statementStrings;
    }

}
