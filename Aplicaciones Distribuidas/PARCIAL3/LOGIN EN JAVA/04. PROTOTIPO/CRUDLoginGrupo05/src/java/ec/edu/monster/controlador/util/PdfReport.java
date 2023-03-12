/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador.util;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Image;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import ec.edu.monster.modelo.entidades.PeempEmple;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author santi
 */
public class PdfReport {
    private static final Font titleFont = FontFactory.getFont(
            FontFactory.TIMES_ROMAN, 14, Font.BOLD);
    private static final Font tableHeaderFont = FontFactory.getFont(
            FontFactory.HELVETICA_BOLD, 12, Font.BOLD);
    
    public static byte[] generateEmployeeReportPdf(
            String savePath,
            List<PeempEmple> employees
    ) throws FileNotFoundException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            
//            PdfWriter.getInstance(document, byteArrayOutputStream);
            PdfWriter.getInstance(document, new FileOutputStream("C:\\FORMULARIOS_CHUQUIMARCA\\PARCIAL3\\LOGIN EN JAVA\\04. PROTOTIPO\\CRUDLoginGrupo05\\reportes\\reporte.pdf"));
//            String imageUrl = "http://localhost:8080/BienesMonster_G08/faces/images/logo.png";
//            String imageUrl = "/";

//            Image logoImage = Image.getInstance(new URL(imageUrl));
            document.setPageSize(PageSize.A4.rotate());

            document.open();
            // Agregar contenido
            // Cabecera
//            logoImage.scaleAbsolute(80, 69);
//            document.add(logoImage);

            // Listado de campos usados
            StringBuilder pdfTextContent = new StringBuilder();
            document.add(new Paragraph("BIENES MU", titleFont));

            document.add(new Paragraph(pdfTextContent + "\n"));

            // Tabla
            float[] columnWidths = {1f, 1f, 2f, 1.5f, 1f, 1.5f, 1.5f, 1f, 1f};
            PdfPTable table = new PdfPTable(columnWidths);

            table.setWidthPercentage(100);

            // Header de la tabla
            tableHeaderFont.setColor(WebColors.getRGBColor("#FFFFFF"));

            table.addCell(getHeaderCell("Apellido"));
            table.addCell(getHeaderCell("Nombre"));
            table.addCell(getHeaderCell("Fecha de Nacimiento"));
            table.addCell(getHeaderCell("Dirección"));
            table.addCell(getHeaderCell("Teléfono"));
            table.addCell(getHeaderCell("Correo Electrónico"));
            table.addCell(getHeaderCell("Cédula"));
            table.addCell(getHeaderCell("Carga Familiar"));
            table.addCell(getHeaderCell("Pasaporte"));

            //  Cuerpo de la tabla
            for (PeempEmple e : employees) {
                table.addCell(e.getPeempApelli());
                table.addCell(e.getPeempNombre());
                table.addCell(e.getPeempFecnac().toString());
                table.addCell(e.getPeempDirec());
                table.addCell(e.getPeempTelef());
                table.addCell(e.getPeempEmail());
                table.addCell(e.getPeempCedula());
                table.addCell(Short.toString(e.getPeempCarfam()));
                table.addCell(e.getPeempPasapo());
            }

            document.add(table);
            document.close();
            
            return byteArrayOutputStream.toByteArray();
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
            return new byte[]{};
        }
    }

    private static PdfPCell getHeaderCell(String headerText) {
        PdfPCell headerCell = new PdfPCell(new Phrase(headerText, tableHeaderFont));
        headerCell.setBackgroundColor(WebColors.getRGBColor("#0163ac"));
        return headerCell;
    }
}
