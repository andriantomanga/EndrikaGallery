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
