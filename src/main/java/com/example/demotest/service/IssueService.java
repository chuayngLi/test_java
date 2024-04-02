package com.example.demotest.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demotest.bean.Issue;
import com.example.demotest.dao.IssueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IssueService {
    private final IssueMapper issueMapper;

    @Autowired
    public IssueService(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    public IPage<Issue> list(String query, Integer current, Integer size) {
        LambdaQueryWrapper<Issue> issueLambdaQueryWrapper = Wrappers.lambdaQuery();
        if (!Objects.equals(query, "")) {
            issueLambdaQueryWrapper.like(Issue::getTitle, query).or().like(Issue::getKeyWord, query);
        }
        issueLambdaQueryWrapper.orderByDesc(Issue::getCreatedAt);
        Page<Issue> issuePage = new Page<>(current, size);
        return issueMapper.selectPage(issuePage, issueLambdaQueryWrapper);
    }

    public Integer add(Issue issue) {
        return issueMapper.insert(issue);
    }

    public int update(Issue issue) {
        return issueMapper.updateById(issue);
    }

    public int del(Integer issueId) {
        return issueMapper.deleteById(issueId);
    }
}
