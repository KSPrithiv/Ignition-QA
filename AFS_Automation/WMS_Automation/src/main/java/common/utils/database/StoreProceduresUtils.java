package common.utils.database;

import common.utils.database.implementation.CallableStatementImplementation;
import lombok.SneakyThrows;
import objects.storeproceduresdata.appointment.AppointmentParams;
import objects.storeproceduresdata.inbound.InboundLoadsSummaryParams;
import objects.storeproceduresdata.inbound.InboundOrderSummaryParams;
import objects.storeproceduresdata.outbound.OutboundSummaryParams;
import objects.storeproceduresdata.outbound.ProcessingParams;
import objects.storeproceduresdata.outbound.ProductsParams;

import java.sql.Connection;
import java.sql.ResultSet;

public class StoreProceduresUtils {
    private CallableStatementImplementation callableStatementImplementation;

     /**
     * execute outbound_OrderSummary procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureOutboundOrderSummary(Connection connection,
                                                               OutboundSummaryParams outboundSummaryParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[outbound_OrderSummary](?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"));;
        callableStatementImplementation.getCallableStatement().setInt("warehouse_id", outboundSummaryParams.getWarehouse_id());
        callableStatementImplementation.getCallableStatement().setInt("route_id", outboundSummaryParams.getRoute_id());
        callableStatementImplementation.getCallableStatement().setString("order_no", outboundSummaryParams.getOrder_no());
        callableStatementImplementation.getCallableStatement().setString("source", outboundSummaryParams.getSource());
        callableStatementImplementation.getCallableStatement().setString("start_date", outboundSummaryParams.getStart_date());
        callableStatementImplementation.getCallableStatement().setString("end_date", outboundSummaryParams.getEnd_date());
        callableStatementImplementation.getCallableStatement().setInt("order_status_id", outboundSummaryParams.getOrder_status_id());
        callableStatementImplementation.getCallableStatement().setInt("door_id", outboundSummaryParams.getDoor_id());
        callableStatementImplementation.getCallableStatement().setInt("owner_id", outboundSummaryParams.getOwner_id());
        callableStatementImplementation.getCallableStatement().setInt("carrier_id", outboundSummaryParams.getCarrier_id());
        callableStatementImplementation.getCallableStatement().setInt("order_type_id", outboundSummaryParams.getOrder_type_id());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", outboundSummaryParams.getCurrentuser_id());
        callableStatementImplementation.getCallableStatement().setString("account_code", outboundSummaryParams.getAccount_code());
        callableStatementImplementation.getCallableStatement().setString("account_name", outboundSummaryParams.getAccount_name());
        return callableStatementImplementation.executeQuery();
    }

     /**
     * execute ignition_InbRouteSummary procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureInboundRouteSummary(Connection connection,
                                                                     InboundLoadsSummaryParams inboundLoadsSummaryParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[ignition_InbRouteSummary](?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"));
        callableStatementImplementation.getCallableStatement().setInt("warehouse_id", inboundLoadsSummaryParams.getWarehouse_id());
        callableStatementImplementation.getCallableStatement().setString("route_code", inboundLoadsSummaryParams.getRoute_code());
        callableStatementImplementation.getCallableStatement().setInt("isActive", inboundLoadsSummaryParams.getIsActive());
        callableStatementImplementation.getCallableStatement().setString("start_date", inboundLoadsSummaryParams.getStart_date());
        callableStatementImplementation.getCallableStatement().setString("end_date", inboundLoadsSummaryParams.getEnd_date());
        callableStatementImplementation.getCallableStatement().setInt("order_status_id", inboundLoadsSummaryParams.getOrder_status_id());
        callableStatementImplementation.getCallableStatement().setInt("door_id", inboundLoadsSummaryParams.getDoor_id());
        callableStatementImplementation.getCallableStatement().setInt("carrier_id", inboundLoadsSummaryParams.getCarrier_id());
        callableStatementImplementation.getCallableStatement().setInt("route_type_id", inboundLoadsSummaryParams.getRoute_type_id());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", inboundLoadsSummaryParams.getCurrentuser_id());
        callableStatementImplementation.getCallableStatement().setString("vendor_code", inboundLoadsSummaryParams.getVendor_code());
        callableStatementImplementation.getCallableStatement().setString("vendor_name", inboundLoadsSummaryParams.getVendor_name());
        return callableStatementImplementation.executeQuery();
    }

     /**
     * execute ignition_InbOrderSummary procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureInboundOrderSummary(Connection connection,
                                                                     InboundOrderSummaryParams inboundOrderSummaryParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[ignition_InbOrderSummary](?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"));
        callableStatementImplementation.getCallableStatement().setInt("warehouse_id", inboundOrderSummaryParams.getWarehouse_id());
        callableStatementImplementation.getCallableStatement().setString("route_id", inboundOrderSummaryParams.getRoute_id());
        callableStatementImplementation.getCallableStatement().setString("order_no", inboundOrderSummaryParams.getOrder_no());
        callableStatementImplementation.getCallableStatement().setInt("isActive", inboundOrderSummaryParams.getIsActive());
        callableStatementImplementation.getCallableStatement().setString("start_date", inboundOrderSummaryParams.getStart_date());
        callableStatementImplementation.getCallableStatement().setString("end_date", inboundOrderSummaryParams.getEnd_date());
        callableStatementImplementation.getCallableStatement().setInt("order_status_id", inboundOrderSummaryParams.getOrder_status_id());
        callableStatementImplementation.getCallableStatement().setInt("door_id", inboundOrderSummaryParams.getDoor_id());
        callableStatementImplementation.getCallableStatement().setInt("owner_id", inboundOrderSummaryParams.getOwner_id());
        callableStatementImplementation.getCallableStatement().setInt("carrier_id", inboundOrderSummaryParams.getCarrier_id());
        callableStatementImplementation.getCallableStatement().setInt("order_type_id", inboundOrderSummaryParams.getOrder_type_id());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", inboundOrderSummaryParams.getCurrentuser_id());
        callableStatementImplementation.getCallableStatement().setString("vendor_code", inboundOrderSummaryParams.getVendor_code());
        callableStatementImplementation.getCallableStatement().setString("vendor_name", inboundOrderSummaryParams.getVendor_name());
        return callableStatementImplementation.executeQuery();
    }

     /**
     * execute ignition_GetOrderProcessingList procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureGetOrderProcessingList(Connection connection, ProcessingParams processingParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[ignition_GetOrderProcessingList](?, ?, ?, ?, ?)}"));
        callableStatementImplementation.getCallableStatement().setInt("all_orders", processingParams.getAll_orders());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", processingParams.getCurrentuser_id());
        callableStatementImplementation.getCallableStatement().setInt("warehouse_id", processingParams.getWarehouse_id());
        callableStatementImplementation.getCallableStatement().setString("selected_date", processingParams.getSelected_date());
        callableStatementImplementation.getCallableStatement().setString("batch_id", null);
        return callableStatementImplementation.executeQuery();
    }

    /**
     * execute filtered ignition_GetOrderProcessingList procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureGetFilteredOrderProcessingList(Connection connection, ProcessingParams processingParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[ignition_GetFilterOrderProcessingList](?, ?, ?, ?, ?, ?, ?)}"));
        callableStatementImplementation.getCallableStatement().setInt("all_orders", processingParams.getAll_orders());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", processingParams.getCurrentuser_id());
        callableStatementImplementation.getCallableStatement().setInt("warehouse_id", processingParams.getWarehouse_id());
        callableStatementImplementation.getCallableStatement().setString("selected_date", processingParams.getSelected_date());
        callableStatementImplementation.getCallableStatement().setString("end_date", processingParams.getEnd_date());
        callableStatementImplementation.getCallableStatement().setString("source", processingParams.getSource());
        callableStatementImplementation.getCallableStatement().setString("batch_id", null);
        return callableStatementImplementation.executeQuery();
    }

    /**
     * execute appt_SearchOrder procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureGetAppointmentOrdersList(Connection connection, AppointmentParams appointmentParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[appt_SearchOrder](?, ?, ?, ?)}"));
        callableStatementImplementation.getCallableStatement().setString("user_name", appointmentParams.getUser_name());
        callableStatementImplementation.getCallableStatement().setString("search_string", appointmentParams.getSearch_string());
        callableStatementImplementation.getCallableStatement().setInt("webuser_warehouse", appointmentParams.getWebuser_warehouse());
        callableStatementImplementation.getCallableStatement().setInt("currentuser_id", appointmentParams.getCurrentuser_id());
        return callableStatementImplementation.executeQuery();
    }

    /**
     * execute export_Products procedure with params
     */

    @SneakyThrows
    public ResultSet executeStoreProcedureExportProducts(Connection connection, ProductsParams productsParams) {
        callableStatementImplementation = new CallableStatementImplementation(connection
                .prepareCall("{call [dbo].[export_Products](?)}"));
        callableStatementImplementation.getCallableStatement().setInt("active_only", productsParams.getActive_only());
        return callableStatementImplementation.executeQuery();
    }
}
