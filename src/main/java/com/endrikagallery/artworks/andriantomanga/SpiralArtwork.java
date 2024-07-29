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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class SpiralArtwork extends AbstractArtwork {
    public SpiralArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        var centerX = 400;
        var centerY = 300;
        var radius = 200;
        var numTurns = 10;
        var numPoints = 100;

        g2d.setStroke(new java.awt.BasicStroke(2));

        for (int i = 0; i < numPoints; i++) {
            var angle = 2 * Math.PI * i / numPoints * numTurns;
            var r = radius * (i / (double) numPoints);
            var x = (int) (centerX + r * Math.cos(angle));
            var y = (int) (centerY + r * Math.sin(angle));

            g2d.setColor(new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)
            ));

            g2d.draw(new Ellipse2D.Double(x, y, 5, 5));
        }
    }
}
