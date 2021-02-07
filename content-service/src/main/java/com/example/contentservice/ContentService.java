package com.example.contentservice;

import com.example.contentservice.Content;
import com.example.contentservice.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    public List<Content> findAllContents(){
        return (List<Content>) contentRepository.findAll();
    }

    public Optional<Content> findContentById(Long id){
        return contentRepository.findById(id);
    }

    public Content addContent(Content content){
        content.setId(null);
        return contentRepository.save(content);
    }

    public Optional<Content> updateContent(Long id, Content content){
        Optional<Content> contentOptional = contentRepository.findById(id);
        if(!contentOptional.isPresent()){
            return contentOptional;
        }
        content.setId(id);
        return Optional.of(contentRepository.save(content));
    }

    public Boolean deleteContent(Long id){
        try{
            contentRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}

