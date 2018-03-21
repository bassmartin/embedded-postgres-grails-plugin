package embedded.postgres

import com.opentable.db.postgres.embedded.EmbeddedPostgres
import groovy.util.logging.Slf4j

@Slf4j
class EmbeddedPostgresFactory {
    String port

    EmbeddedPostgresHolder getDataBase(){
        log.warn "Starting embedded postgres db"

        def builder = EmbeddedPostgres.builder()
        if(port) {
            builder.setPort(port.toInteger())
        }

        EmbeddedPostgresHolder db = new EmbeddedPostgresHolder(builder.start())

        log.warn "${db.toString()} started on ${db.port}"

        db
    }
}

