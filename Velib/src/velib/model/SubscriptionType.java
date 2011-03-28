/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package velib.model;

/**
 *
 * @author Nicolas
 * TODO: not used, to be removed
 */
public class SubscriptionType
{
    private float prix;
    private int duree; // TODO: what type should we use?
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
        return getSubscriptionTypeEnum().getIntSubscriptionTypeEnum();
    }

    public int getDuree()
    {
        return duree;
    }

    public float getPrix()
    {
        return prix;
    }

    public void setDuree(int duree)
    {
        this.duree = duree;
    }

    public void setPrix(float prix)
    {
        this.prix = prix;
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
                    prix = 1;
                    break;
                case ONE_DAY:
                    prix = 2;
                    break;

                /* long subscription */
                case ONE_WEEK:
                    prix = 10;
                    break;
                case ONE_MONTH:
                    prix = 20;
                    break;
                case ONE_YEAR:
                    prix = 30;
                    break;
                default:
                    System.out.println("Unknown type");
                    break;
            }
        }
    }

 }
