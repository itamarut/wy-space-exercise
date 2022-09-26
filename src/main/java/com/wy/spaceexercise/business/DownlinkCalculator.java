package com.wy.spaceexercise.business;

import com.wy.spaceexercise.MainApp;
import com.wy.spaceexercise.entity.Satellite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownlinkCalculator {

	private SatelliteParser satelliteParser = new SatelliteParser();

	public void calculateHighestBandwidth(Integer groundStationBandwidth) throws IOException {
		Map<String, Integer> downlinkByTimePeriods = new HashMap<>();

		List<Satellite> satellites = satelliteParser.parseSatellites();

		for (Satellite s : satellites) {
			LocalTime startTime = s.getStartTime();
			while (startTime.isBefore(s.getEndTime())) {
				LocalTime endTime = startTime.plusMinutes(30);
				String downLinkKey = startTime.toString() + " - " + endTime;
				if (!downlinkByTimePeriods.containsKey(downLinkKey)) {
					downlinkByTimePeriods.put(downLinkKey, s.getBandwidth());
				} else {
					downlinkByTimePeriods.put(downLinkKey, downlinkByTimePeriods.get(downLinkKey) + s.getBandwidth());
				}
				startTime = endTime;
			}
		}

		String highestPeriod = "";
		Integer maxDownlink = 0;
		for (String key : downlinkByTimePeriods.keySet()) {
			int downlink = downlinkByTimePeriods.get(key);
			if (downlink > maxDownlink) {
				maxDownlink = downlink;
				highestPeriod = key;
			}
		}

		System.out.println(String.format("Period %s has the highest total downlink: %d", highestPeriod, maxDownlink));
		if (groundStationBandwidth >= maxDownlink) {
			System.out.println("Ground station has the bandwidth to support max downlink.");
		} else {
			System.out.println("Ground station doesn't have the bandwidth to support max downlink.");
		}
	}
}
