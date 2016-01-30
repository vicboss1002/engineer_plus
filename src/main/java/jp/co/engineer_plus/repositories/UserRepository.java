package jp.co.engineer_plus.repositories;

import jp.co.engineer_plus.entity.EngineerPlusUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * engineer_plus_userのリポジトリ
 */
@Repository
public interface UserRepository extends JpaRepository<EngineerPlusUser, Long> {

}
