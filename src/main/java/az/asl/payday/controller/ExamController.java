package az.asl.payday.controller;

import az.asl.payday.model.ExamDto;
import az.asl.payday.service.exam.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService service;

    @GetMapping
    public ResponseEntity<?> getPages(@RequestParam Integer page, @RequestParam Integer size){
        return ResponseEntity.ok(service.getAllPage(page, size));
    }

//    @GetMapping
//    public ResponseEntity<?> getAll(){
//       return ResponseEntity.ok(service.getAll());
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable("id") Long id){
//        return ResponseEntity.ok(service.getById(id));
//    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ExamDto dto){
        return ResponseEntity.ok(service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExamDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<?> getCriteria(@PathVariable("placeId") Long placeId){
        return ResponseEntity.ok(service.searchByCriteria(placeId));
    }
}

