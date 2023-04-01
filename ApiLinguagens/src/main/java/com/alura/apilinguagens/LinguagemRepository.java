package com.alura.apilinguagens;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface LinguagemRepository extends MongoRepository<Linguagem,String>{

}
