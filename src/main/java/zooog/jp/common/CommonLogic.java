package zooog.jp.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zooog.jp.entity.ActorMapper;
import zooog.jp.model.Actor;
import zooog.jp.model.ActorExample;

public class CommonLogic {
	public boolean checkID(String actocID) {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			// ActorテーブルのMapperを取得します(4)
			ActorMapper map = sqlSession.getMapper(ActorMapper.class);
			// Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
			Actor actor = map.selectByPrimaryKey(Short.valueOf(actocID));
			//ActorIDはDBでIDをチェックする
			if (actor == null) {
				return false;
			}
			return true;
		}
	}

	public Actor selectID(String actocID) {
		try (SqlSession sqlSession = ApsSessionFactory.openSession()) {
			// ActorテーブルのMapperを取得します(4)
			ActorMapper map = sqlSession.getMapper(ActorMapper.class);
			// Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
			Actor actor = map.selectByPrimaryKey(Short.valueOf(actocID));
			// 取得した内容を確認します
			System.out.println("actor.getActorId    = " + actor.getActorId());
			System.out.println("actor.getFirstName  = " + actor.getFirstName());
			System.out.println("actor.getLastName   = " + actor.getLastName());
			System.out.println("actor.getLastUpdate = " + actor.getLastUpdate());
			return actor;
		}
	}

	public List<Actor> selectAll() {
		try(SqlSession sqlSession = ApsSessionFactory.openSession()) {
			ActorMapper mapAll = sqlSession.getMapper(ActorMapper.class);
			ActorExample example = new ActorExample();
			 List<Actor> actor= mapAll.selectByExample(example);
			 for(Actor actor1 :actor) {
				 System.out.println("actor.getActorId    = " + actor1.getActorId());
			 }

			return actor;
		}

	}
	public static void main(String[] args) {
		new CommonLogic().selectAll();
	}
}
