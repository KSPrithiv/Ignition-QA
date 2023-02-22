package util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

/**
 * @Project DSD_OMS
 * @Author Divya.Ramadas@afsi.com
 */

@Sources({"classpath:${env}.properties"})

public interface Environment extends Config
{
    @Key("url")
    String get_url();

    @Key("Account#")
    String get_Account();

    @Key("AnotherAccount")
    String get_AnotherAcc();

    @Key("RouteFilter")
    String get_RouteFilt();

    @Key("Route")
    String get_Route();

    @Key("Route1")
    String get_Route1();

    String username();

    String password();

    @Key("Dummyuser")
    String DummyUser();

    @Key("Dummypass")
    String DummyPassword();

    @Key("AdminUser")
    String getAdminUser();

    @Key("AdminPass")
    String getAdminPass();

    @Key("From_mail")
    String From_mail();

    @Key("From_Pass")
    String From_Pass();

    @Key("To_mail")
    String To_mail();

    @Key("browser")
    String get_browser();

    @Key("IP_Add")
    String getIP_Add();

    @Key("Database")
    String getDBname();

    @Key("DB_User")
    String getDBUser();

    @Key("DB_Password")
    String getDBPassword();

    @Key("DB_ProdSql")
    String getSingle_Prod_Sql();

    @Key("DB_ProdSingle")
    String getSingle_OneMoreProd();

    @Key("DB_ListProdSql")
    String getMultiple_Prod_Sql();

    @Key("DB_ProdTable")
    String get_ProdTable();

    @Key("DB_ProdCond")
    String get_ProdCond();

    @Key("DB_Company")
    String get_Company();

    @Key("DB_DBColumn")
    String get_DBColumn();

    @Key("FullAccount")
    String FullAcc();

    @Key("DB_ProdDesc")
    String get_ProdDesc();

    @Key("DB_OG")
    String get_OG();

    @Key("DB_ParOrder")
    String get_ParOrder();

    @Key("DB_UPC")
    String get_UPC();

    @Key("DB_History")
    String get_History();

    @Key("DB_Category")
    String get_Cateory();

    @Key("CompanyNo")
    String get_CompanyNo();

}

