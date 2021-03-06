package com.funliving.info.common;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SolrHelper {
    @Value("#{config['solr.write']}")
    private String writePath;

    @Value("#{config['solr.search']}")
    private String searchPath;


    public <T> void add(T doc,String index) {
        List<T> docs = new ArrayList<>();
        docs.add(doc);
        try {
            HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",writePath,index));
            client.addBeans(docs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public SolrDocumentList search(String query,int start,int rows,String fl,String index){

        HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",searchPath,index));
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(start);
        solrQuery.setRows(rows);

        try {
            if (fl != null && !fl.equals("*")) {
                solrQuery.setFields(fl);
            }
            solrQuery.setQuery(query);
//            solrQuery.setSort()
            QueryResponse response = client.query(solrQuery, SolrRequest.METHOD.POST);
            return response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SolrDocumentList search(String query,int start,int rows,String fl,String index,String sort){

        HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",searchPath,index));
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(start);
        solrQuery.setRows(rows);
        try {
            if (fl != null && !fl.equals("*")) {
                solrQuery.setFields(fl);
            }
            solrQuery.setQuery(query);
            if(sort.contains(",")) {
                solrQuery.setSort("geodist(Coordinate,"+sort+")", SolrQuery.ORDER.asc);
            }else{
                solrQuery.setSort(sort, SolrQuery.ORDER.asc);
            }
//            solrQuery.setSort()
            QueryResponse response = client.query(solrQuery, SolrRequest.METHOD.POST);
            return response.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clear(String index){
        HttpSolrClient client = new HttpSolrClient(String.format("http://%s%s",writePath,index));
        try {
            UpdateResponse response = client.deleteByQuery("*:*");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
