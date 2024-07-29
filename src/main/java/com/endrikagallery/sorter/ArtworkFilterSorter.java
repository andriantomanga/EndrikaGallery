package com.endrikagallery.sorter;

import com.endrikagallery.Artwork;

import java.util.List;
import java.util.Map;

import static com.endrikagallery.utils.StringUtil.toKey;

public class ArtworkFilterSorter {
    private static final ArtworkByNameSorter DEFAULT_SORTER = new ArtworkByNameSorter();
    private final Map<String, ArtworkSorter> sorters;

    public ArtworkFilterSorter(Map<String, ArtworkSorter> sorters) {
        this.sorters = sorters;
    }

    public List<Artwork> filterAndSort(List<Artwork> artworks, String filterText, String sorterKey) {
        return artworks.stream()
                .filter(artwork -> toKey(artwork.getInfos().name()).contains(toKey(filterText)))
                .sorted(sorters.getOrDefault(sorterKey, DEFAULT_SORTER))
                .toList();
    }
}
