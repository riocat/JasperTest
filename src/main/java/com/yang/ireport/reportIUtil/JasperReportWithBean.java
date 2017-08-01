package com.yang.ireport.reportIUtil;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.ui.jasperreports.JasperReportsUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/1.
 */
public class JasperReportWithBean extends JasperReportBase {
    @Override
    protected void createReport(HttpServletResponse response, File reportFile, JRAbstractExporter exporter) {
        ServletOutputStream ouputStream = null;

        try {
            ouputStream = response.getOutputStream();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile.getPath(), parameterMap, dataSource);
            JasperReportsUtils.render(exporter, jasperPrint, ouputStream);
            ouputStream.flush();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
