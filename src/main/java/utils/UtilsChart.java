/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Shop;
import java.util.List;
import model.Chart;
import model.DashBoardSearchForm;

public interface UtilsChart {

    public List<Chart> getChartByDate(DashBoardSearchForm dashBoard, Integer statusOrder);

    public List<Chart> getChartByDate(DashBoardSearchForm dashBoard, Integer statusOrder, Shop shop);
}
