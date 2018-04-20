package api;

public class RoTCoreAPI {
	
	private static RoTCoreAPI instance;
	
	public static RoTCoreAPI getAPI() {
		if (instance == null) {
			instance = new RoTCoreAPI();
		}
		return instance;
	}
	
}
