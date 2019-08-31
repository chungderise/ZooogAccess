package co.jp.MyBatisSample;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zooog.jp.entity.ActorMapper;
import zooog.jp.model.Actor;

public class App {
    public static void main(String[] args) {

        // resources直下のmybatis-config.xmlを読み込みます(1)
        try (Reader r = Resources.getResourceAsReader("mybatis-config.xml");) {

            // 読み込んだ設定ファイルからSqlSessionFactoryを生成します(2)
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // SQLセッションを取得します(3)
            try (SqlSession session = factory.openSession()) {

                // ActorテーブルのMapperを取得します(4)
                ActorMapper map = session.getMapper(ActorMapper.class);
                // Actorテーブルの主キー（actor_id)が１であるレコードを検索します(5)
                Actor actor = map.selectByPrimaryKey((short) 1);

          // 取得した内容を確認します
                System.out.println("actor.getActorId    = " + actor.getActorId());
                System.out.println("actor.getFirstName  = " + actor.getFirstName());
                System.out.println("actor.getLastName   = " + actor.getLastName());
                System.out.println("actor.getLastUpdate = " + actor.getLastUpdate());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
