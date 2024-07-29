package com.endrikagallery.artworks.xrado;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.*;

public class XRadoDagoArtwork extends AbstractArtwork {

    public XRadoDagoArtwork(ArtworkInfos artwork, ArtistInfos artist) {
        super(artwork, artist);
    }

    @Override
    public void expresses(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawOval(200, 200, 200, 200);
    }
}
