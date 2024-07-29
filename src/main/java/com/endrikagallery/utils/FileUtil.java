package com.endrikagallery.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public final class FileUtil {
    private FileUtil() {
    }

    public static String getFilePath(String fileName) throws IOException {
        // Récupérer le chemin du fichier à partir des ressources
        var resourceUrl = Objects.requireNonNull(FileUtil.class.getClassLoader().getResource(fileName), "Resource not found: " + fileName);

        // Convertir l'URL en chemin
        Path filePath;
        try {
            filePath = Paths.get(resourceUrl.toURI());
        } catch (URISyntaxException e) {
            throw new IOException("Invalid URI syntax for resource: " + fileName, e);
        }

        // Vérifier si le fichier existe
        if (!Files.exists(filePath)) {
            throw new IOException("File does not exist: " + filePath);
        }

        return filePath.toString();
    }
}
