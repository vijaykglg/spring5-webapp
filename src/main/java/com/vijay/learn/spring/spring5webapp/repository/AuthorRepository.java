/*
 * Copyright (c) 2020. All rights reserved.
 * This code implemented by Vijay Gupta for learning purpose only.
 * Certification: Spring Framework 5: Beginner to guru
 */

package com.vijay.learn.spring.spring5webapp.repository;

import com.vijay.learn.spring.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
