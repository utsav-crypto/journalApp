package com.bitsMind.myFirstProject.Repository;

import com.bitsMind.myFirstProject.Entity.JournalEntry;
import com.bitsMind.myFirstProject.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);

    void deleteByUserName(String userName);
}

