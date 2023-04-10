package az.asl.payday.controller;

import az.asl.payday.model.TeacherDto;
import az.asl.payday.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

//    @GetMapping
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
    public ResponseEntity<?> add(@RequestBody TeacherDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TeacherDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
