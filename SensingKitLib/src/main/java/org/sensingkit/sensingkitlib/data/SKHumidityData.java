/*
 * Copyright (c) 2015. Kleomenis Katevas
 * Kleomenis Katevas, k.katevas@imperial.ac.uk
 *
 * This file is part of SensingKit-Android library.
 * For more information, please visit http://www.sensingkit.org
 *
 * SensingKit-Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SensingKit-Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with SensingKit-Android.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.sensingkit.sensingkitlib.data;

import org.sensingkit.sensingkitlib.SKSensorType;

import java.util.HashMap;
import java.util.Locale;

/**
 *  An instance of SKHumidityData encapsulates measurements related to the Humidity sensor.
 */
public class SKHumidityData extends SKAbstractData {

    @SuppressWarnings("unused")
    private static final String TAG = SKHumidityData.class.getSimpleName();

    protected final float humidity;

    /**
     * Initialize the instance
     *
     * @param timestamp Time in milliseconds (the difference between the current time and midnight, January 1, 1970 UTC)
     *
     * @param humidity Humidity measurement
     */
    public SKHumidityData(long timestamp, float humidity) {

        super(SKSensorType.HUMIDITY, timestamp);

        this.humidity = humidity;
    }

    /**
     * Get the csv header of the Humidity sensor data
     *
     * @return String with a CSV formatted header that describes the data of the Humidity sensor.
     */
    @SuppressWarnings("unused")
    public static String csvHeader() {
        return "timeIntervalSince1970,humidity";
    }

    /**
     * Get humidity sensor data in CSV format
     *
     * @return String in CSV format: timeIntervalSince1970, humidity
     */
    @Override
    public String getDataInCSV() {
        return String.format(Locale.US, "%d,%f", this.timestamp, this.humidity);
    }

    /**
     * Get humidity sensor data in dictionary format
     *
     * @return Dictionary containing the humidity sensor data in dictionary format:
     * sensor type, sensor type in string, timeIntervalSince1970, humidity
     */
    @Override
    public HashMap getDataInDict() {
        HashMap multiMap = new HashMap<>();

        multiMap.put("sensorType",this.getSensorType());
        multiMap.put("sensorTypeString",this.getSensorType().toString());
        multiMap.put("timestamp",this.timestamp);
        multiMap.put("humidity",this.humidity);

        return multiMap;
    }

    @SuppressWarnings("unused")
    public float getHumidity() {
        return this.humidity;
    }

}
