package demon.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * HTTP 工具类
 * 
 * @author Demon
 */
public class HttpUtils {
	
	/**
	 * 跨系统网页跳转
	 * @param resp response
	 * @param url
	 * @throws IOException
	 */
	public static void sendRedirect(HttpServletResponse resp, String url) throws IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<meta http-equiv=\"refresh\" content=\"1;url=" + url + "\">");
		out.println("</HEAD>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	/**
	 * 系统内网页跳转
	 * @param resp response
	 * @param url
	 * @throws IOException
	 */
	public static void sendRedirectLocal(HttpServletResponse resp, String url) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<script type=\"text/javascript\">");
		out.println("function autoLogin()");
		out.println("{");
		out.println("window.location.href=\"" + url + "\"");
		out.println("}");
		out.println("</script>");
		out.println("  <BODY onload=\"autoLogin();\">");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
