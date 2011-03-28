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
    HALF_DAY(1),
    ONE_DAY(2),
            
    // short
    ONE_WEEK(3),
    ONE_MONTH(4),
    ONE_YEAR(5);
    
    private long intSubscriptionTypeEnum;

    private SubscriptionTypeEnum(long intSubscriptionTypeEnum)
    {
        this.intSubscriptionTypeEnum = intSubscriptionTypeEnum;
    }


    public long getIntSubscriptionTypeEnum()
    {
        return intSubscriptionTypeEnum;
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
