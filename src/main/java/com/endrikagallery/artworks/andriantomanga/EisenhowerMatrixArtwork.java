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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * <pre>
 *     “I have two kinds of problems: the urgent and the important
 *     The urgent are not important, and the important are never urgent.”
 *                                               — Dwight D. Eisenhower
 * </pre>
 *
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class EisenhowerMatrixArtwork extends AbstractArtwork {
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 20);
    private static final Font DETAIL_FONT = new Font("Arial", Font.BOLD, 13);

    private static final int X_OFFSET = 100;
    private static final int Y_OFFSET = 100;

    private static final int BOX_WIDTH = 200;
    private static final int BOX_HEIGHT = 150;

    private static final int MARGIN = 20;

    private static final Color[] BOX_COLORS = {
            new Color(252, 186, 3),
            new Color(245, 155, 130),
            new Color(201, 197, 195),
            new Color(152, 232, 123)
    };

    private static final String[] BOX_TITLES = {
            "Do", "Schedule", "Delegate", "Delete"
    };

    private static final String[] BOX_DETAILS = {
            "Do it now", "Schedule a time to do it", "Who can do it for you?", "Eliminate it"
    };

    private static final int[][] BOX_POSITIONS = {
            {0, 0},
            {1, 0},
            {0, 1},
            {1, 1}
    };

    public EisenhowerMatrixArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(7));

        drawMatrixBoxes(g2d);
        drawLabels(g2d);
    }

    private void drawMatrixBoxes(Graphics2D g2d) {
        for (var i = 0; i < BOX_POSITIONS.length; i++) {
            var x = X_OFFSET + BOX_POSITIONS[i][0] * (BOX_WIDTH + MARGIN);
            var y = Y_OFFSET + BOX_POSITIONS[i][1] * (BOX_HEIGHT + MARGIN);

            g2d.setColor(BOX_COLORS[i]);
            g2d.fillRect(x, y, BOX_WIDTH, BOX_HEIGHT);

            g2d.setColor(Color.BLACK);
            g2d.setFont(TITLE_FONT);
            g2d.drawString(BOX_TITLES[i], x + MARGIN, y + MARGIN);

            g2d.setFont(DETAIL_FONT);
            g2d.drawString(BOX_DETAILS[i], x + MARGIN, y + 2 * MARGIN);
        }
    }

    private void drawLabels(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.setFont(DETAIL_FONT);

        g2d.drawString("Urgent", X_OFFSET + MARGIN, Y_OFFSET - MARGIN);
        g2d.drawString("Not Urgent", X_OFFSET + BOX_WIDTH + 2 * MARGIN, Y_OFFSET - MARGIN);

        g2d.drawString("Important", X_OFFSET + 2 * MARGIN + 2 * BOX_WIDTH, Y_OFFSET + BOX_HEIGHT / 2);
        g2d.drawString("Not Important", X_OFFSET + 2 * MARGIN + 2 * BOX_WIDTH, Y_OFFSET + BOX_HEIGHT + BOX_HEIGHT / 2);
    }
}
