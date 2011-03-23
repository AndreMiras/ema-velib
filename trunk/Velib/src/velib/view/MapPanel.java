/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MapPanel.java
 *
 * Created on Mar 7, 2011, 10:08:33 AM
 */

package velib.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import velib.dao.BorneSingleton;
import velib.dao.BornesDAO;
import velib.model.Borne;

/**
 *
 * @author andre
 * Using Google Map static API
 */
public class MapPanel extends javax.swing.JPanel
{

    /*
     * "http://maps.google.com"
        + "/maps/api/staticmap?"
        + "center=France,Nimes&zoom=14&size=400x400&sensor=false
     */
    // If thisStation isn't initialised, take Nimes center
    private String defaultLocation = "France,Nimes";

    private Borne thisStation;
    private Borne[] otherStations;
    
    private BufferedImage image;


    /** Creates new form MapPanel */
    public MapPanel()
    {
        initComponents();

        this.thisStation = BorneSingleton.getInstance();

        setUpMapImage();
    }

    public void setThisStation(Borne station)
    {
        this.thisStation = station;
    }

    public void setOtherStations(Borne[] stations)
    {
        this.otherStations = stations;
    }

    /*
     * TODO: finish up
     */
    private String createUrlString()
    {
        String latLongString;
        double latlong[];
        String stationMarker;

        /*
         * If thisStation was init
         */
        if (thisStation != null)
        {
            latlong = thisStation.getLatLong();
            latLongString =
                    createLatLongString(latlong); // center the map to the station
        }
        else // set it to the default location
        {
            latLongString = defaultLocation;
            latlong = null;
        }
        String otherStationMarkers = "";
        stationMarker = createMarkerString("blue",
                "S", latlong);

        // TODO: to be moved to a dedicated function for redability
        if (otherStations != null)
        {
            for(int i=0; i<otherStations.length; i++)
            {
                otherStationMarkers += createMarkerString("green",
                    "S", otherStations[i].getLatLong());
                if (i<otherStations.length-1)
                {
                   otherStationMarkers += "&";
                }
            }
        }


        // TODO: split up server and GET url
        String urlString =
        "http://maps.google.com"
        + "/maps/api/staticmap?"
        + "center="
        // + "France,Nimes"
        + createLatLongString(latlong) // center the map to the station
        + "&zoom=14&"
        + "size="
        + createSizeString(this.getPreferredSize()) // map to be panel size
        + "&sensor=false"
        + "&"
        + stationMarker
        + "&"
        + otherStationMarkers;

        return urlString;
    }

    public void updateMapImage()
    {
        setUpMapImage();
    }

    private void setUpMapImage()
    {
        URL url = null;
        String urlString = createUrlString();
        try
        {
            url = new URL(urlString);
        }
        catch (MalformedURLException ex)
        {
            Logger.getLogger(MapPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            image = ImageIO.read(url);
        }
        catch (IOException ex)
        {
            Logger.getLogger(
                    MapPanel.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    private String createSizeString(Dimension dimension)
    {
        String sizeString =
            dimension.width +
            "x" +
            dimension.height;
        return sizeString;
    }

    private String createLatLongString(double latlong[])
    {
        String latLongString = "";
        if (latlong != null)
        {
            latLongString =
                latlong[0] +
                "," +
                latlong[1];
        }

        return latLongString;
    }

     
    // TODO: cleaning: java color object
    private String createMarkerString(
            String color, String label, double latlong[])
    {
        String markerString;
        String latLongString = createLatLongString(latlong);

        if (!latLongString.isEmpty())
        {
            markerString =
                "markers=color:" + color +
                "%7C" +
                "label:" + label +
                "%7C" +
                latLongString;
        }
        else
        {
            markerString = "";
        }

        return markerString;
    }

    /*
     * Centers the map to X, Y
     */
    public void setCenter()
    {
        
    }

    @Override
    public void paintComponent(Graphics g)
    {
        // see javadoc for more info on the parameters
        g.drawImage(image, 0, 0, null);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder("Map"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
