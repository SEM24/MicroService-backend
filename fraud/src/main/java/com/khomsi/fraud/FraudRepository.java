package com.khomsi.fraud;

import com.khomsi.fraud.model.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Long> {

}
