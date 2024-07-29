package com.endrikagallery.sorter;

import com.endrikagallery.Artwork;

public class ArtworkByCountrySorter implements ArtworkSorter {
    @Override
    public int compare(Artwork o1, Artwork o2) {
        return o1.getArtistInfos().country().compareTo(o2.getArtistInfos().country());
    }
}
