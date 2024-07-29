package com.endrikagallery.sorter;

import com.endrikagallery.Artwork;

public class ArtworkByNameSorter implements ArtworkSorter {
    @Override
    public int compare(Artwork a1, Artwork a2) {
        return a1.getInfos().name().compareTo(a2.getInfos().name());
    }
}
