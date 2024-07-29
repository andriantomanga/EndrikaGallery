package com.endrikagallery.ui;

import com.endrikagallery.Artwork;
import com.endrikagallery.sorter.ArtworkByCountrySorter;
import com.endrikagallery.sorter.ArtworkByNameSorter;
import com.endrikagallery.sorter.ArtworkSorter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class EndrikaGalleryUI extends JFrame {
    private JList<String> artworkList;
    private JPanel canvasPanel;
    private JScrollPane listScrollPane;
    private Artwork currentArtwork;
    private DefaultListModel<String> listModel;
    private List<Artwork> originalArtworks;
    private List<Artwork> filteredAndSortedArtworks;
    private JComboBox<String> sorterComboBox;
    private JTextField filterTextField;

    private final Map<String, ArtworkSorter> sorters = Map.of(
            "Name", new ArtworkByNameSorter(),
            "Country", new ArtworkByCountrySorter()
    );

    public EndrikaGalleryUI(List<Artwork> artworks) {
        setTitle("Endrika Gallery");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.originalArtworks = artworks;
        this.filteredAndSortedArtworks = artworks;

        // ComboBox for sorting criteria
        String[] sorterOptions = {"Name", "Country"};
        sorterComboBox = new JComboBox<>(sorterOptions);
        sorterComboBox.addActionListener(e -> updateSorter());

        // TextField for filtering by name
        filterTextField = new JTextField(15);
        filterTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateListModel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateListModel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateListModel();
            }
        });

        var topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        var filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter:"));
        filterPanel.add(filterTextField);
        filterPanel.add(sorterComboBox);
        topPanel.add(filterPanel, BorderLayout.WEST);

        // Liste des oeuvres
        listModel = new DefaultListModel<>();
        artworkList = new JList<>(listModel); // Initialisation de artworkList
        artworkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        artworkList.addListSelectionListener(e -> {
            int selectedIndex = artworkList.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < filteredAndSortedArtworks.size()) {
                updateCanvas(filteredAndSortedArtworks.get(selectedIndex));
            }
        });
        listScrollPane = new JScrollPane(artworkList);
        listScrollPane.setPreferredSize(new Dimension(200, getHeight()));

        // Initialize the list model after initializing the artworkList
        updateListModel();

        // Canvas panel for displaying artwork
        canvasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentArtwork != null) {
                    currentArtwork.expresses(g);
                }
            }
        };
        canvasPanel.setBackground(Color.WHITE);

        add(topPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.WEST);
        add(canvasPanel, BorderLayout.CENTER);
    }

    private void updateListModel() {
        var selectedSorter = (String) sorterComboBox.getSelectedItem();
        var sorter = sorters.getOrDefault(selectedSorter, new ArtworkByNameSorter());
        var filterText = filterTextField.getText().toLowerCase().strip();

        filteredAndSortedArtworks = originalArtworks.stream()
                .filter(artwork -> artwork.getInfos().name().strip().toLowerCase().contains(filterText))
                .sorted(sorter)
                .toList();

        listModel.clear();
        filteredAndSortedArtworks.forEach(artwork -> listModel.addElement(artwork.getInfos().name()));
        artworkList.setModel(listModel);
    }

    private void updateSorter() {
        updateListModel();
        artworkList.clearSelection();
    }

    private void updateCanvas(Artwork artwork) {
        currentArtwork = artwork;
        if (canvasPanel != null) {
            canvasPanel.repaint();
        }
    }
}
