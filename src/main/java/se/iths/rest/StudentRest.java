package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sms")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {
    StudentService service;

    @Inject
    public StudentRest(StudentService service) {
        this.service = service;
    }

    @POST
    public Response create(Student student){
        ensureStudentDoesntExist(service.getByMail(student.getEmail()));
        ensureStudentHasValues(student);
        service.create(student);
        return Response.ok(student).build();
    }

    @Path("{email}")
    @GET
    public Response getByMail(@PathParam("email") String email){
        Student foundStudent = service.getByMail(email);
        ensureStudentExists(foundStudent, email);
        return Response.ok(foundStudent).build();
    }

    @PUT
    public Response update(Student student){
        ensureStudentExists(service.getByMail(student.getEmail()), student.getEmail());
        ensureStudentHasValues(student);
        service.update(student);
        return Response.ok(student).build();
    }

    @Path("{email}")
    @DELETE
    public Response delete(@PathParam("email") String email){
        Student foundStudent = service.getByMail(email);
        ensureStudentExists(foundStudent, email);
        service.delete(foundStudent);
        return Response.ok(foundStudent).build();
    }

    @Path("all")
    @GET
    public Response getAll(){
        return Response.ok(service.getAll()).build();
    }

    @Path("lastname")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName){
        return Response.ok(service.getByLastName(lastName)).build();
    }

    private void ensureStudentExists(Student foundStudent, String email) {
        if(foundStudent==null){
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with email: " + email + " is not in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    private void ensureStudentDoesntExist(Student student){
        if(student!=null){
            throw new WebApplicationException(Response.status(Response.Status.CONFLICT)
                    .entity("Student with email: " + student.getEmail() + " is already in database")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());
        }
    }

    private void ensureStudentHasValues(Student student){
        if(student.getFirstName()==null||student.getLastName()==null||student.getEmail()==null){
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Student lacks essential data. Must have email, lastName and firstName")
                    .type(MediaType.TEXT_PLAIN_TYPE).build());

        }
    }
}
