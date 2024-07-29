package com.endrikagallery.sorter;

import com.endrikagallery.Artwork;

public class ArtworkByNameSorter implements ArtworkSorter {
    @Override
    public int compare(Artwork artworkA, Artwork artworkB) {
        return artworkA.getInfos().name().compareTo(artworkB.getInfos().name());
    }
}
