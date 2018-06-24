package com.mina.learn.service;

import java.util.List;

import com.mina.base.service.impl.IService;
import com.mina.base.util.Page;
import com.mina.learn.bean.LeanQueryLeanListReq;
import com.mina.learn.bean.LearnResource;

public interface LearnService  extends IService<LearnResource>{
    public List<LearnResource> queryLearnResouceList();
    public void deleteBatch(Long[] ids);
}
