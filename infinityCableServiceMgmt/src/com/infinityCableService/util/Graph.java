package com.infinityCableService.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph {

	public static JFreeChart getRegChart(Map<String, Integer> dataMap) {
		/*
		 * DefaultPieDataset dataset = new DefaultPieDataset(); for(VoterDetails
		 * voterDetObj : voterDetList){
		 * dataset.setValue(voterDetObj.getRes_city_desc(),Double.parseDouble(
		 * voterDetObj.getVoter_reg_num())); } boolean legend = true; boolean
		 * tooltips = false; boolean urls = false;
		 */

		// JFreeChart chart = ChartFactory.createPieChart("Population
		// Distribution of Mecklenburg County", dataset, legend, tooltips,
		// urls);

		// chart.setBorderPaint(Color.GREEN);
		// chart.setBorderStroke(new BasicStroke(5.0f));
		// chart.setBorderVisible(true);
		
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		for (String key : dataMap.keySet()) {
			bardataset.setValue(dataMap.get(key), "No of Users", key);
		}

		JFreeChart barchart = ChartFactory.createBarChart("User Registration", // Title
				"User Status", // X-axis Label
				"No.of Users", // Y-axis Label
				bardataset, // Dataset
				PlotOrientation.VERTICAL, // Plot orientation
				false, // Show legend
				true, // Use tooltips
				false // Generate URLs
		);
		barchart.setBorderPaint(Color.BLUE);
		barchart.setBorderStroke(new BasicStroke(5.0f));
		barchart.setBorderVisible(true);
		return barchart;

	}

}
