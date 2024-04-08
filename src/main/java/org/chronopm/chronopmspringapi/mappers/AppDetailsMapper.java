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

    public static AppDetails mapForUpdate(AppDetailsDto updateDto, AppDetails model) {
        return AppDetails.builder()
                .id(model.getId())
                .welcomeMessage(updateDto.getWelcomeMessage() != null ? updateDto.getWelcomeMessage() : model.getWelcomeMessage())
                .introduction(updateDto.getIntroduction() != null ? updateDto.getIntroduction() : model.getIntroduction())
                .version(updateDto.getVersion() != null ? updateDto.getVersion() : model.getVersion())
                .developers(updateDto.getDevelopers() != null ? updateDto.getDevelopers() : model.getDevelopers())
                .copyRights(updateDto.getCopyRights() != null ? updateDto.getCopyRights() : model.getCopyRights())
                .createdAt(model.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
