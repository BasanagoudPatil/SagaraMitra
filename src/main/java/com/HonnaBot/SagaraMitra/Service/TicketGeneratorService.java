package com.HonnaBot.SagaraMitra.Service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class TicketGeneratorService {

    public ByteArrayInputStream generateTicket(String bookingId, String userName, String boatName,
                                               String date, String slot, String seatCount, boolean isPrivate) {
        try {
            Document document = new Document(PageSize.A5, 36, 36, 50, 36);
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, out);
            document.open();

            // Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.WHITE);
            PdfPCell titleCell = new PdfPCell(new Phrase("SagaraMitra Boat Booking Ticket", titleFont));
            titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            titleCell.setBackgroundColor(new BaseColor(0, 121, 182));
            titleCell.setPadding(12);
            titleCell.setBorder(Rectangle.NO_BORDER);

            PdfPTable titleTable = new PdfPTable(1);
            titleTable.setWidthPercentage(100);
            titleTable.addCell(titleCell);
            document.add(titleTable);
            document.add(Chunk.NEWLINE);

            // Booking Info Table
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);

            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY);

            addRow(table, "Booking ID", bookingId, headerFont, valueFont);
            addRow(table, "User Name", userName, headerFont, valueFont);
            addRow(table, "Boat Name", boatName, headerFont, valueFont);
            addRow(table, "Date", date, headerFont, valueFont);
            addRow(table, "Slot", slot, headerFont, valueFont);
            if (!isPrivate) {
                addRow(table, "Seats Booked", seatCount, headerFont, valueFont);
            } else {
                addRow(table, "Booking Type", "Private", headerFont, valueFont);
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            // Footer / Instructions
            Font footerFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.GRAY);
            Paragraph footer = new Paragraph("Please show this ticket to the boat owner before boarding.\n" +
                    "Thank you for choosing SagaraMitra!", footerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void addRow(PdfPTable table, String label, String value, Font labelFont, Font valueFont) {
        PdfPCell cell1 = new PdfPCell(new Phrase(label, labelFont));
        PdfPCell cell2 = new PdfPCell(new Phrase(value, valueFont));

        cell1.setBorder(Rectangle.NO_BORDER);
        cell2.setBorder(Rectangle.NO_BORDER);

        cell1.setPadding(6);
        cell2.setPadding(6);

        table.addCell(cell1);
        table.addCell(cell2);
    }
}
