package com.endrikagallery.factory;

import com.endrikagallery.AbstractArtwork;
import com.endrikagallery.Artwork;
import com.endrikagallery.model.ArtistInfos;
import com.endrikagallery.model.ArtworkInfos;
import com.endrikagallery.model.Country;
import org.w3c.dom.Element;

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
        return "";
    }

    private static String getTextContent(Element element, String tagName) {
        var nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        throw new IllegalArgumentException("Missing required tag: " + tagName);
    }
}
