package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;

    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }

    private void reset(ActionEvent e) {
        frame.canvas.createOffScreenImage();
        frame.canvas.repaint();
    }

    private void load(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select an image");
        FileNameExtensionFilter filterImageFiles = new FileNameExtensionFilter("Image files (png, jpg, etc.)", "jpg", "jpeg", "png");
        fc.addChoosableFileFilter(filterImageFiles);

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selected = fc.getSelectedFile();
            try {
                frame.canvas.image = ImageIO.read(selected);
                frame.repaint();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void save(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Save your image");

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selected = fc.getSelectedFile();
            try {
                ImageIO.write(frame.canvas.image, "PNG", selected);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }


}
