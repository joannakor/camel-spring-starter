/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.korpacz.spring.camel.feed;

import java.util.Date;
import java.util.List;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import pl.korpacz.spring.camel.dao.ArticleRepository;
import pl.korpacz.spring.camel.model.Article;

/**
 *
 * @author Asia
 */
public class ArticleFeedProcessorImpl implements ArticleFeedProcessor {

    private ArticleRepository articleDao;

    @Override
    public String process(Exchange exchange) {

//          System.out.println("\n\n--------------process---------------\n\n");
//          Message in = exchange.getIn();
//          byte[] file = in.getBody(byte[].class);
//          System.out.println("bytes found:" + file.length);
        StringBuilder builder = new StringBuilder();
        builder.append(new Date().toString()).append("\n");
        List<Article> articleList = articleDao.findAll();
        for (Article article : articleList) {
            builder.append(article.toString()).append("\n");
        }
        System.out.println("Ala ma kota");
        return builder.toString();
    }

    public ArticleRepository getArticleDao() {
        return articleDao;
    }

    @Autowired
    public void setArticleDao(ArticleRepository articleDao) {
        this.articleDao = articleDao;
    }

}
