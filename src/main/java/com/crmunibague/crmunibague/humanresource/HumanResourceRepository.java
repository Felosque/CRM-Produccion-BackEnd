package com.crmunibague.crmunibague.humanresource;

import com.crmunibague.crmunibague.workshift.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HumanResourceRepository extends JpaRepository<HumanResource, Integer> {

    List<HumanResource> findByWorkShift(WorkShift entity);

}
