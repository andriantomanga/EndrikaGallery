package com.endrikagallery.artworks.dago;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.Color;
import java.awt.Graphics;

public class DagoArtwork extends AbstractArtwork {
    public DagoArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        super(artworkInfos, artistInfos);
    }

    @Override
    public void expresses(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int[] xPoints = {
                377, 380, 368, 352, 331, 330, 305, 253, 189, 160, 163, 140,
                141, 165, 163, 142, 117, 104, 109, 122, 123, 140, 197, 197,
                215, 252, 272, 293, 409, 402, 423, 414, 425, 441, 453, 441,
                436, 422, 398, 382
        };
        int[] yPoints = {
                175, 185, 214, 224, 221, 253, 279, 325, 348, 350, 370, 420,
                433, 521, 541, 580, 615, 647, 697, 736, 773, 807, 842, 841,
                837, 816, 817, 799, 427, 407, 360, 319, 313, 336, 304, 279,
                236, 186, 151, 157
        };
        graphics.drawPolygon(xPoints, yPoints, yPoints.length);
    }

}
