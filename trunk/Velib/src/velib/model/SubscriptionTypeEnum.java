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
public enum SubscriptionTypeEnum
{
    // long
    HALF_DAY(1,
    12),
    ONE_DAY(2,
    24),
            
    // short
    ONE_WEEK(3,
    7*24),
    ONE_MONTH(4,
    30*24),
    ONE_YEAR(5,
    365*24);
    
    private long id;
    private long duration; // in hours

    private SubscriptionTypeEnum(long id, long duration)
    {
        this.id = id;
        this.duration = duration;
    }


    public long getId()
    {
        return id;
    }

    public long getDuration()
    {
        return duration;
    }

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
