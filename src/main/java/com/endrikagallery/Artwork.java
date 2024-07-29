package com.endrikagallery;

import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.*;

public interface Artwork {
    void expresses(Graphics graphics);

    ArtworkInfos getInfos();

    ArtistInfos getArtistInfos();
}
