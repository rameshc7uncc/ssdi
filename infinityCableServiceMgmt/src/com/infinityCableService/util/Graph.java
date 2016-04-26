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

	public static JFreeChart getPckgChart(Map<String, Integer> dataMap) {
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		for (String key : dataMap.keySet()) {
			bardataset.setValue(dataMap.get(key), "No of Users", key);
		}

		JFreeChart barchart = ChartFactory.createBarChart("Subscription Per Package", // Title
				"Package Type", // X-axis Label
				"Number of Subsriptions", // Y-axis Label
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

	public static JFreeChart getTotalSale(Map<String, Double> dataMap) {
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		for (String key : dataMap.keySet()) {
			bardataset.setValue(dataMap.get(key), "Sale Per Package", key);
		}

		JFreeChart barchart = ChartFactory.createBarChart("Sale Per Package", // Title
				"Package Type", // X-axis Label
				"Sale per Package", // Y-axis Label
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
