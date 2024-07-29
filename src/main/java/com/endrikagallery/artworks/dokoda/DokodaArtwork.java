package com.endrikagallery.artworks.dokoda;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.*;

public class DokodaArtwork extends AbstractArtwork {

    public DokodaArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRoundRect(200, 200, 400, 150 , 7, 7);
    }
}
