/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.monster.mvpgrupo05.view;

import ec.edu.monster.mvpgrupo05.presenter.FileSelectorPresenter;
import java.io.Serializable;

/**
 *
 * @author santi
 */
public interface FileSelectorView extends Serializable {

    /**
     * Opens the view.
     */
    void open();

    /**
     * Closes the view.
     */
    void close();

    /**
     * Returns true if view is opened.
     *
     * @return True, if the view is opened, false otherwise.
     */
    boolean isOpened();

    /**
     * Sets the presenter component, to the one given as parameter.
     *
     * @param presenter The new presenter component.
     */
    void setPresenter(FileSelectorPresenter presenter);

    /**
     * Gets presenter component.
     *
     * @return The presenter Component.
     */
    FileSelectorPresenter getPresenter();

    /**
     * Sets the file's name, to the value given as parameter.
     *
     * @param name The new name of the file.
     */
    void setFileName(String name);

    /**
     * Gets the name of file.
     *
     * @return The name of the file.
     */
    String getFileName();

    /**
     * Displays a message to the users.
     *
     * @param message The message to be displayed.
     */
    void showMessage(String message);

    /**
     * Displays the data to the view.
     *
     * @param data The data to be written.
     */
    void displayData(String data);
}
