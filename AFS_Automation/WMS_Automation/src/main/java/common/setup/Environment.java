package common.setup;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({ "system:properties",
     "C:\\Users\\pks\\OneDrive -Aptean-online\\Ignition-QA\\AFS_Automation\\WMS_Automation\\src\\test\\resources\\properties\\config_test.properties",
    //"file:${path}/config_test.properties",
    "file:${path}/config_db.properties" })
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

}
