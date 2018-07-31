package com.spacefox.frida.repository;

import com.spacefox.frida.domain.PictureJH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PictureJHRepository extends JpaRepository<PictureJH, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from jh_picture pic where pic.key = ?1",
            nativeQuery = true)
    void deleteFileDataByKey(String key);

    Optional<PictureJH> findByKey(String key);
}
