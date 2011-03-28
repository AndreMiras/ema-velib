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
    12,
    1),
    ONE_DAY(2,
    24,
    2),
            
    // short
    ONE_WEEK(3,
    7*24,
    10),
    ONE_MONTH(4,
    30*24,
    20),
    ONE_YEAR(5,
    365*24,
    30);
    
    private long id;
    private long duration; // in hours
    private long price; // in euros

    private SubscriptionTypeEnum(long id, long duration, long price)
    {
        this.id = id;
        this.duration = duration;
        this.price = price;
    }


    public long getId()
    {
        return id;
    }

    public long getDuration()
    {
        return duration;
    }

    public long getPrice()
    {
        return price;
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
