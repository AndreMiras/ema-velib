package velib.model;

/**
 * TODO: not used, to be removed
 */
public class SubscriptionType
{
    private float price;
    private int duration; // TODO: what type should we use?
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
        setPriceAndDureeFromType();
    }

    public SubscriptionTypeEnum getSubscriptionTypeEnum()
    {
        return subscriptionTypeEnum;
    }

    public long getIdType()
    {
        return getSubscriptionTypeEnum().getId();
    }

    public int getDuration()
    {
        return duration;
    }

    public float getPrice()
    {
        return price;
    }

    public void setDuree(int duration)
    {
        this.duration = duration;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    // TODO: duree -> to english
    // TODO: hardcoded price values
    private void setPriceAndDureeFromType()
    {
        if (subscriptionTypeEnum != null)
        {
            switch(subscriptionTypeEnum)
            {
                /* short subscription */
                case HALF_DAY:
                    price = 1;
                    break;
                case ONE_DAY:
                    price = 2;
                    break;

                /* long subscription */
                case ONE_WEEK:
                    price = 10;
                    break;
                case ONE_MONTH:
                    price = 20;
                    break;
                case ONE_YEAR:
                    price = 30;
                    break;
                default:
                    System.out.println("Unknown type");
                    break;
            }
        }
    }

 }
