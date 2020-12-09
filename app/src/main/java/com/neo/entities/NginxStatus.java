package com.neo.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class NginxStatus {

    private Integer activeConnections;
    private Map<String, Integer> requests;


}
