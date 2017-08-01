package com.yang.ireport.reportIUtil;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.*;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import net.sf.jasperreports.web.util.WebHtmlResourceHandler;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/1.
 */
public abstract class JasperReportBase {

    protected HashMap<String, Object> parameterMap = new HashMap<String, Object>();

    protected Connection connection;

    protected JRAbstractBeanDataSource dataSource;

    public HashMap<String, Object> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(HashMap<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public JRAbstractBeanDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JRAbstractBeanDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JasperReportBase() {
    }

    public JasperReportBase(HashMap<String, Object> parameterMap, Connection connection, JRAbstractBeanDataSource dataSource) {
        this.parameterMap = parameterMap;
        this.connection = connection;
        this.dataSource = dataSource;
    }

    public JasperReportBase(HashMap<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public JasperReportBase(Connection connection) {
        this.connection = connection;
    }

    public JasperReportBase(JRAbstractBeanDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createResponse(String type, HttpServletRequest request, HttpServletResponse response, String templetPath, String fileName, boolean withImage) throws Exception {
        String filePath = request.getServletContext().getRealPath(templetPath);
        File reportFile = new File(filePath);

        switch (type) {
            case "pdf":
                createReport(response, reportFile, new JRPdfExporter());
                break;
            case "html":

                /*               response.setContentType("text/html");
                JRAbstractExporter exporter = new HtmlExporter();
                createReport(response, reportFile, exporter);*/

                JasperPrint jasperPrint = getJasperPrint(reportFile);
                request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);

                HtmlExporter exporterHTML = new HtmlExporter();
                SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
                exporterHTML.setExporterInput(exporterInput);

                SimpleHtmlExporterOutput exporterOutput;

                exporterOutput = new SimpleHtmlExporterOutput(response.getOutputStream());
                exporterOutput.setImageHandler(new WebHtmlResourceHandler("/report/image/"));
                exporterHTML.setExporterOutput(exporterOutput);

                SimpleHtmlReportConfiguration reportExportConfiguration = new SimpleHtmlReportConfiguration();
                reportExportConfiguration.setWhitePageBackground(false);
                reportExportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                exporterHTML.setConfiguration(reportExportConfiguration);
                exporterHTML.exportReport();

/*              JasperPrint jasperPrint = getJasperPrint(reportFile);
                JRHtmlExporter exporter = new JRHtmlExporter();
                String imageDIR = request.getServletContext().getRealPath("/report/image/");
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR_NAME, imageDIR);
                String imageURI = request.getContextPath() + "/report/image/";
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, imageURI);
                exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.TRUE);
                exporter.setParameter(JRHtmlExporterParameter.IS_OUTPUT_IMAGES_TO_DIR, Boolean.TRUE);
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
                exporter.exportReport();*/

                break;
            case "excel":
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"" + ".xls");
                createReport(response, reportFile, new JRXlsExporter());
                break;
            case "word":
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"" + ".doc");
                createReport(response, reportFile, new JRDocxExporter());
                break;
        }
    }

    protected abstract void createReport(HttpServletResponse response, File reportFile, JRAbstractExporter exporter);

    protected abstract JasperPrint getJasperPrint(File reportFile);
}
