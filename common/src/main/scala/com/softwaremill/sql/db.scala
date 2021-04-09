package com.softwaremill.sql

import org.flywaydb.core.Flyway
import com.opentable.db.postgres.embedded.EmbeddedPostgres

trait DbSetup {
  val connectionString = "jdbc:postgresql:template1"

  def dbSetup(): Unit = {
    val server = EmbeddedPostgres.builder().setPort(5432).start()

    val flyway = new Flyway()
    flyway.setDataSource(connectionString, "postgres", null)
    flyway.clean()
    flyway.migrate()
  }
}