package com.shop.computersshop.services;

import com.shop.computersshop.dtos.BrandDTO;
import com.shop.computersshop.models.Brand;
import com.shop.computersshop.repositories.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends GenericServiceImpl<Brand, BrandDTO, Long> implements BrandService {

    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
    }

    @Override
    protected BrandDTO toDTO(Brand entity) {
        return new BrandDTO(entity.getId(), entity.getName());
    }

    @Override
    protected Brand fromDTO(BrandDTO dto) {
        var brand = new Brand();
        brand.setId(dto.id());
        brand.setName(dto.name());
        return brand;
    }
}
