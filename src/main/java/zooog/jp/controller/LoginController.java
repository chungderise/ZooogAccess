package zooog.jp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;

import zooog.jp.common.LoginAccess;
import zooog.jp.model.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		LoginAccess loginAccess = new LoginAccess();
		Gson gson = new Gson();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
			//UsernameはDBでチェックする
			boolean usercheck = loginAccess.userCheck(username);
			if (usercheck) {
				String pass = loginAccess.selectUserName(username).getPass();
				if (password.equals(pass)) {
					Login email = loginAccess.selectUserName(username);
					out.print(gson.toJson(email));
					//						out.print(gson.toJson(password));
					//						response.sendRedirect("index.html");
				} else {
					out.println("Password not");
					out.println("パスワードは正しくないです。");
				}

			} else {
				out.println("ユーザ名を存在していません。");
			}
		} else {
			out.print("ユーザ名とパスワードはNullです。");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
