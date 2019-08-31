package co.jp.MyBatisSample;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import zooog.jp.common.AbstractBaseDbLogic;
import zooog.jp.entity.TestMapper;
import zooog.jp.model.Test;

public class App4 extends AbstractBaseDbLogic{
	public static void main(String[] args) throws IOException {

		try(SqlSession sqlSession = openSession()) {
			// ActorテーブルのMapperを取得します(4)
			TestMapper map = sqlSession.getMapper(TestMapper.class);
//			TestExample example = new TestExample();
            // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
          /*  List<Test> actor = map.selectByExample(example);
           for (Test test1:actor) {
				System.out.println(test1.getUserid());
				System.out.println(test1.getUsername());
				System.out.println(test1.getPassword());
			}*/

			Test test = map.selectByPrimaryKey("quynh");
			System.out.println(test.getUserid());
			System.out.println(test.getUsername());
			System.out.println(test.getPassword());
		}
	}
}
