package com.infinityCableService.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.infinityCableService.controller.PackagesControllerServlet;
import com.infinityCableService.dao.ChannelDao;
import com.infinityCableService.dao.Package_ChannelDao;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.model.Package_Channel;
import com.infinityCableService.model.Packages;
import com.infinityCableService.model.User;



public class PackagesControllerServletTest extends Mockito{

	    /** Servlet under test. */
	    private PackagesControllerServlet servlet;

	    /** Mock request. */
	    private HttpServletRequest request;

	    /** Mock response. */
	    private HttpServletResponse response;

	    /** Mock session. */
	    private HttpSession session;

	    /** Session's attribute map. */
	    private Map attributes;

	    /** Request's parameter map. */
	    private Map parameters;
	   
	    private RequestDispatcher dispatcher;


	    /**
	     * Launches Mockito configuration from annotations.
	     */
	    @Before
	    public void setUp() {

	        attributes = new HashMap();
	        parameters = new HashMap();

	        servlet = new PackagesControllerServlet();
	        request = mock(HttpServletRequest.class);
	        response = mock(HttpServletResponse.class);
	        session = mock(HttpSession.class);
	        dispatcher = mock(RequestDispatcher.class);
	        
	        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
	        when(request.getSession()).thenReturn(session);
	        when(request.getParameterMap()).thenReturn(parameters);
	        when(request.getParameter(anyString())).thenAnswer(new Answer() {
	    	
	            /**
	             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
	             */
	            @Override
	            public Object answer(InvocationOnMock aInvocation) throws Throwable {

	                String key = (String) aInvocation.getArguments()[0];

	                return parameters.get(key);
	            }
	        });

	        when(session.getAttribute(anyString())).thenAnswer(new Answer() {

	            /**
	             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
	             */
	            @Override
	            public Object answer(InvocationOnMock aInvocation) throws Throwable {

	                String key = (String) aInvocation.getArguments()[0];

	                return attributes.get(key);
	            }
	        });

	        Mockito.doAnswer(new Answer() {

	            /**
	             * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
	             */
	            @Override
	            public Object answer(InvocationOnMock aInvocation) throws Throwable {

	                String key = (String) aInvocation.getArguments()[0];
	                Object value = aInvocation.getArguments()[1];
	                attributes.put(key, value);

	                return null;
	            }

	        }).when(session).setAttribute(anyString(), anyObject());
	    }


@Test
public void testDoPostAddPackage() throws ServletException, IOException {

	String[] channelList = {"Discovery", "HBO", "Star Movies", "tenSports","YES" };
	parameters.put("action", "addPackage");
    parameters.put("packageName", "ssdi");
    parameters.put("price", "30");
    parameters.put("pckgDesc","Includes 1 channel");
    parameters.put("channelSelection", channelList);
    
	
	servlet.doGet(request, response);

    
	/*Packages pckCrtd = PackagesDao.getPkgDetails("sumpkg");
	assertNotNull(pckCrtd);
	assertEquals("sumpkg",pckCrtd.getp_Name());
	List<String> pkgChnList = Package_ChannelDao.getPckgChanlList(15);
	assertNotNull(pkgChnList);
	assertEquals(5, pkgChnList.size());*/
	
    
}
@Test
public void testDoPostDeletePackage() throws ServletException, IOException {
	 parameters.put("action", "deletePackage");
     parameters.put("pckgSelected", "sports");
    
     servlet.doGet(request, response);

}
}
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    