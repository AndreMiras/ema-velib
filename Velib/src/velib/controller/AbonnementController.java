package velib.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import velib.dao.AbonnementDAO;
import velib.model.Subscription;
import velib.model.SubscriptionTypeEnum;
import velib.model.SubscriptionType;
import velib.view.AbonnementPanel;
import velib.view.RegisterFormPanel;

public class AbonnementController extends AbstractMainWindowController
{
    private AbonnementPanel abonnementPanel;
    

    public AbonnementController(MainWindowController mainWindowController,
            AbonnementPanel abonnementPanel)
    {
        super(mainWindowController);
        this.abonnementPanel = abonnementPanel;

        abonnementPanel.addAbonnementGroupButtonListener(
                new AbonnementTypeGroupButtonListener());
    }

    class AbonnementTypeGroupButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand;
            SubscriptionTypeEnum abonnementType;
            JButton clickedButton = (JButton)e.getSource();

            actionCommand = clickedButton.getActionCommand();
            abonnementType = SubscriptionTypeEnum.valueOf(actionCommand);
            
            switch(abonnementType)
            {
                /* short subscription */
                case HALF_DAY:
                    System.out.println("bar");
                    break;
                case ONE_DAY:
                    System.out.println("foo");
                    break;
                    
                /* long subscription */
                case ONE_WEEK:
                    longSubscription(abonnementType);
                    break;
                case ONE_MONTH:
                    longSubscription(abonnementType);
                    break;
                case ONE_YEAR:
                    longSubscription(abonnementType);
                    break;
                default:
                    System.out.println("Unknown");
                    break;
            }
        }

        /*
         * TODO: finish up
         */
        private void shortSubscription()
        {
            
        }

        private void longSubscription(SubscriptionTypeEnum abonnementType)
        {
            SubscriptionType typeAbonnement;
            Subscription subscription;
            AbonnementDAO subscriptionDAO = new AbonnementDAO();
            /*
             * Create the subscription object and save it to the DB
             * TODO: this is to be redone
             */
            typeAbonnement = new SubscriptionType(abonnementType);
            // Hit the database with the subscription object
            subscription = new Subscription(0, typeAbonnement);
            subscriptionDAO.create(subscription);

            
            RegisterFormPanel registerFormPanel = new RegisterFormPanel();
            /*
             * Passing the subscription object to the next controller
             * so it will add it to the client object after creating it
             */
            RegisterFormController registerFormController =
                    new RegisterFormController(mainWindowController,
                    subscription, registerFormPanel);
            registerFormPanel.setVisible(true);

            setMainWindowContentPanel(registerFormPanel);
        }
    }

    
}
