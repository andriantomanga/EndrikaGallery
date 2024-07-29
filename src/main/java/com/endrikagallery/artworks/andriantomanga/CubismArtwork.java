/**
 * Copyright (c) 2024 Nabil Andriantomanga
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.endrikagallery.artworks.andriantomanga;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * Cette classe interprète le cubisme en utilisant des formes géométriques imbriquées.
 * L'œuvre est centrée à l'intérieur du rectangle gris avec une grande marge à gauche et en haut.
 */
public class CubismArtwork extends AbstractArtwork {
    private static final int MARGIN_LEFT = 100;   // Grande marge à gauche
    private static final int MARGIN_TOP = 100;    // Grande marge en haut
    private static final int MARGIN_RIGHT = 70;   // Marges à droite
    private static final int MARGIN_BOTTOM = 70;  // Marges en bas
    private static final int ARTWORK_WIDTH = 600; // Largeur fixe de l'œuvre
    private static final int ARTWORK_HEIGHT = 400; // Hauteur fixe de l'œuvre
    private static final int WIDTH = 800;         // Largeur du canvas
    private static final int HEIGHT = 600;        // Hauteur du canvas

    public CubismArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        // Draw background
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(MARGIN_LEFT, MARGIN_TOP, WIDTH - MARGIN_LEFT - MARGIN_RIGHT, HEIGHT - MARGIN_TOP - MARGIN_BOTTOM);

        // Calculate the coordinates to center the artwork
        int artworkX = MARGIN_LEFT + (WIDTH - MARGIN_LEFT - MARGIN_RIGHT - ARTWORK_WIDTH) / 2;
        int artworkY = MARGIN_TOP + (HEIGHT - MARGIN_TOP - MARGIN_BOTTOM - ARTWORK_HEIGHT) / 2;

        // Draw random polygons
        g2d.setStroke(new BasicStroke(3));
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE};
        for (int i = 0; i < 10; i++) {
            g2d.setColor(colors[i % colors.length]);

            GeneralPath path = new GeneralPath();
            int x = artworkX + (int)(Math.random() * ARTWORK_WIDTH);
            int y = artworkY + (int)(Math.random() * ARTWORK_HEIGHT);
            path.moveTo(x, y);

            for (int j = 0; j < 5; j++) {
                x += (int)(Math.random() * 100) - 50;
                y += (int)(Math.random() * 100) - 50;
                path.lineTo(Math.max(artworkX, Math.min(artworkX + ARTWORK_WIDTH, x)),
                        Math.max(artworkY, Math.min(artworkY + ARTWORK_HEIGHT, y)));
            }

            path.closePath();
            g2d.fill(path);
        }

        // Draw the centered black frame
        g2d.setColor(Color.BLACK);
        g2d.drawRect(artworkX, artworkY, ARTWORK_WIDTH, ARTWORK_HEIGHT);

        // Draw lines within the centered black frame
        for (int i = 0; i < 5; i++) {
            int x1 = artworkX + (int)(Math.random() * ARTWORK_WIDTH);
            int y1 = artworkY + (int)(Math.random() * ARTWORK_HEIGHT);
            int x2 = artworkX + (int)(Math.random() * ARTWORK_WIDTH);
            int y2 = artworkY + (int)(Math.random() * ARTWORK_HEIGHT);
            g2d.drawLine(x1, y1, x2, y2);
        }
    }
}
