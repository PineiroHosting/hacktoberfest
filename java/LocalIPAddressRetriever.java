import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class fetches all IP addresses of the local machine, which could be used by local communication but with an
 * external domain (e.g. curl request on external domain, but your machine - not loopback like 127.0.0.1).
 * This could be useful for access validation *for testing*.
 * Don't use this in production. Really. It will be awful. Trust me. I know, what I'm talking about.
 * <p>
 * btw this only works for Linux machines, good luck have fun.
 */
public class LocalIPAddressRetriever {

    public static void main(String[] args) {
        try {
            init();
            System.out.printf("Your local IP address%s: %s\n",
                    (LOCAL_IP_ADDRESSES.size() == 1 ? " is" : "es are"),
                    String.join(", ", LOCAL_IP_ADDRESSES));
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }

    private static final List<String> LOCAL_IP_ADDRESSES = new ArrayList<>();

    private static void init() throws UnknownHostException, SocketException {
        final String ip = Inet4Address.getLocalHost().getHostAddress();
        // avoid loopback in getLocalHost()
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getByName(ip));
        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress address = addresses.nextElement();
            if (address.isLoopbackAddress() || address.isLinkLocalAddress())
                continue;

            String addressString = address.getHostAddress();
            if (addressString.contains("%"))
                addressString = addressString.split("%")[0];

            LOCAL_IP_ADDRESSES.add(addressString);
        }
    }
}
