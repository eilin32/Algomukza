/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.21
 * Generated at: 2019-08-09 01:56:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1564973067371L));
    _jspx_dependants.put("jar:file:/C:/Users/sjm/Desktop/SP/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SP/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<!--\r\n");
      out.write("\tIntensify by TEMPLATED\r\n");
      out.write("\ttemplated.co @templatedco\r\n");
      out.write("\tReleased for free under the Creative Commons Attribution 3.0 license (templated.co/license)\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>Signup</title>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/include/setting.jsp", out, false);
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$('#pwd2').keyup(function(){\r\n");
      out.write("\t\t\t\tvar pwd=$('#pwd').val();\r\n");
      out.write("\t\t\t\tvar pwd2=$('#pwd2').val();\t\t\r\n");
      out.write("\t\t\t\tif(pwd==pwd2){\r\n");
      out.write("\t\t\t\t\t$('#pwdCheck').html(\"비밀번호확인완료\");\r\n");
      out.write("\t\t\t\t}else if(pwd2==\"\"){\r\n");
      out.write("\t\t\t\t\t$('#pwdCheck').html(\" \");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$('#pwdCheck').html(\"비밀번호 확인실패!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t  $(\"#profile\").change(function(){\r\n");
      out.write("   \t\t\t\t\tif(this.files && this.files[0]) {\r\n");
      out.write("    \t\t\t\t\tvar reader = new FileReader;\r\n");
      out.write("    \t\t\t\t\treader.onload = function(data) {\r\n");
      out.write("    \t\t\t\t   $(\"#replaceMe\").attr(\"src\", data.target.result).width(300).height(300);        \r\n");
      out.write("    \t\t\t\t\t\t}\r\n");
      out.write("  \t\t\t\t\t\t reader.readAsDataURL(this.files[0]);\r\n");
      out.write("  \t\t\t\t\t }\r\n");
      out.write("  });\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#checkId').click(function(){\r\n");
      out.write("\t\t\t\tvar checkId=$('#id').val();\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\t\turl :\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/checkId/\"+checkId,\r\n");
      out.write("\t\t\t\t\tsuccess :checkSuccess ,\r\n");
      out.write("\t\t\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\t\talert(\"아이디를 입력해주세요\");\r\n");
      out.write("\t\t\t\t\t\t$('#idCheck').html(\"\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction checkSuccess(data){\r\n");
      out.write("\t\t\tif(data.cnt==0){\r\n");
      out.write("\t\t\t\talert(\"사용가능합니다.\");\r\n");
      out.write("\t\t\t\t$('#idCheck').html(\"중복확인완료\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"중복된 항목입니다.\");\r\n");
      out.write("\t\t\t\t$('#idCheck').html(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction isNull(obj, msg){\r\n");
      out.write("\t\t\tif(!obj.value){\r\n");
      out.write("\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\tobj.focus();\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction checkForm(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar signupFrom=document.signupFrom;\r\n");
      out.write("\t\t\tif (isNull(signupFrom.id, \"ID을 입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(isNull(signupFrom.pwd,\"비밀번호를 입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(isNull(signupFrom.pwd2,\"비밀번호 확인을 입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(isNull(signupFrom.name,\"이름을 입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(isNull(signupFrom.email,\"Email 입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(isNull(signupFrom.phone,\"전화번호를  입력하세요\")){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($('#idCheck').html()!=\"중복확인완료\"){\r\n");
      out.write("\t\t\t\talert(\"ID 중복확인 해주세요\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\tif($('#pwdCheck').html()!=\"비밀번호확인완료\"){\r\n");
      out.write("\t\t\t\talert(\"Password 확인해주세요\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\treturn true;\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"subpage\">\r\n");
      out.write("\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/include/top.jsp", out, false);
      out.write("\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- Main -->\r\n");
      out.write("\t<section id=\"main\" class=\"wrapper\">\r\n");
      out.write("\t\t<div class=\"inner\">\r\n");
      out.write("\t\t\t<br> <br> <br>\r\n");
      out.write("\t\t\t<!-- 회원등록 화면 -->\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form enctype=\"multipart/form-data\" method=\"POST\"\r\n");
      out.write("\t\t\t\t\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/signup\"\r\n");
      out.write("\t\t\t\t\tname=\"signupFrom\" onsubmit=\"return checkForm()\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>프로필사진</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/profile.png\" id=\"replaceMe\" \r\n");
      out.write("\t\t\t\t\t\t\twidth=\"300px\" height=\"300px\" />\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"file\" name=\"profile\"id=\"profile\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>ID</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"id\" id=\"id\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><button type=\"button\" name=\"checkId\" id=\"checkId\">중복확인</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p id=\"idCheck\"></p></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>비밀번호</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"pwd\" id=\"pwd\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>비밀번호확인</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"pwd2\" id=\"pwd2\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p id=\"pwdCheck\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>이름</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"name\" id=\"name\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>Email</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"email\" id=\"email\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>전화번호</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"phone\" id=\"phone\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><label>해당사항체크</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"preg\" name=\"chk\" value=\"p\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"preg\">임신여부</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"old\" name=\"chk\" value=\"o\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"old\">노인</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"age\" name=\"chk\" value=\"a\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>유아</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td></td><td></td><td></td><td></td><td></td><td></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<button id=\"submit\" type=\"submit\">가입하기</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<!-- Footer -->\r\n");
      out.write("\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/include/top.jsp", out, false);
      out.write("\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
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