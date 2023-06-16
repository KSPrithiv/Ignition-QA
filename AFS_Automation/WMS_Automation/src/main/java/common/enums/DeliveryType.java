package common.enums;

import lombok.Getter;

@Getter
public enum DeliveryType {
     DOOR("DOOR"),
     STAGE("STAGE");

     private final String deliveryType;

     DeliveryType(String deliveryType){
        this.deliveryType = deliveryType;
     }
}
