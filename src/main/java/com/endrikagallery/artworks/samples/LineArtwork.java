package com.endrikagallery.artworks.samples;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.Color;
import java.awt.Graphics;

public class LineArtwork extends AbstractArtwork {
    public LineArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawLine(200, 200, 200, 200);
    }
}
