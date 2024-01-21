package com.django.user.mapper;

import com.django.user.entity.Client;
import com.django.user.service.ClientCSVRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client toClient(ClientCSVRepresentation csv);
}
