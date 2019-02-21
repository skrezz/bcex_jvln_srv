package app

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

class DbConnect {
    private val hikariConfig = HikariConfig()

    private val DATABASE_URL = System.getenv("DATABASE_URL")
fun InitDb() {

        hikariConfig.jdbcUrl = "jdbc:postgresql://ec2-79-125-4-96.eu-west-1.compute.amazonaws.com:5432/d8ssgofvhe3n9o?sslmode=require"
        hikariConfig.driverClassName = "org.postgresql.Driver"
        hikariConfig.username = "pupfthwfljjddh"
        hikariConfig.password = "c6747f2bf93cefe8066a2cc6e41aefd64afc830b018fbe781b7953a9d676c3ef"


    val ds = HikariDataSource(hikariConfig)
    Database.connect(ds)

}
    fun insrt (){

    }

}