/*
 * Copyright (c) 2019. Cours outils de développement intégré, HEG-Arc
 */

package ch.hearc.odi.koulutus.services;


import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Participant;
import ch.hearc.odi.koulutus.business.Pojo;
import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.business.Quarter;
import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.business.Status;
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

  public Pojo createAndPersistAPojo(String myProperty) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Pojo pojo = new Pojo();
    pojo.setSomeProperty(myProperty);
    entityManager.persist(pojo);
    entityManager.getTransaction().commit();
    entityManager.close();
    return pojo;
  }

  public List<Session> getSessions() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Session> sessions = entityManager.createQuery("from Session", Session.class)
        .getResultList();
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

  public Session createAndPersistSession(Date startDateTime, Date endDateTime, Double price,
      String room) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Session session = new Session(startDateTime, endDateTime, price, room);
    entityManager.persist(session);
    entityManager.getTransaction().commit();
    entityManager.close();
    return session;
  }

  public void deleteSession(Long sessionId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Session session = entityManager.find(Session.class, sessionId);
    entityManager.remove(session);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public Session updateSession(Long courseId, Session newSession) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Session session = entityManager.find(Session.class, courseId);
    session.update(newSession);
    entityManager.getTransaction().commit();
    entityManager.close();
    return session;
  }

  public List<Course> getCourses() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Course> courses = entityManager.createQuery("from Course", Course.class).getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return courses;
  }

  public Course getCourseById(Long courseId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course course = entityManager.find(Course.class, courseId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return course;
  }

  public Course createAndPersistCourse(Quarter quarter, int year, int maxNumberOfParticipants,
      Status status, List<Session> sessions) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course course = new Course(quarter, year, maxNumberOfParticipants, status, sessions);
    entityManager.persist(course);
    entityManager.getTransaction().commit();
    entityManager.close();
    return course;
  }

  public void deleteCourse(Long courseId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course course = entityManager.find(Course.class, courseId);
    entityManager.remove(course);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public Course updateCourse(Long courseId, Course newCourse) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Course course = entityManager.find(Course.class, courseId);
    course.update(newCourse);
    entityManager.getTransaction().commit();
    entityManager.close();
    return course;
  }

  public List<Program> getPrograms() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Program> programs = entityManager.createQuery("from Program", Program.class)
        .getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return programs;
  }

  public Program getProgramById(Long programId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  public Program createAndPersistProgram(String name, String richDescription, String field,
      int price,
      List<Course> courses) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = new Program(name, richDescription, field, price, courses);
    entityManager.persist(program);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  public void deleteProgram(Long programId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    entityManager.remove(program);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public Program updateProgram(Long programId, Program newProgram) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Program program = entityManager.find(Program.class, programId);
    program.update(newProgram);
    entityManager.getTransaction().commit();
    entityManager.close();
    return program;
  }

  public List<Participant> getParticipants() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    List<Participant> participants = entityManager.createQuery("from Participant", Participant.class)
        .getResultList();
    entityManager.getTransaction().commit();
    entityManager.close();
    return participants;
  }

  public Participant getParticipantById(Long participantId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }

  public Participant createAndPersistParticipant(String firstName, String lastName, Date birthdate,
      List<Course> courses) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = new Participant(firstName, lastName, birthdate, courses);
    entityManager.persist(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }

  public void deleteParticipant(Long participantId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    entityManager.remove(participant);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public Participant updateParticipant(Long participantId, Participant newParticipant) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    Participant participant = entityManager.find(Participant.class, participantId);
    participant.update(newParticipant);
    entityManager.getTransaction().commit();
    entityManager.close();
    return participant;
  }


}





