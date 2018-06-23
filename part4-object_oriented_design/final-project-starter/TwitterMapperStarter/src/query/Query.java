package query;

import filters_original.Filter;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import twitter4j.Status;
import ui.PrettierMarker;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

/**
 * A query over the twitter stream.
 * TODO: Task 4: you are to complete this class.
 */
public class Query implements Observer {
    // The map on which to display markers when the query matches
    private final JMapViewer map;
    // Each query has its own "layer" so they can be turned on and off all at once
    private Layer layer;
    // The color of the outside area of the marker
    private final Color color;
    // The string representing the filter for this query
    private final String queryString;
    // The filter parsed from the queryString
    private final Filter filter;
    // The checkBox in the UI corresponding to this query (so we can turn it on and off and delete it)
    private JCheckBox checkBox;

    public Color getColor() {
        return color;
    }
    public String getQueryString() {
        return queryString;
    }
    public Filter getFilter() {
        return filter;
    }
    public Layer getLayer() {
        return layer;
    }
    public JCheckBox getCheckBox() {
        return checkBox;
    }
    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }
    public void setVisible(boolean visible) {
        layer.setVisible(visible);
    }
    public boolean getVisible() { return layer.isVisible(); }

    public Query(String queryString, Color color, JMapViewer map) {
        this.queryString = queryString;
        this.filter = Filter.parse(queryString);
        this.color = color;
        this.layer = new Layer(queryString);
        this.map = map;
    }

    @Override
    public String toString() {
        return "Query: " + queryString;
    }

    /**
     * This query is no longer interesting, so terminate it and remove all traces of its existence.
     *
     * TODO: Implement this method
     */
    public void terminate() {
        setVisible(false);
        checkBox = null;
    }

    @Override
    public void update(Observable o, Object arg) {
        Status s = (Status) arg;
        if (getFilter().matches(s)) {
//            MapMarkerSimple marker = new MapMarkerSimple(getLayer(), Util.statusCoordinate(s));
//            PrettierMarker marker = new PrettierMarker(getLayer(), util.Util.statusCoordinate(s), getColor());

//            PrettierMarker marker = new PrettierMarker(getLayer(), Util.statusCoordinate(s), getColor(),
//                                                        Util.imageFromURL(s.getUser().getProfileImageURL()).getGraphics());
            PrettierMarker marker = new PrettierMarker(s, getLayer(), Util.statusCoordinate(s), getColor());
//            PrettierMarker marker = new PrettierMarker(s, getLayer(), Util.statusCoordinate(s), getColor(),
//                    Util.imageFromURL(s.getUser().getProfileImageURL()));


            map.addMapMarker(marker);
        }
    }

    private static BufferedImage convertToBufferedImage(Image image)
    {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}

