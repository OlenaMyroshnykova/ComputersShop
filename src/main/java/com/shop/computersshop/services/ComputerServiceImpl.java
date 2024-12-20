package com.shop.computersshop.services;

import com.shop.computersshop.dtos.ComputerDTO;
import com.shop.computersshop.models.Computer;
import com.shop.computersshop.repositories.ComputerRepository;
import com.shop.computersshop.services.ComputerService;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl extends GenericServiceImpl<Computer, ComputerDTO, Long> implements ComputerService {

    public ComputerServiceImpl(ComputerRepository repository) {
        super(repository);
    }

    @Override
    protected ComputerDTO toDTO(Computer entity) {
        return new ComputerDTO(
                entity.getId(),
                entity.getBrand().getName(),
                entity.getMemory(),
                entity.getProcessor(),
                entity.getOperatingSystem(),
                entity.getPrice(),
                entity.getStore().getName()
        );
    }

    @Override
    protected Computer fromDTO(ComputerDTO dto) {
        var computer = new Computer();
        computer.setId(dto.id());
        computer.setMemory(dto.memory());
        computer.setProcessor(dto.processor());
        computer.setOperatingSystem(dto.operatingSystem());
        computer.setPrice(dto.price());
        // Связи для Brand и Store нужно установить через отдельный сервис или репозиторий
        return computer;
    }
}
