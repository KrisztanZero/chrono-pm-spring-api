package org.chronopm.chronopmspringapi.mappers;

import org.chronopm.chronopmspringapi.dtos.AppDetailsDto;
import org.chronopm.chronopmspringapi.models.AppDetails;

import java.time.LocalDateTime;

public class AppDetailsMapper {
    public static AppDetailsDto mapToDto(AppDetails model) {
        return AppDetailsDto.builder()
                .id(model.getId())
                .welcomeMessage(model.getWelcomeMessage())
                .introduction(model.getIntroduction())
                .version(model.getVersion())
                .developers(model.getDevelopers())
                .copyRights(model.getCopyRights())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    public static AppDetails mapToModel(AppDetailsDto dto) {
        return AppDetails.builder()
                .welcomeMessage(dto.getWelcomeMessage())
                .introduction(dto.getIntroduction())
                .version(dto.getVersion())
                .developers(dto.getDevelopers())
                .copyRights(dto.getCopyRights())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static AppDetails mapForUpdate(AppDetailsDto updateDto) {
        return AppDetails.builder()
                .welcomeMessage(updateDto.getWelcomeMessage())
                .introduction(updateDto.getIntroduction())
                .version(updateDto.getVersion())
                .developers(updateDto.getDevelopers())
                .copyRights(updateDto.getCopyRights())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
