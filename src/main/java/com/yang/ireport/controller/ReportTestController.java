package com.yang.ireport.controller;

import com.yang.ireport.model.Repertory;
import com.yang.ireport.model.SalesSlip;
import com.yang.ireport.reportIUtil.JasperReportBase;
import com.yang.ireport.reportIUtil.JasperReportWithBean;
import com.yang.ireport.reportIUtil.JasperReportWithConnection;
import com.yang.ireport.service.RepertoryService;
import com.yang.ireport.service.SalesSlipService;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Controller
@RequestMapping("report")
public class ReportTestController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RepertoryService repertoryService;

    @Autowired
    private SalesSlipService salesSlipService;

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
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/report1.jasper", "report1", false);
    }

    @RequestMapping("japer4")
    public String getReport4() {
        return "reportmain";
    }

    @RequestMapping("japer5")
    public void getReport5(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithBean();
        List<Repertory> list = repertoryService.getList();
        JRAbstractBeanDataSource dataSource = new JRBeanCollectionDataSource(list);
        jrb.setDataSource(dataSource);
        jrb.createResponse(type, request, response, "/WEB-INF/report/Repertory.jasper", "Repertory", false);
    }

    @RequestMapping("japer6")
    public void getReport6(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        HashMap<String, Object> pMap = new HashMap<String, Object>();
        pMap.put("orderCode", "PO1707190012");
        jrb.setParameterMap(pMap);
        jrb.createResponse(type, request, response, "/WEB-INF/report/goodsInfo.jasper", "goodsInfo", false);
    }

    @RequestMapping("japer7")
    public String getReport7() {
        return "reportmain";
    }

    @RequestMapping("japer8")
    public void getReport8(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/chart1.jasper", "chart1", true);
    }

    @RequestMapping("japer9")
    public void getReport9(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/chart2.jasper", "chart2", true);
    }

    @RequestMapping("japer10")
    public void getReport10(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/tableTest.jasper", "tableTest", true);
    }

    @RequestMapping("japer11")
    public void getReport11(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/salesSlip.jasper", "salesSlip", true);
    }

    @RequestMapping("japer12")
    public void getReport12(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithConnection();
        jrb.setConnection(dataSource.getConnection());
        jrb.createResponse(type, request, response, "/WEB-INF/report/crosstabTest.jasper", "crosstabTest", true);
    }

    @RequestMapping("japer13")
    public void getReport13(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithBean();
        List<SalesSlip> list = salesSlipService.getList();
        JRAbstractBeanDataSource dataSource = new JRBeanCollectionDataSource(list);
        jrb.setDataSource(dataSource);
        jrb.createResponse(type, request, response, "/WEB-INF/report/salesSlipUseBean.jasper", "salesSlipUseBean", true);
    }

    @RequestMapping("japer14")
    public void getReport14(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JasperReportBase jrb = new JasperReportWithBean();
        List<SalesSlip> list = salesSlipService.getList();
        JRAbstractBeanDataSource dataSource = new JRBeanCollectionDataSource(list);
        jrb.setDataSource(dataSource);
        jrb.createResponse(type, request, response, "/WEB-INF/report/listTest.jasper", "listTest", true);
    }
}
