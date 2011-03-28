package velib.model;

import java.util.Calendar;
import java.util.Date;

public class Subscription
{

    private long id;
    private Date startDate;
    private Date endDate;
    private Client client;
    private SubscriptionType subscriptionType;
  
    public Subscription()
    {
        this(0, new SubscriptionType());
    }

    public Subscription(long id, SubscriptionType subscriptionType)
    {
        this.id = id;
        startDate = new Date();
        endDate = new Date();
        this.subscriptionType = subscriptionType;
        
        setEndDateFromDuration();

        /*
         * TODO: set dateDebut based on type
         */
        // TODO: this.dateFin = new Date();
    }

    /*
     * Sets the end date from the subscriptionType duration
     * Adds duration (in hours) to today date
     */
    private void setEndDateFromDuration()
    {
        Date today = new Date();
        endDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        
        // adding X hours to today
        calendar.add(Calendar.HOUR,
                (int)subscriptionType.getSubscriptionTypeEnum().getDuration());
    }
    
    public void reloadSubscription()
    {
        setEndDateFromDuration();
    }



    public long getId()
    {
        return id;
    }

    public Date getStartDate()
    {
        return new Date(startDate.getTime());
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }


    public Client getClient()
    {
        return client;
    }

    public SubscriptionType getType()
    {
        return subscriptionType;
    }

    public void setType(SubscriptionType type)
    {
        this.subscriptionType = type;
    }
    

}
