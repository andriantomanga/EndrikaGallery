package com.endrikagallery.ui;

import com.endrikagallery.Artwork;
import com.endrikagallery.sorter.ArtworkFilterSorter;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

public class ArtworkListPanel extends JPanel {

    private JList<String> artworkList;
    private DefaultListModel<String> listModel;
    private JTextField filterTextField;
    private JComboBox<String> sorterComboBox;
    private ArtworkFilterSorter artworkFilterSorter;
    private List<Artwork> originalArtworks;
    private List<Artwork> filteredArtworks;
    private ArtworkSelectionListener selectionListener;

    public ArtworkListPanel(List<Artwork> artworks, ArtworkFilterSorter sorter, ArtworkSelectionListener listener) {
        this.originalArtworks = artworks;
        this.artworkFilterSorter = sorter;
        this.selectionListener = listener;
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        artworkList = new JList<>(listModel);
        artworkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        artworkList.addListSelectionListener(e -> {
            int selectedIndex = artworkList.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < filteredArtworks.size()) {
                selectionListener.onArtworkSelected(filteredArtworks.get(selectedIndex));
            }
        });

        var listScrollPane = new JScrollPane(artworkList);
        listScrollPane.setPreferredSize(new Dimension(200, getHeight()));
        add(listScrollPane, BorderLayout.CENTER);

        filterTextField = new JTextField(10);
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

        sorterComboBox = new JComboBox<>(new String[]{"Name", "Country"});
        sorterComboBox.addActionListener(e -> updateListModel());

        updateListModel();

        var filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter by:"));
        filterPanel.add(filterTextField);
        filterPanel.add(new JLabel("Sort by:"));
        filterPanel.add(sorterComboBox);
        add(filterPanel, BorderLayout.NORTH);
    }

    private void updateListModel() {
        var filterText = filterTextField.getText();
        var sorterKey = (String) sorterComboBox.getSelectedItem();
        filteredArtworks = artworkFilterSorter.filterAndSort(originalArtworks, filterText, sorterKey);
        listModel.clear();
        filteredArtworks.forEach(artwork -> listModel.addElement(artwork.getInfos().name()));
    }
}
