package ch.hearc.odi.koulutus.services;

import static org.junit.Assert.*;

import ch.hearc.odi.koulutus.business.Course;
import ch.hearc.odi.koulutus.business.Pojo;
import ch.hearc.odi.koulutus.business.Quarter;
import ch.hearc.odi.koulutus.business.Session;
import ch.hearc.odi.koulutus.business.Status;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersistenceServiceTest {

  private PersistenceService persistenceService;
  private EntityManagerFactory entityManagerFactory;

  @Before
  public void setUp() throws Exception {
    persistenceService = new PersistenceService();
    entityManagerFactory = Persistence.createEntityManagerFactory("ch.hearc.odi.koulutus.jpa");
  }

  @Test
  public void createAndPersistAPojo() {
    String testString = "hello world!";
    Pojo pojo = persistenceService.createAndPersistAPojo("hello world!");

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    long expectedPojoID = pojo.getId();
    Pojo actualPojo = entityManager.find(Pojo.class, expectedPojoID);

    assertEquals(pojo, actualPojo);
  }

  @Test
  public void getAllSessionsTest() {
    String  sessionRoomName1 = "room1";
    String  sessionRoomName2 = "room2";
    String  sessionRoomName3 = "room3";

    persistenceService.createAndPersistSession(null, null, null, sessionRoomName1);
    persistenceService.createAndPersistSession(null, null, null, sessionRoomName2);
    persistenceService.createAndPersistSession(null, null, null, sessionRoomName3);

    List<Session> sessions = persistenceService.getSessions();

    assertEquals(sessionRoomName1, sessions.get(0).getRoom());
    assertEquals(sessionRoomName2, sessions.get(1).getRoom());
    assertEquals(sessionRoomName3, sessions.get(2).getRoom());
  }

  @Test
  public void getSessionByIdTest() {
    long id = 2l;
    String sessionRoomName = "room2";

    persistenceService.createAndPersistSession(null, null, null, "room1");
    persistenceService.createAndPersistSession(null, null, null, sessionRoomName);

    Session session = persistenceService.getSessionById(id);

    assertEquals(sessionRoomName, session.getRoom());
  }

  @Test
  public void createAndPersistSessionTest() {
    Session session;
    String sessionRoomName = "room1";
    session = persistenceService.createAndPersistSession(null, null, null, sessionRoomName);

    Long sessionId = session.getId();
    Session actualSession = persistenceService.getSessionById(sessionId);

    assertSame(actualSession.getRoom(), sessionRoomName);
  }

  @Test
  public void getAllCoursesTest() {
    Session session1 = persistenceService.createAndPersistSession(null, null, null, "room1");
    Session session2 = persistenceService.createAndPersistSession(null, null, null, "room2");
    Session session3 = persistenceService.createAndPersistSession(null, null, null, "room3");
    Session session4 = persistenceService.createAndPersistSession(null, null, null, "room4");

    persistenceService.createAndPersistCourse(Quarter.Q1, 2010, 10, Status.OPEN, Arrays.asList(session1));
    persistenceService.createAndPersistCourse(Quarter.Q2, 2010, 10, Status.OPEN, Arrays.asList(session2));
    persistenceService.createAndPersistCourse(Quarter.Q3, 2010, 10, Status.OPEN, Arrays.asList(session3));
    persistenceService.createAndPersistCourse(Quarter.Q4, 2010, 10, Status.OPEN, Arrays.asList(session4));

    List<Course> courses = persistenceService.getCourses();

    assertEquals(session1.getRoom(), courses.get(0).getSessions().get(0).getRoom());
  }
}