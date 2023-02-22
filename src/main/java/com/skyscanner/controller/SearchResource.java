package com.skyscanner.controller;

import com.skyscanner.search.Search;
import com.skyscanner.searchResult.SearchResult;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
    List<SearchResult> searchresult;

    public SearchResource(List<SearchResult> searchresult) {
        this.searchresult = searchresult;
    }
    @POST
    public List<SearchResult>search(@Valid Search search){
        List<SearchResult> response = new ArrayList<>();
        for (SearchResult result :searchresult) {
            if(result.getCity().equals(search.getCity())){
                response.add(result);
            }
        }
     return response;
    }
}
