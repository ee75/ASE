

public class Baggage {

	//instant variable
	private int height;
	private int width;
	private int length;
	private int weight;

	
	//Constructor
	public Baggage(int h, int w, int l, int wgt) { 
		height = h;
		width = w;
		length = l;
		weight = wgt;	
	}

	
	public int getHeight() { return height;	}
	
	public int getWidth() { return width;	}
	
	public int getLength() { return length;	}
	
	public int getWeight() { return weight;	}
	
	public double getVolume() {
		double volume = height * width * length/1000000;
		return volume;	
	}
	
	public double getFee() {
		double fee = 0;
		double vol = this.getVolume();
		if (vol > 0.3) {
			if (((vol - 0.3) <= 0.05) && (weight <= 20)) {
				fee = 10;
			}
			else if (((vol - 0.3) <= 0.05) && ((weight - 20) <= 1)) {
				fee = 10+10;
			}
			else if (((vol - 0.3) <= 0.05) && ((weight - 20) > 1)) {
				fee = 10+(10*(weight - 20));
			}
			else if (((vol - 0.3) > 0.05) && (weight <= 20)) {
				fee = 10 * (vol - 0.3)/0.05;
			}
			else if (((vol - 0.3) > 0.05) && ((weight - 20) <= 1)) {
				fee = (10 * (vol - 0.3)/0.05)+10;
			}
			else if (((vol - 0.3) > 0.05) && ((weight - 20) > 1)) {
				fee = (10 * (vol - 0.3)/0.05)+(10*(weight - 20));
			}
		}
		return fee;
	}

}
	
	
