/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.korpacz.spring.camel.feed;

import org.apache.camel.Exchange;

/**
 *
 * @author Asia
 */
public interface ArticleFeedProcessor {
     public String process(Exchange exchange);
}
