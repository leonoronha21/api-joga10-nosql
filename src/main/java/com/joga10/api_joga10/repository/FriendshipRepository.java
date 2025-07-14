package com.joga10.api_joga10.repository;

import com.joga10.api_joga10.model.Friendship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendshipRepository extends MongoRepository<Friendship, String> {
    List<Friendship> findByUserId(String userId);
    List<Friendship> findByFriendId(String friendId);
}
