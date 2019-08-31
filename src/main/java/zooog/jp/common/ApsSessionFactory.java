package zooog.jp.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ApsSessionFactory {
	//SqlSessionFacory
	private static SqlSessionFactory sqlSessionFactory;

	public static void init() {
		try {
			InputStream inputStream =  Resources.getResourceAsStream("mybatis-config.xml");
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("mybatis-config.xmlファイルが見つかりません。" + e.toString());
		}

	}
	public static SqlSession openSession() {
		init();
		return sqlSessionFactory.openSession();
	}

//	public static void main(String[] args) throws IOException {
//
//		try(SqlSession sqlSession = openSession()) {
//			// ActorテーブルのMapperを取得します(4)
//            ActorMapper map = sqlSession.getMapper(ActorMapper.class);
//            // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
//            Actor actor = map.selectByPrimaryKey((short) 1);
//
//      // 取得した内容を確認します
//            System.out.println("actor.getActorId    = " + actor.getActorId());
//            System.out.println("actor.getFirstName  = " + actor.getFirstName());
//            System.out.println("actor.getLastName   = " + actor.getLastName());
//            System.out.println("actor.getLastUpdate = " + actor.getLastUpdate());
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

}
