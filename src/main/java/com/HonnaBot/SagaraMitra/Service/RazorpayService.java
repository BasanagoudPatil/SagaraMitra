package com.HonnaBot.SagaraMitra.Service;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {
    @Value("${razorpay.api.key}")
    private String apiKey;

    @Value("${razorpay.api.secret}")
    private String apiSecret ;

    public String createOrder(int amount, String currency, String receiptId) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Razorpay works in paise
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", receiptId);

        Order order = razorpayClient.orders.create(orderRequest);

        // ✅ Return proper JSON (not just .toString())
        return order.toJson().toString();
    }

}
