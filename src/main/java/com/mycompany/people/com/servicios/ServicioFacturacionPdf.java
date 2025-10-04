
package com.mycompany.people.com.servicios;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.people.com.Models.OfertaEmpleo;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Jovany
 */
public class ServicioFacturacionPdf {
    
    public static void main(String[] args) {
        
        
    }
    public void factura(List<OfertaEmpleo> ofertas){
        
        
     Object[][] matrizOfertas = new Object[ofertas.size()][4]; 
            double subtotal = 0;
           
        String cliente="" ;
        String lugar ="";
        Long cod=Long.parseLong("8");
        for (int i = 0; i < ofertas.size(); i++) {
            
            OfertaEmpleo oferta = ofertas.get(i);
            
            cliente = oferta.getClienteId().getEmpresa();
            lugar = oferta.getClienteId().getCodPostal().getMunicipioId().getNombre();
            cod = oferta.getOfertaEmpleoId();
            matrizOfertas[i][0] = oferta.getOfertaEmpleoId();
            matrizOfertas[i][1] = oferta.getVacanteId().getPuesto();
            matrizOfertas[i][2] = "Q. "+oferta.getCostoId().getPrecio();
            matrizOfertas[i][3] = oferta.getCostoId().getDias();
            subtotal=subtotal+oferta.getCostoId().getPrecio();
        }
     try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Factura.pdf"));
            document.open();

            
            Paragraph encabezado = new Paragraph("People.com S.A.\n11 Calle 5-59, Cdad. de Guatemala 01009\nTel: 555-1234\nCorreo: info@people.com");
            encabezado.setAlignment(Element.ALIGN_CENTER);
            document.add(encabezado);
            String noFactura="";

            document.add(new Paragraph("\nFactura #: "+cod+"       Fecha: " + new Date() + "\n\n"));

            
            document.add(new Paragraph("Cliente: "+ cliente));
            document.add(new Paragraph("Dirección: "+lugar+" \n\n"));

            
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);

            
            String[] encabezados = {"Cod", "Descripción", "Precio Unitario", "Dias"};
            for (String col : encabezados) {
                PdfPCell cell = new PdfPCell(new Phrase(col));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY); //
                cell.setPadding(5f);
                tabla.addCell(cell);
            }
 
         

           
BaseColor colorFila = BaseColor.WHITE;
for (int i = 0; i < matrizOfertas.length; i++) 
{
    Object[] fila = matrizOfertas[i];
    
   // colorFila = (i % 2 == 0) ? BaseColor.WHITE : new BaseColor(224, 235, 255); 

    
    for (Object dato : fila) {
        
        PdfPCell cell = new PdfPCell(new Phrase(dato.toString()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(colorFila);
        cell.setPadding(5f);
        tabla.addCell(cell);
        
    }}
 double impuestos = subtotal * 0.16; 
            double total = subtotal + impuestos;
            document.add(tabla);

           
            PdfPTable tablaTotales = new PdfPTable(2);
            tablaTotales.setWidthPercentage(50);
            tablaTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);

            // Subtotal
            PdfPCell c1 = new PdfPCell(new Phrase("Subtotal:"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(5f);
            tablaTotales.addCell(c1);

            PdfPCell c2 = new PdfPCell(new Phrase("$" + subtotal));
            c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c2.setPadding(5f);
            tablaTotales.addCell(c2);

            // Impuestos
            PdfPCell c3 = new PdfPCell(new Phrase("Impuestos (16%):"));
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            c3.setPadding(5f);
            tablaTotales.addCell(c3);

            PdfPCell c4 = new PdfPCell(new Phrase("$" + impuestos));
            c4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c4.setPadding(5f);
            tablaTotales.addCell(c4);

            // Total
            PdfPCell c5 = new PdfPCell(new Phrase("TOTAL:"));
            c5.setBackgroundColor(new BaseColor(192, 192, 255)); // color morado claro
            c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            c5.setPadding(5f);
            tablaTotales.addCell(c5);

            PdfPCell c6 = new PdfPCell(new Phrase("$" + total));
            c6.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c6.setPadding(5f);
            tablaTotales.addCell(c6);

            document.add(tablaTotales);

            // Pie de página
            Paragraph pie = new Paragraph("¡Gracias por su compra!\nwww.miempresa.com");
            pie.setAlignment(Element.ALIGN_CENTER);
            document.add(pie);

            document.close();
            System.out.println("Factura creada con éxito!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
\