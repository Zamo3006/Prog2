package exercise04;

/**
 * 
 * @author Patrick Budig 5115455
 *
 */

public class NaviCon implements NaviConInterface {

	GeoLocationManager geoManager;

	@Override
	public void setGeoLocationManager(GeoLocationManager geoManager) {
		this.geoManager = geoManager;
	}

	@Override
	public Point getCurrentPosition() throws InstantiationException, NullPointerException {
		if (geoManager == null) {
			throw new NullPointerException("NoGeoManager");
		}
		Point returnPoint = null;
		try {
			returnPoint = geoManager.currentLocation();
			return returnPoint = returnPoint.moved(1, -1);
		} catch (IllegalAccessException e) {
			returnPoint = getCurrentPosition();
		} catch (InstantiationException e) {
			throw e;
		}
		return returnPoint;
	}

}
