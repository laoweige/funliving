package com.funliving.info.common;

import com.funliving.info.resource.repr.ApartmentJson;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class SolrHelper {
    public static <T> void add(T doc,String solr,String index) {
        List<T> docs = new ArrayList<>();
        docs.add(doc);
        try {
            HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",solr,index));
            client.addBeans(docs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static SolrDocumentList search(String query,int start,int rows,String fl,String solr,String index){

        HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",solr,index));
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        try {
            if (fl != null && !fl.equals("*")) {
                solrQuery.setFields(fl);
            }
            solrQuery.setQuery(query);
            QueryResponse response = client.query(solrQuery, SolrRequest.METHOD.POST);
            return response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
