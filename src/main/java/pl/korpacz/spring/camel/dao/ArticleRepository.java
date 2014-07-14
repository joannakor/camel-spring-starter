/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.korpacz.spring.camel.dao;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.korpacz.spring.camel.model.Article;

/**
 *A;s dfsgsfdg
 * @author Asia
 */
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByAuthor(String author);

    public List<Article> findByTitle(String title);

    public List<Article> findByDate(Date date);
}
