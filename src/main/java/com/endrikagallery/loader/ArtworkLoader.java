package com.endrikagallery.loader;

import com.endrikagallery.Artwork;
import com.endrikagallery.factory.ArtworkFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class   ArtworkLoader {
    private ArtworkLoader() {
    }

    public static List<Artwork> loadArtworks(String filePath) throws Exception {
        var artworks = new ArrayList<Artwork>();

        var factory = DocumentBuilderFactory.newInstance();
        var builder = factory.newDocumentBuilder();
        var doc = builder.parse(filePath);
        doc.getDocumentElement().normalize();
        var artworkNodes = doc.getElementsByTagName("artwork");

        IntStream.range(0, artworkNodes.getLength())
                .mapToObj(artworkNodes::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .map(artworkElement -> {
                    try {
                        return ArtworkFactory.from(artworkElement);
                    } catch (Exception e) {
                        throw new RuntimeException("Error creating artwork from element", e);
                    }
                })
                .forEach(artworks::add);

        return artworks;
    }
}
