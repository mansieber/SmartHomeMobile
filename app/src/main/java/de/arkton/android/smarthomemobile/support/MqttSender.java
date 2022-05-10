package de.arkton.android.smarthomemobile.support;

import android.util.Log;
import android.widget.EditText;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URISyntaxException;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.QoS;
import org.json.JSONObject;
import org.json.JSONException;

import de.arkton.android.smarthomemobile.R;
import de.arkton.android.smarthomemobile.activities.MainActivity;

/**
 * Objects of the class can communicate via MQTT JSON objects.
 *
 * @author manni
 */
public class MqttSender {
    private static final String LOG_CLASS = MqttSender.class.getSimpleName();

    private final String BROKER_IP = "192.168.178.31";
    private final int BROKER_PORT = 1883;
    MainActivity gui;
    MQTT mqttConnection;
    BlockingConnection connection;

    public MqttSender(MainActivity gui) {
        mqttConnection = new MQTT();
        this.gui = gui;
        try {
            mqttConnection.setHost(BROKER_IP, BROKER_PORT);
            mqttConnection.setClientId("SmartHomeGui");
            connection = mqttConnection.blockingConnection();
        } catch ( URISyntaxException e ) {
            gui.setStatus("MQTT URI broker error");
            Log.e(LOG_CLASS,"Wrong MQTT broker URI");
        }
    }

    /*
     * Send a message to the broker.
     * @param topic the topic
     * @param key the key
     * @param message the message
     */
    public void sendMessage(String topic, String key, String message) {
        try {
            String payload;
            JSONObject obj = new JSONObject();
            obj.put(key, message);
            payload = obj.toString();
            try {
                connection.publish(topic, payload.getBytes(), QoS.AT_LEAST_ONCE, false);
            } catch ( Exception e ) {
                gui.setStatus("Message to MQTT broker failed");
                Log.w(LOG_CLASS,"Message to MQTT broker failed");
            }
        } catch ( JSONException e ) {
            Log.e(LOG_CLASS, "Building message failed");
        }
    }

    /*
     * Connect to the broker.
     */
    public void connect() {
        try {
            gui.setStatus("MQTT broker connecting ...");
            connection.connect();
            gui.setStatus("MQTT broker connected");
        } catch ( Exception e ) {
            gui.setStatus("MQTT broker connection failed");
            Log.e(LOG_CLASS, "Connection to MQTT broker failed");
        }
    }

    /*
     * Close the connection to the broker.
     */
    public void closeConnection() {
        try {
            connection.disconnect();
        } catch ( Exception e ) {
            Log.e(LOG_CLASS, "Disconnect from MQTT broker failed");
        }
    }
}
