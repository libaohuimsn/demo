package com.mina.learn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mina.base.util.MyMapper;
import com.mina.learn.bean.LearnResource;


public interface LearnResourceMapper extends MyMapper<LearnResource> {
	List<LearnResource> queryLearnResouceList();
}