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

public class SatelliteParser {

	public List<Satellite> parseSatellites() throws IOException {
		List<Satellite> satellites = new ArrayList<>();
		Map<String, Integer> downlinkByTimePeriods = new HashMap<>();

		InputStream is = MainApp.class.getClassLoader().getResourceAsStream("pass-schedule.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = br.readLine()) != null) {
			String[] satelliteInfoTokens = line.split(",");
			Satellite satellite = new Satellite().setName(satelliteInfoTokens[0])
					.setBandwidth(Integer.parseInt(satelliteInfoTokens[1]))
					.setStartTime(LocalTime.parse(satelliteInfoTokens[2]))
					.setEndTime(LocalTime.parse(satelliteInfoTokens[3]));
			satellites.add(satellite);
		}

		return satellites;
	}
}
