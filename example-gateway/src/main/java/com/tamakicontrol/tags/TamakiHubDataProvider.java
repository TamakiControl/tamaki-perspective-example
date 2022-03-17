package com.tamakicontrol.tags;

import com.inductiveautomation.ignition.common.gson.Gson;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tamakicontrol.model.BookingType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TamakiHubDataProvider implements Runnable {

    private static final LoggerEx logger = LoggerEx.newBuilder().build(TamakiHubDataProvider.class);
    private final BookingType bookingType = null;
    private final EntityTagMapper<BookingType> tagMapper;
    private final GatewayContext gatewayContext;

    public TamakiHubDataProvider(GatewayContext gatewayContext) {
        this.gatewayContext = gatewayContext;
        tagMapper = new EntityTagMapper<>(ExampleTagProvider.getInstance().get(), "example/booking-types/", bookingType, BookingType.class);
        gatewayContext.getExecutionManager().registerAtFixedRate("Example", "TamakiHubDataProvider", this, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        gatewayContext.getExecutionManager().unRegister("Example", "TamakiHubDataProvider");
    }

    @Override
    public void run() {
        try {
            poll();
        } catch (Exception e) {
            logger.error("Error while polling", e);
        }
    }

    private void poll() throws IOException {
        Request request = new Request.Builder()
                .url("http://3ea6-98-97-34-205.ngrok.io/booking-types/1")
                .method("GET", null)
                .addHeader("Authorization", "Basic OjM0NWUzZWYxLTk4MzYtNGVjNi04ZDMyLTA5OTZlZWYzMjNlMQ==")
                .build();

        var call = new OkHttpClient().newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                logger.error("Failed to get data from api", e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    var stringData = response.body().string();
                    Gson gson = new Gson();
                    BookingType bookingType = gson.fromJson(stringData, BookingType.class);
                    updateTags(bookingType);
                } catch (Exception e) {
                    logger.error("Error after response received", e);
                }
            }
        });
    }

    public void updateTags(final BookingType bookingType) {
        tagMapper.setModel(bookingType);
        tagMapper.configureTags();
        tagMapper.updateTags();
    }


}
