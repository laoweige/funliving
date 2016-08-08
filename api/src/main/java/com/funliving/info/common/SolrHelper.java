package com.funliving.info.common;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class SolrHelper {
    public static <T> void add(T doc,String url,String index) {
        List<T> docs = new ArrayList<>();
        docs.add(doc);
        try {
            HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",url,index));
            client.addBeans(docs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
