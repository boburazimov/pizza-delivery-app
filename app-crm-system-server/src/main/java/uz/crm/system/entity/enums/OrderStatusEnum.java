package uz.crm.system.entity.enums;

/** Статусы для заказака, доставки и т.д **/

public enum OrderStatusEnum {

    ORDER_PENDING,          // 1. Заказ не обработан
    ORDER_ACCEPTED,         // 2. Заказ принят
    ORDER_IN_PROGRESS,      // 3. Заказ в процессе приготовления
    ORDER_READY,            // 4. Заказ готов к доставке
    PROCESS_OF_DELIVERY,    // 5. Заказ в процессе доставки
    ORDER_DELIVERED,        // 6. Заказ доставлен
    ORDER_CANCELLED         // 7. Заказ отменен
}
