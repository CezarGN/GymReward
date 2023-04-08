package com.internship.accesaapplication.Services;

import com.internship.accesaapplication.Entities.Badge;
import com.internship.accesaapplication.Entities.User;
import com.internship.accesaapplication.Repositories.BadgeRepository;
import com.internship.accesaapplication.Repositories.QuestRepository;
import com.internship.accesaapplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internship.accesaapplication.Entities.Quest;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private BadgeRepository badgeRepository;

    public Quest proposeQuest(String name, String description, int reward, User user){
        Quest proposedQuest = new Quest(name,description,reward,user);
        if(questRepository.findQuestById(proposedQuest.getId()) == null && user.getTokens() >= reward) {
            questRepository.save(proposedQuest);
        }
        return proposedQuest;
    }

    public User getPaid(String rewarded, String questName){
        User rewardedd = userRepository.findByUsername(rewarded);
        Quest quest = questRepository.findByName(questName);
        User rewarder = quest.getLeader();
        rewardedd.setTokens(rewardedd.getTokens() + quest.getReward());
        rewarder.setTokens(rewarder.getTokens() - quest.getReward());
        userRepository.save(rewardedd);
        userRepository.save(rewarder);
        return rewardedd;
    }

    public User getBadge(String name, String username){
        User user = userRepository.findByUsername(username);
        Badge badge = badgeRepository.findByName(name);
        List<Quest> questsNeccesary = badge.getQuests();
        if(new HashSet<>(user.getQuestsCompleted()).containsAll(questsNeccesary)){
            user.getBadges().add(badge);
        }
        userRepository.save(user);
        return user;
    }

    public List<Quest> showQuests(String username){
        User user = userRepository.findByUsername(username);
        return user.getQuestsToBeCompleted();
    }

    public int getTokens(String username){
        User user = userRepository.findByUsername(username);
        return user.getTokens();
    }
}
