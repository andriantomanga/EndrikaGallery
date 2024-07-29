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
        graphics.setColor(Color.RED);
        int[] xPoints = {
                377, 380, 368, 352, 331, 330, 305, 253, 189, 160, 163, 140,
                141, 165, 163, 142, 117, 104, 109, 122, 123, 140, 197, 197,
                215, 252, 272, 293, 409, 402, 423, 414, 425, 441, 453, 441,
                436, 422, 398, 382
        };
        int[] yPoints = {
                95, 105, 134, 144, 141, 173, 199, 245, 268, 270, 290, 340,
                353, 441, 461, 500, 535, 567, 617, 656, 693, 727, 762, 761,
                757, 736, 737, 719, 347, 327, 280, 239, 233, 256, 224, 199,
                156, 106, 71, 77
        };

        graphics.fillPolygon(xPoints, yPoints, yPoints.length);
    }

}
