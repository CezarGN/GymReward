package com.internship.accesaapplication.Controller;
import com.internship.accesaapplication.Entities.Quest;
import com.internship.accesaapplication.Entities.User;
import com.internship.accesaapplication.Services.UserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.URISyntax;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createQuest")
    public ResponseEntity<Quest> proposeQuest(@RequestBody Quest quest)
        throws URISyntaxException {
            return new ResponseEntity(
                    userService.proposeQuest(quest.getName(), quest.getDescription(), quest.getReward(), quest.getLeader()),
                    HttpStatus.CREATED);
        }

    @PutMapping("/finishedQuest")
    public ResponseEntity<User> finishedQuest(@RequestParam String username, @RequestParam String questName)
            throws URISyntaxException {
        return new ResponseEntity(
                userService.getPaid(username,questName),
                HttpStatus.ACCEPTED);
        }
        @PutMapping("/getBadge")
    public ResponseEntity<User> getABadge(@RequestParam String badgeName, @RequestParam String username)
            throws URISyntaxException{
        return new ResponseEntity<>(
                userService.getBadge(badgeName,username),
                HttpStatus.ACCEPTED);
        }
        @GetMapping("/getTokens")
    public ResponseEntity<Integer> getTokens(@RequestParam String username)
            throws URISyntaxException{
        return new ResponseEntity<>(
                userService.getTokens(username),
                HttpStatus.OK);
        }

        @GetMapping("/showQuests")
    public ResponseEntity<List<Quest>> showQuests(@RequestParam String username)
            throws URISyntaxException{
        return new ResponseEntity<>(
                userService.showQuests(username),
                HttpStatus.OK);
        }
    }
