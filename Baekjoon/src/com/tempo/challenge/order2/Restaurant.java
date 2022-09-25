package com.tempo.challenge.order2;

public interface Restaurant {

    public void menuOrder();// 주문 request
    public void menuConfirm();// 주문 request confirm
    public void cooking();// 조리
    public void menuReserve();// 주문 response
}
