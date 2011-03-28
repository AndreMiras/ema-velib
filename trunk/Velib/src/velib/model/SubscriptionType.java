package velib.model;

/**
 * TODO: not used, to be removed
 */
public class SubscriptionType
{
    private float price;
    private long duration; // TODO: what type should we use?
    private SubscriptionTypeEnum subscriptionTypeEnum;

    public SubscriptionType()
    {
        // one day by default
        this(SubscriptionTypeEnum.ONE_DAY);
    }

    public SubscriptionType(SubscriptionTypeEnum subscriptionTypeEnum)
    {
        /*
         * TODO: set duree and price
         */
        this.subscriptionTypeEnum = subscriptionTypeEnum;
        setPriceAndDurationFromType();
    }

    public SubscriptionTypeEnum getSubscriptionTypeEnum()
    {
        return subscriptionTypeEnum;
    }

    public long getIdType()
    {
        return getSubscriptionTypeEnum().getId();
    }

    public long getDuration()
    {
        return duration;
    }

    public float getPrice()
    {
        return price;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    // TODO: hardcoded price values
    private void setPriceAndDurationFromType()
    {
        if (subscriptionTypeEnum != null)
        {
            duration = subscriptionTypeEnum.getDuration();
            price = subscriptionTypeEnum.getPrice();
        }
    }

 }
