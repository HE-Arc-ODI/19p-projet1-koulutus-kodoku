package ch.hearc.odi.koulutus.rest;

import ch.hearc.odi.koulutus.business.Program;
import ch.hearc.odi.koulutus.services.PersistenceService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("program")
public class ProgramResourceRest {

  @Inject
  private PersistenceService persistenceService;

  @GET
  public List<Program> getPrograms() {
    return persistenceService.getPrograms();
  }

  @GET
  @Path("{id}")
  public Program getProgramById(@PathParam("id") Long programId) {
    return persistenceService.getProgramById(programId);
  }

  @POST
  public void createProgram(Program program) {
    persistenceService.createAndPersistProgram(program.getName(), program.getRichDescription(),
        program.getField(), program.getPrice(), program.getCourses());
  }

  @DELETE
  @Path("{id}")
  public void deleteProgramById(@PathParam("id") Long programId) {
    persistenceService.deleteProgram(programId);
  }

  @PUT
  @Path("{id}")
  public Program updateProgram(@PathParam("id") Long programId, Program program) {
    return persistenceService.updateProgram(programId, program);
  }


}
