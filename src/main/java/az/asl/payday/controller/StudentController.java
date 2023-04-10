package az.asl.payday.controller;

import az.asl.payday.model.StudentDto;
import az.asl.payday.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

//    @GetMapping()
//    public ResponseEntity<?> getAll(){
//        return ResponseEntity.ok(service.getAll());
//    }

    @GetMapping
    public ResponseEntity<?> getPages(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAllPage(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody StudentDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody StudentDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/name")
    public ResponseEntity<?> searchByName(@RequestParam("name") String name){
        return ResponseEntity.ok(service.searchByName(name));
    }
}
