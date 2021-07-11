/*
 * package com.aem.ayansh.core.servlets;
 * 
 * import java.io.IOException; import java.sql.Connection;
 * 
 * import javax.servlet.Servlet; import javax.servlet.ServletException;
 * 
 * import org.apache.sling.api.SlingHttpServletRequest; import
 * org.apache.sling.api.SlingHttpServletResponse; import
 * org.apache.sling.api.servlets.HttpConstants; import
 * org.apache.sling.api.servlets.SlingAllMethodsServlet; import
 * org.osgi.framework.Constants; import
 * org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference; import org.slf4j.Logger;
 * import org.slf4j.LoggerFactory;
 * 
 * import com.aem.ayansh.core.dbutil.DataBaseConnectionHelper;
 * 
 * @Component(service=Servlet.class, property={ Constants.SERVICE_DESCRIPTION +
 * "=LopTop Servlet", "sling.servlet.methods=" + HttpConstants.METHOD_GET,
 * 
 * "sling.servlet.resourceTypes="+ "ayansh/components/structure/page",
 * "sling.servlet.extensions=" + "txt"
 * 
 * "sling.servlet.paths="+"/bin/LapTop" })
 * 
 * 
 * public class LapTop extends SlingAllMethodsServlet{ protected static final
 * Logger log=LoggerFactory.getLogger(LapTop.class);
 * 
 * @Reference DataBaseConnectionHelper obj; Connection con=null;
 * 
 * @Override protected void doGet(SlingHttpServletRequest request,
 * SlingHttpServletResponse response) throws ServletException, IOException { //
 * TODO Auto-generated method stub //super.doGet(request, response);
 * //log.info("servlet called***************");
 * //response.getWriter().write("hai this is chandu");
 * 
 * // Connection con=obj.getDataBaseConnection(getServletName())
 * con=obj.getDataBaseConnection("ayaana");
 * log.info("hitted the servlet*********"+con);
 * 
 * //response.getWriter().write("hai this is chandu from aem"); } }
 */