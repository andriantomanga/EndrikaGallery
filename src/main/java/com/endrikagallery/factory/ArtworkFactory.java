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

package com.endrikagallery.factory;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.Artwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;
import com.endrikagallery.model.Country;
import com.endrikagallery.utils.StringUtil;
import org.w3c.dom.Element;

/**
 * Provides utility methods for creating instances of {@link com.endrikagallery.Artwork}
 * from various types of input objects. This class is a factory class designed to
 * encapsulate the creation logic for {@link com.endrikagallery.Artwork} objects.
 *
 * @author Nabil Andriantomanga
 * @see com.endrikagallery.Artwork
 * @since 2024
 * @version 1.0
 */
public final class ArtworkFactory {
    private ArtworkFactory() {
    }

    public static Artwork from(Element element) throws ReflectiveOperationException {
        var artworkInfos = createArtworkInfos(element);

        var artistElement = (Element) element.getElementsByTagName("artist").item(0);
        var artistInfos = createArtistInfos(artistElement);

        var artworkClass = element.getElementsByTagName("artworkClass").item(0).getTextContent();
        var artworkClassObject = Class.forName(artworkClass);
        var constructor = artworkClassObject.getDeclaredConstructor(ArtworkInfos.class, ArtistInfos.class);

        return (AbstractArtwork) constructor.newInstance(artworkInfos, artistInfos);
    }

    private static ArtworkInfos createArtworkInfos(Element element) {
        var artworkName = getTextContent(element, "name");
        var artworkDescription = getTextContent(element, "description");
        return new ArtworkInfos(artworkName, artworkDescription);
    }

    private static ArtistInfos createArtistInfos(Element artistElement) {
        var artistName = getTextContent(artistElement, "name");
        var artistGithubId = getTextContent(artistElement, "githubId");
        var artistCountryCode = getOptionalTextContent(artistElement, "countryCode");
        var artistEmail = getOptionalTextContent(artistElement, "email");
        var artistPhone = getOptionalTextContent(artistElement, "phone");
        var artistWebsite = getOptionalTextContent(artistElement, "website");

        return ArtistInfos.builder()
                .githubId(artistGithubId)
                .name(artistName)
                .email(artistEmail)
                .phone(artistPhone)
                .country(Country.fromCode(artistCountryCode))
                .website(artistWebsite)
                .build();
    }

    private static String getOptionalTextContent(Element element, String tagName) {
        var nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return StringUtil.EMPTY;
    }

    private static String getTextContent(Element element, String tagName) {
        var nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        throw new IllegalArgumentException("Missing required tag: " + tagName);
    }
}
