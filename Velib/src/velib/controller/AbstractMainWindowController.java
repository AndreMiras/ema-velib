package velib.controller;

import javax.swing.JPanel;

public class AbstractMainWindowController
{
    public MainWindowController mainWindowController;

    public AbstractMainWindowController(MainWindowController mainWindowController)
    {
        this.mainWindowController = mainWindowController;
    }

    protected void setMainWindowContentPanel(JPanel jpanel)
    {
        mainWindowController.setMainWindowContentPanel(jpanel);
    }


    protected void initMainWindow()
    {
        mainWindowController.mainWindowFrameSetup();
    }

}
