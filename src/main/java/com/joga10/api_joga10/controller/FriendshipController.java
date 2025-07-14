package com.joga10.api_joga10.controller;

import com.joga10.api_joga10.model.Friendship;
import com.joga10.api_joga10.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/friendships")
public class FriendshipController {
    @Autowired
    private FriendshipRepository friendshipRepository;

    @GetMapping
    public List<Friendship> getAllFriendships() {
        return friendshipRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Friendship> getFriendshipsByUser(@PathVariable String userId) {
        return friendshipRepository.findByUserId(userId);
    }

    @GetMapping("/friend/{friendId}")
    public List<Friendship> getFriendshipsByFriend(@PathVariable String friendId) {
        return friendshipRepository.findByFriendId(friendId);
    }

    @PostMapping
    public Friendship createFriendship(@RequestBody Friendship friendship) {
        return friendshipRepository.save(friendship);
    }

    @PutMapping("/{id}")
    public Friendship updateFriendship(@PathVariable String id, @RequestBody Friendship friendship) {
        friendship.setId(id);
        return friendshipRepository.save(friendship);
    }

    @DeleteMapping("/{id}")
    public void deleteFriendship(@PathVariable String id) {
        friendshipRepository.deleteById(id);
    }
}
