package com.endrikagallery.artworks.andriantomanga;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class SpiralArtwork extends AbstractArtwork {
    public SpiralArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        final int centerX = 400;
        final int centerY = 300;
        final int radius = 200;
        final int numTurns = 10;
        final int numPoints = 100;

        g2d.setStroke(new java.awt.BasicStroke(2));

        for (int i = 0; i < numPoints; i++) {
            double angle = 2 * Math.PI * i / numPoints * numTurns;
            double r = radius * (i / (double) numPoints);
            int x = (int) (centerX + r * Math.cos(angle));
            int y = (int) (centerY + r * Math.sin(angle));

            g2d.setColor(new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)
            ));

            g2d.draw(new Ellipse2D.Double(x, y, 5, 5));
        }
    }
}
