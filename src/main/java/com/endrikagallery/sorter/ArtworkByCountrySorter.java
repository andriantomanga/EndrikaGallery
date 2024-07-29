package com.endrikagallery.sorter;

import com.endrikagallery.Artwork;

public class ArtworkByCountrySorter implements ArtworkSorter {
    @Override
    public int compare(Artwork artworkA, Artwork artworkB) {
        var countryA = artworkA.getArtistInfos().country();
        var countryB = artworkB.getArtistInfos().country();

        if (countryA == null && countryB == null) {
            return 0;
        }
        if (countryA == null) {
            return -1;
        }
        if (countryB == null) {
            return 1;
        }
        return countryA.compareTo(countryB);

    }
}
