package velib.dao;

import velib.model.Borne;

/**
 * @author andre
 * TODO: ? with the associated controller save the Borne id within a file?
 */
public class BorneSingleton
{

    private static Borne borne;

    public static Borne getInstance()
    {
        BornesDAO borneDAO;
        
        if(borne == null)
        {
            borneDAO = new BornesDAO();
            // TODO: hardcoded to be changed
            borne = borneDAO.find(1);
        }

        return borne;
    }

    public static void setBorne(Borne borne)
    {
        BorneSingleton.borne = borne;
    }


}

