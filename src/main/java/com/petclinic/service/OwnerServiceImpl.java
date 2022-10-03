package com.petclinic.service;


import com.petclinic.model.Owner;
import com.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository){  // Create constructor for use repository.
        this.ownerRepository = ownerRepository;                // @Autowired method is not advice.
    }

    @Override
    public List<Owner> getAllOwners(){return ownerRepository.findAll();}

    public void saveOwner(Owner owner){this.ownerRepository.save(owner);}

    @Override
    public void deleteOwner(int id) {
        this.ownerRepository.deleteById(id);
    }

    public Owner getOwnerById(int id){
        Optional<Owner> optional = ownerRepository.findById(id);
        Owner owner = null;
        if(optional.isPresent()){
            owner = optional.get();
        }else{
            throw new RuntimeException("Owner is not found!");
        }
        return owner;
    }



}
