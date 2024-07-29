package com.endrikagallery;

import com.endrikagallery.loader.ArtworkLoader;
import com.endrikagallery.ui.EndrikaGalleryUI;
import com.endrikagallery.utils.FileUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EndrikaGallery {
    private static final Logger logger = Logger.getLogger(EndrikaGallery.class.getName());

    public static void main(String[] args) {
        try {
            var filePath = FileUtil.getFilePath("artworks.xml");
            var artworks = ArtworkLoader.loadArtworks(filePath);
            new EndrikaGalleryUI(artworks).setVisible(true);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred while loading the artworks", e);
        }
    }
}
