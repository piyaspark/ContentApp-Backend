package com.example.contentservice;

import com.example.contentservice.Content;
import com.example.contentservice.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contents")
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping()
    public List<Content> getAllContents() {
        return contentService.findAllContents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContentById(@PathVariable Long id){
        Optional<Content> contentOptional = contentService.findContentById(id);
        if(!contentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contentOptional);
    }

    @PostMapping()
    public ResponseEntity<?> postContent(@RequestBody Content body){
        Content content = contentService.addContent(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContent(@PathVariable Long id, @RequestBody Content body){
        Optional<Content> content = contentService.updateContent(id, body);
        if(!content.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable Long id){
        if(!contentService.deleteContent(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
