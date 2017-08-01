package com.yang.ireport.reportIUtil;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

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

    public void createResponse(String type, HttpServletRequest request, HttpServletResponse response, String templetPath, String fileName) throws Exception {
        String filePath = request.getServletContext().getRealPath(templetPath);
        File reportFile = new File(filePath);

        switch (type) {
            case "pdf":
                JRAbstractExporter exporter = new JRPdfExporter();
                createReport(response, reportFile, exporter);
                break;
            case "html":
                response.setContentType("text/html");
                createReport(response, reportFile, new HtmlExporter());
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
}
