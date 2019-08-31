package co.jp.MyBatisSample;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import zooog.jp.common.AbstractBaseDbLogic;
import zooog.jp.entity.ActorMapper;
import zooog.jp.model.Actor;


public class App3 extends AbstractBaseDbLogic{
	public static void main(String[] args) throws IOException {

		try(SqlSession sqlSession = openSession()) {
			// ActorテーブルのMapperを取得します(4)
            ActorMapper map = sqlSession.getMapper(ActorMapper.class);
            // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
            Actor actor = map.selectByPrimaryKey((short) 1);

      // 取得した内容を確認します
            System.out.println("actor.getActorId    = " + actor.getActorId());
            System.out.println("actor.getFirstName  = " + actor.getFirstName());
            System.out.println("actor.getLastName   = " + actor.getLastName());
            System.out.println("actor.getLastUpdate = " + actor.getLastUpdate());

		}
	}
}
