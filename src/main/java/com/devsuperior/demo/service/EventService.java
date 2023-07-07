package com.devsuperior.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EventService {
	
	 @Autowired
	 EventRepository repository;
	 
	 @Transactional
	    public EventDTO update(Long id, EventDTO dto) {
	        try {
	            Event entity = repository.getReferenceById(id);
	            copyDtoToEntity(dto, entity);
	            entity = repository.save(entity);
	            return new EventDTO(entity);
	        } catch (EntityNotFoundException e) {
	            throw new ResourceNotFoundException("Id not found" + id);
	        }
	    }

	private void copyDtoToEntity(EventDTO dto, Event entity) {
		    entity.setName(dto.getName());
	        entity.setDate(dto.getDate());
	        entity.setUrl(dto.getUrl());
	        entity.setCity(new City(dto.getCityId(), null));
	    }
		
	}
	
	   

