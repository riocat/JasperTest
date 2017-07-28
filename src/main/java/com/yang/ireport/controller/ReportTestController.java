package com.yang.ireport.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.jasperreports.JasperReportsUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/26.
 */
@Controller
@RequestMapping("report")
public class ReportTestController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("japer")
    public String getReport(Model model, String type) {

        // 动态指定报表模板url
        model.addAttribute("url", "/WEB-INF/report/report1.jasper");
        if ("pdf".equals(type)) {
            model.addAttribute("format", "pdf"); // 报表格式
        } else if ("excel".equals(type)) {
            model.addAttribute("format", "xls"); // 报表格式
        }
        model.addAttribute("jrMainDataSource", dataSource);
        return "iReportView"; // 对应jasper-defs.xml中的bean id
    }

    @RequestMapping("japer2")
    public String getReport2(Model model, String type) {

        // 动态指定报表模板url
        model.addAttribute("url", "/WEB-INF/report/report2.jasper");
        if ("pdf".equals(type)) {
            model.addAttribute("format", "pdf"); // 报表格式
        } else if ("html".equals(type)) {
            model.addAttribute("format", "html"); // 报表格式
        }
        model.addAttribute("jrMainDataSource", dataSource);
        return "iReportView"; // 对应jasper-defs.xml中的bean id
    }

    @RequestMapping("japer3")
    public void getReport2(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = request.getServletContext().getRealPath("/WEB-INF/report/report1.jasper");
        File reportFile = new File(filePath);
        String path = reportFile.getPath();

        if ("pdf".equals(type)) {
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode("report1", "UTF-8") + "\"" + ".pdf");
            JRAbstractExporter exporter = new JRPdfExporter();
            createReportWithConnection(response, reportFile, exporter);
        } else if ("html".equals(type)) {
            response.setContentType("text/html");
            JRAbstractExporter exporter = new HtmlExporter();
            createReportWithConnection(response, reportFile, exporter);
        } else if ("excel".equals(type)) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode("report1", "UTF-8") + "\"" + ".xls");
            JRAbstractExporter exporter = new JRXlsExporter();
            createReportWithConnection(response, reportFile, exporter);
        } else if ("word".equals(type)) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode("report1", "UTF-8") + "\"" + ".doc");
            JRAbstractExporter exporter = new JRDocxExporter();
            createReportWithConnection(response, reportFile, exporter);
        }
    }

    private void createReportWithConnection(HttpServletResponse response, File reportFile, JRAbstractExporter exporter) {
        Connection connection = null;
        ServletOutputStream ouputStream = null;
        try {
            connection = dataSource.getConnection();
            ouputStream = response.getOutputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile.getPath(), new HashMap<String, Object>(), connection);
            JasperReportsUtils.render(exporter, jasperPrint, ouputStream);
            ouputStream.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
