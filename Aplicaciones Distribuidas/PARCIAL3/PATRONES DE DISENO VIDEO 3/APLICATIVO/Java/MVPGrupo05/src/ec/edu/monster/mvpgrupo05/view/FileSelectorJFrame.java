/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.mvpgrupo05.view;

import ec.edu.monster.mvpgrupo05.presenter.FileSelectorPresenter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 *
 * @author santi
 */
public class FileSelectorJFrame extends JFrame implements FileSelectorView, ActionListener {

    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The "OK" button for loading the file.
     */
    private final JButton ok;

    /**
     * The cancel button.
     */
    private final JButton cancel;

    /**
     * The text field for giving the name of the file that we want to open.
     */
    private final JTextField input;

    /**
     * A text area that will keep the contents of the file opened.
     */
    private final JTextArea area;

    /**
     * The Presenter component that the frame will interact with.
     */
    private FileSelectorPresenter presenter;

    /**
     * The name of the file that we want to read it's contents.
     */
    private String fileName;

    /**
     * Constructor.
     */
    public FileSelectorJFrame() {
        super("File Loader");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(100, 100, 500, 400);

        /*
     * Add the panel.
         */
        var panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        panel.setBounds(0, 0, 500, 400);
        panel.setBackground(Color.LIGHT_GRAY);

        /*
     * Add the info label.
         */
        var info = new JLabel("File Name :");
        panel.add(info);
        info.setBounds(30, 10, 100, 30);

        /*
     * Add the contents label.
         */
        var contents = new JLabel("File contents :");
        panel.add(contents);
        contents.setBounds(30, 100, 120, 30);

        /*
     * Add the text field.
         */
        this.input = new JTextField(100);
        panel.add(input);
        this.input.setBounds(150, 15, 300, 20);

        /*
     * Add the text area.
         */
        this.area = new JTextArea(100, 100);
        var pane = new JScrollPane(area);
        pane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(pane);
        this.area.setEditable(false);
        pane.setBounds(150, 100, 300, 250);

        /*
     * Add the OK button.
         */
        this.ok = new JButton("OK");
        panel.add(ok);
        this.ok.setBounds(150, 50, 100, 25);
        this.ok.addActionListener(this);

        /*
     * Add the cancel button.
         */
        this.cancel = new JButton("Cancel");
        panel.add(this.cancel);
        this.cancel.setBounds(300, 50, 100, 25);
        this.cancel.addActionListener(this);

        this.presenter = null;
        this.fileName = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.ok.equals(e.getSource())) {
            this.fileName = this.input.getText();
            presenter.fileNameChanged();
            presenter.confirmed();
        } else if (this.cancel.equals(e.getSource())) {
            presenter.cancelled();
        }
    }

    @Override
    public void open() {
        this.setVisible(true);
    }

    @Override
    public void close() {
        this.dispose();
    }

    @Override
    public boolean isOpened() {
        return this.isVisible();
    }

    @Override
    public void setPresenter(FileSelectorPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public FileSelectorPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public void setFileName(String name) {
        this.fileName = name;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void displayData(String data) {
        this.area.setText(data);
    }
}
