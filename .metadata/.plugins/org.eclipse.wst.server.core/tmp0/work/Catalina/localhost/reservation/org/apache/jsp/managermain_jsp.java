/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-12-27 21:24:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class managermain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\t\r\n");
      out.write("\t<title>你好</title>\r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"Hello.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"settled.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-expand-sm navbar-dark bg-dark\">\r\n");
      out.write("      <a class=\"navbar-brand\">东方体育中心</a>\r\n");
      out.write("      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarsExample03\" aria-controls=\"navbarsExample03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("      \t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("      <div class=\"collapse navbar-collapse\" id=\"navbarsExample03\">\r\n");
      out.write("        <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("        <li class=\"nav-item active\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"managermain.jsp\">首页<span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"managerorder.jsp\">订单管理 </a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item dropdown\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown03\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">新闻管理</a>\r\n");
      out.write("            <div class=\"dropdown-menu dropdown-top\" aria-labelledby=\"dropdown03\">\r\n");
      out.write("              <a class=\"dropdown-item dropdown-word\" href=\"addnews.jsp\">发布新闻 </a>\r\n");
      out.write("              <a class=\"dropdown-item dropdown-word\" href=\"managernews.jsp\">查看新闻</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a class=\"nav-link\" href=\"managermessage.jsp\">留言管理</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item dropdown no-arrow\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("            \t<i class=\"ps-icon\"></i>\r\n");
      out.write("            \t");
      out.print( session.getAttribute("usrName") );
      out.write("\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"dropdown-menu dropdown-menu-right dropdown-top\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("              <a class=\"dropdown-item dropdown-word\" href=\"managerInform.jsp\">个人信息</a>\r\n");
      out.write("            <div class=\"dropdown-divider\"></div>\r\n");
      out.write("              <a class=\"dropdown-item dropdown-word\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">登出</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <main role=\"main\">\r\n");
      out.write("      <div class=\"jumbotron first-section\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <h1 class=\"display-5\">您好！</h1>\r\n");
      out.write("          <p class=\"display-text\">\r\n");
      out.write("          \t欢迎来到东方体育中心，您可以在此管理订单、新闻和留言。\r\n");
      out.write("          </p>\r\n");
      out.write("          <p class=\"display-text\">祝您上班愉快！</p>\r\n");
      out.write("          <p class=\"display-button\"><a class=\"btn btn-primary btn-lg btn-word\" href=\"UserInform.jsp\" role=\"button\">管理个人账户</a></p>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-md-4\">\r\n");
      out.write("            <h3>新闻</h3>\r\n");
      out.write("            <p class=\"display-text\">在这里您可以查看和发布场馆新闻。</p>\r\n");
      out.write("            <p><a class=\"btn btn-secondary btn-next\" href=\"managernews.jsp\" role=\"button\">查看更多</a></p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-4\">\r\n");
      out.write("            <h3>订单</h3>\r\n");
      out.write("            <p class=\"display-text\">您可以在这里查看所有用户订单，并对其进行操作。</p>\r\n");
      out.write("            <p><a class=\"btn btn-secondary btn-next\" href=\"managerorder.jsp\" role=\"button\">查看更多</a></p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-md-4\">\r\n");
      out.write("            <h3>留言板</h3>\r\n");
      out.write("            <p class=\"display-text\">您可以查看并审核用户留言。</p>\r\n");
      out.write("            <p><a class=\"btn btn-secondary btn-next\" href=\"managermessage.jsp\" role=\"button\">查看更多</a></p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("      </div>\r\n");
      out.write("    </main>\r\n");
      out.write("    <footer class=\"footer\">\r\n");
      out.write("      <div class=\"container foot-text\">\r\n");
      out.write("        <span class=\"foot-t\">Created by Jiayi Zhu & Shen Lei</span>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" style=\"display: none;\" aria-hidden=\"true\">\r\n");
      out.write("      <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("          <div class=\"modal-header\">\r\n");
      out.write("            <h5 class=\"modal-title\" id=\"exampleModalLabel\">确定登出？</h5>\r\n");
      out.write("            <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("              <span aria-hidden=\"true\">×</span>\r\n");
      out.write("            </button>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"modal-body\" style=\"text-align:center\">生命在于运动</div>\r\n");
      out.write("          <div class=\"modal-footer\">\r\n");
      out.write("            <button class=\"btn btn-secondary btn-cencel\" type=\"button\" data-dismiss=\"modal\">取消</button>\r\n");
      out.write("            <a class=\"btn btn-primary\" href=\"logout.jsp\">确定</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdn.staticfile.org/popper.js/1.14.3/umd/popper.min.js\"></script>\r\n");
      out.write("\t<script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
