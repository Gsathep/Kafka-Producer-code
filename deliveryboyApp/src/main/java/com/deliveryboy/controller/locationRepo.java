package com.deliveryboy.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface locationRepo extends JpaRepository<location,Long>
{
}
