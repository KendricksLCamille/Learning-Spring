package com.learning.consuming_a_restful_web_service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Value(Long id, Long userId, String title, Boolean completed) { }