package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import com.crmunibague.crmunibague.requestdetailsrawmaterial.RequestDetailsRawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawMaterialDeliveryStatesRepository extends JpaRepository<RawMaterialDeliveryStates, Integer> {

    List<RawMaterialDeliveryStates> findByRequest(RequestDetailsRawMaterial code);

}
