package bookrecord.client;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import bookrecord.orm.AuthorAddress;
import bookrecord.orm.Article;
import bookrecord.orm.Author;
import bookrecord.orm.Blog;
import bookrecord.orm.Book;
import bookrecord.orm.HardBind;
import bookrecord.orm.Publisher;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(AuthorAddress.class).addAnnotatedClass(Article.class).addAnnotatedClass(Author.class).addAnnotatedClass(Blog.class).addAnnotatedClass(HardBind.class).addAnnotatedClass(Publisher.class).buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();
		
		Book b=new Book("It industry","2A",600,new Date(2001,1,12));
		ses.save(b);
		Publisher p =  new Publisher(23,"Bharath", "Tumkur", 6362211035L);

		
		ses.save(p);
		b.setPublisher(p);
		ses.save(b);
		
		Article a1= new Article("valtech.com","ValtechIndia");
		ses.save(a1);
		Author a=new Author("Dheeraj",9611858765L);
		ses.save(a);
		AuthorAddress a11=new AuthorAddress(29,"jp nagar", "ka", 560079L);
		ses.save(a11);
		a.setAuthoraddress(a11);
		a11.setAuthor(a);
		Blog b1=new Blog("Blog", "blog.com", 3L);
		ses.save(b1);
		HardBind hb1=new HardBind(1, 200, "2022", 1);
		ses.save(hb1);
		
	tx.commit();
	ses.close();
	sf.close();
	}

}
