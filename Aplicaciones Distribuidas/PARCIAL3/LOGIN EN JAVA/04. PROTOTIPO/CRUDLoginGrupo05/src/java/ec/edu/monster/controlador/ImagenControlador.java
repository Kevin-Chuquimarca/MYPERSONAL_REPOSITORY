/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ec.edu.monster.controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author santi
 */
@Named(value = "imagenControlador")
@SessionScoped
public class ImagenControlador implements Serializable {

    private UploadedFile file;
    private String path = "C:\\FORMULARIOS_CHUQUIMARCA\\PARCIAL3\\LOGIN EN JAVA\\04. PROTOTIPO\\CRUDLoginGrupo05\\web\\resources\\img\\";

    public ImagenControlador() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        this.file = event.getFile();
        if (file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            cargarFotoUsuario("default");
        }
    }

    public void cargarFotoUsuario(String nombreImg) throws IOException {
        String fileName = nombreImg + ".png";
        try (OutputStream output = new FileOutputStream(path + fileName)) {
            IOUtils.copy(this.file.getInputStream(), output);
        } catch (IOException e) {
            System.out.println("image: " + e.getMessage());
        }
    }
}
