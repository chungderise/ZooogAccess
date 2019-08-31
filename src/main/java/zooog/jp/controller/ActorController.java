package zooog.jp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;

import zooog.jp.common.CommonLogic;
import zooog.jp.model.Actor;

/**
 * Servlet implementation class ActorController
 */
public class ActorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonLogic commonLogic = new CommonLogic();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String actocID = request.getParameter("actorID");
		//ActorIDをチェック
		if (!StringUtils.isNullOrEmpty(actocID)) {
			if (!commonLogic.checkID(actocID)) {
				out.print(gson.toJson(null));
				out.flush();
				out.close();
			} else {
				Actor actor = commonLogic.selectID(actocID);
				out.print(gson.toJson(actor));
				out.flush();
				out.close();
			}
		} else {
			List<Actor> actor = (new CommonLogic()).selectAll();
			out.print(gson.toJson(actor));
			out.flush();
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
