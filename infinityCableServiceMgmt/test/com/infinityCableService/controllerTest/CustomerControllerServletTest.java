package com.infinityCableService.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
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

import com.infinityCableService.controller.UserControllerServlet;
import com.infinityCableService.dao.PackagesDao;
import com.infinityCableService.model.Packages;
import com.infinityCableService.model.User;

public class CustomerControllerServletTest  extends Mockito{

    /** Servlet under test. */
    private UserControllerServlet servlet;

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

        servlet = new UserControllerServlet();
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
 public void testDoPostUpdateDetails() throws ServletException, IOException {
        
    	parameters.put("action", "updateDetails");
        parameters.put("firstName", "Divya");
        parameters.put("lastName", "Lakshmi");
        parameters.put("email", "lsridhar@uncc.edu");
        parameters.put("phoneNumber", "789409344");
        parameters.put("address1", "dsvbjsfj");
        parameters.put("address2", "vkjvkjhv");
        parameters.put("city", "hvj");
        parameters.put("state", "jh");
        parameters.put("zipcode", "98546");
        parameters.put("password", "Lakshmi@20");
        
        
        
        servlet.doGet(request, response);

        Object object = attributes.get("theUser");

        assertNotNull(object);
        assertTrue(User.class.isAssignableFrom(object.getClass()));

       User updatedUser = (User) object;

        assertEquals("Divya", updatedUser.getFirstName());
        assertEquals("Lakshmi", updatedUser.getLastName());
        assertEquals("lsridhar@uncc.edu", updatedUser.getEmailAddress());
        
        
    }
    @Test
    public void testDoPostViewPackage() throws ServletException, IOException{
    	
    	parameters.put("action", "viewPackage");
    	List<Packages> pckgsList = PackagesDao.getAllPcgks();
    	assertNotNull(pckgsList);
		assertEquals(4, pckgsList.size());
    	
    	
    	
    }
    
    
}
