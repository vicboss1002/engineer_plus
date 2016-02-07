package jp.co.engineer_plus.repositories;

import jp.co.engineer_plus.entity.EpUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * engineer_plus_userのリポジトリ
 */
@Repository
public interface EqUserRepository extends JpaRepository<EpUser, Long> {

}
