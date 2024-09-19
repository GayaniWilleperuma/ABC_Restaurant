package com.abc.service;

import com.abc.dao.QueriesDao;
import com.abc.model.Queries;

public class QServices {
	public class QueryService {
	    private QueriesDao querydao = new QueriesDao();

	    public void submitQuery(Queries query) throws Exception {
	        querydao.submitQuery(query);
	    }
}
}