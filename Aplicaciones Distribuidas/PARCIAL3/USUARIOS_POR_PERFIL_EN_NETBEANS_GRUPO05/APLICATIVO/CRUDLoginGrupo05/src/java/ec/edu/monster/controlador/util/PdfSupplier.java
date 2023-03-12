/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.primefaces.util.SerializableSupplier;

/**
 *
 * @author santi
 */
public class PdfSupplier implements SerializableSupplier<InputStream> {
    private byte[] content;
    
    public PdfSupplier(byte[] content) {
        this.content = content;
    }
    
    @Override
    public ByteArrayInputStream get() {
        return new ByteArrayInputStream(content);
    }
}