// For more information please refer to https://github.com/checkout/checkout-sdk-java
import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.previous.CheckoutApi;
import com.checkout.webhooks.previous.WebhookRequest;
import com.checkout.webhooks.previous.WebhookResponse;

CheckoutApi api = CheckoutSdk
    .builder()
    .previous()
    .staticKeys()
    .secretKey("secret_key")
    .environment(Environment.SANDBOX) // or Environment.PRODUCTION
    .build();

WebhookRequest webhookRequest = WebhookRequest.builder().build();
webhookRequest.setUrl("https://docs.checkout.com/webhooks/updated");

try {
    WebhookResponse response = api.webhooksClient().updateWebhook("webhook_id", webhookRequest).get();
} catch (CheckoutApiException e) {
    // API error
    String requestId = e.getRequestId();
    int statusCode = e.getHttpStatusCode();
    Map<String, Object> errorDetails = e.getErrorDetails();
} catch (CheckoutArgumentException e) {
    // Bad arguments
} catch (CheckoutAuthorizationException e) {
    // Invalid authorization
}
