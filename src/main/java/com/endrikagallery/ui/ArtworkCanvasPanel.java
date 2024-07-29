/**
 * Copyright (c) 2024 Nabil Andriantomanga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.endrikagallery.ui;

import com.endrikagallery.Artwork;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class ArtworkCanvasPanel extends JPanel {
    private Artwork currentArtwork;

    public ArtworkCanvasPanel(List<Artwork> artworks) {
        if (!artworks.isEmpty()) {
            this.currentArtwork = artworks.get(0);
        }
    }

    public void setCurrentArtwork(Artwork artwork) {
        this.currentArtwork = artwork;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (currentArtwork != null) {
            currentArtwork.expresses(graphics);
        }
    }
}
