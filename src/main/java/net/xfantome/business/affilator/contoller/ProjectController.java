package net.xfantome.business.affilator.contoller;
import java.util.List;
import java.util.Set;
import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.xfantome.business.affilator.entity.Project;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")


public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Operation(summary = "get all projects")
    @GetMapping
    public ResponseEntity<Set<Project>> getAllProjects() {
        return new ResponseEntity<>(
                projectService.getAllProjects(),
                HttpStatus.OK);
    }

//    @Operation(summary = "get project by id")
//    @GetMapping("/{id}")
//    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") String id) {
//        Project project = projectService.getProjectById(id);
//        if (project != null) {
//            return ResponseEntity.ok().body(project);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @Operation(summary = "get projects by client id")
    @GetMapping("/{clientId}")
    public ResponseEntity<List<Project>> getProjectsByClientId(@PathVariable(value = "clientId") String clientId) {
        List<Project> projects = projectService.getProjectsByClientId(clientId);
        if (!projects.isEmpty()) {
            return ResponseEntity.ok().body(projects);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "create new project")
    @PostMapping
    public ResponseEntity<ApiResponse> createProject(@RequestBody ProjectReq req) {

        return new ResponseEntity<>(
                projectService.CreateProject(req)
                , HttpStatus.OK);
    }
    @Operation(summary = "modify project")
    @PutMapping("/{id}")
    public void updateProject(@PathVariable(value = "id") String id, @RequestBody ProjectReq ProjectDetails) {
        projectService.UpdateProject(id, ProjectDetails);
    }
    @Operation(summary = " delete project ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable(value = "id") String id) {
        projectService.DeleteProject(id);
        return ResponseEntity.ok().build();

    }
}
