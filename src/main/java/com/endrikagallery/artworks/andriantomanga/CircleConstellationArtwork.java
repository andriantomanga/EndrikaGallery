package com.endrikagallery.artworks.andriantomanga;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class CircleConstellationArtwork extends AbstractArtwork {

    public static final int DELTA_X = 90;
    public static final int DELTA_Y = 90;

    public CircleConstellationArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
//        int[] xValues = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
//        int[] yValues = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};

        int[] xValues = {110, 134, 218, 146, 166, 110, 54, 74, 2, 86};
        int[] yValues = {0, 72, 72, 108, 192, 144, 192, 108, 72, 72};

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        var path = new GeneralPath();

        path.moveTo(DELTA_X + xValues[0], DELTA_Y + yValues[0]);

        for (int i = 1; i < xValues.length; i++) {
            path.lineTo(DELTA_X + xValues[i], DELTA_Y + yValues[i]);
        }

        path.closePath();
        graphics2D.translate(DELTA_X + 150, DELTA_Y + 150);
        Random rNumbers = new Random();
        for (int i = 1; i <= 20; i++) {
            graphics2D.rotate(Math.PI / 10.0, DELTA_X, DELTA_Y);
            graphics2D.setColor(new Color(rNumbers.nextInt(256), rNumbers.nextInt(256), rNumbers.nextInt(256)));
            graphics2D.fill(path);
        }
        graphics2D.dispose();
    }
}
