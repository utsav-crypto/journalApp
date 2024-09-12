package com.bitsMind.myFirstProject.Repository;

import com.bitsMind.myFirstProject.Entity.ConfigJournalAppEntity;
import com.bitsMind.myFirstProject.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}

