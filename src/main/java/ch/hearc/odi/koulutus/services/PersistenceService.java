/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.services;


import ch.hearc.odi.koulutus.business.Pojo;
import ch.hearc.odi.koulutus.business.Session;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceService {

  private EntityManagerFactory entityManagerFactory;


  public PersistenceService() {
    //  an EntityManagerFactory is set up once for an application
    //  IMPORTANT: the name here matches the name of persistence-unit in persistence.xml
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

  @Override
  public void finalize() throws Throwable {
    entityManagerFactory.close();
    super.finalize();
  }

  public Pojo createAndPersistAPojo(String myProperty){
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Pojo pojo = new Pojo();
    pojo.setSomeProperty(myProperty);
    entityManager.persist(pojo);
    entityManager.getTransaction().commit();
    entityManager.close();
    return pojo;
  }

  public List<Session> getSessions(){
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Session> sessions = entityManager.createQuery("from Session", Session.class).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return sessions;
  }

  public Session getSessionById(Long sessionId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Session session = entityManager.find(Session.class, sessionId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return session;
  }

  public Session createAndPersistSession(Date startDateTime, Date endDateTime, Double price, String room){
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Session session = new Session(startDateTime, endDateTime, price, room);
    entityManager.persist(session);
    entityManager.getTransaction().commit();
    entityManager.close();
    return session;
  }





}





