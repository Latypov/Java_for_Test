package my.javapr.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Nurulla on 4/22/2016.
 */
public class GeoIpServiceTests {

  @Test
  public  void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("69.204.201.133");
    assertEquals(geoIP.getCountryCode(), "USA");
  }

  @Test
  public  void testInvalidMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("69.204.201.xxx");
    assertEquals(geoIP.getCountryCode(), "USA");
  }


}
