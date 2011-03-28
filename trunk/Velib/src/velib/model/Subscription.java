package velib.model;

import java.util.Calendar;
import java.util.Date;

public class Subscription
{

    private long id;
    private Date dateDebut;
    private Date dateFin;
    private Client client;
    private SubscriptionType subscriptionType;
  
    public Subscription()
    {
        this(0, new SubscriptionType());
    }

    public Subscription(long id, SubscriptionType subscriptionType)
    {
        this.id = id;
        dateDebut = new Date();
        dateFin = new Date();
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
        dateFin = new Date();
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

    public Date getDateDebut()
    {
        return new Date(dateDebut.getTime());
    }

    public Date getDateFin()
    {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut)
    {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin)
    {
        this.dateFin = dateFin;
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
