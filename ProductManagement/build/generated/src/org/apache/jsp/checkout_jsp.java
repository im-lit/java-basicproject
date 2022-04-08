package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <section class=\"checkout spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <c:set value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.LOGIN_USER}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"u\"/>\n");
      out.write("                <c:set value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.ERROR_CREATE}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"err\"/>\n");
      out.write("                <div class=\"checkout__form\">\n");
      out.write("                    <h4>Billing Details</h4>\n");
      out.write("                    <form action=\"CheckOutController\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-8 col-md-6\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Full Name<span>*</span></p>\n");
      out.write("                                            <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"name\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"checkout__input\">\n");
      out.write("                                    <p>Phone<span>*</span></p>\n");
      out.write("                                    <input type=\"text\" placeholder=\"Street Address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"phone\">                                    \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"col-lg-6\">\n");
      out.write("                                        <div class=\"checkout__input\">\n");
      out.write("                                            <p>Adress<span>*</span></p>\n");
      out.write("                                            <input type=\"text\" name=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6\">\n");
      out.write("                                <div class=\"checkout__order\">\n");
      out.write("                                    <h4>Your Order</h4>\n");
      out.write("                                    <div class=\"checkout__order__products\">Products <span>Total</span></div>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.CART}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"c\">\n");
      out.write("                                            <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.product.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" <span> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.quantity*c.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("$\n");
      out.write("                                                    <c:set var=\"amount\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.quantity*c.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></span></li>\n");
      out.write("                                                    <c:set var=\"total\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total+amount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                                </c:forEach>\n");
      out.write("                                    </ul>                                 \n");
      out.write("                                    <div class=\"checkout__order__total\">Total <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("$</span></div>\n");
      out.write("                                    <input type=\"hidden\" name=\"total\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                    <input type=\"hidden\" name=\"userID\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.userID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">PLACE ORDER</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
