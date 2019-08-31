package zooog.jp.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zooog.jp.entity.LoginMapper;
import zooog.jp.model.Login;
import zooog.jp.model.LoginExample;

public class LoginAccess {

	public Login selectUserID(Integer userID) {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
			Login login = loginMapper.selectByPrimaryKey(Integer.valueOf(userID));
			System.out.println("ID:" + login.getId());
			System.out.println("ID:" + login.getUser());
			System.out.println("ID:" + login.getPass());
			return login;
		}
	}

	public Login selectUserName(String userName) {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
			Login login = loginMapper.selectByUserName(userName);
			System.out.println("ID:" + login.getId());
			System.out.println("USER:" + login.getUser());
			System.out.println("PASS:" + login.getPass());
			return login;
		}
	}

	public List<Login> selectAll() {
		try(SqlSession sqlSession = ApsSessionFactory.openSession()) {
			LoginMapper mapAll = sqlSession.getMapper(LoginMapper.class);
			LoginExample example = new LoginExample();
			 List<Login> actor= mapAll.selectByExample(example);
			 for(Login actor1 :actor) {
				 System.out.println("ID= " + actor1.getId());
				 System.out.println("USER= " + actor1.getUser());
				 System.out.println("PASS= " + actor1.getPass());
			 }
			return actor;
		}

	}

	public boolean userCheck(String username) {
		try(SqlSession sqlSession = ApsSessionFactory.openSession()) {
			LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
			Login user = loginMapper.selectByUserName(username);
			if (user == null) {
				return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
//		new LoginAccess().selectAll();
//		new LoginAccess().selectUserName("admin");
		boolean result =  new LoginAccess().userCheck("admin@zooog.jp");
		System.out.println(result);
	}
}
