package com.endrikagallery;

import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;

import java.awt.Graphics;

public abstract class AbstractArtwork implements Artwork {
    private final ArtworkInfos infos;
    private final ArtistInfos artistInfos;

    public AbstractArtwork(ArtworkInfos artworkInfos, ArtistInfos artistInfos) {
        this.infos = artworkInfos;
        this.artistInfos = artistInfos;
    }

    @Override
    public abstract void expresses(Graphics graphics);

    @Override
    public ArtworkInfos getInfos() {
        return infos;
    }


    @Override
    public ArtistInfos getArtistInfos() {
        return artistInfos;
    }
}