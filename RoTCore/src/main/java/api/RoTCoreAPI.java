package api;

public class RoTCoreAPI {
	
	private static RoTCoreAPI instance;
	
	/**
	 * Gets the API instance
	 * @return The API
	 */
	public static RoTCoreAPI getAPI() {
		if (instance == null) {
			instance = new RoTCoreAPI();
		}
		return instance;
	}
	
}
