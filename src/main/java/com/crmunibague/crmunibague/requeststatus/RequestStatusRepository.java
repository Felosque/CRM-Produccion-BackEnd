package com.crmunibague.crmunibague.requeststatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface RequestStatusRepository extends JpaRepository<RequestStatus, Integer> {
}
