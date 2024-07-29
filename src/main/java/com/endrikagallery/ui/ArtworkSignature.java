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

package com.endrikagallery.ui;

import com.endrikagallery.Artwork;
import com.endrikagallery.utils.StringUtil;

import java.awt.*;

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class ArtworkSignature {
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 14);
    private static final Font DETAIL_FONT = new Font("Arial", Font.PLAIN, 13);

    private final Artwork currentArtwork;

    public ArtworkSignature(Artwork currentArtwork) {
        this.currentArtwork = currentArtwork;
    }

    public void sign(Graphics2D graphics, int x, int y) {
        graphics.setColor(Color.BLACK);
        graphics.setFont(TITLE_FONT);
        graphics.drawString(currentArtwork.getInfos().name(), x, y);

        graphics.setFont(DETAIL_FONT);
        graphics.drawString(currentArtwork.getInfos().description(), x, y + 20);

        var artist = currentArtwork.getArtistInfos();
        graphics.drawString(artist.name() + "(https://github.com/" + artist.githubId() + ")", x, y + 40);

        if (artist.country().isKnown()) {
            graphics.drawString("Artist from " + artist.country().getName(), x, y + 60);
        }

        if (StringUtil.isNotEmpty(artist.email())) {
            graphics.drawString(artist.email(), x, y + 80);
        }
        if (StringUtil.isNotEmpty(artist.phone())) {
            graphics.drawString(artist.phone(), x, y + 100);
        }
    }
}
