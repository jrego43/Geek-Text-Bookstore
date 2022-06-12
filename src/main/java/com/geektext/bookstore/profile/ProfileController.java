package com.geektext.bookstore.profile;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "api/profile")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
    
    @GetMapping(path="/{profile_id}")
    public @ResponseBody Optional<Profile> getProfileById(Long profile_id) {
        System.out.println("Getting all profiles...");
        return profileRepository.findById(profile_id);
    }

}
