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
import com.endrikagallery.sorter.ArtworkByCountrySorter;
import com.endrikagallery.sorter.ArtworkByNameSorter;
import com.endrikagallery.sorter.ArtworkFilterSorter;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

/**
 * @author Nabil Andriantomanga
 * @version 1.0
 * @since 2024
 */
public class EndrikaGalleryUI extends JFrame {

    private ArtworkCanvasPanel canvasPanel;
    private ArtworkListPanel artworkListPanel;

    public EndrikaGalleryUI(List<Artwork> artworks) {
        setTitle("Endrika Gallery");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        var sorters = Map.of(
                "Name", new ArtworkByNameSorter(),
                "Country", new ArtworkByCountrySorter()
        );

        var artworkFilterSorter = new ArtworkFilterSorter(sorters);
        canvasPanel = new ArtworkCanvasPanel(artworks);
        artworkListPanel = new ArtworkListPanel(artworks, artworkFilterSorter, canvasPanel::setCurrentArtwork);

        var splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, artworkListPanel, canvasPanel);
        splitPane.setDividerLocation(400);
        splitPane.setOneTouchExpandable(true);

        add(splitPane, BorderLayout.CENTER);
    }
}
