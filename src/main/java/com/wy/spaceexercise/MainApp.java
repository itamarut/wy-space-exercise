package com.wy.spaceexercise;

import com.wy.spaceexercise.business.DownlinkCalculator;

import java.io.IOException;

public class MainApp {

	public static void main(String[] args) throws IOException {

		Integer groundStationBandwidth = Integer.parseInt(args[0]);
		DownlinkCalculator calculator = new DownlinkCalculator();
		calculator.calculateHighestBandwidth(groundStationBandwidth);
	}
}
