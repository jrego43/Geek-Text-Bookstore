package com.geektext.bookstore.profile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

    private final ProfileRepository pRepository;
    private final CardRepository cRepository;

    @Autowired
    public ProfileService(ProfileRepository pRepository, CardRepository cRepository){
        this.pRepository = pRepository;
        this.cRepository = cRepository;
    }

    public List<Profile> getProfiles(){
        return (List<Profile>) pRepository.findAll();
    }

    public void addNewProfile(Profile profile){
        if(profile.getUsername() == null){
            throw new IllegalArgumentException("Username is required... Try again!");
        }
        else if(profile.getPassword() == null){
            throw new IllegalArgumentException("Password is required...Try again!");
        }
        else{
            pRepository.save(profile);
        }
        //System.out.println(profile);
    }

    @Transactional
    public void addNewCard(Long profile_id, String cNumber){
        Profile profile = pRepository.findById(profile_id)
            .orElseThrow(()->new IllegalStateException("profile does not exist..."));
        
        profile.inputNewCard(cNumber);
    }

    public void deleteProfile(Long id) {
        boolean exists = pRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Profile with id: " + id + " does not exist");
        }
        pRepository.deleteById(id);
    }

    @Transactional
	public void updateProfile(Long profile_id, String username, String password, String full_name,
			String home_address) {
        
        Profile profile = pRepository.findById(profile_id)
            .orElseThrow(()->new IllegalStateException("profile does not exist..."));

        if(username != null && username.length() > 0 && !Objects.equals(profile.getUsername(), username)){
            profile.setUsername(username);
        }
        if(password != null && password.length() > 0 && !Objects.equals(profile.getPassword(), password)){
            profile.setPassword(password);
        }
        if(full_name != null && full_name.length() > 0 && !Objects.equals(profile.getFullName(), full_name)){
            profile.setFullName(full_name);
        }
        if(home_address != null && home_address.length() > 0 && !Objects.equals(profile.getHomeAddress(), home_address)){
            profile.setHomeAddress(home_address);
        }
	}

}



