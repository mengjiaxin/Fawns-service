/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.63
 * Generated at: 2016-05-04 10:26:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.app.admin.page.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class foot_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    <title>top</title>\r\n");
      out.write("\t<link name=\"pageCss\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("app/admin/page/web/css/gsk_common.css\">\r\n");
      out.write("\t<link name=\"pageCss\" id=\"change_style\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("app/admin/page/web/css/01/style.css\">\r\n");
      out.write("\t<link name=\"pageCss\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basePath);
      out.write("app/admin/page/web/css/main.css\">\r\n");
      out.write("</head>\r\n");
      out.write("  <body>\r\n");
      out.write("  \t<div\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"border: medium none; background: none repeat scroll 0% 0% transparent;\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"layBJA6YA3\" class=\"div-state-default w100b list_main\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"frameBJA6YA_left3\" class=\"w100b list_second ui-sortable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div systemcomlibid=\"com_8\" id=\"lib_3\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"text-align: center; background-color: transparent; left: 0px; top: 0px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"conner_3\" title=\"图片\" dragtype=\"lib_1397489010042\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"image\" statictype=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"com_content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"overflow: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h2 style=\"border-bottom: #CCCCCC 1px solid;\"></h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p class=\"conner_10\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<strong>8645部队军需后期管理系统</strong> &copy; 2013-2014 All Right Reserved.\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
