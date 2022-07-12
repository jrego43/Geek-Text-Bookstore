package com.geektext.bookstore.profile;

import java.util.List;
import java.util.Optional;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/profile")
public class ProfileController {
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @Autowired
    public CardRepository cardRepository;

    @Autowired
    private ProfileRepository profileRepository;
    
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
    
    @GetMapping(path="/{profile_id}")
    public @ResponseBody Optional<Profile> getProfileById(@PathVariable Long profile_id) {
        System.out.println("Getting all profiles...");
        return profileRepository.findById(profile_id);
    }

    @GetMapping(path="/user/{username}")
    public @ResponseBody Optional<Profile> getProfileByUser(@PathVariable String username){
        return profileRepository.findProfileByUsername(username);
    }

    @DeleteMapping(path = "/{profile_id}")
    public void deleteProfile(@PathVariable("profile_id") Long id){
        profileService.deleteProfile(id);
    }

    @PutMapping(path = "/update/{profile_id}")
    public void updateProfile(
            @PathVariable("profile_id") Long profile_id,
            @RequestParam(required=false) String username,
            @RequestParam(required=false) String password,
            @RequestParam(required=false) String full_name,
            @RequestParam(required=false) String home_address){
        profileService.updateProfile(profile_id,username,password,full_name,home_address);
    }


    @GetMapping
    public List<Profile> getProfiles(){
        return profileService.getProfiles();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Profile customer){
        profileService.addNewProfile(customer);
    }

    @PutMapping(path = "/creditCard/{profile_id}")
    public void addNewCard(
        @PathVariable("profile_id") Long profile_id,
        @RequestParam(required=false) String cNumber){
            profileService.addNewCard(profile_id,cNumber);
        }

}
