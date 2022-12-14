/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.ChiTietHDDTO;
import DTO.HoaDonDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class XuatHoaDonBUS {
    private String file = "./report/test.pdf";
    private ArrayList<ChiTietHDDTO> dscthd = new ArrayList<ChiTietHDDTO>();
    private HoaDonDTO hd;
    private BaseFont bf;
    public XuatHoaDonBUS()
    {
                
    }

    public XuatHoaDonBUS(HoaDonDTO hd,ArrayList<ChiTietHDDTO> dscthd) 
    {
        this.hd = hd;
        file = "./report/bill"+hd.getMaHD()+".pdf";
        this.dscthd = dscthd;
    }
    public void print()
    {
        String uderline = "*";
        try {
            //Tạo Font
            bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            
            // Tạo tài liệu
            Document bill = new Document(PageSize.A4, 15, 15, 10, 10);
            
            String line = "";
            for(int i = 0 ; i < bill.getPageSize().getWidth()/5; i++)
            {
                line += uderline;
            }
            //Tạo đối tượng writter
            PdfWriter.getInstance(bill, new FileOutputStream(file));
            
            //Mở document
            bill.open();
            
            Paragraph header = new Paragraph("SIÊU THỊ WIZARD",new Font(bf,35));
            header.setAlignment(1);
            bill.add(header);
            
            Paragraph info = new Paragraph("Hóa dơn : "+hd.getMaHD()+"          Ngày : "+hd.getNgayLap(),new Font(bf,15));
            bill.add(info);
            
            Paragraph l = new Paragraph(line);
            l.setAlignment(1);
            bill.add(l);
            
            String[] cellHeader = {"Mã SP","Tên SP","SL","Đơn Giá","Thành tiền"};
            
            PdfPTable t = new PdfPTable(cellHeader.length);
            t.setSpacingAfter(10);
            t.setSpacingBefore(10);
            int[] relativeWidths = {20,80,10,40,80};
            t.setWidths(relativeWidths);
            
            for(String s : cellHeader)
            {
                t.addCell(createCell(s, new Font(bf,13)));
            }    
            for(ChiTietHDDTO ct : dscthd)
            {
                t.addCell( createCell(ct.getMaSP()) );
                t.addCell( createCell(ct.getTenSP()) );
                t.addCell( createCell(String.valueOf(ct.getSoLuong()) ));
                t.addCell( createCell(String.valueOf(ct.getDonGia()) ));
                t.addCell( createCell(String.valueOf(ct.getThanhTien())));
            }
            bill.add(t);
            
            bill.add(l);
            
            Paragraph sum = new Paragraph("Tổng tiền: "+ hd.getTongTien()+"đ",new Font(bf,20));
            
            
            sum.setAlignment(Element.ALIGN_RIGHT);
            bill.add(sum);
            
            
            bill.close();
            
//            PDDocument document = PDDocument.load(new File(file));
//            
//            PrinterJob job = PrinterJob.getPrinterJob();
//            job.setPageable(new PDFPageable(document));
//            job.print();
                    
            JOptionPane.showMessageDialog(null, "In hoàn tất");
            System.out.println("Done");
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(XuatHoaDonBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatHoaDonBUS.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    public PdfPCell createCell(String s)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,new Font(bf,13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        
        return cell;
    }
    public PdfPCell createCell(String s,Font font)
    {
        PdfPCell cell = new PdfPCell(new Phrase(s,font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
}
