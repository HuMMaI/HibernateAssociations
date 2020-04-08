package homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        Post post = new Post();
        post.setTitle("Test post");

        Comment comment1 = new Comment("author", post);
        Comment comment2 = new Comment("author2", post);
        Comment comment3 = new Comment("author3", post);

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(post);
        session.save(comment1);
        session.save(comment2);
        session.save(comment3);

        transaction.commit();
    }
}
