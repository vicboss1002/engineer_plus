package jp.co.engineer_plus.repositories;

import jp.co.engineer_plus.entity.BusinessPlan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * bisiness_planのリポジトリ
 */
@Repository
public interface BusinessPlanRepository extends CrudRepository<BusinessPlan, Long> {

}
