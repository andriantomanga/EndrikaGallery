package com.endrikagallery;

import com.endrikagallery.loader.ArtworkLoader;
import com.endrikagallery.ui.EndrikaGalleryUI;
import com.endrikagallery.utils.FileUtil;

import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EndrikaGallery {
    private static final Logger LOGGER = Logger.getLogger(EndrikaGallery.class.getName());

    public static void main(String[] args) {
        try {
            var filePath = FileUtil.getFilePath("artworks.xml");
            var artworks = ArtworkLoader.loadArtworks(filePath);

            var gallery = new EndrikaGalleryUI(artworks);
            gallery.setExtendedState(JFrame.MAXIMIZED_BOTH);
            gallery.setUndecorated(false);
            gallery.setVisible(true);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred while loading the artworks", e);
        }
    }
}
