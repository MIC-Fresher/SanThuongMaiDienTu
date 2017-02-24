/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Orders;
import entity.Shop;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Chart;
import model.DashBoardSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrdersRepository;

@Service
public class UtilsChartImpl implements UtilsChart, Serializable {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Chart> getChartByDate(DashBoardSearchForm dashBoard, Integer statusOrder) {
        Calendar cal = Calendar.getInstance();
        List<Orders> orders = null;
        Chart chart = null;
        List<Chart> charts = null;
        try {
            orders = ordersRepository.findByStatusOrderId_StatusOrderIdAndUpdateDateBetween(statusOrder, dashBoard.getFromDate(), dashBoard.getToDate());

            if (orders.isEmpty()) {
                return null;
            } else {
                charts = new ArrayList<>();

                for (int i = 0; i < orders.size(); i++) {
                    chart = new Chart();
                    cal.setTime(orders.get(i).getUpdateDate());
                    cal.add(Calendar.MONTH, -1);
                    chart.setDatePayment(cal.getTime());
                    chart.setRevenue(orders.get(i).getTotalPrice());
                    charts.add(chart);
                }
                return charts;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Chart> getChartByDate(DashBoardSearchForm dashBoard, Integer statusOrder, Shop shop) {
        Calendar cal = Calendar.getInstance();
        List<Orders> orders = null;
        Chart chart = null;
        List<Chart> charts = null;
        try {
            orders = ordersRepository.findOrderByDateAndShop(dashBoard.getFromDate(), dashBoard.getToDate(), statusOrder, shop.getShopName());

            if (orders.isEmpty()) {
                return null;
            } else {
                charts = new ArrayList<>();

                for (int i = 0; i < orders.size(); i++) {
                    chart = new Chart();
                    cal.setTime(orders.get(i).getUpdateDate());
                    cal.add(Calendar.MONTH, -1);
                    chart.setDatePayment(cal.getTime());
                    chart.setRevenue(orders.get(i).getTotalPrice());
                    charts.add(chart);
                }
                return charts;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
