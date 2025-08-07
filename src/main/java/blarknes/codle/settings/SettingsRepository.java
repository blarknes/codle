package blarknes.codle.settings;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long> {

    // TODO: make this query better
    @Query(value = "SELECT * FROM settings LIMIT 1", nativeQuery = true)
    Optional<Settings> findSettings();

}
