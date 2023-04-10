package az.asl.payday.controller;

import az.asl.payday.model.LessonDto;
import az.asl.payday.service.lesson.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService service;

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

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody LessonDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody LessonDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
       service.delete(id);
    }
}

