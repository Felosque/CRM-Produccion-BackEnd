package com.crmunibague.crmunibague.requestanalysis;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestAnalysisRepository extends JpaRepository<RequestAnalysis, RequestAnalysisPK> {

    //List<RequestAnalysis> findByRequestAnalysisCode(Integer code);

}
