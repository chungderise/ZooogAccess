package zooog.jp.common;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractBaseDbLogic {
	protected static SqlSession openSession() {
		return ApsSessionFactory.openSession();
	}

}
