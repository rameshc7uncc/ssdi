package com.infinityCableService.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
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
import com.infinityCableService.model.User;

public class UserControllerServletTest  extends Mockito{

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

    /**
     * Test method for
     * {@link UserControllerServlet#doPost(HttpServletRequest, HttpServletResponse)} .
     *
     * @throws IOException
     * @throws ServletException
     */
    @Test
    public void testDoPostLogin() throws ServletException, IOException {

		when(request.getRequestDispatcher("/adminHomePage.jsp")).thenReturn(dispatcher);
        parameters.put("action", "login");
        parameters.put("email", "drani@uncc.edu");
        parameters.put("password", "Summer100");
        
        servlet.doGet(request, response);

        Object object = attributes.get("theAdmin");

        assertNotNull(object);
        assertTrue(User.class.isAssignableFrom(object.getClass()));

        User adminUser = (User) object;

        assertEquals("Admin", adminUser.getRoleId());
    }

    /**
     * Test method for
     * {@link SessionServlet#doGet(HttpServletRequest, HttpServletResponse)} .
     *
     * @throws IOException
     * @throws ServletException
     */
    @Test
    public void testDoPostSignup() throws ServletException, IOException {
        
    	parameters.put("action", "signup");
        parameters.put("firstName", "John");
        parameters.put("lastName", "Smith");
        parameters.put("email", "johns@gmail.com");
        parameters.put("phoneNumber", "3452785678");
        parameters.put("address1", "23, Glenn Dr");
        parameters.put("address2", "House No 34");
        parameters.put("city", "Seatle");
        parameters.put("state", "WA");
        parameters.put("zipcode", "45678");
        parameters.put("password", "1234!");
        parameters.put("confirm_password", "1234!");
        
        
        servlet.doGet(request, response);

        Object object = attributes.get("theUser");

        assertNotNull(object);
        assertTrue(User.class.isAssignableFrom(object.getClass()));

       User newuser = (User) object;

        assertEquals("johns@gmail.com", newuser.getEmailAddress());
        assertEquals("WA", newuser.getState());
        assertEquals("1234!", newuser.getPassword());
        
        
    }

    
}
