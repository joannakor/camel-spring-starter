/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.korpacz.spring.camel.route;

import java.util.List;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.FileComponent;
import org.springframework.beans.factory.annotation.Autowired;
import pl.korpacz.spring.camel.dao.ArticleRepository;
import pl.korpacz.spring.camel.model.Article;

/**
 *
 * @author Asia
 */
public class RouteRunner extends RouteBuilder {

    @Autowired
    private ArticleRepository articleDao;

    @Override
    public void configure() throws Exception {
        //  from("file://target/test?noop=true").beanRef("myProcessor", "process");
        //   List<Article> articeList=articleDao.findAll();
        from("timer:foo?period=30s")
                //from("quartz://timerNameAsia?options")
                // from("file:d://zdjecia/*?noop=true")
                .beanRef("articleFeedProcessor", "process")                
                .to("file:///e://target//?autoCreate=true&fileName=raport_${date:now:yyyyMMdd-HH-mm-ss}.txt");
        //.to("log:foo");//to("log:foo");
    }

    public ArticleRepository getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleRepository articleDao) {
        this.articleDao = articleDao;
    }

}
