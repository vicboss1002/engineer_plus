package jp.co.engineer_plus.repositories;

import jp.co.engineer_plus.entity.EpBusinessPlan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * bisiness_planのリポジトリ
 */
@Repository
public interface EqBusinessPlanRepository extends CrudRepository<EpBusinessPlan, Long> {

}
