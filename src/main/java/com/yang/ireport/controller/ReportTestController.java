package com.yang.ireport.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.yang.ireport.model.SalesSlipFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.ireport.model.SalesSlip;
import com.yang.ireport.model.SalesSlipGoodsInfoFactory;
import com.yang.ireport.reportIUtil.JasperReportBase;
import com.yang.ireport.reportIUtil.JasperReportWithBean;
import com.yang.ireport.reportIUtil.JasperReportWithConnection;
import com.yang.ireport.service.RepertoryService;
import com.yang.ireport.service.SalesSlipService;

import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 
 * 各个方法的请求路径为Controller类@RequestMapping注解值+"/"+方法@RequestMapping注解值
 * 
 * Created by Administrator on 2017/7/26.
 */
@Controller
@RequestMapping("report")
public class ReportTestController {

	
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SalesSlipService salesSlipService;
    
    /**
     * index.jsp菜单栏请求跳转到这个中介方法，为iframe设置目标页面
     * 
     * @param type 为reportmain.jsp中${num}传值，以拼接成不同的请求路径
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("japer")
    public String toReportmain(String type, HttpServletRequest request) throws Exception {
    	request.setAttribute("num", type);
//    	 直接请求/WEB-INF/jsp/reportmain.jsp
    	return "reportmain";
    }

    /**
     * 有子报表的主从报表测试，使用JDBC数据源，并且使用了自定义参数
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer1")
    public void getReport1(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	 JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
//         添加数据连接
        jrb.setConnection(dataSource.getConnection());
//        生成传递参数用Map
        HashMap<String, Object> pMap = new HashMap<String, Object>();
//        向主数据集自定义参数orderCode设值
        pMap.put("orderCode", "PO1707190012");
//        为工具类的参数Map赋值
        jrb.setParameterMap(pMap);
//        生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/goodsInfo.jasper", "goodsInfo");
    }

    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer2")
    public void getReport2(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
//      为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/salesSlip.jasper", "salesSlip");
    }

    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer3")
    public void getReport3(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	javabean数据源专用工具类
        JasperReportBase jrb = new JasperReportWithBean();
//      调用业务逻辑获取销货单列表
        List<SalesSlip> list = salesSlipService.getList();
//      将获得数据封装成javabean数据源
        JRAbstractBeanDataSource dataSource = new JRBeanCollectionDataSource(list);
//      为工具类的参数dataSource赋值
        jrb.setDataSource(dataSource);
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/salesSlipUseBean.jasper", "salesSlipUseBean");
    }
   
    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer4")
    public void getReport4(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
//      为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/crosstabTest.jasper", "crosstabTest");
    }
    
    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer5")
    public void getReport5(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	javabean数据源专用工具类
        JasperReportBase jrb = new JasperReportWithBean();
//      调用javabean数据源工厂类SalesSlipGoodsInfoFactory获取假数据
        Collection list = SalesSlipGoodsInfoFactory.getBeanCollection();
//      将获得数据封装成javabean数据源
        JRAbstractBeanDataSource dataSource = new JRBeanCollectionDataSource(list);
//      为工具类的参数dataSource赋值
        jrb.setDataSource(dataSource);
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/piechart1.jasper", "piechart1");
    }
    
    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer6")
    public void getReport6(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
//      为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/chart2.jasper", "chart2");
    }
    
    /**
     * 
     * @param type 要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer7")
    public void getReport7(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
//   	JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
//      为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
//      生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/groupTest.jasper", "groupTest");
    }

    /**
     *
     * @param type
     *            要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer8")
    public void getReport8(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
        // 为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
        // 生成传递参数用Map
        HashMap<String, Object> pMap = new HashMap<String, Object>();
        // 向主数据集自定义参数image1设值
        String imagePath = request.getServletContext().getRealPath("/images")+"/";
        pMap.put("image1", imagePath);
        // 为工具类的参数Map赋值
        jrb.setParameterMap(pMap);
        // 生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/imageTest.jasper", "imageTest");
    }

    /**
     *
     * @param type
     *            要获得的报表文件类型
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("japer9")
    public void getReport9(String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // JDBC数据源专用工具类
        JasperReportBase jrb = new JasperReportWithConnection();
        // 为工具类的参数connection赋值
        jrb.setConnection(dataSource.getConnection());
        // 生成传递参数用Map
        HashMap<String, Object> pMap = new HashMap<String, Object>();
        // 向主数据集自定义参数orderCode设值
        pMap.put("orderCode", "PO1707190012");
        // 为工具类的参数Map赋值
        jrb.setParameterMap(pMap);
        // 生成报表
        jrb.createResponse(type, request, response, "/WEB-INF/report/sub_table_jdbc.jasper", "sub_table_jdbc");
    }
}
