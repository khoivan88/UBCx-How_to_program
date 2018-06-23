package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;
import util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PrettierMarker extends MapMarkerCircle {
    public static final double defaultMarkerSize = 15.0;
    public static final int defaultProfileSize = (int) (defaultMarkerSize*1.5);

    private BufferedImage image;
    private Status status;


    public PrettierMarker(Status s, Layer layer, Coordinate coord, Color color) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        this.status = s;
        this.image = Util.imageFromURL(status.getUser().getProfileImageURL());
        setColor(Color.BLACK);
        setBackColor(color);
    }


    @Override
    public void paint(Graphics g, Point position, int radius) {
        int size = radius * 2;
        if (g instanceof Graphics2D && this.getBackColor() != null) {
            Graphics2D g2 = (Graphics2D)g;
            Composite oldComposite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(3));
            g2.setPaint(this.getBackColor());
            g.fillOval(position.x - radius, position.y - radius, size, size);
            g2.setComposite(oldComposite);
        }

        g.setColor(this.getColor());
        g.drawOval(position.x - radius, position.y - radius, size, size);

        //To add profile picture onto the marker:
        g.drawImage(this.image, position.x - defaultProfileSize/2, position.y - defaultProfileSize/2, defaultProfileSize, defaultProfileSize, null);
//        g.drawImage(this.image, position.x - radius, position.y - radius, size, size, null);


        if (this.getLayer() == null || this.getLayer().isVisibleTexts()) {
            this.paintText(g, position);
        }

    }

    public String getTweet() {
        return this.status.getText();
    }

    public Status getStatus() {
        return status;
    }
}
