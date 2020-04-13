package edu.sjtu.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sjtu.shorturl.entity.Link;


@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

    Link findByLongUrl(String longUrl);

    Link findByShortUrl(String shortUrl);

}
