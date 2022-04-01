package se.iths.utility;

import se.iths.entity.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class DataGenerator {
    @PersistenceContext
    EntityManager manager;

    @PostConstruct
    public void addData(){
        Student a = new Student("Arne", "And", "a@a.com");
        Student b = new Student("Örjan", "And", "b@a.com");
        Student c = new Student("Björne", "Björn", "b@b.com");
        Student d = new Student("Frans", "Björn", "a@b.com");
        Student e = new Student("Cesar", "Clown", "c@c.com");
        Student f = new Student("Augustus", "Clown", "a@c.com");
        Student g = new Student("Pyrrhus", "Clown", "b@c.com");
        Student h = new Student("David", "Dåre", "d@d.com");
        Student i = new Student("Einar", "Enhörning", "e@e.com");

        manager.persist(a);
        manager.persist(b);
        manager.persist(c);
        manager.persist(d);
        manager.persist(e);
        manager.persist(f);
        manager.persist(g);
        manager.persist(h);
        manager.persist(i);
    }
}
