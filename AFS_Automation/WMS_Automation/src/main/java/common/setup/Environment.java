package common.setup;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({"system:properties",
        "file:${path}/config_test.properties",
        "file:${path}/config_db.properties"}
)
public interface Environment extends Config {

    @Key("browser")
    String getBrowser();

    @Key("runtype")
    String getRunType();

    @Key("username")
    String getUserName();


    @Key("password")
    String getPassword();

    @Key("adminUsername")
    String getAdminUsername();

    @Key("adminPassword")
    String getAdminPassword();

    @Key("url")
    String getUrl();

    @Key("dbIp")
    String getDbIp();

    @Key("dbName")
    String getDbName();

    @Key("dbUserName")
    String getDbUserName();

    @Key("dbUserPassword")
    String getDbUserPassword();

    @Key("WMS_From_mail")
   String From_mail();

    @Key("WMS_From_Pass")
    String From_Pass();

    @Key("WMS_To_mail")
    String To_mail();
}
