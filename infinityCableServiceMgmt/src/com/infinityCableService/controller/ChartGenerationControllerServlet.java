package com.infinityCableService.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.infinityCableService.util.Graph;

/**
 * Servlet implementation class ChartGenerationControllerServlet
 */
@WebServlet("/ChartGenerationControllerServlet")
public class ChartGenerationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartGenerationControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int width = 600;
        int height = 450;
        
        OutputStream outputStream;
        JFreeChart chart ;
        String url = "/adminHomePage.jsp";

        // get current action
        String action = request.getParameter("action");
        try{
	    if (action == null) {
	        url = "/adminHomePage.jsp";  // default action
	    }else {
	        switch (action) {
	            case "getRegChart":
	            	Map<String, Integer> dataMap;
	                response.setContentType("image/png");
	                 outputStream = response.getOutputStream();
	                 dataMap = (Map<String, Integer>) session.getAttribute("dataMap");
	                 chart = Graph.getRegChart(dataMap);
	                
	                ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
	                break;
	            case "totalpackagesale":
	            	Map<String, Integer> dataMap1;
	            	response.setContentType("image/png");
	            	outputStream = response.getOutputStream();
	                dataMap1 = (Map<String, Integer>) session.getAttribute("dataMap");
	                chart = Graph.getPckgChart(dataMap1);
	                
	                ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
	                break;
	                
	            case "totalsale":
	            	
	            	Map<String, Double> dataMap2;
	            	response.setContentType("image/png");
	            	outputStream = response.getOutputStream();
	                dataMap2 = (Map<String, Double>) session.getAttribute("dataMap");
	                chart = Graph.getTotalSale(dataMap2);
	                
	                ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);
	                break;
	                
	            case "downloadChnlListing":
					ServletContext sc = getServletContext();
					String path = sc.getRealPath("");
					String filename ="Channel Listing.pdf";
					
					response.setContentType("application/octet-stream");
					response.setHeader("content-disposition", "attachment; filename="+filename);
					
					FileInputStream in = new FileInputStream(path+"/"+filename);
					PrintWriter out = response.getWriter();
					
					int i=in.read();
					while(i != -1){
						out.write(i);
						i = in.read();    					
					}
					in.close();
					out.close();
					break;
	        }
	    }
        }catch(Exception e){
			System.out.println("!!Error occured while processing"+" action: "+action+" in ChartControllerServlet!!");
			e.printStackTrace();
		}

        
    }
    
     /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
