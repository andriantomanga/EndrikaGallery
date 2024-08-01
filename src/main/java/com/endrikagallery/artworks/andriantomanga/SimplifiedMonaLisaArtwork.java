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

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class SimplifiedMonaLisaArtwork extends AbstractArtwork {
    private static final Color SKIN_COLOR = new Color(255, 224, 189);

    public SimplifiedMonaLisaArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;

        // Couleur de fond
        g2d.setColor(new Color(155, 160, 104));
        g2d.fillRect(50, 50, 700, 500);

        // Fond du visage
        g2d.setColor(SKIN_COLOR); // Couleur de la peau
        g2d.fillOval(275, 150, 200, 230);

        // Dessiner les yeux
        g2d.setColor(Color.WHITE);
        g2d.fillOval(320, 250, 30, 20); // Œil gauche
        g2d.fillOval(380, 250, 30, 20); // Œil droit
        g2d.setColor(Color.BLACK);
        g2d.fillOval(328, 253, 15, 15); // Œil gauche (pupille)
        g2d.fillOval(388, 253, 15, 15); // Œil droit (pupille)

        // Dessiner le sourire
        g2d.drawArc(345, 330, 30, 5, 0, -180);

        // Dessiner les cheveux
        g2d.setColor(new Color(102, 51, 0)); // Couleur des cheveux bruns
        g2d.fillRect(275, 150, 200, 35); // Cheveux du dessus
        g2d.fillRect(265, 170, 40, 200); // Cheveux à gauche
        g2d.fillRect(440, 170, 50, 200); // Cheveux à droite

        // Dessiner le nez
        g2d.drawArc(350, 315, 10, 4, 0, -180);

        // Dessiner la robe
        g2d.setColor(new Color(40, 25, 36)); // Couleur sombre de la robe
        g2d.fillRect(275, 400, 200, 150); // Robe

        // Dessiner la main gauche
        g2d.setColor(SKIN_COLOR); // Couleur de la peau
        g2d.fillRoundRect(350, 510, 70, 20, 10, 10); // Main gauche

        // Dessiner la main droite reposant sur la main gauche
        g2d.fillRoundRect(370, 520, 70, 20, 10, 10); // Main droite

        // Dessiner George
        g2d.fillRect(365, 350, 70, 50);

        // Dessiner la poitrine
        g2d.fillRect(305, 400, 140, 50);

        // Cadre de la photo
        g2d.setStroke(new BasicStroke(7));
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 50, 700, 500);
    }
}
