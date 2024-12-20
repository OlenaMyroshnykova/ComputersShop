package com.shop.computersshop.services;

import com.shop.computersshop.dtos.StoreDTO;
import com.shop.computersshop.models.Store;
import com.shop.computersshop.repositories.StoreRepository;
//import com.shop.computersshop.services.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends GenericServiceImpl<Store, StoreDTO, Long> implements StoreService {

    public StoreServiceImpl(StoreRepository repository) {
        super(repository);
    }

    @Override
    protected StoreDTO toDTO(Store entity) {
        return new StoreDTO(
                entity.getId(),
                entity.getName(),
                entity.getTaxId(),
                entity.getOwner().getName()
        );
    }

    @Override
    protected Store fromDTO(StoreDTO dto) {
        var store = new Store();
        store.setId(dto.id());
        store.setName(dto.name());
        store.setTaxId(dto.taxId());
        // Связь с владельцем устанавливается через отдельный сервис или репозиторий
        return store;
    }
}
