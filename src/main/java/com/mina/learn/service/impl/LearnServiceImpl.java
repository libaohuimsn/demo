package com.mina.learn.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mina.base.service.BaseService;
import com.mina.base.util.Page;
import com.mina.learn.bean.LeanQueryLeanListReq;
import com.mina.learn.bean.LearnResource;
import com.mina.learn.dao.LearnResourceMapper;
import com.mina.learn.service.LearnService;

@Service
public class LearnServiceImpl extends BaseService<LearnResource>  implements LearnService {
	
	/*@Autowired
    private JdbcTemplate jdbcTemplate;*/
	
    @Autowired
    private LearnResourceMapper  learnResourceMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id->learnResourceMapper.deleteByPrimaryKey(id));
    }

	@Override
	public List<LearnResource> queryLearnResouceList() {
//		PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceMapper.queryLearnResouceList();
	}

	
}
