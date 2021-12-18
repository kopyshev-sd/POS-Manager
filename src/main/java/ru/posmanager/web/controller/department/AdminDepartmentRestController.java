package ru.posmanager.web.controller.department;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.posmanager.service.bank.DepartmentService;
import ru.posmanager.to.bank.DepartmentDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminDepartmentRestController.DEPARTMENT_REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDepartmentRestController extends AbstractDepartmentController {
    public static final String DEPARTMENT_REST_URL = "/api/admin/departments";

    public AdminDepartmentRestController(DepartmentService service) {
        super(service);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDTO> createWithLocation(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO created = super.create(departmentDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(DEPARTMENT_REST_URL + "/{id}")
                .buildAndExpand(created.id()).toUri();

        return ResponseEntity.created(uri).body(created);
    }

    @Override
    @GetMapping("/{id}")
    public DepartmentDTO get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping
    public List<DepartmentDTO> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody DepartmentDTO to, @PathVariable int id) {
        super.update(to, id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        super.delete(id);
    }
}
