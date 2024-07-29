package com.endrikagallery.artworks.andriantomanga;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Dans cet exemple, ModernArtArtwork utilise l'interface graphique pour dessiner une composition géométrique inspirée par Piet Mondrian.
 * Elle utilise des couleurs primaires et des lignes noires pour créer une œuvre d'art moderne. Vous pouvez ajuster les dimensions,
 * les couleurs et les positions pour créer une œuvre unique et impressionnante.
 */
public class ModernArtArtwork extends AbstractArtwork {
    public ModernArtArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        // Draw background
        g2d.setColor(Color.WHITE);
        g2d.fillRect(100, 100, 800, 600);

        // Draw grid
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));

        // Horizontal lines
        g2d.drawLine(150, 100, 850, 100);
        g2d.drawLine(150, 300, 850, 300);
        g2d.drawLine(150, 500, 850, 500);
        g2d.drawLine(150, 700, 850, 700);

        // Vertical lines
        g2d.drawLine(150, 100, 150, 700);
        g2d.drawLine(300, 100, 300, 700);
        g2d.drawLine(500, 100, 500, 700);
        g2d.drawLine(700, 100, 700, 700);
        g2d.drawLine(850, 100, 850, 700);

        // Draw colored rectangles
        g2d.setColor(Color.RED);
        g2d.fillRect(150, 150, 150, 150);

        g2d.setColor(Color.BLUE);
        g2d.fillRect(300, 300, 150, 150);

        g2d.setColor(Color.YELLOW);
        g2d.fillRect(500, 500, 150, 150);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(700, 600, 150, 50);
    }
}
