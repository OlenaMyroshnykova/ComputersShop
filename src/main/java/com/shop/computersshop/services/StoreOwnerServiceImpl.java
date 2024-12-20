package com.shop.computersshop.services;

import com.shop.computersshop.dtos.StoreOwnerDTO;
import com.shop.computersshop.models.StoreOwner;
import com.shop.computersshop.repositories.StoreOwnerRepository;
//import com.shop.computersshop.services.StoreOwnerService;
import org.springframework.stereotype.Service;

@Service
public class StoreOwnerServiceImpl extends GenericServiceImpl<StoreOwner, StoreOwnerDTO, Long> implements StoreOwnerService {

    public StoreOwnerServiceImpl(StoreOwnerRepository repository) {
        super(repository);
    }

    @Override
    protected StoreOwnerDTO toDTO(StoreOwner entity) {
        return new StoreOwnerDTO(entity.getId(), entity.getName());
    }

    @Override
    protected StoreOwner fromDTO(StoreOwnerDTO dto) {
        var owner = new StoreOwner();
        owner.setId(dto.id());
        owner.setName(dto.name());
        return owner;
    }
}

