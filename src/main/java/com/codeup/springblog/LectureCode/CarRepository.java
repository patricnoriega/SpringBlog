package com.codeup.springblog.LectureCode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMake(String make);
//    List<Car> findAllByMake(String make);
}
