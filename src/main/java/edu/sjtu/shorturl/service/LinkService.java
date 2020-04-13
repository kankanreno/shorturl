package edu.sjtu.shorturl.service;

import edu.sjtu.shorturl.entity.Link;

public interface LinkService {

    String save(Link link);

    String restoreUrl(String url);

}
