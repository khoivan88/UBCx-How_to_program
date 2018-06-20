package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;

public class PrettierMarker extends MapMarkerCircle {
    public static final double defaultMarkerSize = 5.0;
//    public static final Color defaultColor = Color.red;
//    public static final Point defaultPoint = new Point();

    public PrettierMarker(Layer layer, Coordinate coord, Color color) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);
    }

    public PrettierMarker(Layer layer, Coordinate coord, Color color, Graphics graphic) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);
        paint(graphic, new Point((int) coord.getLat(), (int) coord.getLon()), (int) defaultMarkerSize);

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
        if (this.getLayer() == null || this.getLayer().isVisibleTexts()) {
            this.paintText(g, position);
        }

    }

}
