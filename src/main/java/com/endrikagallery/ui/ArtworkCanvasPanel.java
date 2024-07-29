package com.endrikagallery.ui;

import com.endrikagallery.Artwork;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;

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
