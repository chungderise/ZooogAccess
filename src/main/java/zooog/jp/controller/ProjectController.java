package zooog.jp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;

import zooog.jp.common.ProjectAccess;
import zooog.jp.model.Project;

/**
 * Servlet implementation class ProjectController
 */
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectAccess projectAccess = new ProjectAccess();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String actocID = request.getParameter("actorID");
		//ActorIDをチェック
		if (!StringUtils.isNullOrEmpty(actocID)) {
				List<Project> project = projectAccess.seclectOne(actocID);
				out.print(gson.toJson(project));
				response.setContentType("application/json");
				out.flush();
				out.close();
		} else {
			List<Project> project = (new ProjectAccess()).seclectAll();
			out.print(gson.toJson(project));
			response.setContentType("application/json");
			out.flush();
			out.close();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);

	}

}
