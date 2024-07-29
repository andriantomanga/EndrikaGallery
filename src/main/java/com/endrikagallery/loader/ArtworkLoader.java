/**
 * Copyright (c) 2024 Nabil Andriantomanga
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.endrikagallery.loader;

import com.endrikagallery.Artwork;
import com.endrikagallery.factory.ArtworkFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Provides methods for loading {@link com.endrikagallery.Artwork} objects
 * from an XML file.
 *
 * @author Nabil Andriantomanga
 * @since 2024
 * @version 1.0
 */
public final class ArtworkLoader {
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
