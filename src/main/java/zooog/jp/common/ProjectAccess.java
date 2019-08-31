package zooog.jp.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zooog.jp.entity.ProjectMapper;
import zooog.jp.model.Project;
import zooog.jp.model.ProjectExample;

public class ProjectAccess {
	public Project selectProject(String projectTitle) {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
			Project project = projectMapper.selectByProjectTitle(projectTitle);
			String pro = project.getProjecttitle();
			System.out.println(pro);
			System.out.println(project.getProjecttitle());
			System.out.println(project.getMaxmonthly());

			return project;
		}

	}

	public List<Project> seclectOne(String projectname) {
		String title = "";
		ArrayList<Project> list = new ArrayList<Project>();
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			ProjectMapper mapAll = sqlSession.getMapper(ProjectMapper.class);
			ProjectExample projectExample = new ProjectExample();
			List<Project> projectList = mapAll.selectByExample(projectExample);
			for (int i = 0; i < projectList.size(); i++) {
				title = projectList.get(i).getProjecttitle();
				if (title.contains(projectname)) {
					list.add(projectList.get(i));
				}
			}
			System.out.println(list);
			return list;
		}
	}

	public List<Project> seclectAll() {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			ProjectMapper mapAll = sqlSession.getMapper(ProjectMapper.class);
			ProjectExample projectExample = new ProjectExample();
			ArrayList<String> cars = new ArrayList<String>();
			List<Project> projectList = mapAll.selectByExample(projectExample);
			for (Project project : projectList) {
				cars.add(project.getProposalnumber());
				cars.add(project.getProjecttitle());

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String startdate = formatter.format(project.getApplicationenddate());
				cars.add(startdate);
				cars.add(project.getProjectcol());
				cars.add(project.getApplicationtarget());
				cars.add(project.getMaxmonthly());
				System.out.println("Project: " + project.toString());
			}
			return projectList;
		}
	}

	public static void main(String[] args) {
		new ProjectAccess().seclectOne("ALM");
		//		new ProjectAccess().selectProject("ALM");
	}
}