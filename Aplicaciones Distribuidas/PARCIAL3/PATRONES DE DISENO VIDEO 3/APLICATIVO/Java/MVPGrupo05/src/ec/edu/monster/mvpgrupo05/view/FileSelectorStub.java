/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.mvpgrupo05.view;

import ec.edu.monster.mvpgrupo05.presenter.FileSelectorPresenter;

/**
 *
 * @author santi
 */
public class FileSelectorStub implements FileSelectorView {

    /**
     * Indicates whether or not the view is opened.
     */
    private boolean opened;

    /**
     * The presenter Component.
     */
    private FileSelectorPresenter presenter;

    /**
     * The current name of the file.
     */
    private String name;

    /**
     * Indicates the number of messages that were "displayed" to the user.
     */
    private int numOfMessageSent;

    /**
     * Indicates if the data of the file where displayed or not.
     */
    private boolean dataDisplayed;

    /**
     * Constructor.
     */
    public FileSelectorStub() {
        this.opened = false;
        this.presenter = null;
        this.name = "";
        this.numOfMessageSent = 0;
        this.dataDisplayed = false;
    }

    @Override
    public void open() {
        this.opened = true;
    }

    @Override
    public void setPresenter(FileSelectorPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isOpened() {
        return this.opened;
    }

    @Override
    public FileSelectorPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public String getFileName() {
        return this.name;
    }

    @Override
    public void setFileName(String name) {
        this.name = name;
    }

    @Override
    public void showMessage(String message) {
        this.numOfMessageSent++;
    }

    @Override
    public void close() {
        this.opened = false;
    }

    @Override
    public void displayData(String data) {
        this.dataDisplayed = true;
    }

    /**
     * Returns the number of messages that were displayed to the user.
     */
    public int getMessagesSent() {
        return this.numOfMessageSent;
    }

    /**
     * Returns true, if the data were displayed.
     *
     * @return True if the data where displayed, false otherwise.
     */
    public boolean dataDisplayed() {
        return this.dataDisplayed;
    }
}