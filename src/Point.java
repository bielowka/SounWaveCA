public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;

	public static Integer []types ={0,1,2};
	int type;

	public int sinInput = 0;

	public Point() {
		this.type = 0;
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		this.nVel = 0;
		this.eVel = 0;
		this.wVel = 0;
		this.sVel = 0;
		this.pressure = 0;

//		this.type = 0;
	}

	public void updateVelocity() {
		if (this.type != 0) return;
		nVel = nVel - (nNeighbor.getPressure() - this.pressure);
		eVel = eVel - (eNeighbor.getPressure() - this.pressure);
		wVel = wVel - (wNeighbor.getPressure() - this.pressure);
		sVel = sVel - (sNeighbor.getPressure() - this.pressure);
	}

	public void updatePresure() {
		if (this.type == 0) {
			this.pressure = (float) (this.pressure - 0.5 * (nVel + eVel + wVel + sVel));
		}
		if (this.type == 2){
			sinInput += 15;
			sinInput = sinInput % 360;
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}