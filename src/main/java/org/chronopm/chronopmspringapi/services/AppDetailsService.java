package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.AppDetailsDto;
import org.chronopm.chronopmspringapi.mappers.AppDetailsMapper;
import org.chronopm.chronopmspringapi.models.AppDetails;
import org.chronopm.chronopmspringapi.repositories.IAppDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppDetailsService implements IEntityService<AppDetailsDto> {

    private final IAppDetailsRepository appDetailsRepository;

    public AppDetailsService(IAppDetailsRepository appDetailsRepository) {
        this.appDetailsRepository = appDetailsRepository;
    }

    @Override
    public List<AppDetailsDto> getAll() {
        return appDetailsRepository.findAll().stream()
                .map(AppDetailsMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppDetailsDto getById(String id) {
        return AppDetailsMapper.mapToDto(getAppDetailsById(id));
    }

    @Override
    public AppDetailsDto create(AppDetailsDto appDetailsDto) {
        var appDetails = appDetailsRepository.save(AppDetailsMapper.mapToModel(appDetailsDto));
        return AppDetailsMapper.mapToDto(appDetails);
    }

    @Override
    public AppDetailsDto update(AppDetailsDto appDetailsDto, String id) {
        var existingAppDetails = getAppDetailsById(id);
        var updatedAppDetails = AppDetailsMapper.mapForUpdate(appDetailsDto, existingAppDetails);
        updatedAppDetails.setId(id);
        var appDetails = appDetailsRepository.save(updatedAppDetails);
        return AppDetailsMapper.mapToDto(appDetails);
    }

    @Override
    public String delete(String id) {
        appDetailsRepository.deleteById(id);

        return id;
    }

    private AppDetails getAppDetailsById(String id) {
        return appDetailsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("App details not found"));
    }
}
