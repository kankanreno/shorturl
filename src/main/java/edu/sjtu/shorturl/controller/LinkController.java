package edu.sjtu.shorturl.controller;

import edu.sjtu.shorturl.config.ServerConfig;
import edu.sjtu.shorturl.dto.Result;
import edu.sjtu.shorturl.entity.Link;
import edu.sjtu.shorturl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private ServerConfig serverConfig;

    private String defaultPage = "http://www.cnilink.com";

    /**
     * 生成短链接
     *
     * @param url
     * @return 短链接
     */
    @GetMapping("/api")
    @ResponseBody
    public Result save(String url) {
        if (url == null || "".equals(url)) {
            return new Result(-1, "url为空");
        }
        if (url.startsWith("http://") || url.startsWith("https://")) {
            Link link = new Link();
            link.setLongUrl(url);
            String shortUrl = linkService.save(link);
            return new Result(0, "生成短链接成功", serverConfig.getUrl() + shortUrl); // TODO: 本地测试时，端口号获取不到
        } else {
            return new Result(-1, "网址必须以http或https开头");
        }
    }

    /**
     * 301跳转
     *
     * @param url
     * @return
     */
    @GetMapping("/{url}")
    public String restoreUrl(@PathVariable("url") String url) {

        String restoreUrl = linkService.restoreUrl(url);

        if (restoreUrl != null && !"".equals(restoreUrl)) {
            return "redirect:" + restoreUrl;
        } else {
            return "redirect:" + defaultPage;
//            return  "forward:/404.html";    //如果要访问本地html，@RequestMapping("/{url}")前面必须加一层路径/aa/{url}
        }

    }

}
