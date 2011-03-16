/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author andre
 */

/*
 * List of supported abonnements types
 */
public enum AbonnementType
{
    // long
    HALF_DAY,
    ONE_DAY,
            
    // short
    ONE_WEEK,
    ONE_MONTH,
    ONE_YEAR;

    @Override public String toString()
    {
        // only capitalize the first letter
        String s = super.toString();
        return s.substring(0, 1) + s.substring(1).toLowerCase();
    }

    public String value()
    {
        return super.toString();
    }
}
