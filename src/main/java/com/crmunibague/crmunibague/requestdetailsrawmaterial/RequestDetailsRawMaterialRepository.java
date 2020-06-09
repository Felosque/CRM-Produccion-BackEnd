package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import com.crmunibague.crmunibague.rawmaterialrequests.RawMaterialRequests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestDetailsRawMaterialRepository extends JpaRepository<RequestDetailsRawMaterial, Integer> {

    List<RequestDetailsRawMaterial> findByRawMaterialRequests(RawMaterialRequests code);
}
